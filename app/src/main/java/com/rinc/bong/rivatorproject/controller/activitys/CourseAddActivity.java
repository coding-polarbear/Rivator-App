package com.rinc.bong.rivatorproject.controller.activitys;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Course;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.services.CourseService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;
import com.rinc.bong.rivatorproject.utils.ToastUtill;

import java.io.File;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseAddActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    private static final String TAG = CourseAddActivity.class.getSimpleName();
    private static final int REQUEST_GALLERY_CODE = 200;
    private static final int READ_REQUEST_CODE = 300;
    private Uri uri;
    private User user;

    private ImageView imageView;
    private EditText title;
    private EditText unitTime;
    private EditText price;
    private EditText curriculum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_add);
        init();

    }

    private void init() {
        imageView = (ImageView) findViewById(R.id.imageView);
        title = (EditText) findViewById(R.id.title);
        unitTime = (EditText) findViewById(R.id.unitTime);
        price = (EditText) findViewById(R.id.price);
        curriculum = (EditText) findViewById(R.id.curriculum);
        user = User.last(User.class);
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
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,CourseAddActivity.this);
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
        Toast.makeText(CourseAddActivity.this,"권한이 거부되었습니다!",Toast.LENGTH_SHORT).show();
    }

    public void upload(View view) {
        String filePath = getRealPathFromURIPath(uri,CourseAddActivity.this);
        File file = new File(filePath);

        Course course = new Course();
        course.setTitle(title.getText().toString());
        course.setCategory(user.getSubject());
        course.setUnit(Integer.parseInt(unitTime.getText().toString()));
        course.setPrice(Integer.parseInt(price.getText().toString()));
        course.setCurriculum(curriculum.getText().toString());

        CourseService courseService = RetrofitUtil.getLoginRetrofit().create(CourseService.class);
        Call<Status> call = courseService.addCourse(course, RetrofitUtil.createRequestBody(file,"courseImage"));
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
