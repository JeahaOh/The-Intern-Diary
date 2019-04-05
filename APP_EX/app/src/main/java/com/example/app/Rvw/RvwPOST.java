package com.example.app.Rvw;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.service.autofill.FillEventHistory;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.Memb.Memb;
import com.example.app.R;
import com.example.app.Request.RequestInterface;
import com.example.app.Request.RetrofitClient;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.widget.Toast.makeText;

public class RvwPOST extends AppCompatActivity {

    final String TAG = getClass().getSimpleName();

    TextView rst_title;     //  화면 타이틀
    RatingBar ratingBar;    //  레이팅 바
    TextView rateResult;    //  레이팅 바 추가 text
    ImageView imageView;    //  이미지 미리보기
    Button cameraBtn;       //  사진 찍기 버튼
    Button loadPhoto;       //  사진 가져오기 버튼
    Button submit;          //  사진 가져오기 버튼

    int score = 3;          //  RatingBar 초기값.

    //  보낼 사진 File의 껍데기, 앨범 또는 카메라에서 가져온 이미지를 저장할 변수.
    private File tempFile;

    //  사진 경로
    private static String mCurrentPhotPath;

    // onActivityResult에서 requestCode로 반환 되는 값.
    private static final int PICK_FROM_ALBUM = 1;
    private static final int PICK_FROM_CAMERA = 2;
    // 카메라, 사진첩 접근 권한
    private Boolean isPermission = true;

    //  request 객체를 밖으로 뺐음.
    private static final RequestInterface request =
            RetrofitClient.getClient().create( RequestInterface.class );

