package com.example.app.Rvw;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app.Memb.Memb;
import com.example.app.R;
import com.example.app.Request.RequestInterface;
import com.example.app.Request.RetrofitClient;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RvwPOST extends AppCompatActivity {

    final String TAG = getClass().getSimpleName();
    ImageView imageView;
    Button cameraBtn;
    TextView submit;
    final static int TAKE_PICTURE = 1;

    String mCurrentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 1;

    Bitmap phot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvw_post);

        //  데이터 받기
        Bundle intent = getIntent().getExtras();
        final int rst_no = intent.getInt( "rst_no" );
        final String rst_nm = intent.getString("rst_name");


        // 레이아웃과 변수 연결
        imageView = findViewById(R.id.phot_preview);
        cameraBtn = findViewById(R.id.takePhoto);
        submit = findViewById(R.id.submit);


        // 카메라 버튼에 리스너 추가
        cameraBtn.setOnClickListener(new Button.OnClickListener(){
            // 버튼 onClick 리스너 처리부분
            @Override
            public void onClick( View v ) {
                switch( v.getId() ){
                    case R.id.takePhoto:
                        // 카메라 앱을 여는 소스
                        dispatchTakePictureIntent();
                        break;
                }
            }
        });
        // submit 버튼에 리스너 추가
        submit.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("\n\tSUBMIT BTN CLICKED!");

                String id = Memb.getMemb().getId();

                EditText contText = (EditText)findViewById(R.id.rvw_cont);
                String cont = contText.getText().toString();
                if( cont.length() <= 0) {
                    return;
                }
                int score = 3;


                //  Retrofit을 Singleton Pattern으로 생성한 객체를 가져옴.
                Retrofit retrofit = RetrofitClient.getClient();

                //  Retrofit 클래스로 RequestInterface.class를 구현하여 생성함.
                RequestInterface request = retrofit.create(RequestInterface.class);

                //  request의 getRstJSONList()를 통하여 HTTP 요청을 서버에 보냄.
                //  Call : HTTP 요청을 보내고 응답을 받는 retrofit interface.
                Call<String> call = request.createRvw(rst_no, id, cont, score, phot);

                call.enqueue( new Callback<String>() {

                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String data = response.body();
                        System.out.println( data );
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                }) ;
            }
        });

        // 6.0 마쉬멜로우 이상일 경우에는 권한 체크 후 권한 요청
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED ) {
                Log.d(TAG, "권한 설정 완료");
            } else {
                Log.d(TAG, "권한 설정 요청");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
    }

    // 권한 요청
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult");
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED ) {
            Log.d(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
        }
    }


    // 카메라로 촬영한 영상을 가져오는 부분
    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent intent ) {
        super.onActivityResult( requestCode, resultCode, intent );
        try {
            switch (requestCode) {
                case TAKE_PICTURE:
                    if ( resultCode == RESULT_OK ) {
                        File file = new File( mCurrentPhotoPath );
                        Bitmap bitmap = MediaStore.Images.Media
                                .getBitmap( getContentResolver(), Uri.fromFile( file ) );
                        if ( bitmap != null ) {
                            ExifInterface ei = new ExifInterface( mCurrentPhotoPath );

                            int orientation = ei.getAttributeInt( ExifInterface.TAG_ORIENTATION,
                                    ExifInterface.ORIENTATION_UNDEFINED );

                            Bitmap rotatedBitmap;

                            switch( orientation ) {

                                case ExifInterface.ORIENTATION_ROTATE_90:
                                    rotatedBitmap = rotateImage( bitmap, 90 );
                                    break;

                                case ExifInterface.ORIENTATION_ROTATE_180:
                                    rotatedBitmap = rotateImage( bitmap, 180 );
                                    break;

                                case ExifInterface.ORIENTATION_ROTATE_270:
                                    rotatedBitmap = rotateImage( bitmap, 270 );
                                    break;

                                case ExifInterface.ORIENTATION_NORMAL:

                                default:
                                    rotatedBitmap = bitmap;
                            }

                            imageView.setImageBitmap( rotatedBitmap );
                            phot = rotatedBitmap;
                        }

                    }
                    break;
            }
        } catch ( Exception err ) {
            Log.d("CamActResult ERR : ", err.toString() );
            err.printStackTrace();
        }
    }

    //  카메라로 촬영한 이미지를 파일로 저장해 주는 함수
    private File createImageFile() throws IOException {
        //  사진 이름 만들기
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,      /* prefix */
                ".jpg",       /* suffix */
                storageDir          /* directory*/
        );

        //  Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    //  카메라 인텐트를 실행하응 부분을 별도의 함수로 만듦.
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //  Ensure that there's a camera activity to handle the intent
        if( takePictureIntent.resolveActivity( getPackageManager() ) != null ){
            //  Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            }   catch( IOException e ) {
                //  Error occured while creating the File
                Log.v("createImgFile() gotErr:", e.toString() );
            }
            //  Continue only if the File was Successfully created
            if( photoFile != null ) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.app.fileprovider", photoFile );
                takePictureIntent.putExtra( MediaStore.EXTRA_OUTPUT, photoURI );
                startActivityForResult( takePictureIntent, REQUEST_TAKE_PHOTO );
            }
        }
    }

    //  사진을 돌려주는 함수
    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(),
                matrix, true);
    }
}
