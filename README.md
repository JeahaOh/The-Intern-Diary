# The-Intern-Diary

**2019년 02/11 ~ 04/11 인턴 기록**

-------------------------------------------------------------------------------------------

## 04/02 화요일

### 10:00

Menu Package 생성.

### 11:10

GET 방식 URL (/menu/list?rst_no=XXX )로 Menu List JSON 전송

### 11:20

Menu List를 WEB상에서는 어떻게 출력 할지, APK 상에서는 어떻게 출력 할지 고민중...  
그나저나 사진 File 삭제 로직도 구현 해야 할 것 같은데...  
- https://javacpro.tistory.com/27

### 15:30

WEB (rst/detail?id=XXX)에 menuList출력.

### 16:10

CSS 정리

### 17:00
- https://www.androidhive.info/
    - 안드로이드 UI 도와주는 WEB

### 17:35

MainActivity 중복 클릭...  
Menu..?

-------------------------------------------------------------------------------------------

## 04/02 화요일

### 09:00

완성하지 못한 부분 개선을 하자.
rstDetail.jsp

사진이 변경되면 js로 UUID를 만든뒤 사진만 먼저 서버에 저장, DB에 사진 이름 저장.
UUID를 input hidden으로 이름만 저장해 둔 뒤 rstDetail 저장할때 사진 이름도 저장시킴.
rstController에서 photSevice에 rst_no와 phot_no를 저장??

### 11:30

이미 짜둔 로직을 바꿔야 해서 어떻게 해야할지 한참 고민중임.

### 14:40

이상하다 이상해  
어렵다 어려워

### 16:35

처음부터 로직을 잘못 짠걸까

### 17:25

식당 정보, 사진 저장 수정 성공...  
코드 정리 해야 함.

-------------------------------------------------------------------------------------------

## 04/01 월요일

### 11:50 발표 준비

### 13:15

식당 등록시 에러 발견...

### 14:40

식당 저장 SQL문 수정

### 17:10

발표 후 시간이 훅 갔음.  
프로젝트 싸이즈가 작고 기본적인것만 해서 그런지 질문이 거의 없었음..  
이미지 업로드 이슈를 해결 하지 못한것에 웬지 감점 요소가 있었을것으로 생각 됨.  

-------------------------------------------------------------------------------------------

## 03/31 일요일

### 14:40 

인턴 과정에 대한 결산 보고 준비
-   발표 컨텐츠 구성 :
    -   인턴 생활을 마치며...
    -   인턴기간 시작부터 끝까지 무엇을 하고 무엇을 배웠고를 정리...
    -   내가 인턴 전에 알던것은 어떻고 인턴 생활을 마치며 무엇을 배웠고 알게 되었다를 정리.
    -   과제 : 처음에 이만큼 하고자 했던 것들을 어떤 과정을 걸처서 이만큼 했다를 보고..

### 15:10

DB ReverseEngineering으로 Table과 data 추출 저장.

### 15:20

예제 프로젝트들 경로 정리

### 20:00

인턴을 마친 후기 정리


-------------------------------------------------------------------------------------------

## 03/30 토요일

### 13:25

Speing 주석 작업중..  
rvw.js 파일 메소드들 다시 확인 해 봐야함...  
rvw detail이 뜨지 않는 증상도 발견...  
대체 어디서 꼬인걸까?  

### 14:34

rvw 문제 해결...  
getRvwList SQL문 수정하면서 getRvwDtl SQL문을 확인도 안하고 건드렸던게 문제였음..  
**!!SQL은 함부러 건드리는게 아니다!!**

### 14:40

rvw 삭제문제 발견..  
rvw에 사진이 있다면 외래키 문제로 삭제가 안되는 것 으로 판단 됨.

### 15:10

rvw 삭제 제약조건 잘못 건드렸다가 rst에 접근이 안됨....  
해결 : rvw 삭제 요청이 오면, rvw table의 useyn을 N값으로 주는것으로 했음.

### 16:20

APK 주석 처리중인데, MainActivity에서 RstDetail로 넘어갈때 Rst 객체로 넘기도록 해야겠음...

### 21:00

APK rst도 객체로 전달 시키기 성공..

### 21:20

APK Google Map API 예외 처리...  

### 22:40

웬만한 코드정리 완료..  
내일 사진 각도 잡아주는 메소드 만들어 주고, 발표 준비를 하도록 하자.


-------------------------------------------------------------------------------------------

## 03/29 금요일

### 10:40

Rvw Detail UI 성공.

### 11:00

일부 수정

### 11:35

전화 걸기 기능

### 14:22 

일부 기능 수정

남은 시간 안에 할 일
- APK Camera 기능 개선 (사진 상하 구분 못하는 부분)
- APK 후기 작성시 사진 없이도 upload 하기
- 코드 주석 작성

### 15:00

월요일 : 인턴 과정에 대한 결산 보고를 땡겨서 하는것임.
-   인턴생활 전체에 대한 보고를 하는것.
-   컨텐츠 구성 :
    -   개발이 잘 나왔는가 아닌가가 아니고 시작부터 끝까지 무엇을 하고 무엇을 배웠고를 정리...
    -   과제 : 처음에 이만큼 하고자 했던 것들을 어떤 과정을 걸처서 이만큼 했다를 보고..
    -   내가 인턴 전에 알던것은 어떻고 인턴 생활을 마치며 무엇을 배웠고 알게 되었다를 정리.
    -   인턴 생활을 마치며...

### 15:15

작업물들 주석 처리중

### 17:10

주석 처리와 작업물 일부 수정.

-------------------------------------------------------------------------------------------

## 03/28 목요일

- APK 상에서 구글 지도 더 유연하게 움직이기?
    - https://stackoverflow.com/questions/33117198/how-to-make-google-maps-scroll-properly-inside-scroll-view

- 폰에서 백버튼 누를때 원하는 화면으로 넘어가게 하는 방법?
    - @Override
    public void onBackPressed() {
        startActivity(new Intent(context, SoundSetting.class));
    }    

### 11:50

APK 후기 작성 완료시 기능 성공.

### 13:05 Linux 서버 시간 이상 확인

- https://antilibrary.org/422

### 14:20

APK rvwList에서 rvw 사진을 보여주려고 했으니 adapter에서 안되는것 같음.. 방법은 있을텐데 모르겠음..

### 14:50

rvwPost Post Button 중복 클릭 방지.

### 16:00

Intent로 객체 전달? 성공.
- https://eunplay.tistory.com/28

### 17:30

rstAdapter에서는 onBindViewHolder에서 onClickListener가 작동하는데,  
rvwAdapter에서는 작동하지 않음...  
이유가 뭘까..?


### 20:50

onClickListener가 먹지 않은 이유는 어처구니 없게도 앞에 있는 switch문에서 return을 먹어서 였음...
- 안드로이드 디버깅하는 방법
    - http://labs.brandi.co.kr/2018/06/14/kimby.html

### 21:20

팝업으로 activity 띄우기 예제
- https://ghj1001020.tistory.com/9
- https://arabiannight.tistory.com/entry/275

### 22:25

Rvw_Detail Activity UI Design 없는 생성



-------------------------------------------------------------------------------------------

## 03/27 수요일

### 09:24

PopUpMenu 예제
- https://core9090.tistory.com/22
- https://survivalking.tistory.com/25

### 09:50

MainActivity에 PopUp Menu 삽입

### 10:35

checkbox dialog로 변경

### 11:00

Rst에 min_price Field 추가, sql문 수정

### 11:15

SQL문 수정

### 13:00

- https://stackoverflow.com/questions/30398247/how-to-filter-a-recyclerview-with-a-searchview
    - 참고하고 싶은데 너무 어렵다

### 13:40

RecyclerView Search 간단한 예제 발견

### 16:25

가격에 따른 Filtering 성공.

### 16:45

- 남은 기능
    - APK Camera 기능 개선 (사진 상하 구분 못하는 부분)
    - APK 후기 보기 기능 및 후기 작성 완료시 기능
    - APK 후기 작성시 사진 없이도 upload 하기
    - APK 후기 사진 리스트로 보여주기..
    - APK rst Menu 보여주기..
    - WEB Apache Tiles

-------------------------------------------------------------------------------------------

## 03/26 화요일

### 14:40

UI 수정

### 17:50

약간의 디테일 수정...  
필터링 꼭 해야해

### 21:00

Filtering 예제?  
설명이 영어라 못 알아 먹겠음...

### 21:00

Checkbox에 onCheckedChangeListener()를 이용해서
- https://bitsoul.tistory.com/46
Filtering을 한다?
- https://pyeongho.github.io/edit_search
- https://jizard.tistory.com/53

### 21:20

Checkbox onCheckedChangeListener() 예제


### 00:30

음...

-------------------------------------------------------------------------------------------

## 03/25 월요일

### 14:05

드디어... rvw랑 phot POST 성공..!  
일단 git commit 후에 코드 정리 해야겠음...

### 14:35

코드 정리

### 15:00

UI 수정

### 16:45

Tiles 재실패...

### 17:15

이번주 주간보고 없이 다음주 월요일에 주간 보고, 다음주 수요일에 결과 보고..  
남은 작업중에 무엇이 우선일지 고민 해 봐야 할 시점인듯 함.  

  타일즈? 필터링? UI 정리? 페이징 처리? 주석? 고민 해봐야겠음..

rst_list filter
- 검색 키워드
    - 안드로이드 리사이클러뷰 필터
    - android recyclerview filterable
    - https://academy.realm.io/kr/posts/android-search-text-view/
    - https://www.androidpub.com/2223800

### 18:00

일부 주석 정리

### 23:00

Header, Navbar, Footer Design

-------------------------------------------------------------------------------------------

## 03/24 일요일

### 09:42

MultipartFile.getOriginalFileName()

-------------------------------------------------------------------------------------------

## 03/23 토요일

### 01:55

ratingBar OnRatingBarChangeListener와 score

### 13:30

일단 RvwPost Activity에서 form data 만드는 것 부터 해야겠음...

### 14:40

갤러리에서 사진 가져오기

### 15:20

APP RvwPost Activity reinit...

- URI?
    - https://computer99.tistory.com/5

### 16:15

```
2019-03-23 16:13:25.659 7843-7843/com.example.app E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.example.app, PID: 7843
    android.os.FileUriExposedException: file:///storage/emulated/0/Android/data/com.example.app/files/Pictures/Yummy_161325_8777534467889681584.jpg exposed beyond app through ClipData.Item.getUri()
        at android.os.StrictMode.onFileUriExposed(StrictMode.java:1960)
        at android.net.Uri.checkFileUriExposed(Uri.java:2348)
        at android.content.ClipData.prepareToLeaveProcess(ClipData.java:942)
        at android.content.Intent.prepareToLeaveProcess(Intent.java:9854)
        at android.content.Intent.prepareToLeaveProcess(Intent.java:9839)
        at android.app.Instrumentation.execStartActivity(Instrumentation.java:1610)
        at android.app.Activity.startActivityForResult(Activity.java:4487)
        at android.support.v4.app.FragmentActivity.startActivityForResult(FragmentActivity.java:767)
        at android.app.Activity.startActivityForResult(Activity.java:4445)
        at android.support.v4.app.FragmentActivity.startActivityForResult(FragmentActivity.java:754)
        at com.example.app.Rvw.RvwPOST.takePhoto(RvwPOST.java:212)
        at com.example.app.Rvw.RvwPOST.access$100(RvwPOST.java:34)
        at com.example.app.Rvw.RvwPOST$2.onClick(RvwPOST.java:117)
        at android.view.View.performClick(View.java:6294)
        at android.view.View$PerformClick.run(View.java:24770)
        at android.os.Handler.handleCallback(Handler.java:790)
        at android.os.Handler.dispatchMessage(Handler.java:99)
        at android.os.Looper.loop(Looper.java:164)
        at android.app.ActivityThread.main(ActivityThread.java:6494)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:438)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:807)
```

- https://kyome.tistory.com/9

### 앱 사이의 파일 공유
Android 7.0을 대상으로 하는 앱의 경우,  
Android 프레임워크는 앱 외부에서 file:// URI의 노출을 금지하는 StrictMode API 정책을 적용합니다.  
파일 URI를 포함하는 인텐트가 앱을 떠나면 FileUriExposedException 예외와 함께 앱에 오류가 발생합니다.  
  
애플리케이션 간에 파일을 공유하려면 content:// URI를 보내고 이 URI에 대해 임시 액세스 권한을 부여해야 합니다.  
이 권한을 가장 쉽게 부여하는 방법은 FileProvider 클래스를 사용하는 방법입니다.  
  
권한과 파일 공유에 대한 자세한 내용은 파일 공유를 참조하세요.
- https://developer.android.com/about/versions/nougat/android-7.0-changes.html#accessibility

위에 설명에서와 같이 FileProvider클래스를 사용해서 content:// URI에 권한을 부여하는 방법을 보면 다음과 같습니다.



1. AndroidManifest.xml 수정
    ```
    <application>
        <provider
            android:name="android.support.v4.content.FileProvider"
            android:authorities="com.bignerdranch.android.test.fileprovider"
            android:exported="false"
            android:grantUriPermissions="true">
            <meta-data
                android:name="android.support.FILE_PROVIDER_PATHS"
                android:resource="@xml/filepaths" />
        </provider>
    </application>
    ```

