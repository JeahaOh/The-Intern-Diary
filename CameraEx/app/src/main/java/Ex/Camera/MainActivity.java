package Ex.Camera;

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
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button cameraButton;
    String mCurrentPhotoPath;
    final static int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  레이아웃과 변수 연결
        imageView = findViewById(R.id.imageview);
        cameraButton = findViewById(R.id.camera_button);

        //  카메라 버튼에 리스너 추가
        cameraButton.setOnClickListener( this );

        //  6.0 마쉬멜로우 이상일 경우에는 권한 체크 후 권한 요청
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if( checkSelfPermission( Manifest.permission.CAMERA ) == PackageManager.PERMISSION_GRANTED
                    &&
                    checkSelfPermission( Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText( getApplicationContext(), "권한 설정 완료", Toast.LENGTH_SHORT );
            } else {
                Toast.makeText( getApplicationContext(), "권한 설정 요청", Toast.LENGTH_SHORT );
                ActivityCompat.requestPermissions(
                        this,
                        new String[]
                                { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE },
                        1);

            }
        }
    }

    //  권한 요청 메소드
    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Toast.makeText(getApplicationContext(), "onRequestPermissionsResult", Toast.LENGTH_LONG);
        if( grantResults[0] == PackageManager.PERMISSION_GRANTED
                &&
                grantResults[1] == PackageManager.PERMISSION_GRANTED ) {
            Toast.makeText( getApplicationContext(), "Permission: " + permissions[0] + " was " + grantResults[0] , Toast.LENGTH_SHORT);
        }
    }

    //  버튼 onClickListener 처리부분
    @Override
    public void onClick( View v ) {
        switch( v.getId() ){
            case R.id.camera_button:
                Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_LONG);
                //  카메라 앱을 여는 소스
                takePhoto();
                break;
        }
    }

    //  카메라로 촬영한 영상을 가져오는 부분
    protected void onActivityResult( int requestCode, int resultCode, Intent intent ) {
        super.onActivityResult( requestCode, resultCode, intent);
        try {
            switch (requestCode) {
                case REQUEST_TAKE_PHOTO:
                    if (resultCode == RESULT_OK ) {
                        Toast.makeText(getApplicationContext(), "onActivityRESULT_OK", Toast.LENGTH_LONG);
                        File file = new File( mCurrentPhotoPath );
                        Bitmap bitmap =
                                MediaStore
                                        .Images
                                        .Media
                                        .getBitmap(
                                                getContentResolver()
                                                , Uri.fromFile( file ));
                        if( bitmap != null ) {
                            ExifInterface ei = new ExifInterface( mCurrentPhotoPath );
                            Toast.makeText(getApplicationContext(), mCurrentPhotoPath, Toast.LENGTH_LONG);
                            int orientation = ei.getAttributeInt
                                    ( ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED );

                            Bitmap rotatedBitmap = null;
                            switch( orientation ){
                                case ExifInterface.ORIENTATION_ROTATE_90:
                                    Toast.makeText(getApplicationContext(), "ORIENTATION_ROTATE_90", Toast.LENGTH_LONG);
                                    rotatedBitmap = rotateImage( bitmap, 90 );
                                    break;
                                case ExifInterface.ORIENTATION_ROTATE_180:
                                    Toast.makeText(getApplicationContext(), "ORIENTATION_ROTATE_90", Toast.LENGTH_LONG);
                                    rotatedBitmap = rotateImage( bitmap, 180 );
                                    break;
                                case ExifInterface.ORIENTATION_ROTATE_270:
                                    Toast.makeText(getApplicationContext(), "ORIENTATION_ROTATE_90", Toast.LENGTH_LONG);
                                    rotatedBitmap = rotateImage( bitmap, 270 );
                                    break;
                                case ExifInterface.ORIENTATION_NORMAL:
                                default:
                                    Toast.makeText(getApplicationContext(), "ORIENTATION_NORMAL", Toast.LENGTH_LONG);
                                    rotatedBitmap = bitmap;
                            }
                            imageView.setImageBitmap( rotatedBitmap );
                        }
                    }
                    break;
            }
        } catch ( Exception err ) {
            err.printStackTrace();
        }
    }

    /* 카메라에서 찍어온 사진을 저장할 파일 만들기 */
    private File createImageFile() throws IOException {
        //  이미지 이름 만들어 주기
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format( new Date() );
        String imageFileName = "JEPG_" + timeStamp + "_";
        // 이미지가 저장될  폴더 이름
        File storageDir = getExternalFilesDir( Environment.DIRECTORY_PICTURES );
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",  /* suffix */
                storageDir      /* directory */
        );

        //  사진 파일 저장
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }
    /* 카메라에서 찍어온 사진을 저장할 파일 만들기 */

    //  카메라 인텐트를 실행하는 별도의 함수
    private void takePhoto() {
        Intent takePictureIntent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE );
        //  인텐트를 저리 할 카메라 활동이 있는지 확인.
        if( takePictureIntent.resolveActivity( getPackageManager() ) != null ) {
            //  지정한 곳으로 사진 파일 저장
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (Exception e) {
                //  사진 생성중 예외 발생
            }
            //  사진이 정상적으로 생성되면 계속 작업
            if( photoFile != null ) {
                Uri photoURI = FileProvider.getUriForFile(
                        this,
                        "Ex.Camera.fileprovider",
                        photoFile
                );
                takePictureIntent.putExtra( MediaStore.EXTRA_OUTPUT, photoURI );
                startActivityForResult( takePictureIntent, REQUEST_TAKE_PHOTO );
            }
        }
    }

    //  이미지를 회전 시키는 Method
    public Bitmap rotateImage( Bitmap source, float angle ) {
        Matrix matrix = new Matrix();
        matrix.postRotate( angle );
        Toast.makeText(getApplicationContext(), "ORIENTATION_NORMAL", Toast.LENGTH_LONG);
        return Bitmap.createBitmap
                ( source, 0, 0, source.getWidth(), source.getHeight(), matrix, true );
    }
}
