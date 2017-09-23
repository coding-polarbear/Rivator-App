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
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Project;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.services.ProjectService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectAddActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    private static final String TAG = ProjectAddActivity.class.getSimpleName();
    private static final int REQUEST_GALLERY_CODE = 200;
    private static final int READ_REQUEST_CODE = 300;
    private Uri uri;

    private ImageView projectImage;
    private EditText title;
    private EditText teamName;
    private EditText numOfTeam;
    private EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_add);
        init();
        setCustomActionbar();
    }

    private void init() {
        projectImage = (ImageView) findViewById(R.id.projectImage);
        title = (EditText) findViewById(R.id.title);
        teamName = (EditText) findViewById(R.id.teamName);
        numOfTeam = (EditText) findViewById(R.id.numOfTeam);
        description = (EditText) findViewById(R.id.description);
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
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,ProjectAddActivity.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_GALLERY_CODE && resultCode == Activity.RESULT_OK) {
            uri = data.getData();
            if(EasyPermissions.hasPermissions(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Glide.with(getApplicationContext()).load(uri).centerCrop().into(projectImage);
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
        Toast.makeText(ProjectAddActivity.this,"권한이 거부되었습니다!",Toast.LENGTH_SHORT).show();
    }

    private void setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_cancle, view -> {

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("프록젝트 작성");

            //ImageButton 리스너 설정
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnClose);
            imageButton.setOnClickListener(v -> finish());

        });
    }

    public void upload(View view) {
        String filePath = getRealPathFromURIPath(uri,ProjectAddActivity.this);
        File file = new File(filePath);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        User user = User.last(User.class);

        Project project = new Project();
        project.setTitle(title.getText().toString());
        project.setDescription(description.getText().toString());
        project.setTeamName(teamName.getText().toString());
        project.setMemberNum(Integer.parseInt(numOfTeam.getText().toString()));
        project.setDate(formatter.format(new Date(System.currentTimeMillis())));
        project.setCategory(user.getSubject());

        Log.d(TAG,"File name : " + file.getName());
        ProjectService projectService = RetrofitUtil.getLoginRetrofit().create(ProjectService.class);
        Call<Status> call;
        call = projectService.addProjectWithImage(project, RetrofitUtil.createRequestBody(file));
        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                if(response.body().getResult().getSuccess().equals("200")) {
                    SnackBarUtill.makeSnackbarWithFinish(getWindow().getDecorView().getRootView(), response.body().getResult().getMessage(), Snackbar.LENGTH_LONG, ProjectAddActivity.this);
                } else {
                    SnackBarUtill.makeSnackBar(view, response.body().getResult().getMessage(), Snackbar.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {

            }
        });
    }
}