2. res/xml/filepaths.xml 생성
    ```
    <?xml version="1.0" encoding="utf-8"?>
    <paths xmlns:android="http://schemas.android.com/apk/res/android">
        <external-path name="storage/emulated" path="."/>
    </paths>
    ```
3. Uri.fromFile(File mFile) 코드 대체
    ```
    Uri uri = Uri.fromFile(mPhotoFile);
    -> Uri uri = FileProvider.getUriForFile(getContext(), "com.Yummy.android.EX.fileprovider", mPhotoFile);
    ```
*com.Yummy.android.EX 부분은 개인의 도메인임.  
mPhotoFile 대신 생성한 파일 객체를 넣음..  
  
**filepaths.xml과 AndroidManifest.xml 내부의 meta-data, android:resource="@xml/filepaths"가 일치해야함**


### 17:00

사진 찍어 파일 만들기, 앨범에서 사진 선택하기 성공....  
    ```
    2019-03-23 16:55:12.133 12390-12390/com.example.app I/System.out: 	SUBMIT BTN CLICKED!
    2019-03-23 16:55:12.133 12390-12390/com.example.app I/System.out: id : asdf1020
    2019-03-23 16:55:12.133 12390-12390/com.example.app I/System.out: rst_no : 4
    2019-03-23 16:55:12.133 12390-12390/com.example.app I/System.out: score : 3
    2019-03-23 16:55:12.133 12390-12390/com.example.app I/System.out: cont : 후기 작성하기
    2019-03-23 16:55:12.133 12390-12390/com.example.app I/System.out: phot.path() :/storage/emulated/0/Yummy/Yummy_165455_2341088579743724054.jpg
    ```

### 17:20

코드 정리

### 17:30

카메라 회전각도 적용?  
카메라 회전은 작동 하지 않음...  
시간 관계상 다음 단계 진행 하는걸로..
- 최초에 따라 했던 예제
    - https://blog.naver.com/whdals0
- 원본 예제
    - http://blog.naver.com/PostView.nhn?blogId=whdals0&logNo=221408855795&categoryNo=29&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=search
- 다른 예제
    - https://superwony.tistory.com/5
    - https://stickyny.tistory.com/95
    - https://blog.hansoolabs.com/583

### 21:40

사진 없이 FormUrlEncoded로 통신 성공..

1. Request Interface
    ```
    @Headers({
            "Content-Type:application/x-www-form-urlencoded;charset=UTF-8"
    })
    @FormUrlEncoded
    @POST("/yummy/rvw/Element")
    Call<ResponseBody> postRvw(
            @Field("rst_no")    int rst_no,
            @Field("id")        String id,
            @Field("cont")      String cont,
            @Field("score")     int score
    );
    ```

2. ReviewPOST
    ```◊
    Call<ResponseBody> call = request.postRvw(rst_no, id, cont, score);

    call.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {

        }
    });
    ```

3. Controller
    ```
    @RequestMapping(value = "/Element", method = RequestMethod.POST)
    public String Element(
            int rst_no, String id, String cont, int score
                ) throws Exception {
        System.out.println("\nrvw/Element FORM TEST");
        System.out.printf("%d, %s, %s, %d\n\n",rst_no , id , cont, score);
        return "rvwTest";
    }
    ```


4. Android Studio Logcat
    ```
    D/OkHttp: --> POST http://IP:8888/yummy/rvw/Element
    D/OkHttp: Content-Type: application/x-www-form-urlencoded;charset=UTF-8
    D/OkHttp: Content-Length: 91
    D/OkHttp: rst_no=2&id=asdf1020&cont=%ED%9B%84%EA%B8%B0%20%EC%9E%91%EC%84%B1%ED%95%98%EA%B8%B0&score=5
    D/OkHttp: --> END POST (91-byte body)
    D/OkHttp: <-- 200 http://`IP:8888/yummy/rvw/Element (54ms)
    ```

5. Eclipse Console Log
    ```
    rvw/Element FORM TEST
    2, asdf1020, 후기 작성하기, 5
    ```

### 23:20

RetrofitClient Refactoring

### 23:25

- http://chuumong.github.io/android/2017/01/13/Get-Started-With-Retrofit-2-HTTP-Client

### 23:55

사진만 전송 성공

1. Request Interface
    ```
    @Multipart
    @POST("/yummy/rvw/phot")
    Call<ResponseBody> postPhot( @Part MultipartBody.Part File );
    ```

2. Review Post
    ```
    RequestBody requestFile
            = RequestBody.create( MediaType.parse( "multipart/form-data" ), tempFile );
    MultipartBody.Part body
            = MultipartBody.Part.createFormData(
                    "phot", tempFile.getName(), requestFile );

    Call<ResponseBody> call = request.postPhot( body );

    call.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse( Call<ResponseBody> call, Response<ResponseBody> response ) {

        }

        @Override
        public void onFailure( Call<ResponseBody> call, Throwable t ) {

        }
    });
    ```
3. Controller
    ```
    @ResponseBody
    @RequestMapping(value = "/phot", method = RequestMethod.POST, consumes = "multipart/form-data") // 
    public String imgOnly(
        @RequestPart(name="phot", required = false) MultipartFile phot
        ) throws Exception {
        System.out.println("\nrvw/phot POST TEST");
        logger.info("\n\t/rvw/Object receive -->\nrvwPhot : {}\n", phot.getSize());
        return "Success";
    }
    ```
4. Android Studio Logcat
    ```
    D/OkHttp: --> POST http://172.20.10.10:8888/yummy/rvw/phot
    D/OkHttp: Content-Type: multipart/form-data; boundary=8cf46a36-3666-459d-b0b9-ab06509751bc
    D/OkHttp: Content-Length: 174366
    D/OkHttp: --8cf46a36-3666-459d-b0b9-ab06509751bc
    D/OkHttp: Content-Disposition: form-data; name="phot"; filename="Yummy_000551_9160860048574099024.jpg"
    D/OkHttp: Content-Type: multipart/form-data
    D/OkHttp: Content-Length: 174127
    D/OkHttp: ������JFIF����������������C��		
    I/chatty: uid=10080(com.example.app) .10.10:8888/... identical 2 lines
    --- 생략
    D/OkHttp: --> END POST (2719153-byte body)
    D/OkHttp: <-- 200 http://172.20.10.10:8888/yummy/rvw/phot (1985ms)
    D/OkHttp: Accept-Charset: 
    --- 생략 
    D/OkHttp: Content-Type: text/html;charset=UTF-8
    D/OkHttp: Content-Length: 7
    D/OkHttp: Date: Sat, 23 Mar 2019 14:52:32 GMT
    D/OkHttp: Success
    D/OkHttp: <-- END HTTP (7-byte body)
    ```

5. Eclipse Console Log
    ```
    rvw/phot POST TEST
    2019-03-23 23:52:32,769  INFO [egovframework.rvw.web.RvwController] 
        /rvw/Object receive -->
    rvwPhot : 2718930
    ```
- https://philip1994.tistory.com/15

### 00:50

    사진 File, Rvw 객체 제이슨 전송하면 성공 할 듯.

-------------------------------------------------------------------------------------------

## 03/22 금요일

### 11:00

Create Rvw  UI 제작, 화면 연결함.

### 13:20

안드로이드 카메라 사용 예제 공부중.
- http://blog.naver.com/PostView.nhn?blogId=whdals0&logNo=221408855795&categoryNo=29&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=search

### 14:50

Create RVW UI 수정, 카메라 기능 개선 예제
- https://blog.naver.com/whdals0/221409327416

### 17:40

Retrofit POST 415

-------------------------------------------------------------------------------------------

## 03/21 목요일

### 09:35

에러 발견.  
rst_detail에 사진이 없는 경우 사진이 안올라감.  
사진이 있는경우 수정을 통해서 사진이 올라감.  
사진 유무의 판단 로직에 문제가 있는듯 하다...  

### 10:35

FeedBack
- 5초 없애야 함...
- 후기작성, 소팅, tiles

### 13:15

사진이 404일때 재요청 하기..  
but 요청을 너무 많이해서 다른 방법을 찾아야 할 듯함.

### 13:50

사진 저장 로직 개선.

### 15:00

PhotService의 phot 저장 기능 개선.

### 15:35

JSP:INCLUDE 성공...  
include에는 c:url을 쓸 수 없음..  
c:url은 js, css, image file 등의 파일에만 쓸 수 있음...

### 15:50

tiles를 꼭 하고 싶은데 짜잘한 기능이라서 나중에 하기로 했음..  
- https://velog.io/@bakim17/%EC%A0%84%EC%9E%90%EC%A0%95%EB%B6%80-tiles-%EC%84%B8%ED%8C%85    
링크 보면 금방 할 수 있는 기능인 듯 함.

### 20:45

AJAX로 rvw/saveWith에 rvw JSON 객체 전송 성공...  
BUT Multipart는 아직 못함...

### 22:40

RvwController에서 AJAX JSON으로 Multipart File과 Rvw 내용을 받게 하려고 삽질을 했는데,  
생각해 보니 retrofit 2에서 POST를 하면 알아서 formdata 형식으로 보내준다고 봤던게 지금 생각 났음...
일단 form 형식으로 MultipartFile이랑 Rvw 받는 method를 만들고 작동 확인 했고,
Android에서 Retrofit을 사용해서 POST 하면서 테스트 해 봐야 할것 같음...

- 참고 했던 LINK
    - http://hacks.mozilla.or.kr/2010/05/firefox-4-formdata%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC-js%EB%A1%9C-%EB%B3%B4%EB%8B%A4-%EC%89%BD%EA%B2%8C-%ED%8F%BC-%EB%8B%A4%EB%A3%A8%EA%B8%B0/
    - https://www.zerocho.com/category/HTML&DOM/post/59465380f2c7fb0018a1a263
    - https://dev.to/imben1109/html-form-ajax-file-upload-front-end-2klc
    - http://hellowk1.blogspot.com/2015/07/formdata-file-submit-with-formdata.html
    - https://brunch.co.kr/@ourlove/69

-------------------------------------------------------------------------------------------

## 03/20 수요일

### 09:25

게시물 먼저 저장하고, 게시물 번호 받아서 사진 저장

### 11:05

AJAX로 사진 전송, 수신 성공!
- https://roqkffhwk.tistory.com/67

### 13:45

사진 저장 성공.
- 사진 저장 경로
    - /Users/Jeaha/egov/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/yummy/resources/images/rst
- 참고는 했지만 도움은 되지 않은 링크
    - https://blog.hanumoka.net/2018/09/06/spring-20180906-spring-file-upload/
    - https://meaownworld.tistory.com/30
    - https://shj7242.github.io/2017/12/07/Spring30/
    - http://blog.daum.net/question0921/422

### 14:05
- com.yummy phot package 생성

### 15:20

사진 저장, DB에 사진 이름 저장 성공.

### 15:30

식당에 대해 사진이 1장 이상일 경우 에러 발생...  
DB 설계를 잘못한 듯 하다

### 16:20

식당 사진 에러 수정.  
DB에 rst_no에 대해 이미 phot_no이 있는 경우 이미 있는 phot_no를 삭제 후 upload

### 16:45

작업 내용 주석 처리

### 17:05

rvw에 대한 multipart form data upload 처리를 해야함.

-------------------------------------------------------------------------------------------

## 03/19 화요일

### 09:25

Rst Rate 정보 출력 성공.

### 11:30

Rvw List 준비중

### 14:40

Rvw List 출력 성공

### 15:20

구글 지도 API, RstDetail Scroll 기능 추가.

### 16:10

지도 UI height 수정

### 17:25

WEB rst/detail image path 설정

### 18:00

- 이미지 파일 확장자 없이 연결
    - https://devks.tistory.com/23
      
    전자정부 default setting으로 했는데 경로 문제였음...  

### 20:20

웹 image UI 수정

### 20:45

adroid image 불러오는 lib
- https://code.tutsplus.com/ko/tutorials/android-sdk-working-with-picasso--cms-22149

### 21:30

android image 출력 성공

### 22:00

사진 올리는 기능 만들기 해야함.  
rvw 작성부터? rst 작성부터?


### 23:50

URL 정리

1. Android Study Link 모음
    - Android Activity 시작
        - https://developer.android.com/training/basics/activity-lifecycle/starting?hl=ko

    - Android Life Cycle
        - https://vaert.tistory.com/161

    - Android 화면 전환과 Activity 간 데이터 전송
        - https://jizard.tistory.com/10

    - Layout, ViewGroup, View 개념정리
        - https://mattlee.tistory.com/74

    - Android Layout 탐구
        - https://academy.realm.io/kr/posts/exploring-new-android-layouts/

    - Linear Layout
        - https://developer.android.com/guide/topics/ui/layout/linear?hl=ko

    - View
        - https://m.blog.naver.com/PostView.nhn?blogId=netrance&logNo=110121255363&categoryNo=84&proxyReferer=&proxyReferer=https%3A%2F%2Fwww.google.com%2F

    - Activity And View
        - https://m.blog.naver.com/netrance/110121169955

    - RecyclerView 간단 설명
        - https://liveonthekeyboard.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-RecyclerView-1-%EA%B0%84%EB%8B%A8%ED%95%9C-%EC%82%AC%EC%9A%A9%EB%B2%95
        - https://programmingfbf7290.tistory.com/entry/%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-%EC%89%AC%EC%9A%B4-RecyclerView

    - RecyclerView에 대한 고찰
        - http://dudmy.net/android/2017/06/23/consider-of-recyclerview/

    - Adapter
        - https://straight-strange.tistory.com/23

    - Adapter And View
        - http://dktfrmaster.blogspot.com/2016/09/adapter-view.html

    - ViewHolder
        - https://swalloow.tistory.com/71

    - String Resource
        - https://developer.android.com/guide/topics/resources/string-resource?hl=ko

    - 아이콘 만들기
        - https://developer.android.com/studio/write/image-asset-studio.html?hl=ko

2. Retrofit에 대한 POST들
    - Retrofit2 공식 문서
        - http://devflow.github.io/retrofit-kr/

    - 예제
        - https://cres-cent.tistory.com/19
        - https://falinrush.tistory.com/5
        - https://march3samwuli.tistory.com/entry/Retrofit-2%EB%A1%9C-Http%ED%86%B5%EC%8B%A0-%EA%B5%AC%ED%98%84-%EC%8B%9C%EA%B0%84%EC%9D%84-%EB%8B%A8%EC%B6%95%ED%95%B4%EB%B3%B4%EC%9E%90
        - https://yujuwon.tistory.com/entry/retrofit-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0
        - https://interconnection.tistory.com/73
        - https://square.github.io/retrofit/2.x/retrofit/retrofit2/Call.html
        - https://developer.android.com/reference/android/telecom/Call

-------------------------------------------------------------------------------------------

## 03/18 월요일

### 10:20

대략적인 코드 분석을 했고, 이 이후에 어떻게 해야 할까?

### 11:15

오오... List 클릭하면 log뜨게 했음.. ㄷㄷ  
장족의 발전이다...

### 15:30

rst_detail에 대한 layout을 만들었음.  
잘한 것 같지는 않음..

### 17:15

화면은 넘겼으나, 화면으로 데이터를 넘기는 방법을 모르겠음...

### 21:30

RstDetail 화면 전환 성공

### 21:45

Retrofit에 Singleton Pattern 적용

### 21:50

더 자세하게 나온 retrofit 예제
- http://chuumong.github.io/android/2017/01/13/Get-Started-With-Retrofit-2-HTTP-Client

### 22:20

sql문 수정

### 23:20

GET으로 Rater 정보 받아오기 성공
GET으로 해야 하나?


-------------------------------------------------------------------------------------------

## 03/17 일요일

### 14:10

모르겠다 모르겠어

- `http://dudmy.net/android/2017/06/23/consider-of-recyclerview/`
    - 내공이 부족해서 도대체 무슨말인지 모르겠음...

