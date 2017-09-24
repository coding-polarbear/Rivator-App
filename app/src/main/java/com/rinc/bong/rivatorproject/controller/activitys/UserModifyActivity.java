package com.rinc.bong.rivatorproject.controller.activitys;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.adapters.HomeWorkPagerAdapter;
import com.rinc.bong.rivatorproject.controller.adapters.SpinnerAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.UserLogin;
import com.rinc.bong.rivatorproject.retrofitBean.UserModify;
import com.rinc.bong.rivatorproject.services.UserService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;
import com.rinc.bong.rivatorproject.utils.ToastUtill;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserModifyActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    private static final String TAG = UserModifyActivity.class.getSimpleName();
    private static final int REQUEST_GALLERY_CODE = 200;
    private static final int READ_REQUEST_CODE = 300;


    private ImageView imageView;
    private EditText editName;
    private EditText editPhoneNumber;
    private Spinner citySpinner = null;
    private Spinner districtSpinner = null;
    private Spinner townSpinner = null;
    private Spinner subjectSpinner = null;

    private List<String> cityList;
    private List<String> districtList;
    private List<String> townList;
    private List<String> subjectList;

    private User user;
    private Uri uri;
    private File file;
    private View view;
    private Retrofit retrofit;
    private Call<UserLogin> call = null;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_modify);
        init();
        setDummyData();
        setSpinner();
        setData();
        setCustomActionbar();
    }

    private void init() {
        imageView = (ImageView) findViewById(R.id.imageView);
        editName = (EditText) findViewById(R.id.editName);
        editPhoneNumber = (EditText) findViewById(R.id.editPhoneNumber);
        citySpinner = (Spinner) findViewById(R.id.citySpinner);
        districtSpinner = (Spinner) findViewById(R.id.districSpinner);
        townSpinner = (Spinner) findViewById(R.id.townSpinner);
        subjectSpinner = (Spinner) findViewById(R.id.subjectSpinner);

        user = User.last(User.class);
        view = getWindow().getDecorView().getRootView();
        Log.d("init","init");
        url = "http://n0rr.iptime.org:7001/users/" + user.getUserId() + "/profile-image.jpg";
        Glide.with(UserModifyActivity.this).load("http://n0rr.iptime.org:7001/users/" + user.getUserId() + "/profile-image.jpg").diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true).into(imageView);
    }

    private void setDummyData() {
        cityList = new ArrayList<>();
        cityList.add("시");
        cityList.add("서울시");
        cityList.add("인천시");
        cityList.add("시흥시");
        cityList.add("하남시");

        districtList = new ArrayList<>();
        districtList.add("구/군");
        districtList.add("마포구");
        districtList.add("서대문구");
        districtList.add("은평구");
        districtList.add("중구");

        townList = new ArrayList<>();
        townList.add("동/읍/면");
        townList.add("홍제동");
        townList.add("홍은동");
        townList.add("북가좌동");
        townList.add("남가좌동");

        subjectList = new ArrayList<>();
        subjectList.add("선택해주십시오");
        subjectList.add("Basic");
        subjectList.add("웹");
        subjectList.add("어플리케이션");
        subjectList.add("게임");
        subjectList.add("node.js");
    }

    private void setSpinner() {
        SpinnerAdapter cityAdapter = new SpinnerAdapter(getApplicationContext(), R.layout.sign_up_spinner_item, cityList);
        SpinnerAdapter districtAdapter = new SpinnerAdapter(getApplicationContext(), R.layout.sign_up_spinner_item, districtList);
        SpinnerAdapter townAdapter = new SpinnerAdapter(getApplicationContext(), R.layout.sign_up_spinner_item, townList);
        SpinnerAdapter subjectAdapter = new SpinnerAdapter(getApplicationContext(), R.layout.sign_up_spinner_item, subjectList);

        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        townAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        citySpinner.setAdapter(cityAdapter);
        districtSpinner.setAdapter(districtAdapter);
        townSpinner.setAdapter(townAdapter);
        subjectSpinner.setAdapter(subjectAdapter);
    }

    private void setData() {
        citySpinner.setSelection(cityList.indexOf(user.getLocalCity()));
        districtSpinner.setSelection(districtList.indexOf(user.getLocalDistrict()));
        townSpinner.setSelection(townList.indexOf(user.getLocalTown()));
        subjectSpinner.setSelection(subjectList.indexOf(user.getSubject()));
        editName.setText(user.getUserName());
        editPhoneNumber.setText(user.getPhone());
    }
    public void modifyUser(View view) {
        modify();
    }

    private void modify() {
        retrofit = RetrofitUtil.getLoginRetrofit();
        UserService userService = retrofit.create(UserService.class);
        UserModify userModify = new UserModify(editName.getText().toString(), editPhoneNumber.getText().toString(),
                citySpinner.getSelectedItem().toString(), districtSpinner.getSelectedItem().toString(),
                townSpinner.getSelectedItem().toString(),subjectSpinner.getSelectedItem().toString());
        if(file != null)
            call = userService.userModifyWithProfile(userModify,RetrofitUtil.createRequestBody(file,"profileImage"));
        else
            call = userService.userModifyWithNoProfile(userModify);

        call.enqueue(new Callback<UserLogin>() {
            @Override
            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    User.deleteAll(User.class);
                    User tempUser = response.body().getUser();
                    tempUser.save();
                    Log.d("userTest", tempUser.toString());
                    SnackBarUtill.makeSnackbarWithFinish(view, result.getMessage(), Toast.LENGTH_LONG,UserModifyActivity.this);
                }
            }

            @Override
            public void onFailure(Call<UserLogin> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하였습니다!",Snackbar.LENGTH_SHORT);
                Log.d("test", t.getMessage());
            }
        });
    }
    public void setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_back, view -> {

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("계정정보 수정");
            textView.setClickable(false);

            //ImageButton 리스너 설정
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());

        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mActionbar.setActionBarElevation(15);
        }

    }

    public void select(View view) {
        Intent openGalleryIntent = new Intent(Intent.ACTION_PICK);
        openGalleryIntent.setType("image/*");
        startActivityForResult(openGalleryIntent, REQUEST_GALLERY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_GALLERY_CODE && resultCode == Activity.RESULT_OK) {
            uri = data.getData();
            if(EasyPermissions.hasPermissions(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Glide.with(this).load(uri).into(imageView);
                String filePath = getRealPathFromURIPath(uri, UserModifyActivity.this);
                file = new File(filePath);
            } else {
                EasyPermissions.requestPermissions(this,"파일을 읽으려면 권한이 필요합니다",READ_REQUEST_CODE, android.Manifest.permission.READ_EXTERNAL_STORAGE);
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
            modify();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        SnackBarUtill.makeSnackBar(view, "권한이 없습니다",Snackbar.LENGTH_SHORT);
    }
}