    //  빠른시간 안에 중복 클릭을 방지하기 위한 기준 시간 변수.
    private static final long MIN_CLICK_INTERVAL = 600;
    private long mLastClickTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvw_post);

        //  화면 시작시 tedPermission()를 실행해서 권한을 확인함.
        tedPermission();

        //  데이터 받기
        Bundle intent = getIntent().getExtras();
        final int rst_no = intent.getInt( "rst_no" );
        final String rst_nm = intent.getString("rst_nm");
        rst_title = findViewById(R.id.rst_title);
        rst_title.setText( rst_nm + " 후기" );

        // 레이아웃과 변수 연결
        ratingBar  = findViewById(R.id.ratingBar);       //  Rating Bar
        rateResult = findViewById(R.id.rateResult);      //  Rating Bar의 Sub Text
        cameraBtn  = findViewById(R.id.takePhoto);       //  카메라 버튼
        loadPhoto  = findViewById(R.id.loadPhoto);       //  사진 가져오기 버튼
        imageView  = findViewById(R.id.phot_preview);    //  사진 미리보기 view
        submit     = findViewById(R.id.submit);          //  submit 버튼


        //  ratingBar 변경 리스너
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                score = (int) rating;
                switch( score ) {
                    case 1 :
                        rateResult.setText( "최악" );
                        return;
                    case 2 :
                        rateResult.setText( "별로" );
                        return;
                    case 3 :
                        rateResult.setText( "무난" );
                        return;
                    case 4 :
                        rateResult.setText( "맛집" );
                        return;
                    case 5 :
                        rateResult.setText( "추천" );
                }
            }
        });

        // 카메라 버튼에 리스너 추가
        cameraBtn.setOnClickListener(new Button.OnClickListener(){
            // 버튼 onClick 리스너 처리부분
            @Override
            public void onClick( View v ) {
                if(isPermission)  takePhoto();
                else makeText( getApplicationContext(),
                        getResources().getString(R.string.permission_2), Toast.LENGTH_SHORT).show();
            }
        });

        //  사진 가져오기 버튼에 리스너 추가
        loadPhoto.setOnClickListener( new Button.OnClickListener(){
            @Override
            public void onClick( View v ) {
                if(isPermission) goToAlbum();
                else makeText( getApplicationContext(),
                        getResources().getString(R.string.permission_2), Toast.LENGTH_SHORT).show();
            }
        });


        // submit 버튼에 리스너 추가
        submit.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //  여기서 부터 중복 클릭 방지를 위한 로직
                //  현재 시간.
                long currentClickTime = SystemClock.uptimeMillis();
                //  현재 시간에서 마지막 시간을 뺀 elapsedTime.
                long elapsedTime = currentClickTime - mLastClickTime;
                mLastClickTime = currentClickTime;
                //  elapsedTime가 기준 시간보다 늦다면 리턴.
                if(elapsedTime <= MIN_CLICK_INTERVAL){
                    Toast.makeText(getApplicationContext(), "fastClick", Toast.LENGTH_LONG);
                    return;
                }
                //  여기까지 중복 클릭 방지를 위한 로직


                //  여기부터 RVW의 유효성 겁사.

                //  후기 값을 String 가져온 뒤, null 값이면 Toast와 함께 return.
                EditText contText = findViewById(R.id.rvw_cont);
                String cont = contText.getText().toString();
                if( cont.length() <= 0 || cont.equals("")) {
                    makeText( getApplicationContext(),
                            R.string.nullCont, Toast.LENGTH_SHORT ).show();
                    return;
                }
                //  사진이 없다면 toast와 함께 return.
                if( tempFile == null || tempFile.length() <= 0) {
                    makeText( getApplicationContext(),
                            getResources().getString(R.string.nullPhot), Toast.LENGTH_SHORT).show();
                    return;
                }
                //  여기까지 RVW의 유효성 겁사.


                //  RequestBody로 전송할 data 포장.
                RequestBody requestFile
                        = RequestBody.create(MediaType.parse("multipart/form-data"), tempFile );
                MultipartBody.Part phot
                        = MultipartBody.Part.createFormData(
                                "phot", tempFile.getName(), requestFile);
                RequestBody RST_NO
                        = RequestBody.create(MediaType.parse("text/plain"), rst_no + "" );
                RequestBody ID
                        = RequestBody.create(MediaType.parse("text/plain"), Memb.getMemb().getId() );
                RequestBody CONT
                        = RequestBody.create(MediaType.parse("text/plain"), cont );
                RequestBody SCORE
                        = RequestBody.create(MediaType.parse("text/plain"), score + "" );

                Call<ResponseBody> call;
                call = request.upload(phot, RST_NO, ID, CONT, SCORE);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        onPostSuccess();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

            }
        });
    }

    /* 여기 부터 카메라 또는 갤러리 접근을 위한 권한 확인 method */
    private void tedPermission() {
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(getApplicationContext(), "카메라 및 갤러리 접근 권한 확인", Toast.LENGTH_SHORT).show();
                // 권한 요청 성공
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(getApplicationContext(), "카메라 및 갤러리 접근 권한 없음", Toast.LENGTH_LONG).show();
                // 권한 요청 실패
            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage(getResources().getString(R.string.permission_2))
                .setDeniedMessage(getResources().getString(R.string.permission_1))
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();
    }
    /* 여기 까지 카메라 또는 갤러리 접근을 위한 권한 확인 method */


    /* 앨범에서 이미지를 가져오기 위한 method */
    private void goToAlbum() {
        //  Intent를 이용해 앨범으로 이동함.
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }
    /* 앨범에서 이미지를 가져오기 위한 method */


    /* 카메라에서 이미지를 가져오기 위한 method */
    private void takePhoto() {
        //  Intent를 이용해 Camera로 이동함.
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        try {
            tempFile = createImageFile();
        } catch (IOException e) {
            makeText(this, "이미지 처리 오류! 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
            finish();
            e.printStackTrace();
        }
        if ( tempFile != null ) {
            /** tempFile 의 Uri 경로를 intent에 추가해 줘야 함.
             *  카메라에서 찍은 사진이 저장될 주소임.
             *  tempFile 을 전역변수로 해서 사용하기 때문에 이 tempFile 에 카메라에서 촬영한 이미지를 넣어 줄것임.
             */

            //  Android 버전에 맞춰서 작업 함.
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            Uri photoUri = FileProvider.getUriForFile(this,
                    "com.example.app.fileprovider", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
            startActivityForResult(intent, PICK_FROM_CAMERA);
            } else {
                Uri photoUri = Uri.fromFile(tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent, PICK_FROM_CAMERA);
            }
        }
    }
    /* 카메라에서 이미지를 가져오기 위한 method */

    /** startActivityForResult를 통해 다른 Activity에서 돌아오면
     *  onActivityResult가 동작하게 됨..
     *  requestCode로 반환 되는 동작을 하게 됨.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /* 카메라를 켰다 사진을 안찍거나, 앨범에 가서 사진을 안 골라 온 경우의 예외 처리 */
        if (resultCode != Activity.RESULT_OK) {
            makeText(this, "취소 되었습니다.", Toast.LENGTH_SHORT).show();
            if(tempFile != null) {
                if (tempFile.exists()) {
                    if (tempFile.delete()) {
                        tempFile = null;
                    }
                }
            }
            return;
        }
        /* 카메라를 켰다 사진을 안찍거나, 앨범에 가서 사진을 안 골라 온 경우의 예외 처리 */

        /*  onActivityResult의 requestCode 값에 따라 로직이 실행됨 */
        if (requestCode == PICK_FROM_ALBUM) {
            Uri photoUri = data.getData();
            Cursor cursor = null;
            try {
                // Uri 스키마를 `content:///`에서 `file:///`로  변경.
                String[] proj = { MediaStore.Images.Media.DATA };

                assert photoUri != null;
                cursor = getContentResolver()
                        .query(photoUri, proj, null, null, null);

                assert cursor != null;
                int column_index = cursor.getColumnIndexOrThrow( MediaStore.Images.Media.DATA );

                cursor.moveToFirst();

                tempFile = new File(cursor.getString(column_index));
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
            setImage();
        } else if (requestCode == PICK_FROM_CAMERA) {

            setImage();
        }
        /*  onActivityResult의 requestCode 값에 따라 로직이 실행됨 */



//                    File file = tempFile;
////                    Bitmap bitmap = MediaStore.Images.Media
////                            .getBitmap( getContentResolver(), Uri.fromFile( file ) );
////                    if( bitmap != null ){
////                        ExifInterface ei = new ExifInterface( mCurrentPhotPath );
////                        int orientation = ei.getAttributeInt( ExifInterface.TAG_ORIENTATION,
////                                ExifInterface.ORIENTATION_UNDEFINED);
////
////                        Bitmap rotatedBitmap = null;
////                        switch( orientation ){
////                            case ExifInterface.ORIENTATION_ROTATE_90:
////                                rotatedBitmap = rotateIamge(bitmap, 90);
////                                break;
////                            case ExifInterface.ORIENTATION_ROTATE_180:
////                                rotatedBitmap = rotateIamge(bitmap, 180);
////                                break;
////                            case ExifInterface.ORIENTATION_ROTATE_270:
////                                rotatedBitmap = rotateIamge(bitmap, 270);
////                                break;
////                            case ExifInterface.ORIENTATION_NORMAL :
////                            default:
////                                rotatedBitmap = bitmap;
////                        }
////                        setImage();
////                    }


    }

    /** 받아온 이미지 넣기
     *  전역 변수 tempFile을 불러와 bitmap 파일로 변환한 후,
     *  imageView에 넣어줌.
     */
    private void setImage() {

        ImageView imageView = findViewById(R.id.phot_preview);

        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap originalBm = BitmapFactory.decodeFile(tempFile.getAbsolutePath(), options);
        Log.d(TAG, "setImage : " + tempFile.getAbsolutePath());

        imageView.setImageBitmap(originalBm);
    }
    /* 받아온 이미지 넣기 */

    /* 카메라에서 찍어온 사진을 저장할 파일 만들기 */
    private File createImageFile() throws IOException {
        // 이미지 파일 이름 ( Yummy_{시간}_ )
        @SuppressLint("SimpleDateFormat")
        String timeStamp = new SimpleDateFormat("HHmmss").format( new Date() );
        String imageFileName = "Yummy_" + timeStamp + "_";

        // 이미지가 저장될  폴더 이름
        File storageDir = new File(
                Environment.getExternalStorageDirectory() + "/DCIM/Camera/");
        if (!storageDir.exists()) {
            storageDir.mkdirs();
        }

        File image = File.createTempFile(
                imageFileName,      /* prefix */
                ".jpg",       /* suffix */
                storageDir          /* directory*/
        );

        mCurrentPhotPath = image.getAbsolutePath();
        // 빈 파일 생성
        return image;
    }
    /* 카메라에서 찍어온 사진을 저장할 파일 만들기 */

    /* 카메라에서 찍어온 이미지의 촬영 각에 맞춰 사진을 돌려주는 메소드 */
    public static Bitmap rotateIamge( Bitmap source, float angle ) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(
                source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }
    /* 카메라에서 찍어온 이미지의 촬영 각에 맞춰 사진을 돌려주는 메소드 */

    /* POST가 완료되면 하는 행동 */
    private void onPostSuccess() {
        //  POST가 완료 되었다고 ToastMessage를 띄움.
        Toast.makeText(this, "리뷰 작성 성공!", Toast.LENGTH_LONG).show();
        //  activity를 종료시킴.
        finish();
    }
    /* POST가 완료되면 하는 행동 */

}