### 19:15

Application과 Retrofit에 대해 약간의 공부를 함.  
사실 본건 많은데 이해 한건 얼마 안됨.
Retrofit 예제를 식당 목록 출력 시키는 것으로 변환 시켰고,  
코드 분석 하면서 Android Application 공부를 조금 했음.

-------------------------------------------------------------------------------------------

## 03/16 토요일

### 12:00

어제 회사에서는 맥 IP로 접속이 안됬었는데 오늘 집에서는 접속이 가능 했음..`169.254.XXX.XXX`  
대체 무엇이 문제인지..?


### 13:45

앱에서 웹으로 /rst/rstList 요청은 성공 했고 웹에서 반응도 있음
서버에서는 정상적으로 데이터를 보낸것 같은데, 앱에서 처리 하지 못한 것 같음...
Logcat log..

```
2019-03-16 13:48:07.754 11142-11160/com.example.app D/EGL_emulation:
    eglCreateContext: 0xa1a05120: maj 3 min 0 rcv 3

2019-03-16 13:48:07.756 11142-11160/com.example.app D/EGL_emulation:
    eglMakeCurrent: 0xa1a05120: ver 3 0 (tinfo 0xa1a031c0)

2019-03-16 13:48:07.775 11142-11142/com.example.app E/RecyclerView:
    No adapter attached; skipping layout

2019-03-16 13:48:07.830 11142-11160/com.example.app D/EGL_emulation:
    eglMakeCurrent: 0xa1a05120: ver 3 0 (tinfo 0xa1a031c0)

2019-03-16 13:48:07.902 11142-11142/com.example.app D/Error:
    java.lang.IllegalStateException: Expected BEGIN_OBJECT but was BEGIN_ARRAY at line 1 column 2 path $
```

No adapter attached; skipping layout  
아무래도 이 부분이 에러의 원인인듯

### 13:55 

git에 /target/ 경로를 올려도 되는 건지 모르겠어서  
spring maven git target경로 키워드로 검색했더니 찾던 내용은 아니지만 공부할만한 내용이 나왔음.
- spring
    - `https://jeong-pro.tistory.com/168`
    - `https://antop.tistory.com/149`

- gitignore
    - `https://github.com/github/gitignore`


### 14:50

```
java.lang.IllegalStateException: Expected BEGIN_OBJECT but was BEGIN_ARRAY at line 1 column 2 path $
```
이 부분이 문제인 것 같은데 구글링 해도 잘 모르겠음...

```
음 에러내용으로 보아서는 json 응답 본문중에 뭔가 잘못된 문자가 들어간걸로 생각이 되네요. (써주신 응답에는 정상적인걸로 보이지만..)

서버에서 http 응답 코드가 뭔지, 정확한 응답 body 를 어떻게 내려주는지, 헤더의 Content-Type 은 뭔지 등의 정보를 좀 더 봐야 좀 더 수월하게 원인을 파악할 수 있을 것 같아요.

Retrofit 에다가 OkHttpClient 를 설정하여 사용하여 보세요.

OkHttpClient 쪽에 확장 라이브러리로 HttpLoggingInterceptor 라는게 있습니다.

이것을 OkHttpClient에 addInterceptor 해주시면 안드로이드 로그캣에 HTTP 요청/응답에 대한 상세한 내용을 로그캣으로 보실 수 있습니다.
```

### 15:15

- HTTP log 보기
    - https://nobase-dev.tistory.com/6
  
log 상으로 JSON 데이터는 받지만 화면에 안뜨는것으로 결론남...
- https://yujuwon.tistory.com/entry/retrofit-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0
- https://march3samwuli.tistory.com/entry/Retrofit-2%EB%A1%9C-Http%ED%86%B5%EC%8B%A0-%EA%B5%AC%ED%98%84-%EC%8B%9C%EA%B0%84%EC%9D%84-%EB%8B%A8%EC%B6%95%ED%95%B4%EB%B3%B4%EC%9E%90  
뭐이리 어려운 게야  
  
### 16:40

객체의 배열을 받아서 이 배열을 객체로 변환 하지 못하고 있는건데...  
안드로이드를 잘 몰라서 한참 헤메는 것

- http://www.masterqna.com/android/70675/json-%ED%8C%8C%EC%8B%B1-%EB%8F%84%EC%99%80%EC%A3%BC%EC%84%B8%EC%9A%94
- https://stackoverflow.com/questions/5554217/google-gson-deserialize-listclass-object-generic-type  
- https://okky.kr/article/545778
- https://stackoverflow.com/questions/42623437/parse-json-array-response-using-retrofit-gson
  
이게 해결책 같지만, 예제 코드에 대한 이해가 부족해서 잘 모르겠다...

### 18:40

문제의 원인은 내가 앱을 1도 모르고, 이해를 못하는 것이다..  

-------------------------------------------------------------------------------------------

## 03/15 금요일

맥에서 작업??  
안드로이드 예제가 맥에서는 그냥 잘 돌아감... ㄷㄷ
전자정부 서버를 맥에서 돌릴까?  
- `https://compunication.tistory.com/9`

- `https://medium.com/ufofactory-org/os-x%EC%97%90-%EC%A0%84%EC%9E%90%EC%A0%95%EB%B6%80%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED%81%AC-setting-%ED%95%98%EA%B8%B0-9e07ec896114`
    - 이게 먹히는지 모르겠음.. 일단 neon 버전 설치는 실패함..

### 15:00 오... 맥에서 전자정부 돌아감..!

### 17:40

https://asm0628.tistory.com/176

-------------------------------------------------------------------------------------------

## 03/14 목요일

### 10:20

jsp include 하고 싶은데 왜 에러가 나는지 모르겠음...

- https://okky.kr/article/359683

?

### 11:50

한숨만 나오는 상황 ~_~

### 15:00 FEEDBACK

APP 안하면 0점임...  
부실장님보다 차장님들 평가 점수가 더 높음.  
  
### 16:00

회원 가입 예제 프로젝트 Layout 구성.  

### 16:30

회원 가입 예제 화면 전환 기능 구성.
Intent, 버튼 변수와 입력값 변수.

### 17:20

회원 가입 예제 기능 구현
뭘까?

### 17:50

Spring 서버에서 데이터를 받으면 LOG로 프린트 하는 URL을 만들어서 테스트 해봐...

- `https://addio3305.tistory.com/43`

### 20:00

안스에서 예제 실행중인데 LogCat에서
```
2019-03-14 20:02:16.051 25088-25088/? I/com.management: Not late-enabling -Xcheck:jni (already on)
2019-03-14 20:02:16.079 25088-25088/? W/com.management: Unexpected CPU variant for X86 using defaults: x86
2019-03-14 20:02:16.255 25088-25088/? W/com.management: JIT profile information will not be recorded: profile file does not exits.
2019-03-14 20:02:16.257 25088-25088/? I/chatty: uid=10091(com.management) identical 10 lines
2019-03-14 20:02:16.257 25088-25088/? W/com.management: JIT profile information will not be recorded: profile file does not exits.
2019-03-14 20:02:16.271 25088-25088/? I/InstantRun: starting instant run server: is main process
2019-03-14 20:02:16.448 25088-25088/? W/com.management: Accessing hidden method Landroid/view/View;->computeFitSystemWindows(Landroid/graphics/Rect;Landroid/graphics/Rect;)Z (light greylist, reflection)
2019-03-14 20:02:16.448 25088-25088/? W/com.management: Accessing hidden method Landroid/view/ViewGroup;->makeOptionalFitsSystemWindows()V (light greylist, reflection)
2019-03-14 20:02:16.533 25088-25088/? D/OpenGLRenderer: Skia GL Pipeline
2019-03-14 20:02:16.598 25088-25109/? I/ConfigStore: android::hardware::configstore::V1_0::ISurfaceFlingerConfigs::hasWideColorDisplay retrieved: 0
2019-03-14 20:02:16.599 25088-25109/? I/ConfigStore: android::hardware::configstore::V1_0::ISurfaceFlingerConfigs::hasHDRDisplay retrieved: 0
2019-03-14 20:02:16.599 25088-25109/? I/OpenGLRenderer: Initialized EGL, version 1.4
2019-03-14 20:02:16.599 25088-25109/? D/OpenGLRenderer: Swap behavior 1
2019-03-14 20:02:16.599 25088-25109/? W/OpenGLRenderer: Failed to choose config with EGL_SWAP_BEHAVIOR_PRESERVED, retrying without...
2019-03-14 20:02:16.599 25088-25109/? D/OpenGLRenderer: Swap behavior 0
2019-03-14 20:02:16.631 25088-25109/? D/EGL_emulation: eglCreateContext: 0xec399dc0: maj 3 min 1 rcv 4
2019-03-14 20:02:16.663 25088-25109/? D/EGL_emulation: eglMakeCurrent: 0xec399dc0: ver 3 1 (tinfo 0xf0d44df0)

2019-03-14 20:02:16.669 25088-25109/? E/eglCodecCommon: glUtilsParamSize: unknow param 0x000082da
2019-03-14 20:02:16.670 25088-25109/? E/eglCodecCommon: glUtilsParamSize: unknow param 0x000082da

2019-03-14 20:02:16.752 25088-25109/? D/EGL_emulation: eglMakeCurrent: 0xec399dc0: ver 3 1 (tinfo 0xf0d44df0)
2019-03-14 20:02:18.107 25088-25088/com.management W/ActivityThread: handleWindowVisibility: no activity for token android.os.BinderProxy@bbad3b6
2019-03-14 20:02:18.261 25088-25109/com.management D/EGL_emulation: eglMakeCurrent: 0xec399dc0: ver 3 1 (tinfo 0xf0d44df0)

2019-03-14 20:02:18.697 25088-25113/com.management D/NetworkSecurityConfig: No Network Security Config specified, using platform default

2019-03-14 20:02:19.932 25088-25088/com.management I/AssistStructure: Flattened final assist data: 3260 bytes, containing 1 windows, 11 views
2019-03-14 20:02:25.094 25088-25088/com.management I/AssistStructure: Flattened final assist data: 3300 bytes, containing 1 windows, 11 views
2019-03-14 20:03:01.077 25088-25088/com.management I/AssistStructure: Flattened final assist data: 3316 bytes, containing 1 windows, 11 views
```

1. `2019-03-14 20:02:16.669 25088-25109/? E/eglCodecCommon: glUtilsParamSize: unknow param 0x000082da`
2. `2019-03-14 20:02:18.697 25088-25113/com.management D/NetworkSecurityConfig: No Network Security Config specified, using platform default`
두종류의 문제가 보임...  
No Network는 AndroidManifest.xml 파일에

```
<uses-permission android:name="android.permission.INTERNET"/>
```
해 줬는데도 뜨고 있음.. 일단 무시해 보도록 함.

- `https://warmboi.tistory.com/9`


-------------------------------------------------------------------------------------------

## 03/13 수요일

### 09:30

안드로이드 프로젝트 재 생성

