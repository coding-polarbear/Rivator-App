package com.rinc.bong.rivatorproject.controller.activitys;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.retrofitBean.UserRegister;
import com.rinc.bong.rivatorproject.controller.adapters.SpinnerAdapter;
import com.rinc.bong.rivatorproject.services.UserService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.DialogUtill;
import com.rinc.bong.rivatorproject.utils.DrawableFileUtill;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;
import com.rinc.bong.rivatorproject.utils.ToastUtill;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentSignUpActivity extends AppCompatActivity implements PermissionCallbacks {

    private static final String TAG = StudentSignUpActivity.class.getSimpleName();
    private static final int REQUEST_GALLERY_CODE = 200;
    private static final int READ_REQUEST_CODE = 300;
    private Uri uri;
    private File file = null;
    private View view;

    private de.hdodenhof.circleimageview.CircleImageView imageView;
    private EditText editId;
    private EditText editPassword1;
    private EditText editPassword2;
    private EditText editName;
    private EditText editPhoneNumber;
    private CheckBox checkBox;

    private Spinner citySpinner;
    private Spinner districtSpinner;
    private Spinner townSpinner;
    private Spinner subjectSpinner;

    private List<String> cityList;
    private List<String> districtList;
    private List<String> townList;
    private List<String> subjectList;

    private String localCity;
    private String localTown;
    private String localDistrict;
    private String subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);
        setCustomActionbar();
        init();
        setDummyData();
        setSpinner();
    }

    private void init() {
        imageView = findViewById(R.id.imageView);
        citySpinner = findViewById(R.id.citySpinner);
        districtSpinner = findViewById(R.id.districSpinner);
        townSpinner = findViewById(R.id.townSpinner);
        subjectSpinner = findViewById(R.id.subjectSpinner);
        editId = findViewById(R.id.editId);
        editName = findViewById(R.id.editName);
        editPassword1 = findViewById(R.id.editPassword1);
        editPassword2 = findViewById(R.id.editPassword2);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);
        checkBox = findViewById(R.id.checkBox);
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
                String filePath = getRealPathFromURIPath(uri, StudentSignUpActivity.this);
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
    }

    private void setSpinner() {
        SpinnerAdapter cityAdapter = new SpinnerAdapter(getApplicationContext(),R.layout.sign_up_spinner_item,cityList);
        SpinnerAdapter districtAdapter = new SpinnerAdapter(getApplicationContext(),R.layout.sign_up_spinner_item,districtList);
        SpinnerAdapter townAdapter = new SpinnerAdapter(getApplicationContext(),R.layout.sign_up_spinner_item,townList);
        SpinnerAdapter subjectAdapter = new SpinnerAdapter(getApplicationContext(),R.layout.sign_up_spinner_item,subjectList);

        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        townAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        citySpinner.setAdapter(cityAdapter);
        districtSpinner.setAdapter(districtAdapter);
        townSpinner.setAdapter(townAdapter);
        subjectSpinner.setAdapter(subjectAdapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                localCity = citySpinner.getSelectedItem().toString();
                Log.d(TAG, localCity);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                localDistrict = districtSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        townSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                localTown = townSpinner.getSelectedItem().toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subject = subjectSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    public void back(View view) {
        finish();
    }

    public void next(View view) {
        if(checkBox.isChecked()) {
            register();

        } else {
            DialogUtill.makeDialogWithPositiveButton("알림","이용약관에 동의해주세요!","확인",StudentSignUpActivity.this);
        }
    }

    private void register() {
        User user = new User(editName.getText().toString(), editId.getText().toString(),
                editPassword1.getText().toString(), editPhoneNumber.getText().toString(),
                "student", localCity, localTown, localDistrict,subject);
        MultipartBody.Part image;
        if(file != null) {
            image = RetrofitUtil.createRequestBody(file,"profileImage");
        } else {
            image = RetrofitUtil.createRequestBody(DrawableFileUtill.getDrawableResource(R.drawable.student,"student_profile",getApplicationContext()),"pofileImage");
        }
        UserService userService = RetrofitUtil.retrofit.create(UserService.class);
        Call<UserRegister> register = userService.register(user,image);
        view = getWindow().getDecorView().getRootView();
        register.enqueue(new Callback<UserRegister>() {
            @Override
            public void onResponse(Call<UserRegister> call, Response<UserRegister> response) {
                Result result = response.body().getResult();
                Log.d("test",response.body().toString());
                if(result.getSuccess().equals("200")) {
                    ToastUtill.makeToast(getApplicationContext(),result.getMessage(), Toast.LENGTH_SHORT);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //기존의 액티비티 모든 스택 제거
                    startActivity(intent);
                } else {
                    SnackBarUtill.makeSnackBar(view,result.getMessage(), Snackbar.LENGTH_LONG);
                }
            }
            @Override
            public void onFailure(Call<UserRegister> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view,"회원가입에 실패하였습니다.", Snackbar.LENGTH_LONG);
                Log.d("fail : " , t.getMessage());
            }
        });
    }

    private void setCustomActionbar() {
        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_cancle, view -> {
            TextView textView = view.findViewById(R.id.title);
            textView.setText("프로필 작성");
            ImageButton imageButton = view.findViewById(R.id.btnClose);
            imageButton.setOnClickListener( v-> finish());
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mActionbar.setActionBarElevation(15);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        if(uri != null) {
            register();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        SnackBarUtill.makeSnackBar(view, "권한이 없습니다",Snackbar.LENGTH_SHORT);
    }

}
