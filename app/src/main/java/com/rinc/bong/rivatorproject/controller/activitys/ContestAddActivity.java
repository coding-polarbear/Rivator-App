package com.rinc.bong.rivatorproject.controller.activitys;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Contest;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.adapters.ContestRecyclerAdapter;
import com.rinc.bong.rivatorproject.services.ContestService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;
import com.rinc.bong.rivatorproject.utils.ToastUtill;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContestAddActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private static final String TAG = ContestAddActivity.class.getSimpleName();
    private static final int REQUEST_GALLERY_CODE = 200;
    private static final int READ_REQUEST_CODE = 300;

    private static final int START_TIME_FLAG=3000;
    private static final int END_TIME_FLAG=4000;
    private Uri uri;
    private int flag = 0;
    private Calendar result1 = Calendar.getInstance();
    private Calendar result2 = Calendar.getInstance();
    private SimpleDateFormat simpleDateFormat;

    private EditText title;
    private EditText priseNum;
    private TextView startTime;
    private TextView endTime;
    private EditText criteria;
    private EditText fieldEntry;
    private EditText description;
    private EditText award;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest_add);
        init();
        setCustomActionbar();
    }

    private void init() {
        title = (EditText) findViewById(R.id.title);
        priseNum = (EditText) findViewById(R.id.priseNum);
        startTime = (TextView) findViewById(R.id.startTime);
        endTime = (TextView) findViewById(R.id.endTime);
        criteria = (EditText) findViewById(R.id.criteria);
        fieldEntry = (EditText) findViewById(R.id.fieldEntry);
        description = (EditText) findViewById(R.id.description);
        award = (EditText) findViewById(R.id.award);
        imageView = (ImageView) findViewById(R.id.imageView);
        startTime.setOnClickListener(v->{
            flag=START_TIME_FLAG;
            makeDateDialog();
        });
        endTime.setOnClickListener(v -> {
            flag=END_TIME_FLAG;
            makeDateDialog();
        });
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    public void select(View view) {
        selectImage();
    }

    private void selectImage() {
        Intent openGalleryIntent = new Intent(Intent.ACTION_PICK);
        openGalleryIntent.setType("image/*");
        startActivityForResult(openGalleryIntent, REQUEST_GALLERY_CODE);
    }


    //PermissionResult가 요구 될때 그 값을 Easy Permission으로 넘겨줌
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,ContestAddActivity.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_GALLERY_CODE && resultCode == Activity.RESULT_OK) {
            uri = data.getData();
            if(EasyPermissions.hasPermissions(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Glide.with(getApplicationContext()).load(uri).centerCrop().into(imageView);
            } else {
                EasyPermissions.requestPermissions(this,"계속하려면 권한이 필요합니다.",READ_REQUEST_CODE, android.Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        }
    }

    private String getRealPathFromURIPath(Uri contentURI, Activity activity) {
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }


    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        if(uri != null) {
            selectImage();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Toast.makeText(ContestAddActivity.this,"권한이 거부되었습니다!",Toast.LENGTH_SHORT).show();
    }

    private void makeDateDialog() {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                ContestAddActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
        dpd.setVersion(DatePickerDialog.Version.VERSION_2);
    }

    private void makeTimeDialog() {
        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(
                ContestAddActivity.this, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), true);
        tpd.show(getFragmentManager(),"Timepickerdialog");
        tpd.setVersion(TimePickerDialog.Version.VERSION_2);
    }
    private void setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_cancle, view -> {

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("콘테스트 작성");

            //ImageButton 리스너 설정
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnClose);
            imageButton.setOnClickListener(v -> finish());

        });
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        if(flag == START_TIME_FLAG) result1.set(year, monthOfYear, dayOfMonth);
        else result2.set(year, monthOfYear, dayOfMonth);
        makeTimeDialog();
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        if(flag == START_TIME_FLAG) {
            result1.set(result1.get(Calendar.YEAR), result1.get(Calendar.MONTH), result1.get(Calendar.DATE), hourOfDay, minute, second);
            startTime.setText(simpleDateFormat.format(result1.getTime()));
        } else {
            result2.set(result2.get(Calendar.YEAR), result2.get(Calendar.MONTH), result2.get(Calendar.DATE), hourOfDay, minute, second);
            endTime.setText(simpleDateFormat.format(result2.getTime()));
        }
    }

    public void upload(View view) {
        String filePath = getRealPathFromURIPath(uri, ContestAddActivity.this);
        File file = new File(filePath);
        User user = User.last(User.class);

        Contest contest = new Contest();
        contest.setTitle(title.getText().toString());
        contest.setPrizeNum(Integer.parseInt(priseNum.getText().toString()));
        contest.setFiledEntry(fieldEntry.getText().toString());
        Log.d("FieldEntry", fieldEntry.getText().toString());
        contest.setDateStart(startTime.getText().toString());
        contest.setDateEnd(endTime.getText().toString());
        contest.setDescription(description.getText().toString());
        contest.setAward(award.getText().toString());
        contest.setCategory(user.getSubject());

        ContestService contestService = RetrofitUtil.getLoginRetrofit().create(ContestService.class);
        Call<Status> call = contestService.putContest(contest, RetrofitUtil.createRequestBody(file,"contestImage"));
        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    ToastUtill.makeToast(getApplicationContext(), result.getMessage(), Toast.LENGTH_SHORT);
                    finish();
                } else {
                    SnackBarUtill.makeSnackBar(view, result.getMessage(), Snackbar.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하였습니다.", Snackbar.LENGTH_SHORT);
            }
        });
    }
}