### 11:50

- https://www.inflearn.com/

안드로이드 강의 보기...  
지금 이걸 본다고 할 수 있는게 없는거 같은데...?

### 14:30

아... 안돼.....

### 16:30

ghldmlwjr...

### 17:35

- 구글 안드로이드 가이드
    - https://developer.android.com/guide?hl=ko

- 괜찮아 보이는 블로그
    - https://recipes4dev.tistory.com/category/ANDROID%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D

### 22:45

Layout 까지 수강

### 23:50

회원 가입 프로젝트 예제 init

-------------------------------------------------------------------------------------------

## 03/12 화요일 

### 10:30

URL, 메소드, 매개변수, 리턴값 정리

### 11:25

메소드 정리 및 주석 처리

### 13:40

아... 안돼.....

### 14:20

```
SELECT
  SUM(score),
  AVG(score),
  COUNT(score)
FROM
  rvw
WHERE
  rst_no = 156;
```

-------------------------------------------------------------------------------------------

### 15:20 평점 내기

```
A에 대한 예상 별점 =
( (평가 범위의 가지수 * 평가 범위의 중간 값) + A에 대한 총점 합계) / (1번의 기회에 부여 할수 있는 최대 평가 값 + A에 대한 총 리뷰 수)

A에 대한 예상 별점 =
( 15 + A에 대한 총점 합계 ) / ( 5 + A에 대한 총 리뷰 수 )

( ( 15 ) + sum ) / (float) ( 5 + cnt )
```

필요한 sql문

```

SELECT
  SUM(score)    AS sum,
  COUNT(score)  AS cnt
FROM rvw
WHERE
  rst_no = #{rst_no}
```

-------------------------------------------------------------------------------------------

### 17:50

안드로이드 재 시도, 실패.

### 22:30

평점 계산식에 따른 계산과 Controller Service DAO, UI Design 없는 출력까지


-------------------------------------------------------------------------------------------

## 03/11 월요일

### 11:20

RVW detail modal창, delete 구현.

### 13:00

RVW update 구현

### 13:40

일부 수정

### 14:35

안드로이드 새로운 예제

### 15:50

- `https://www.learn2crack.com/2016/02/recyclerview-json-parsing.html`
따라 하는 중

### 21:00

아.. 안돼....

### 24:20 method정리 오류 수정

-------------------------------------------------------------------------------------------

## 03/10 일요일

- 전체 평점에 상대적인 평가 점수
- 전체 평가 인원에 상대적인 평가 인원 수
- 전체 식당에 평가자 수  
- 평가 대상인 식당의 수  
```
-- 전체 평가 점수, 전체 평가자 수
SELECT
  SUM(score),
    COUNT(score)
FROM rvw;

-- 해당 식당에 대한 평가 점수, 평가자 수
SELECT
  SUM(score),
    COUNT(score)
FROM
  rvw
WHERE
  rst_no = 156;

-- 평점이 있는 가게의 수
SELECT
  COUNT(DISTINCT rst_no)
FROM
  rvw;
```

전체 가게들이 평가자 수에 비해 총 몇점을 받았는데,  
해당 가게는 평가자 수에 비해 몇점을 받았다.  
  
화면에 나와야 하는 것 
별로, 평범, 좋아, 평가자 수, 

```
rating(K1,K2,K3)=C×m+total number of starsC+number of reviews



{ 평가 범위 X 평가 범위의 평균 + (평점 X 평가자 수) } / { 평가 범위 + 리뷰 수 }

{ 3 X 0 + 3800 } / { 3 + 2432 }

(점수 합계 X 평가자 수) / (평가자의 선택 범위 X 평가자 수)
```

### 17:40

rvw ServerSide delete, detail 기능 구현

### 18:30

모달 띄우기


-------------------------------------------------------------------------------------------
## 03/09 토요일

### 14:10
*.js  
sample.css 파일 정리

### 13:50

페이징 처리 너무 하고싶지만, 다른 할게 많아서 넘어 가야 할것 같음..
초기 설정 할 때 전자정부 예제를 미리 확인 했어야 했음...

### 17:10

평점에 대해서 계속 고민중...

### 18:00

```
SELECT
  COUNT(score) AS sum,
    (SELECT
    COUNT(score)
     FROM
    rvw
  WHERE
    score = 1
  AND
    rst_no = 156) AS three,
  (SELECT
    COUNT(score)
     FROM
    rvw
  WHERE
    score = 0
  AND
    rst_no = 156) AS two,
  (SELECT
    COUNT(score)
     FROM
    rvw
  WHERE
    score = -1
  AND
    rst_no = 156) AS one
  
FROM
  rvw
WHERE
  rst_no = 156;


SELECT
  SUM(score)
    
FROM rvw
WHERE
  rst_no = 156;

```

전체 식당에 평가자 수  
평가 대상인 식당의 수  
해당 식당에 대한 총 평가자 수  
해당 식당에 대한 평가 점수  
해당 평가에 해당 평가를 내린 사람의 수  

-------------------------------------------------------------------------------------------
## 03/08 금요일

### 10:20 paging 처리 실패?

시간적으로 크게 중요하지 않은거 같아서 일단 스킵 하기로 함.

```
2019-03-08 10:33:10,482 ERROR [org.springframework.web.servlet.tags.form.HiddenInputTag] Neither BindingResult nor plain target object for bean name 'pageIndex' available as request attribute
java.lang.IllegalStateException: Neither BindingResult nor plain target object for bean name 'pageIndex' available as request attribute
```
- https://addio3305.tistory.com/89
- https://okky.kr/article/236304
- http://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte:ptl:view:paginationtag

- https://addio3305.tistory.com/91

### 16:30

rvw insert 기능 구현,  
rvw, memb에 가짜 데이터 삽입.

### 17:45

- https://aljjabaegi.tistory.com/191
- https://aljjabaegi.tistory.com/190
    

-------------------------------------------------------------------------------------------
## 03/07 목요일

### 09:50

지금까지 한 작업물에 주석 처리중.

### 11:15

rst 저장 기능 개선.

### 11:50

rst 삭제 기능.

### 13:50

jsp 코드 정리.

### 15:30

Feedback : 통계나 해라.

### 15:50

RVW Package 생성

### 16:50

- https://www.google.com/search?q=net+error_aborted+404+c%3Aurl&rlz=1C1CHBD_koKR836KR836&oq=net+error_aborted+404+c%3Aurl&aqs=chrome..69i57.5531j0j1&sourceid=chrome&ie=UTF-8
- https://blockcahin.tistory.com/62
c:url이 깨지는 현상을 잡고 싶은데...  
- src\main\webapp\WEB-INF\config\egovframework\springmvc\dispatcher-servlet.xml
이 녀석이 문제 인것 같음..

beans:beans로 잡으면 잡히지만, 다른 properties는 잡히지 않음..

  <mvc:resources location="/resources/" mapping="/resources/**"/> ??

[org.springframework.web.servlet.PageNotFound] No mapping found for HTTP request with URI

- https://lng1982.tistory.com/97
- http://toby.epril.com/?p=1107
!!!!!!!!!!!!!!!!!!!
- ***https://okky.kr/article/219699***
!!!!!!!!!!!!!!!!!!!
```
web.xml에서 url-pattern에 /를 넣은 이유가 있나요?
특별한 이유가 없으면 /를 넣은 url 패턴을 빼세요..
/ 때문에 css나 js도 DispatcherServlet에서 처리할려고 그런겁니다..
만약 /를 넣어야 할 이유가 있으시다면 web.xml에
css나 js는 Tomcat의 기본 서블릿에서 처리하도록 다음과 같이 하세요..

<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.css</url-pattern>
</servlet-mapping>

<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.js</url-pattern>
</servlet-mapping>
```

### 23:20

javascript random 함수와 시간 함수 예제,

-------------------------------------------------------------------------------------------

## 03/06 수요일

### 10:00

어제 못했던 rstDetail.jsp UI 작업 마저 하는 중...

### 11:00

```
javax.el.PropertyNotFoundException: Property [upper_no] not readable on type [egovframework.rst.vo.Rst]
```
rstDetail.jsp 요리 유형 작업중 나온 에러
- Rst.class수정 하면서 upper_no에 대한 getter, setter, consturctor 설정을 안잡아 줘서 그럼.

### 13:20 !! rstDetail Form ISSUE !!

rstDetail.jsp 에서 rst삭제 js 준비 까지만 했음.  
생성, 삭제, 수정 기능 들어가야 하며, 생성 폼에서는 대분류 선택시 소분류 카테고리 AJAX로 출력 해야 함.  
  
### 14:00 Android Studio Project 생성

### 14:30 App Login 만들기

- https://jizard.tistory.com/104

### 14:50 Android Studio Project 재생성

### 16:00 Android Project 앱 생성 예제 성공.

- https://jizard.tistory.com/104

### 16:45 예제 찾음

- 설명
    - https://dev-juyoung.github.io/2017/11/10/android-retrofit-basic/
- 코드
    - https://github.com/dev-juyoung/retrofit-sample

### 17:25

- https://java.ihoney.pe.kr/283
Controller에서 JSON 으로 인자를 받거나 반환 하는 것에 대해서 찾아 봤음.  
이미 확신 하고 있었지만 맞았다는거..  
REST API 서버를 먼저 만들고 Client Side WEB 구현, APP은 나중에 구현 하는게 나을 것 같음.

- ***https://www.learn2crack.com/2016/02/recyclerview-json-parsing.html***

### 19:50 Spring Ajax에 Json으로 응답 하기

- https://victorydntmd.tistory.com/172

### 20:30 rst 저장, 삭제 기능 구현중..

- https://github.com/JeahaOh/java110-team-project/blob/master/src/main/resources/bitcamp/java110/cms/mapper/MemberDao.xml
- https://stackoverflow.com/questions/4205181/insert-into-a-mysql-table-or-update-if-exists

### 22:10

```
INSERT INTO rst (rst_no, rst_name, star, loc, loc_dtl, catag_no, tel, opn_tm, brck_tm, dnnr_tm, lo_tm)
VALUES (188, 'insertTest', -2, '동안구', '안양시', 10, '010-1020-4332', '11:00:00', '00:00:00', '00:00:00', '21:00:00')
ON DUPLICATE KEY UPDATE
    rst_name = 'insertTest',
    star = -2, loc = '동안구',
    loc_dtl = '안양시',
    catag_no = 10,
    tel = '010-3430-8902',
    opn_tm = '09:00:00',
    brck_tm = '00:00:00',
    dnnr_tm = '00:00:00',
    lo_tm = '22:00:00'
```
- https://wkdgusdn3.tistory.com/entry/%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EB%8B%A4%EC%9D%8C-autoincrement-%EA%B0%92-%EB%B0%9B%EC%95%84%EC%98%A4%EA%B8%B0

### 02:40

rst delete 해야함...

-------------------------------------------------------------------------------------------

## 03/05 화요일

### 09:45

egovSampleList.jsp 파일을 참고해서 jsp 파일을 작성 하고자, 분석중.  
egovSampleList.jsp가 js 파일이나, img, css 파일의 경로를 못 찾고 404 error를 내고 있음...

### 10:10

CSS 경로 잡기는 나중에 하기로... c:url을 걸든 그냥 href를 쓰던 경로에 대한 공부를 좀 해야 할 듯.

### 10:50

c:url?
- https://offbyone.tistory.com/319

### 11:10

c:out?
- https://okky.kr/article/209612
- https://needjarvis.tistory.com/51
단순히 출력 되는 것으로 판단 하면 안됨..

### 11:45

javax.servlet.jsp.JspTagException: No message found under code 'title.rst.id' for locale 'ko_KR'.
spring:message TAG를 사용 하려는데 이런 에러가 뜸...
- https://yangtaeho.tistory.com/entry/
Spring-message-%ED%83%9C%EA%B7%B8%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%A9%94%EC%84%B8%EC%A7%80-%EA%B4%80%EB%A6%AC

### 14:30

http://localhost:8888/yummy/rst/detail?id=10 URL로 식당 상세정보 DB에서 가져오는 것 까지 성공 했고 화면으로 출력 하지는 않음.

### 15:30

jsp 파일 주석 처리와 properties 파일 editor 색깔 설정

### 15:45

egovSampleRegister.jsp에서
```
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
```
태그를 발견함.  
- https://offbyone.tistory.com/325
바로 사용 할 수 있을 지는 모르겠음.

### 16:00

egovSampleRegister.jsp에서
```
<c:set var="registerFlag" value="${empty sampleVO.id ? 'create' : 'modify'}"/>
<title>Sample   <c:if test="${registerFlag == 'create'}"><spring:message code="button.create" /></c:if>
                <c:if test="${registerFlag == 'modify'}"><spring:message code="button.modify" /></c:if>
</title>                
```
태그 발견...
- http://blog.naver.com/PostView.nhn?blogId=wonminst&logNo=90096004269&categoryNo=0&parentCategoryNo=40&viewDate=&currentPage=1&postListTopCurrentPage=1&from=search
c:set의 3항 연산자에 따라 title이 바뀌는 것 같음.. 호?  
사용 하는데 오래 걸릴 것 같음...

### 17:20

rstDetail.jsp UI 작업...

### 20:20

rstDetail.jsp UI 작업...
- https://code.i-harness.com/ko/docs/html/element/input/time

### 21:30

rstDetail.jsp UI 작업...
- https://www.sitepoint.com/community/t/form-drop-down-menus-select-other-and-make-a-textbox-appear/2789

### 22:45

rstDetail.jsp UI 작업...

### 24:20

rstDetail.jsp UI를 위해 Catag 작업

-------------------------------------------------------------------------------------------

## 3/04 월요일

### 09:30

egovframwork/example Package에 연결된 iBatis / MyBatis 설정 파일들을 찾았음.  
iBatis 설정 파일들을 주석 처리 하고, MyBatis를 연결, 서버 작동 제대로 함.
- 각 파일에 참조하는 파일의 경로가 있음.
- iBatis 설정 파일
    - egovframework/example/sample/service/impl/SampleDAO.java
    - \resources\egovframework\spring\context-sqlMap.xml
    - \resources\egovframework\sqlmap\example\sql-map-config.xml
    - \resources\egovframework\sqlmap\example\sample\EgovSample_Sample_SQL.xml
- MyBatis 설정 파일
    - \resources\egovframework\sqlmap\example\sample\EgovSample_Sample_SQL.xml
        ```
        <?xml version="1.0" encoding="UTF-8"?>
        <!-- MyBatis 설정 파일  -->

        <beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd">
            <!-- SqlSession setup for MyBatis Database Layer -->
            <bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
                <property name="dataSource" ref="dataSource" />
                <property name="configLocation" value="classpath:/egovframework/sqlmap/example/sql-mapper-config.xml" />
                <property name="mapperLocations" value="classpath:/egovframework/sqlmap/example/mappers/*.xml" />
            </bean>

            <!-- MapperConfigurer setup for MyBatis Database Layer with @Mapper("deptMapper") in DeptMapper Interface -->
            <bean class="egovframework.rte.psl.dataaccess.mapper.MapperConfigurer">
                <property name="basePackage" value="egovframework.example.sample.service.impl" />
            </bean>
            
        </beans>
        ```
    - \resources\egovframework\sqlmap\example\sql-mapper-config.xml
    - \resources\egovframework\sqlmap\example\mappers\EgovSample_Sample_SQL.xm  
  
- \webapp\WEB-INF\web.xml
    - URL action에 .do가 아닌 일반 경로로 ("/") 설정함.
    ```
    <servlet-mapping>
        <servlet-name>action</servlet-name>
        <!-- <url-pattern>*.do</url-pattern> -->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    ```

### 10:30

```
2019-03-04 10:32:27,678 ERROR [org.springframework.web.context.ContextLoader] Context initialization failed
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'membService': Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.BeanCreationException: Could not autowire field: egovframework.memb.DAO.MembDAO egovframework.memb.service.MembServiceImple.membDao; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [egovframework.memb.DAO.MembDAO] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
  at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:334) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1214) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:543) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:482) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:772) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:839) ~[spring-context-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:538) ~[spring-context-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.web.context.ContextLoader.configureAndRefreshWebApplicationContext(ContextLoader.java:446) ~[spring-web-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.web.context.ContextLoader.initWebApplicationContext(ContextLoader.java:328) [spring-web-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.web.context.ContextLoaderListener.contextInitialized(ContextLoaderListener.java:107) [spring-web-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.apache.catalina.core.StandardContext.listenerStart(StandardContext.java:4817) [catalina.jar:8.5.38]
  at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:5283) [catalina.jar:8.5.38]
  at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150) [catalina.jar:8.5.38]
  at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1423) [catalina.jar:8.5.38]
  at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1413) [catalina.jar:8.5.38]
  at java.util.concurrent.FutureTask.run(Unknown Source) [?:1.8.0_201]
  at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source) [?:1.8.0_201]
  at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source) [?:1.8.0_201]
  at java.lang.Thread.run(Unknown Source) [?:1.8.0_201]
Caused by: org.springframework.beans.factory.BeanCreationException: Could not autowire field: egovframework.memb.DAO.MembDAO egovframework.memb.service.MembServiceImple.membDao; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [egovframework.memb.DAO.MembDAO] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
  at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:573) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:331) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  ... 22 more
Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [egovframework.memb.DAO.MembDAO] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
  at org.springframework.beans.factory.support.DefaultListableBeanFactory.raiseNoSuchBeanDefinitionException(DefaultListableBeanFactory.java:1373) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1119) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1014) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:545) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:331) ~[spring-beans-4.2.4.RELEASE.jar:4.2.4.RELEASE]
  ... 22 more
```

### 13:30

DAO와 ServiceImple 간의 연결 에러.  
DAO에 @Mapper("membDao") annotation을 붙여주고,  
ServiceImple에 @Resource(name="membDao") annotation을 붙여주고,  
sql-mapper-config.xml에 <typeAlias alias="memb" type="egovframework.memb.vo.Memb" /> 로 타입을 정의 해 줌.  
  
### 14:30

git tag 삭제  
- 로컬 tag 삭제
    - git tag -d [tag name]
- 원격 저장소 tag 삭제
    - git push origin :[tag name]

### 15:00

- git stage에 올라 가지 않은, 수정한 파일들 수정 이전으로 되돌리기
    - git reset --hard

### 17:00

- /rst/list 접속시 rstList 출력하는 기능 준비...

### 17:45

- memb 회원 가입, 탈퇴 기능 뼈대만 만드는 중.

### 20:30

- memb 회원 가입시 idCheck 기능, ServerSide에서 id의 정규 표현식 확인 기능 제작
    - https://highcode.tistory.com/6
    - https://cofs.tistory.com/358?category=627148
    - 

### 21:45

- memb 회원 가입, 탈퇴 기능, ServerSide 구현. 

### 22:10

내일 rstList 페이지와 rst 관리 기능들 만들 것임.  
WBS 상으로는 APP을 만들어야 하지만, rst의 기능들을 구현 한 후, APP을 만드는게 훨씬 효율적이라고 판단 되었음...

-------------------------------------------------------------------------------------------

## 3/03 일요일

아이바티스로 연결된것을 마이바티스로 바꾸려 했으나 잘 모르겠음. 시간 낭비 하는 것 같아서 일단 로그인 페이지 만드는것 부터 해야 겠음.  
  
전자정부 프레임 워크는 src/main/java/egovframework 이하에 있는 컨트롤러에만 반응을 함. (여기서 1시간 이상 삽질 했음)  
.do가 붙지 않으면 요청에 응답 하지 않음.

작업 참고 :
- http://blog.daum.net/janustop/86
- 전자정부 프레임워크 환경 설정 설명 :
    - https://sharedstoryit.tistory.com/entry/%EC%A0%84%EC%9E%90%EC%A0%95%EB%B6%80-%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED%81%AC-%EC%84%A4%EC%A0%951

컨트롤러 접근은 하지만 jsp 파일에 접근 못 하는 일이 생김.
dispathcer-servlet.xml에서 설정이
```
<bean class="org.springframework.web.servlet.view.UrlBasedViewResolver" p:order="1"
    p:viewClass="org.springframework.web.servlet.view.JstlView"
    p:prefix="/WEB-INF/jsp/egovframework/example/" p:suffix=".jsp"/>
```
이렇게 되서 인데, 'example/' 이부분을 넣고 빼고에 차이가 있었음... 
ViewResolver의 문제인데,
- https://stackoverflow.com/questions/7527607/how-to-use-multiple-places-in-spring-viewresolver 
처럼 return 하는 String에 경로를 추가 해 주면 됨  
이 부분 해결하는데 또 2시간 소요 했음.
ViewResolver에 관한 설명 : https://m.blog.naver.com/PostView.nhn?blogId=chocolleto&logNo=30086936956&proxyReferer=https%3A%2F%2Fwww.google.com%2F  
  
AWS DB에 데이터 넣었음.
생각 보다 속도가 나지 않음.  
이러다 제대로 못만들거 예상 되고, 인턴 끝나면 전자정부를 공부 하던지 스프링을 다시 공부하던지 해야겠음..  

회원 로그인 기능 구현 중...  
src/main/java/egovframework/example/sample Package 참고 해서 만들 던 중,  
iBatis / MyBatis 설정 바꾸는 부분을 발견 했음... 좀더 연구 해 봐야 할 것 같음.
  
  
  학원에서 배웠던 Gradle로 build한 Spring과 따로 했던 Maven으로 build한 Spring, egovFrame의 구조가 많이 다름...

  jquery를 이용한 loginForm Submit을 했음.
  참고  
  - https://zetawiki.com/wiki/JQuery_%ED%8F%BC_submit
  - https://www.codingfactory.net/10691
  - https://88240.tistory.com/36

-------------------------------------------------------------------------------------------

## 3/02 토요일

MyBatis 설정 후, 공통 컴포넌트 설치해주니 서버만 돌아가고 계속 에러가 뜨는 문제가 발생함.  
설정 부분에서 문제가 생긴것 같은데 무슨 이유인지 근본적인 이유를 찾지 못 하고 있음... 

```
3월 02, 2019 2:13:12 오후 org.apache.catalina.core.StandardContext listenerStop
심각: Exception sending context destroyed event to listener instance of class [org.springframework.web.context.ContextLoaderListener]
java.lang.IllegalStateException: BeanFactory not initialized or already closed - call 'refresh' before accessing beans via the ApplicationContext
```

- 공통 컴포넌트 설치 법
    - http://www.egovframe.go.kr/wiki/doku.php?id=egovframework:dev3.7:imp:editor:common_component
- 공통 컴포넌트 커스터마이징 방안
    - http://www.egovframe.go.kr/wiki/doku.php?id=egovframework:%EC%BB%A4%EC%8A%A4%ED%84%B0%EB%A7%88%EC%9D%B4%EC%A7%95_%EB%B0%A9%EC%95%88

현재 윈도우랑 맥에서 동시 작업을 하고 있는데, repository에 작업 파일을 올리지 않고 있어서 이것도 문제 사항인것 같음...  

이슈 사항 해결하면, 필히 repository에 올려서 버젼 관리를 하며 작업 해야겠음
  
  
아무래도 공통 컴포넌트를 끌어 들이면서 사용 하지 않을 컴포넌트까지 끌어들인게 이것 저것 꼬이게 한 것 같음.
일단 마이바티스를 통한 DB연결, 로그 까지 설정 했었는데 프로젝트를 repository에서 처음부터 다시 설정하고, 시작해야겠음.

**나 진짜 삽질 많이 한다...**

공통 컴포넌트 프로젝트 재 시작후 github에 올리니 security warnning이 떴음...  
대충 보니 공통 컴포넌트는 DB 정보를 globals.properties에 저장하는 것으로 보임...  
.gitignore에 엉뚱한 파일 이름만 올린것임...  
전자 정부 프레임 워크 대체 왜 쓰는거죠..?  

-------------------------------------------------------------------------------------------
  
github security 문제를 해결하고, 서버를 돌리니 회원 관리 하려면 설치해야하는 컴포넌트가 또 다른것 같음...  
공통 컴포넌트 문제 = 묶어 쓰는게 많다.  
설명이 친절하지 않다.  
너무나도 한국적이다.  
극혐;
  
  전자정부 프레임 워크는 스프링 시큐리티나 세션관리 로 회원, 로그인을 관리 하는 것 같음.
  Spring Security에 관한 설명
  - https://okky.kr/article/382738

  2009년에 만들어지고 2011년에 마지막으로 업데이트 된걸 쓰고 있다는게 참 멍청이 같음...
  MyBatis 쓰고싶은데 iBatis로 설정 되있는것도 참 어처구니가 없음..

-------------------------------------------------------------------------------------------

아무래도 공통 컴포넌트는 안 쓰는게 나을 것 같단 생각이 듦.

공통 컴포넌트 없이 전자정부 웹 프로젝트 생성 후 샘플 프로젝트 DB 연동 성공했음. 아이바티스로 연결 된것 같은데 마이바티스로 바꾸는 작업 연구 해야 할 거 같음.

-------------------------------------------------------------------------------------------

## 3/01 금요일

공통 컴포넌트를 사용하기 위해서 DB에 공통 컴포넌트에서 만들어주는 테이블과 데이터를 넣어야 하는 것 같음.  
공통 컴포넌트를 그대로 사용하는건 아니지만 일단 테스트를 위해서 DB를 연결 해 줘야 할듯.  
이클립스 Perspective 창 중에서 Data Source Explorer에서 Database Connections -> new 해서 db Connector 잡아 주고, db 설정값 입력해줌.
- http://www.egovframe.go.kr/wiki/doku.php?id=egovframework:dev2:imp:editor:dbio_editor:data_source_explorer#data_source_explorer
이미 수업때 배웠던거 임. 혹시 기억 못할까바 링크 걸어둠.

DB 설정후 공통 컴포넌트 설치
- http://www.egovframe.go.kr/wiki/doku.php?id=egovframework:dev2:imp:editor:common_component

-------------------------------------------------------------------------------------------

## 2/28 목요일

이클립스 워크스페이스 설정  
효율 적인 방법 없나?

- https://aljjabaegi.tistory.com/category/Programing/egovFramework

- 이클립스 콘솔로그 파일로 남기기
```
서버 더블 클릭 > Overview > Open launch configuration > Common >
Output File > File System > 로그가 남겨질 파일 생성 > 파일에 로그가 쌓임.
```
- Spring Properties 설명과 사용
    - https://jinyoung8806.github.io/spring/spring_properties/
- Spring MyBatis에 log4jdbc-log4j2 설정하기
    - https://blog.hanumoka.net/2018/07/27/spring-20180727-Spring-add-log4jdbc-log4j2-in-mysql-mybatis/
- 괜찮아 보이는 블로그
    - https://aljjabaegi.tistory.com/


- git push 취소하기
    1. commit을 되돌린다.
        - 가장 최근의 commit을 취소하고 워킹 디렉토리를 되돌린다.
        ```
        git reset HEAD^
        ```
        - 원하는 시점으로 워킹 디렉토리를 되돌린다.
        ```
        git reset [COMMIT ID]
        ```
    2. 커밋 취소한 목적 수행한다.
    3. 되돌려진 상태에서 다시 commit.
        ```
        git commit -m '[COMMIT MSG]'
        ```
    4. 강제 push
        ```
        git push origin [BRANCH NAME] -f
        또는
        git push origin +master
        ```
    ```
    ➜  The-Intern-Diary git:(master) git status
    On branch master
    Your branch is up to date with 'origin/master'.

    Untracked files:
    (use "git add <file>..." to include in what will be committed)

        Docs/Daily Record/

    nothing added to commit but untracked files present (use "git add" to track)
    ➜  The-Intern-Diary git:(master) ✗ git add .
    ➜  The-Intern-Diary git:(master) ✗ git commit -m '.'
    [master 1969fdf] .
    2 files changed, 0 insertions(+), 0 deletions(-)
        -- 여기서 DB 정보가 담긴 이미지를 그냥 올려버렸음.
    create mode 100644 Docs/Daily Record/2019-02-28 DB TEST RESULT.png
    create mode 100644 Docs/Daily Record/2019-02-28 DB TEST.png
    ➜  The-Intern-Diary git:(master) git push
        
        -- 중간생략 --

    ➜  The-Intern-Diary git:(master) git reset HEAD^
        -- commit 되돌리기
    ➜  The-Intern-Diary git:(master) ✗ git log --oneline --graph --all
        -- commit ID 확인
    ➜  The-Intern-Diary git:(master) ✗ git reset 7b4bcb5
        -- commit 취소하기
    
        -- 중간 생략 --

    ➜  The-Intern-Diary git:(master) git add .
    ➜  The-Intern-Diary git:(master) ✗ git commit -m '.'
    [master f4e7c43] .
    2 files changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 Docs/Daily Record/2019-02-28 DB TEST RESULT.png
    create mode 100644 Docs/Daily Record/2019-02-28 DB TEST.png

    ➜  The-Intern-Diary git:(master) git push origin master -f
        -- 강제 push

        Enumerating objects: 8, done.
        Counting objects: 100% (8/8), done.
        Delta compression using up to 12 threads
        Compressing objects: 100% (6/6), done.
        Writing objects: 100% (6/6), 357.63 KiB | 29.80 MiB/s, done.
        Total 6 (delta 2), reused 0 (delta 0)
        remote: Resolving deltas: 100% (2/2), completed with 2 local objects.
        To https://github.com/JeahaOh/The-Intern-Diary.git
        + 1969fdf...f4e7c43 master -> master (forced update)
    ```

    - MyBatis 로 DB연결 성공 했음.  
        근데 CDATA? 본적 없는 구문이 있었음.  
        XML 파일 상에서 MyBatis 비교연산자나 부등호 처리할 때 구분을 하기위해,  
        CDATA 태그 안의 쿼리릴 다 문자열로 치환하는 문법인것 같음.
        전자정부 프레임 워크 프로젝트의 구조를 파악하는 시간이 필요 할것 같음.
        - https://epthffh.tistory.com/entry/Mybatis-%EC%97%90%EC%84%9C-CDATA-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0

-------------------------------------------------------------------------------------------

## 2/27 수요일

DB 서버를 AWS에 있는 DB를 쓸까 생각함.
- Workbench를 이용하거나 phpMyAdmin을 이용할 수 있음.
    - Workbench 연결 방법 : https://cloud.hosting.kr/mysql-workbench/
    - phpMyAdmin 주소 : **http://13.125.217.122/phpMyAdmin/index.php**
    - 접속 아이디와 비밀번호는 나의 "그것"임.
  
- 현재 있는 data
    - rst, phot, menu, rst_catg
    - DB 완료시 다 넣고 테스트
- 넣어야 할 fake data
    - 회원, 회원 관리 완료시 js for문으로 30개 정도 만들기
    - 가고싶다, 회원 30개 data 넣은 후 rondom for문으로 만들기
    - 후기, 사진, 후기 관리 완료시 넣기
    - 관리 요청 다른것들 구현 후 기능 만들고 테스트

CSV 파일로 rst 테이블에 데이터를 넣는 중에 시간 컬럼에 null 값이 있으면 들어가지 않는 문제가 있었음.  
CSV 파일에서 00:00:00으로 넣고, Workbench 상에서 데이터를 지워주기로 했음.  
```
UPDATE `test`.`rst` SET `brck_tm` = NULL, `dnnr_tm` = NULL WHERE `brck_tm` = '00:00:00' AND `dnnr_tm` = '00:00:00' ;
```
근본적인 해결 방법을 찾아 보긴 해야 할거 같음.
```
기능 개발하기 바쁘니 디자인은 신경 쓰지 말라
맛집 통계를 내서 따로 규칙을 만들어 자체적인 별점은 줘라.

조회수, 가고싶어요 수, 맛있어요, 무난해요, 별로예요
```
- https://okky.kr/article/400750
- 

-------------------------------------------------------------------------------------------

## 2/26 화요일

어제 UI 디자인을 하고 생각 해 보니 UI Templeate Engine을 필수적으로 사용 해야 할 것 같다고 느끼게 되었음.  
아마 Handlebars.js나 Handlebars.java를 이용 할 것 같음.  
  
- 참고
    - https://sailboat-d.tistory.com/30
    - https://rongscodinghistory.tistory.com/13
    - http://blog.naver.com/PostView.nhn?blogId=tmondev&logNo=220402051411&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView
  
- DB Feedback
    - 코드 관리 테이블
    - 메뉴 - 메뉴판 관계 맞는지?
    - 앱에서 회원 가입 로그인 기능 있는게 맞느것 같다.
    - 후기와 평점과 레스토랑의 관계 이게 맞는건가?

- API
    - 프로그램과 프로그램을 연결해주는 일종의 다리 역할
- 컴포넌트
    - 각각의 독립된 모듈듈
    - https://mommoo.tistory.com/55
- 모듈
    - 일종의 패키지 혹은 lib
    - https://edu.goorm.io/learn/lecture/202/%EB%B0%94%EB%A1%9C-%EC%8B%A4%ED%96%89%ED%95%B4%EB%B3%B4%EB%A9%B4%EC%84%9C-%EB%B0%B0%EC%9A%B0%EB%8A%94-%ED%8C%8C%EC%9D%B4%EC%8D%AC/lesson/26679/%EB%AA%A8%EB%93%88%EC%9D%B4%EB%9E%80

```
DB...


```
- MyBatis: Insert multiple rows if doesn’t exist otherwise update the existing rows
    ```
    <insert id="insertOrUpdateMultipleRecords" parameterType="HashMap">
        INSERT INTO table1  ( field1, field2, created )
        VALUES
            <foreach collection="inputList" item="inputListItem" separator=",">
                (#{inputListItem.itemfield1}, #{inputListItem.itemfield2} , NOW())
            </foreach>
        ON DUPLICATE KEY UPDATE field2 = VALUES(field2)
    </insert>
    ```



-------------------------------------------------------------------------------------------

## 2/25 월요일

앱 UI proto 디자인은 끝냈음.  
웹 UI가 문제인데, 관리자 기능에 대한 규칙과 UI에 대한 아이디어가 잘 떠오르지 않음.
    
- 아파치 타일즈 적용 예제 :
    - https://offbyone.tistory.com/search/%ED%83%80%EC%9D%BC%EC%A6%88
    - https://epthffh.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%83%80%EC%9D%BC%EC%A6%88-Spring-Tile-%EC%84%A4%EC%A0%95%ED%95%B4%EB%B3%B4%EA%B8%B0

레스토랑 분류가 너무 많아서 대분류 컬럼을 추가했음.  
  
- 웹
    - 홈 : 로그인 창 보이기
        - 로그인 안하면 이하 항목은 볼 수 없음.

    - 헤더 : 로그아웃, 홈으로
    - 좌측 바 :
        - 레스토랑 정보 관리
        - 관리 요청 보기
    - 푸터 : 딱히 들어갈 건 없음.
  

안드로이드에서 차트 만들기 : https://coding-factory.tistory.com/65
  
  
  집 가서 해야 할 일 시스템 아키텍쳐


-------------------------------------------------------------------------------------------

## 2/24 일요일

후기 평가는 3가지  
- 맛있어요  1
- 무난해요  0
- 별로예요 -1

"가고싶다"랑 "조회수"기능은 시간이 남으면 넣는 걸로.
망고 플레이트를 벤치마킹 하기로.
  
참고? : https://www.slideshare.net/JngHwnLim/201706-77922496

평점, 후기 남기기는 WEB Server 제작 완료시 Javascript로 For문과 Math.Random()을 이용해서 Fake data 넣기로.
      

Adroid connect to Spring Server by JSON 참고 
- https://cocomo.tistory.com/412
- http://www.mobileflow.co.kr/main/blog/220824582088
- https://derveljunit.tistory.com/71
- https://coding-factory.tistory.com/32
- http://blog.naver.com/PostView.nhn?blogId=lmjing&logNo=220660414338


-------------------------------------------------------------------------------------------

## 2/23 토요일

UI 구상중...  
심플하게 해야 할것 같음

```
md파일의 줄바꿈은 space 두번
```

-------------------------------------------------------------------------------------------

## 2/22 금요일

```
아침에 문득 관리 요청 기능을 빼고 DB 데이터 정보 다루는 것에 집중을 하는게 어떨까 생각을 하게 됬음.
통계 내고, 하는것에 더 "집중" 하는게 낫지 않겠는가 하는 판단임.
일단 가격정보 표현하는것과 (평균가, 최대가, 최소가)
방문자들의 만족도 (총 방문자 수, 긍정적, 부정적, 무응답)
전체 방문자들이 어떤 요리 유형 선호하는지


http://blog.naver.com/PostView.nhn?blogId=nateen7248&logNo=220501285099&parentCategoryNo=&categoryNo=55&viewDate=&isShowPopularPosts=false&from=postView
식당정보를 엑셀로 작성, CSV 파일로 export한다.
workbench에서 import 

앱에서 회원 가입을 하지 않고 최초 실행시 사용자 번호를 받아 오는것으로 하자.

하루 종일 미슐랭 식당 이름, 위치, 가격정보 등을 엑셀화 하였음.
DB 설계를 조금 다시 해야 할 듯.
평점과 후기 fake data를 for문과 MathRandom으로 남기는 방법을 찾아 봐야 겠음.

```

최종 산출물 = 시스템 아키텍쳐, DB 설계서, 화면설계서, 완료 보고서


-------------------------------------------------------------------------------------------

## 2/21 목요일

### 프로젝트 기획과 발표

```
너무 준비를 안한것 같음.
주제가 별로 좋지 않았던거 같지만 이미 시작해서...  OTL
문서에 대한 지적만 받고 주제에 대한 얘기는 없었음.

---

산출물의 의미를 파악하라.
통계를 좋아하시는 것 같음. 간단하게 쓸 수 있는 챠트 라이브러리를 찾아봐야 할 것 같음.
주제가 시선을 끌지 못하니 "시선을 끌만한 무언가"가 있어야 하겠음.
클라이언트의 성격을 분석해서 아이템을 선정 해야함.
"Point가 있어야 하고, 딱 눈에 보여야 함"

---

현재 WBS에서 우선도가 바뀌면 일정 조정한것도 볼수 있게 만들어야함.

---
DB 모델링 후 테스트 하려는데 문자 셋 문제가 났음.
utf8
utf8_general_ci


SET collation_server ='utf8_general_ci';

ALTER DATABASE **DB_name** COLLATE = 'utf8_general_ci';

ALTER TABLE **table_name**
CONVERT TO CHARACTER SET **charset_name** **[COLLATE collation_name]**;


참고 : https://mariadb.com/kb/en/library/setting-character-sets-and-collations/


꼭!! Database table에 CHARACTER SET 확인 해야함.

2시간 정도
multi insert 와 multi delete를 시도 해 보았는데 Foreign Key 때문에 작동 하지 않음.

insert는 따로 해줘야 할것으로 판단 되고

delete는 
ON DELETE CASCADE
ON UPDATE CASCADE
조건에 따라 설정을 해줘야 할것으로 판단 됨.

통계 내야 하는 부분은
ON DELETE NO ACTION
으로 평점 정보는 남겨야 할 것 같음.

```

-------------------------------------------------------------------------------------------

## 2/20 수요일

```
문서 작업, 발표 준비, 작업
2/21에 있을 발표 준비 함.
내가 잘 하고 있는건지 잘 모르겠음.
요구사항 정의서, 메뉴 구성도나 시스템 구성도를 직접 만드니까 확실히 구체적인 생각이 드는것 같긴 함.
```

-------------------------------------------------------------------------------------------

## 2/19 화요일

```
문서 작업
메뉴 구성도, 시스템 구성도, 프로그램 목록, 요구사항 정의서, WBS 작업, DB 설계
```
Feedback
```
조금만 더 디테일 하게
```
-------------------------------------------------------------------------------------------

## 2/18 월요일

### 기획
#### 미슐랭 서울

- 미슐랭 선정 맛집에 관한 정보를 공유하는 서비스

#### 기능
- WEB APP 모두 공통 컴포넌트의 일반 로그인과 게시판 기능을 사용함.
1. APP
    - 유저 전용.
    - 앱을 사용하기 위해서는 회원 가입을 해야함.
    - 맛집에 관한 미슐랭 별점, 위치 정보, 사진을 볼 수 있음.
    - 유저들의 후기와 선호도(좋아요/그냥그래요/별로예요)를 볼 수 있음.
    - 후기를 작성할 때는 사진을 올릴 수 있음.
        - 자리에서 사진찍어서 올리기, 사진첩에서 선택해서 올리기.
    - 잘못된 정보나 후기를 신고할 수 있음.

2. WEB
    - 관리자 전용.
    - 미슐랭 가이드 맛집 정보 CRUD 기능.
    - 신고 사항 확인과 처리.

- 피드백
    - 가격대 필터링해서 볼 수 있도록 해야함.
        

- 앱과 서버는 REST API 형식으로 연결해서 JSON으로 데이터를 주고 받게 설계.
    - http://blog.naver.com/PostView.nhn?blogId=lmjing&logNo=220660414338
    - https://coding-factory.tistory.com/32

```
기획에 대해 상담을 했음.
기준치, 기대치가 높은 것 같고, 바라보는 시각이 확실히 다른것 같은 느낌을 받았음.
나는 아직 한참 멀었다는 걸 깨달았음.
```      

-------------------------------------------------------------------------------------------
# 기획 FIX
-------------------------------------------------------------------------------------------
## 2/17 일요일

공통 컴포넌트 초기 설정 가이드
- http://www.egovframe.go.kr/wiki/doku.php?id=egovframework:com:v2:init_getstarted

```
공통 컴포넌트를 봐도 친절한 설명이 없어서 어떻게 해야 할 지 잘 모르겠음.
.m2/repository 문제인건지 와이파이 문제인 건지, 공통 컴포넌트 불러 와서 이상한 에러가 남.
웹앱 공통으로 회원정보 CRUD와 게시판 CRUD만 만들면 잘 하는것 같음.
오늘은 서류 작업을 우선적으로 해야겠음.
```
- 지역별 보기시, 서울 25구의 지도 구성
    - Dropbox는 너무 식상하므로 4각형으로 추상화 해서 테이블로 디자인
    ```
    성북 강북 도봉 노원
    은평 서대문 종로 중 동대문 중랑
    마포 용산 성동 광진
    한강
    강서 영등포 동작 서초 강남 송파 강동
    양천 구로 금천 관악
    ```
- UI Prototype 작업
    - 가시적인것 부터 작업해야 나머지 서류 작업이 더 편할것 같아서 UI 작업부터 했음.

-------------------------------------------------------------------------------------------
## 2/16 토요일
오전에 기획하며 모은 자료를 git 관리가 꼬여서 날려 먹었음. 다시 기획작업 하는데 낮에 정리한 만큼하지 못하였음.
그 전에 git에 관해 약간 정리하자면.
#### git add 취소하기
- 실수로 git add . 으로 모든 파일을 staging area에 넣은 경우
    ```
    git reset HEAD [file]
    ```
    - 뒤에 파일명이 없다면 add한 파일을 전체 취소함
#### git commit 취소하기
- 완료한 commit을 취소 해야하는 경우
    - 너무 일찍 commit 한 경우
    - 어떤 파일을 빼먹고 commit 한 경우
    - 100M 이상의 자료를 commit 한 경우
    ```
    [방법 1] commit을 취소하고 해당 파일들은 staged 상태로 워킹 디렉터리에 보존
    git reset --soft HEAD^
    [방법 2] commit을 취소하고 해당 파일들은 unstaged 상태로 워킹 디렉터리에 보존
    git reset --mixed HEAD^ // 기본 옵션
    git reset -HEAD^ // 위와 동일
    git reset HEAD~2 // 마지막 2개의 commit을 취소
    [방법 3] commit을 취소하고 해당 파일들은 unstaged 상태로 워킹 디렉터리에서 삭제
    git reset --hard HEAD^
    ```
### 교훈

git reset 할 때는 작업 하던 파일을 따로 보관 하도록 하자...

-------------------------------------------------------------------------------------------

### 기획

#### Seoul Pics

*"Seoul Pictures"* 와 *"Seoul Picks"* 의 중의적 표현
- 서울관광재단의 서울 공식 여행 가이드를 보고 모티브를 받았음.
    - http://korean.visitseoul.net/index
    - 시민이 발로 찾은 서울 골목길 30선.pdf
    - 서울 best 100.pdf
    - 서울 야간 관광 가이드.pdf
- 이용자들이 서울에서 문화, 역사, 식도락 등의 다양한 활동을 사진으로 공유함으로 내/외국인의 나들이, 관광등 장소에 관한 정보를 공유할 수 있는 서비스.

#### 기능 (예정)

- 회원 관리와 사진 공유 게시판의 CRUD와 Client Side의 선 개발 후 이후 나머지 기능들 구현.

1. Web App 공통 (구현 확정)
    - 일반 로그인 (사용자디렉토리 / 통합 인증)
        - 모바일에서는 한번의 로그인 처리
        - 웹에서는 session 처리
    - 게시판 (협업)
        - 사용자들이 올리는 사진과 위치 정보, 간단한 후기 표시
        ------------------------------------------------------------------------------------------- -
    - 외부 API (일정상 구현 가능 미지수)
        - Google Map API
            - 방문지에 대한 위치 정보를 구글지도로 공유
            - WEB APP 둘다 지원함.
            - https://developers.google.com/maps/documentation/?hl=ko



2. Web (구현 미확정)
    - 공통 컴포넌트 기반
        - 게시물 통계 (통계/리포팅, 모바일 지원인지 모르겠음.)
            - 많이 방문한 지역을 통계 낼 수 있음
        - 쿠키/세션
            - 로그인
        - 로그관리 (시스템 관리)
            - 관리자의 모니터링용
        - 메뉴관리
        - 프로그램 관리
        - 코드관리
            - 이용자/관리자, 25개 구별 코드, 테마별 코드 등의 관리
    - 외부 라이브러리 (라이브러리만 찾아보았고 사용할지는 미정임)
        - starrr.js
            - 게시자의 별점 평가
            - https://github.com/dobtco/starrr
        - slides.js
            - 테마별 보기 상세 모달로 이미지 보여주는 방식으로 괜찮을 듯. (무료)
            - https://slidesjs.com/
        - ImageEditor
            - 기능 몇 가지 빼서 워터마크 붙이기에 괜찮을듯
            - 아니면 기능만 참고하는 걸로
            - https://nhnent.github.io/tui.image-editor/latest/index.html
        - JavaScript Use Canvas To Watermark Images
            - http://cwestblog.com/2017/06/11/javascript-use-canvas-to-watermark-images/
        - Watermark.js
            - https://www.patrick-wied.at/static/watermarkjs/


3. APP (구현 미확정)(공통 컴포넌트 기반)
    - 마이페이지(개인화)
    - 모바일 사진 앨범
    - 위치정보 연계
    - 멀티미디어 제어

-------------------------------------------------------------------------------------------

### 게시판 디자인 참고

- https://templated.co/visualize
    - https://opentutorials.org/course/2473/13815
    - WEB의 메인 페이지를 이런 모습으로 하고, 마우스 오버하면 장소 정보를 나오게 하면 심플해서 괜찮을 것 같음.

-------------------------------------------------------------------------------------------

## 2/15 금요일

### 개발팀장님 교육

#### 개발 PROCESS

- 요구분석
    - SRS 작성
    - 테스트 계획서 작성
    - 개발 계획서 작성
- 설계
    - 설계서 작성
        - UML, 시퀀스 등의 다이어 그램
    - 테스트 케이스 작성
        - 복합적 상황에 대한 케스트 케이스 작성
- 구현
    - 소스코드 작성
        - WBS에 기반한 개발
    - 주기적 빌드
        - git, svn등을 이용한 형상관리와 빌드.
- 테스트
    - 알파 테스트
        - 기능이 돌아가는지
    - 베타 테스트
        - 성능과 안정성이 어떤지
    - RC 테스트
        - 실제 필드에서 테스트

    ```
    - 20% 개발과
    - 80%의 버그픽스
    ```
    ```
    비지니스에서는 더 큰 에러를 먼저 잡는게 나을 수도 있다.
    사소한 문제와 큰 문제의 중요도는 비지니스 측면에서 다르다.

    MANTIS -> trello의 상위버젼.

    처음에 아키텍쳐를 고려해서 개발을 해야 나중에 헬파티가 나지 않음.
    ```

### WEB APP

```
오전에 간단한 교육과 과제 변경을 듣게 되었음.
2주 4주 프로젝트 2개에서 6주 1개로 변경 되었음.

요구사항 정의서, WBS, 유즈케이스 명세서, 시스템 구성도, 메뉴 구성도, 프로그램 목록, 화면 설계서, 데이터 베이스 설계서,

단위시험 결과서, 통합 시스템 결과서, 사용자 지침서, 운영 관리 지침서, 프로젝트 완료 발표.

2/28 까지 "설계" 기한임.
Item 발표(item 선정 먼저 해야 할 듯),
다음주 부터 주간 발표를 하고, 
최종 발표는 부장님들 포함 4명 이상 심사를 오심.
보고서의 양식은 자유이며, 소스를 보실 수도 있다고 함.
일일 작업 내용도 정리하는게 좋을 것 같음.

전자정부 컴포넌트 활용을 어떻게 하는지 보실것으로 예상 되므로, 공통 컴포넌트에 있는 기능을 먼저 살펴 보고, Item 선정을 하는게 나을것 같음.

주간 발표가 있고, 산출물 발표가 있기 때문에 사실상 4주 정도의 시간이 있음,
나는 웹 서버 및 웹 페이지 제작 기술만 조금 아는 상태이고,
안드로이드 앱 개발에 시간이 더 걸릴것으로 생각되어
웹을 2주 안에 개발 해야 할 것이라고 예상 됨.

구상중인 주제는 서울 명소 방문 인증과, 25개 구의 관광지 통계?
가능하다면 구글 Map API 를 사용하고 싶음.
웹에서 Javascript로 Stream을 열어서 웹캠으로 사진 찍는것만 오늘 테스트 해 보았고, 웹 구현은 가능하고, 나머지 앱 개발과 전체적 일정 조율은 고민 해 봐야 할 것 같음.

이번 주말까지 주제 Fix 하고, 6주 안에 내 능력 안에 어느정도 까지 개발 할 수 있을지 판단 해야 할것으로 판단 하고 있음.
```

-------------------------------------------------------------------------------------------

## 2/14 목요일

오전에 웹 앱 간단한 교육하고 QnA시간을 가졌음.
WBS 외에 크게 중요한 얘기가 없어서 기록하지 않음.

### WBS (Work Breakdown Structure)

프로젝트를 소규모의 구성 단위까지 나누어 전달할 수 있는 기능.
'계약 업무 분류 체계 (Contract Work Breakdown Structure, CWBS)'라고도 함.
- 역할
    - 전체의 큰 업무를 분류하여 구성 요소로 만등 후에 각 요소를 평가, 일정별 계획, 그것을 완수할 수 있는 사람에게 할당해주는 역할을 수행함.
    - 본래 목적은 담당자, 예산 등 프로젝트에 들어갈 수 있는 자원들을 기입하여 해당 내용을 적극정으로 관리하고 투영하는데 목적이 있음.
    - IT에 들어가면 프로젝트의 진행에 있어 일정에 대한 부분만 보여주고 있는 형태가 되었음. (프로젝트 진행 계획에만 치중하고 있다고 보면 됨.)

```
오후에 개발 환경 설정을 마져 했음.
오늘 오후를 좀 날려먹었는데,
org.apache.catalina.LifecycleException
java.util.zip.ZipException: error in opening zip file
등의 에러 때문이였음.

원인은 .m2/repository 문제 였는데,
이게 지우고 jar 파일을 다시 받아와도 와이파이로 받아오는 자료들을 제대로 인식하지 않고 에러를 계속 뿜었음.
집에 와서 다른거 변경없이 repository만 다시 받았는데 아무 문제 없이 돌아가서 조금 현타가 왔음.

```


-------------------------------------------------------------------------------------------

## 2/13 수요일

### APP 

안드로이드 정말 간단한 교육을 받음.

안드로이드 생명주기 = 앱에서 굉장히 중요함 어디에 무엇을 넣을지...

- 안드로이드 스튜디오 설치.
    - SDK manager
    - ABD? 설정이 꼬이면 제대로 안돌아 갈 수도 있음.. 셋팅을 잘 해야함.
    - 임의 프로젝트 설치해서 셋팅이 잘 됬는지 확이 해야함.

**!!**

웹 서버를 이용해서 웹과 앱 개발.
타겟에 맞춰서 디자인도 해야함.
- UI 안드로이드 스튜디오에서 쉽게 할 수 있음.
    - dp : pixel의 대체 단위... em rem?

- 변수 이름 잘 지어야 함.
- 과제의 의도
    - 1차 : 멀티미디어 다루기
    - 2차(비중이 크지는 않음) : 네트워크.
- 2주 안에 하는 과제임.
- 모르는 부분을 스터디 하는 식
- 안드로이드 폰에서는 SQLiteDB만 쓸 수 있다.

- 과정을 평가함.
- 문서 작업 해야함. 간단하게라도.
- 기간상 많은 양이 필요하지 않음.
- WBS? 산출물은 미리 작성해 놓는 것이 좋을 것으로 예상 됨.

**!!!**

- 국내 IoT음성 솔루션 사업화
- 글로벌 IoT 음성 솔루션 시장 진출
- 딥러닝 STT
- 음성인식 대화 쳇봇

### WEB

서버 사이드, 클라이언트 사이드. (백엔드/프론트엔드)

- WEB 서버 정적인 컨텐츠에 대한 처리.
- WAS 서버 동적인 처리.

- 실무에서 역할
    ```
    웹 기획자 : 고객의 need를 수용해서 정리, 화면을 기획. PM또는 전문 기획자.
        약간 애매함. 어떤 부서에 누구와 일하느냐에 따라 달라짐.
        pm 기획자 : 디테일한 기획서가 안나옴.
        전문 기획자 : 사이트에 특화된 기획이 나올 수 있음.

    퍼블리셔 : 웹디의 시안을 쪼개서 html만듦.

    웹 디 : 컨텐츠 제작. 대외적 홍보
        그래픽 디자인
        멀티형 인터랙션 디자인

    개발자: 퍼블리셔가 없는걸로 예상하고 다 만질 줄 알아야 함.
    ```
- 실무에서 사용 할 프레임웍, 환경정보와 셋팅

    ```
    공공사업을 많이 하기 때문에 전자정부 프레임 워크를 써야함.
    Spring 기반에 component가 이미 만들어 져 있음.

    www.eGovFrame.go.kr
    전자 정부 3.7

    JDK1.8
    Tomcat v8.0
    MySql 5.6

    notepad++

    공통 컴포넌트 MVC를 이용한 게시판
    ```

**!!**
SI에서 목표하는 것과 지난 프로젝트.
QnA 음성인식 쳇봇 구축 구상중.
서울시 도시재생 사이트
LH 
노랑풍선

```
오후에 환경 설정과 tool 설치를 했음.
Mac OS 단축키와 윈도우 단축키, 마우스 감도, 트랙패드 방향 때문에 조금 불편함.
집에 돌아와서 하지 못한 셋팅을 마져 했음.
```
```
Server Tomcat v8.5 failed to start.
apache-tomcat-X.X.XX/lib/servlet-api.jar 파일을
*/JAVA/jdkX.Y.Z/lib/servlet-api.jar 에 대체해주면 해결 될 수도 있음.
이유는 버젼이 맞지 않아서 임.

mvn .m2/repository 로 인한 에러도 여러가지임

ios나 react-native도 공부 해 보고싶음.
```

-------------------------------------------------------------------------------------------

## 2/12 화요일

### 영업 부장님 교육

- 회사의 IQS품질 지수가 가파르게 성장했다 => 자동차 시스템에 독보적이라고 할 수 있음.
- 영어 잘 하면 회사에서 해외 출장이 잦음.
- 지금 음성인식으로 핫한 시장 : 금융, 보험등의 ARS전화.
- context? context center?
- 영업의 팁. "희소성 있는 기술로 어필 후, 영업" 개인 어필도 다르지 않다.
- Language에 국한 되지 마라. (여러 언어를 배워라.)
- 요즘은 개발 방법론에 따라 개발하는 추세임 -> 요구사항 명확화.
    - 좋은 리더가 되기 위한 기본요소.

**질문**
- 회사에서 하는 SI 사업
    - 돈 되는 건 다 함.
    - 팀 단위로 파견 가기도 함.
    - 주로 공공기관으로 감.


### 부실장님 교육

- 결과도 중요하지만, 과정도 중요하다. 부실 공사는 안됨.
- 인턴 과제 실습 중에 진행 과정을 피력해야하고, 산출물이 있어야 하며, 과제의 의도를 파악하는게 중요함.

1. 기획서를 재차 확인해야 함.
    - 고객과 나의 목표가 맞는지 확인하는 것임.
2. 고객과 나의 용어 정리.

이 두 가지는 어디에서 일하던 필수임.
문서를 통한 확인 과정이 필요한 이유는 **설계서 등의 산출물은 시스템의 매뉴얼이 되기 때문임.**
진짜 전문가는 설명을 잘 해서 이해를 시키는 사람임.

### S/W 개발 방법 론?

애자일, 폭포수, 등등등...
전채 프로세스는 같으나 접근 방법이 다름.
정확하게 방법론을 쓰지 않으면 부실 공사임.

숙제 : 어떤 과제를 하고 싶은지 생각하라.
```
당장 딱히 좋은 아이디어는 떠오르지 않는데,
"은행권 공동 오픈 플랫폼 API"를 이용해서,
간단하게 나의 모든 은행 계좌를 조회하는 웹을 만들어 볼까 생각 중임.

회사가 뽑으려는 사람이 실력 보다는 협업에 무리 없을 사람,
함께 할 수 있는 사람을 뽑으려 하는것 같아서 더 노력 해야 겠다는 생각을 하게 됨.
```


### 차창님 교육

1. 기본 예절
- 인사
    - 안 받아주는 사람에겐 할 필요 없다.
- 전화
    - "안녕 하십니까. ~의 ~입니다."
    - 자기 전화 아니면 잘 안 받는데 신입이 대신 받으면 인상이 깊을 것임.
- 명함
    - 상대방이 받을 때 반듯해 보이도록 건낸다.
    - 미팅시에 상대방의 명함을 테이블 위에 두고 대화함.
    - 만나면 명함을 먼저 꺼내고, 직급 순으로 주고 받음.
- 악수
    - 적당한 세기로 힘을 줘야 인상을 줄 수 있음.
- 지각
    - "지각은 병이다. 극복해야 함."
- 의전
    - 주로 엘레베이터에서 대표님을 만나고 내릴 때까지의 행동.
    - 의전이 물처럼 흘러야 함.
    - 상석의 구분도 할 줄 알아야 함.
- 입사의 기술
    - 같이 일 하고 싶은 사람을 뽑음.
    - 재수 없는 느낌이면 떨어짐.
- 면접의 고수
    - 흥미 유발, 쉽게 접할 수 없고, 나만 경험한 이야기, 고급정보 등의 재미있는 이야기.
- 커리어 패스(Career Path)
    - 어떤 테크트리를 타냐에 따라...
- 무능의 역설
    - 맨날 털리고 깨지는 사람이 좋은 곳을 간다..?
    - 공고를 더 자주 보고, 면접을 더 많이 보게 됨. 커리어 관점에서 더 잘 보게 됨.

2. 눈에 띄는 법
- 욕망이 있는 사람.
- 사실 눈에 띄는 사람은 자체 발광함.
- 질문을 잘 함.
    - 말은 줄이고 임팩트 있는 질문을 함.
        - 질문에서 그 사람의 로직이 나온다.
    - 본질과 핵심에 닿는 질문을 함.
- 속도
    - 회신, 피드백등이 빠름.
    - 코딩도 빠름.
- 사각지대
    - 아무도 생각 못한 것을 잪어냄. 허점을 찾음.
- 열정 = 기간 = 결과

3. 전문가 되기
- 요구사항, 문제점등의 요약, 글을 조리있게 잘 씀.
- 복기
    - 지난 프로젝트 복기 해 보기
    - "무슨 이슈를 어떻게 해결했는가"
    - 프로젝트 문제 해결 => 흥미로운 이야깃 거리임.
    - 어떤 문제를 어떻게 해결 하고를 스토리 텔링 할 수 있음.
- DB
    - 나만의 DB 만들어라
    - 업무적, 사적 기록
    - 기록을 하다 보면 DB가 되고 전문가가 되게 됨.
        - 구글 킵, 에버노트, 구글 캘린더
- 영어
    - 학력의 벽을 넘길수 있는 KEY.
    - 유툽에 구글 개발자 듣고 이해 할 수 있으면 외국에서 일할 수 있음.

3. 자기 관리 = 시간
- "퇴근 후 시간의 경제적 가치"
- 체력
- 점심 시간에 식사 후 책 읽고, 퇴근 후 운동. 주말에 자기 관리.
- "매꾸" : 매일 꾸준히 하는게 있어야 함.

4. 그 외
- 마흔 이후가 진짜다.
- 전략적으로 커리어 패스를 짜도록 하라.


### 회사 장점

공부하려고 마음 먹으면 공부 할 수 있는 회사임.
워라밸이 좋은 편이고 휴가 안 쓰면 돈 나옴.

```
오늘 정말 많은 것을 배웠지만, 차장님 수업이 제일 인상 깊었음.
그리고 취직 후 하려던 계획이 있었는데 차장님이 약간 롤모델이 될것 같음.
일단 출근이 9시라서 퇴근 후 운동 1시간,
출|퇴근 버스에서 영어 공부,
퇴근 후 프로그래밍 공부.
주말에도 이것 저것 공부를 하고 수학도 좀 해야 할 것 같음.
내년에는 방통대를 다닐 계획임.
일단 자바스크립트와 js기반 라이브러리나 프레임 웤을 좀 배워야 할것 같음.
c계열이나 swift or object c 공부를 하고 싶음.

아쉽게도 차장님은 이번주에 더 좋은 곳으로 이직 하신다고 함.


윈도우를 안 쓰다 쓰려니 단축키가 정말 모르겠음. 붙캠에서 돌리는 윈도우라 그럴 수도 있는 것 같음.
맥에서 붙캠으로 윈도우를 돌리려니 마우스 트랙패드 감도나, 맥에서만 쓸 수 있는 단축키가 정말 좋다는걸 느끼고 있음.
정직원이 되면 회사에서 노트북이 나오니 하드웨어적 문제는 그리 중요한게 아닌것 같음.
다만 단축키나 윈도우 사용법이 좀 문제가 있는 것 같음.
```

-------------------------------------------------------------------------------------------

## 2/11 월요일

- 09:10분에 오라고 들었었는데 그게 아니였나봄. 너무 일찍 가면 민폐인거 같아서 오라고 한 시간에 들어 왔는데 이미 다들 도착해 있었음.
    - 어쩌면 10분 전에 오라는걸 10분 뒤에 오라는 걸로 잘못 기억했던걸까...
- 2000년에 설립 되서, 메인으로 하는 사업은 국내에서는 독보적인 위치에 있지만 국제적으로 보면 아직 한참 멀었다고 함.
- 사업부가 3곳 있고, 웹 & 앱 4명, IVI 2명, C개발자 4명을 뽑았다고 함.
- 인턴은 총 10명 뽑아서 9명 왔고 1명은 자신이 원하는 업무가 아니라고 나갔음.
- 인턴 들어온 사람은 가급적이면 다 뽑을 수 있고, 떨어지는 사람은 교육에 너무 못 따라 오거나 태도가 안좋은 사람을 걸러 낼 것이라고 함.
    - 인턴은 이번 기수가 처음이고, 약 6개월 전에 시험 삼아 3명 뽑아서 시행 했다고 함.
    - 2명 중 1명이 교육을 못 따라와서 탈락 하게 되었다고 하고, 붙은 사람 중 1명도 비전공이고 1도 모르는 상태에서 왔지만, 주말에도 나오고 늦게까지 열심히 하는 태도에 뽑았다고 함.
- 본인 제외 7명은 전공자이거나 비전공이여도 이공계열이고, 인턴끼리 대화 하는데 모르는 얘기가 조금 많았음..
    - 떨어지는 사람이 내가 아닐까 걱정이긴 하지만, 그래도 성실함은 자부 할 수 있으니까 나를 좀 더 믿어보기로 했음.
- 프로그래밍 공부와 함께 영어, 수학을 좀 공부할 필요성이 있지 않을까 생각하고 있음...
- 대표님이 한 시간정도 얘기 하고 가셨는데 사회에 회의적 이셨음.
    - 어디서 시작하던 치킨집 아니면 편의점 사장으로 만나더라.
    - 코딩 -> 말하는 것. [ "무엇"을 말하고 싶은거니? ]
    - 40대 넘겨서 계속 일하고 싶다면 지금 계속 공부 해야 한다.
    - 한국에선 사실 software로 살기 힘들다.
    - 어디에 있던 성의 있게 하라.
- 인턴용 PC를 지급 했는데, 참석 인원을 적게 예상했는지 PC가 모자랐고 3명은 중고노트북이 지급 된다고 해서 나 포함 3명은 개인 노트북을 사용 하기로 했음.
    - 생각해 보니 윈도우로 개발하게 될것 같은데 5년 가까이 맥만 사용하던 입장에서 약간 불똥 떨어진 상황인 것 같음.
- 옥상에서 보는 탄천 경치가 나쁘지 않았음. (그렇다고 엄청 좋은 것은 아님)

-------------------------------------------------------------------------------------------

## 2/10 일요일

- 2월 11일부터 성남시 분당구에 위치한 한 중소기업에서 인턴을 하게 되었음.
- 2개월 후 정규직 채용 가능성이 있긴 하지만, 가능성은 높지 않을거란 추측을 하고 있음.
- 일단 무슨 일을 하게 될지, 어떤 것들을 배우게 될진 아직 모르지만,
- 일일 기록을 해두는것이 좋을거 같다는 생각이 들어서 여기에 기록하기로 했음.

-------------------------------------------------------------------------------------------


