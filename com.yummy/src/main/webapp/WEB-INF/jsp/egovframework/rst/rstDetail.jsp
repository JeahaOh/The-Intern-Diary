<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%--
   /**
  * @Class Name : rstDetail.jsp
  * @Description : Rst 상세 정보 화면
  * @Modification Information
  *
  *   수정일     수정자           수정내용
  *  -------  --------  ---------------------------
  *  2019.03.05      최초 생성
  *
  * author JeahaOh
  * since 2019.03.05
  *
  * Copyright (C) 2019 by JeahaOh  All right reserved.
  */
--%>

<!DOCTYPE html>
<html lang="kor">
  <head>
  <meta charset="UTF-8">
  <title>${rst.rst_name} <spring:message code="title.rst.info"/></title>
  <%--
  <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
  --%>
  <style>
  * {margin:0;padding:0;}
  * html {height:1px;}
  body {margin:0; padding:0; font-family:"굴림"; font-size:12px; color:#666; scroll:auto;}
  table {/* width="100%" border="1" cellpadding="0" cellspacing="0" style=" */bordercolor: #D3E2EC; bordercolordark: #FFFFFF; BORDER-TOP: #C2D0DB 2px solid; BORDER-LEFT: #ffffff 1px solid; BORDER-RIGHT: #ffffff 1px solid; BORDER-BOTTOM: #C2D0DB 1px solid; border-collapse: collapse; margin: auto; text-align: center;}
  table, tr, td, th {font-family:"돋움"; font-size:11px; color:#333333;}
  .listtd {padding:10px 5px 8px 5px; border-bottom:1px solid #e5e5e5;}
  th {background-color:#F3F5E0; background:url(../../images/egovframework/example/th_bg.gif) 0 0 repeat; height:26px; text-align:center; vertical-align:middle; color:#003366;}
  img {border:0; vertical-align:middle;}
  p { height:20px; margin:0; padding:5 0 0 0;}
  .check ul {margin:0; padding:0; float:left;}
  .check li {list-style-type:none; float:left; margin:0 0 0 0; padding:0 0 0 3px;}
  .top {vertical-align:top;}
  
  a:link { font-size:11px; font-family:"돋움"; color:#3A5870; text-decoration:none; line-height:100%;}
  a:visited { font-size:11px; font-family:"돋움"; color:#3A5870; text-decoration:none}
  a:active { font-size:11px; font-family:"돋움"; color:#339999; text-decoration:none;}
  a:hover { font-size:11px; font-family:"돋움"; color:#339999; text-decoration:none;}
  
  .login {position:relative; margin:0; padding:0 0 0 0px; text-align:left; vertical-align:top; padding:52px 0px 0px 270px; /*overflow:hidden;*/ width:330px; height:260px;background:url(../../images/egovframework/example/login_bg.jpg) 0 0 no-repeat; }
  .login_en {position:relative; margin:0; padding:0 0 0 0px; text-align:left; vertical-align:top; padding:52px 0px 0px 270px; /*overflow:hidden;*/ width:330px; height:260px;background:url(../../images/egovframework/example/login_bg_en.jpg) 0 0 no-repeat; }
  .error {position:relative; margin:0; padding:0 0 0 0px; text-align:left; vertical-align:top; padding:120px 0px 0px 80px; /*overflow:hidden;*/ width:520px; height:260px;background:url(../../images/egovframework/example/error_bg.jpg) 0 0 no-repeat; }
  .error_en {position:relative; margin:0; padding:0 0 0 0px; text-align:left; vertical-align:top; padding:120px 0px 0px 80px; /*overflow:hidden;*/ width:520px; height:260px;background:url(../../images/egovframework/example/error_bg_en.jpg) 0 0 no-repeat; }
  #logo {margin:0; padding:0; text-align:left; /*overflow:hidden;*/ width:910px;}
  #header {height:74px; background:url(../../images/egovframework/example/civilappeal_topmn_bg.jpg) repeat-x;}
  #top {width:910px;}
  .menu { text-align:center; height:38px; margin:0; padding:13px 0 0 0;}
  .menu ul {display:inline; width:910px;}
  .menu li {display:inline; list-style-type:none; margin:0; padding:14px 28px 0 28px; background:url(../../images/egovframework/example/civilappeal_topmn_bar.jpg) 0 15px no-repeat;}
  .menu li.last {width:1px; padding:15px 0 0 0; background:url(../../images/egovframework/example/civilappeal_topmn_bar.jpg) 0 0 no-repeat;}
  .menu a.top:link {font-family:"굴림"; font-weight:bold; color:#FFFFFF; text-decoration:none; font-size:12px;}
  .menu a.top:visited {font-family:"굴림"; font-weight:bold; color:#FFFFFF; text-decoration:none; font-size:12px;}
  .menu a.top:hover {font-family:"굴림"; font-weight:bold; color: #00CCFF; text-decoration:none; font-size:12px;} 
  .menu a.top:active {font-family:"굴림"; font-weight:bold; color:#FFFFFF; text-decoration:none; font-size:12px;} 
  
  .menu .on a.top:link {font-family:"굴림"; font-weight:bold; color:#00CCFF; text-decoration:none; font-size:12px;}
  .menu .on a.top:visited {font-family:"굴림"; font-weight:bold; color:#00CCFF; text-decoration:none; font-size:12px;}
  .menu .on a.top:hover {font-family:"굴림"; font-weight:bold; color: #00CCFF; text-decoration:none; font-size:12px;} 
  .menu .on a.top:active {font-family:"굴림"; font-weight:bold; color:#00CCFF; text-decoration:none; font-size:12px;} 
    
  .right_area {float:right; height:38px; margin:0; padding:0 8px 0 0; background:url(../../images/egovframework/example/civilappeal_topmn_bg11.jpg) right no-repeat;}
  #sub {float:left; padding:10px 10px 10px 10px; /*overflow:hidden;*/width:180px; margin-right:30px;}
  #sub .login {width:180px; height:70px; text-align:left; vertical-align:top; padding:5px 0 0 0; background:url(../../images/egovframework/example/civilappeal_login_bg.jpg) right no-repeat; margin-bottom:10px;}
  #sub .login_en {width:180px; height:70px; text-align:left; vertical-align:top; padding:5px 0 0 0; background:url(../../images/egovframework/example/civilappeal_login_bg_en.jpg) right no-repeat; margin-bottom:10px;}
  #sub .sub_menu {width:150px; height:300px; text-align:left; vertical-align:top; background:url(../../images/egovframework/example/civilappeal_leftmenu_bg.jpg) 0 0 no-repeat; padding-top:40px; padding-left:15px; padding-right:15px; padding-bottom:0px;}
  #sub .sub_menu dl {width:150px;}
  #sub .sub_menu dd {font-weight:bold; padding-left:0px; padding-right:0px; padding-bottom:0px; padding-top:10px; margin:0;}
  #sub .sub_menu dt {list-style:none;  padding-left:0px; padding-right:0px; padding-bottom:0px; padding-top:8px; margin:0px;}
  #sub .sub_menu_en {width:150px; height:300px; text-align:left; vertical-align:top; background:url(../../images/egovframework/example/civilappeal_leftmenu_bg_en.jpg) 0 0 no-repeat; padding-top:40px; padding-left:15px; padding-right:15px; padding-bottom:0px;}
  #sub .sub_menu_en dl {width:150px;}
  #sub .sub_menu_en dd {font-weight:bold; padding-left:0px; padding-right:0px; padding-bottom:0px; padding-top:10px; margin:0;}
  #sub .sub_menu_en dt {list-style:none;  padding-left:0px; padding-right:0px; padding-bottom:0px; padding-top:8px; margin:0px;}
  #content {float:left; text-align:left; /*overflow:hidden;*/width:680px; background-color:#FFFFFF; padding:10px 0px 10px 0px;}
  #content_pop {float:left; text-align:left; /*overflow:hidden;*/width:680px; background-color:#FFFFFF; padding:10px 10px 10px 10px;}
  #title {float:left; text-align:left; margin:0 0 10 0; padding:0; height:30px; border-bottom:1px solid #e5e5e5; width:680px;}
  #title ul {float:left; margin:0; padding:0;}
  #title li {list-style-type:none; width:200px; padding:3px 0px 2px 0px; float:left; font-family:"돋움"; font-size:16px; font-weight:bold; color:#000000;}
  #title .location {float:right; height:20px; margin:0; padding:5 0 0 0; font-family:"돋움"; font-size:11px;}
  #foot {margin:0; padding:0 0 0 0; text-align:left; /*overflow:hidden;*/ height:40px; clear:both; background-color:#F7F7F7; border-top:1px solid #e5e5e5; font-family:Tahoma; font-size:11px; color:#999999;}
  #search {float:right; margin:0; padding:10px 0 10px 0; width:680px;}
  #search ul {margin:0; float:right;}
  #search li {list-style-type:none; float:left; margin:0 0 0 0; padding:0 0 0 3px;}
  #table {float:left; margin:0 0 10px 0; padding:0 0 0 0; width:680px;}
  #paging {padding:0 0 0 0; text-align:center; width:680px;}
  #paging ul {display:inline;}
  #paging li {display:inline; list-style-type:none; padding:0 10px 0 10px; font-family: Tahoma; font-size:11px; color: #333333;}
  #paging li.pre10 {padding:0 2px 0 2px;}
  #paging li.pre1 {padding:0 2px 0 2px;}
  #paging li.next10 {padding:0 2px 0 2px;}
  #paging li.next1 {padding:0 2px 0 2px;}
  #paging li.line {background:url(../../images/egovframework/example/paging_line.gif) 0 2px no-repeat;}
  #paging li.first {padding:0 5px 0 0;}
  #paging li.last {background:url(../../images/egovframework/example/paging_line.gif) 0 2px no-repeat; padding:0 5px 0 0;}
  #sysbtn {float:right; text-align:right; padding:0; margin:0; display:inline;}
  #sysbtn ul {margin:0; padding:0; float:left; display:inline;}
  #sysbtn li {list-style-type:none; margin:0 auto; padding:0 0 0 3px; float:left; display:inline;}
  
  #sysbtn1 {text-align:left; padding-top:10px; padding-bottom:0px; margin-bottom:0px; width:680px;}
  #sysbtn1 ul {margin:0; padding:0; float:left; display:inline;}
  #sysbtn1 li {list-style-type:none; margin:0 0 0 0; padding:0 0 0 3px; float:left; display:inline;}
  #idwrap {float:left; padding-top:0px; padding-bottom:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; margin-top:0px; padding-left:0px; padding-right:0px; }
  #idwrap ul {float:left; padding:0; margin:0;}
  #idwrap li {list-style-type:none; float:left; margin:0; padding-right:3px;}
  button {padding: 0px 10px; white-space:nowrap;}
  .btn_blue_l {float:left; background:url(../../images/egovframework/example/btn_bg_l.gif) 0 0 no-repeat; height:20px; padding:0px 0px 0px 10px; margin:0px 0px 0px 0px;}
  .btn_blue_r {float:left; background:url(../../images/egovframework/example/btn_bg_r.gif) 0 0 no-repeat; background-position:right; height:20px; font-family:"돋움"; font-size:11px; color:#000000; margin:0px 0px 0px 0px; padding-top:0px; _padding-top:0px; padding-left:10px; padding-right:10px; padding-bottom:0px; text-align:center;}
  input select { height:20px; font-family:"돋움"; font-size:12px; color:#000000; padding:2px 2px 0px 2px; margin-top:0px; _margin-top:-1px;}
  select {font-family:'돋움'; font-size:12px; margin-top:0px; height:20px; padding-top:0px;}
  .tbtd_caption {font-weight:bold; color:#003366; background-color:#E5EDF3; text-align:right; padding:10px 10px 9px 5px; margin:0;}
  .tbtd_content {background-color:#F5F8FA; padding:7px 10px 5px 10px; margin:0;}
  .tbtd_caption_re {font-weight:bold; color:#666633; background-color:#F6F5E5; text-align:right; padding:10px 10px 9px 5px; margin:0;}
  .tbtd_content_re {background-color:#F9F9F2; padding:7px 10px 5px 10px; margin:0;}
  input.txt         {height:18px; background-color:#FFF; border:1px solid #BCC8D8; padding-top:2px; color:#5e5e5e; cursor:text;}
  input.essentiality  {height:18px; background-color:#ebebeb; border:1px solid #BCC8D8; padding-top:2px; color:#000; cursor:text;}
  
  
  #catag_no {width: 145px;}
  
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  </head>
  <body style="text-align: center; margin: 0 auto; display: inline; padding-top: 100px;">
    <div id="outter_container">
      <div id="inner_container">
        <form id="rstForm" name="rstForm">
          <div id="content_pop">
            <div id="table">
              <table>
                <colgroup>
                  <col width="200"/>
                  <col width="100"/>
                  <col width="100"/>
                  <col width="90"/>
                  <col width="90"/>
                  <col width="90"/>
                </colgroup>
                
                <tr>
                  <td class="tbtd_caption" colspan="3">
                    <%-- rst_form이 생성용인지, 읽기 수정용인지 확인 하기 위한 C:CHOOSE --%>
                    <c:choose>
                      <c:when test="${mode eq 'Create'}">
                        <h4 id="mode" class="title create"><spring:message code="mode.create"/></h4>
                      </c:when>
                      <c:otherwise>
                        <h4 id="mode" class="title modify"><spring:message code="mode.modify"/></h4>
                      </c:otherwise>
                    </c:choose>
                    <%-- rst_form이 생성용인지, 읽기 수정용인지 확인 하기 위한 C:CHOOSE --%>
                  </td>
                  <td class="tbtd_caption">
                    <c:if test="${mode eq 'Modify'}">
                      <input type="hidden" id="rst_no" name="rst_no" value="${rst.rst_no}" required>
                    </c:if>
                  </td>
                  <td class="tbtd_caption">
                    <c:if test="${mode eq 'Modify'}">
                      <button type="button" id="update_rst" onclick="updateRst()">
                        <spring:message code="button.modify"/>
                      </button>
                      <button type="button" id="remove_rst" class="rst_form" onclick="removeRst()">
                        <spring:message code="button.delete"/>
                      </button>
                    </c:if>
                  </td>
                  <td class="tbtd_caption">
                    <button type="button" id="save_rst" class="rst_form" onclick="saveRst()">
                      <spring:message code="button.save"/>
                    </button>
                  </td>
                </tr>
                <tr>
                  <td class="tbtd_caption" rowspan="5">
                    <div id="preview" style="width: 100%; height: 200px; border: 1px solid #bcbcbc;">
                    </div>
                  </td>
                  <td class="tbtd_caption">
                    <label for="rst_name"><spring:message code="title.rst.name"/></label>
                  </td>
                  <td class="tbtd_caption">
                    <label for=""><spring:message code="title.rst.upper_catag"/></label>
                  </td>
                  <td class="tbtd_caption">
                    <label for="catag_no"><spring:message code="title.rst.catag"/></label>
                  </td>
                  <td class="tbtd_caption">
                    <label for="tel"><spring:message code="title.rst.tel"/></label>
                  </td>
                  <td class="tbtd_caption">
                    <label for="star"><spring:message code="title.rst.star"/></label>
                  </td>
                </tr>
                
                <tr>
                  <td class="tbtd_caption">
                    <input type="text" id="rst_name" class="rst_form"
                        name="rst_name" value="<c:out value="${rst.rst_name}"/>" required>
                  </td>
                  
                  <td class="tbtd_caption">
                    <select name="upper_catag" id="upper_catag" class="rst_form" required>
                      <c:forEach var="catag" items="${upperCatagList}" varStatus="status" >
                        <option value="${catag.catag_no}"
                            <c:if test="${catag.catag_no eq rst.upper_no}">selected</c:if>>
                                ${catag.catag_nm}
                        </option>
                      </c:forEach>
                    </select>
                  </td>
                  
                  <td class="tbtd_caption">
                    <select name="catag_no" id="catag_no" class="rst_form" required>
                      <c:if test="${catagList ne null || catagList != ''}">
                        <c:forEach var="catag" items="${catagList}" varStatus="status">
                          <option value="${catag.catag_no}"
                              <c:if test="${catag.catag_no eq rst.catag_no}">selected</c:if>>
                                  ${catag.catag_nm}
                          </option>
                        </c:forEach>
                      </c:if>
                    </select>
                  </td>
                  
                  <td class="tbtd_caption">
                    <input type="tel" id="tel" class="rst_form" name="tel"
                        alt="<spring:message code="title.rst.tel"/>" 
                        value="<c:out value="${rst.tel}"/>">
                  </td>
                  <td class="tbtd_caption">
                    <select name="star" id="star" class="rst_form" required>
                      <option value="1" <c:if test="${rst.star eq 1}">selected</c:if>>
                        <spring:message code="star.1"/>
                        </option>
                      <option value="2" <c:if test="${rst.star eq 2}">selected</c:if>>
                        <spring:message code="star.2"/>
                      </option>
                      <option value="3" <c:if test="${rst.star eq 3}">selected</c:if>>
                       <spring:message code="star.3"/>
                      </option>
                      <option value="-1" <c:if test="${rst.star eq -1}">selected</c:if>>
                       <spring:message code="star.-1"/>
                      </option>
                      <option value="-2" <c:if test="${rst.star eq -2}">selected</c:if>>
                        <spring:message code="star.-2"/>
                      </option>
                    </select>
                  </td>
                </tr>
                
                <tr>
                  <td class="tbtd_caption">
                    <label for="loc"><spring:message code="title.rst.loc"/></label>
                  </td>
                  <td class="tbtd_caption" colspan="4">
                    <label for="loc_dtl"><spring:message code="title.rst.loc_dtl"/></label>
                  </td>
                </tr>
                
                <tr>
                  <td class="tbtd_caption">
                    <input type="text" id="loc" class="rst_form"
                        name="loc" alt="<spring:message code="title.rst.loc"/>"
                        value="<c:out value="${rst.loc}"/>">
                  </td>
                  <td class="tbtd_caption" colspan="4">
                    <input type="text" id="loc_dtl" class="rst_form"
                        name="loc_dtl" alt="<spring:message code="title.rst.loc_dtl"/>"
                        value="<c:out value="${rst.loc_dtl}"/>" style="width: 475px;" required>
                  </td>
                </tr>
                
                <tr>
                  <td class="tbtd_caption">
                    <label for="opn_tm"><spring:message code="title.rst.opn_tm"/></label>
                  </td>
                  <td class="tbtd_caption">
                    <label for="brck_tm"><spring:message code="title.rst.brck_tm"/></label>
                  </td>
                  <td class="tbtd_caption">
                    <label for="dnnr_tm"><spring:message code="title.rst.dnnr_tm"/></label>
                  </td>
                  <td class="tbtd_caption">
                    <label for="lo_tm"><spring:message code="title.rst.lo_tm"/></label>
                  </td>
                  <td class="tbtd_caption"></td>
                </tr>
                
                <tr>
                  <td class="tbtd_caption">
                    <input type="file" id="img" class="rst_form" name="img" alt="사진" accept=".png, .jpg, .jpeg">
                  </td>
                  <td class="tbtd_caption">
                    <input type="time" id="opn_tm" class="rst_form" 
                        name="opn_tm" alt="<spring:message code="title.rst.opn_tm"/>" 
                        value="<c:out value="${rst.opn_tm}"/>" required>
                  </td>
                  <td class="tbtd_caption">
                    <input type="time" id="brck_tm" class="rst_form" 
                        name="brck_tm" alt="<spring:message code="title.rst.brck_tm"/>" 
                        value="<c:out value="${rst.brck_tm}"/>" >
                  </td>
                  <td class="tbtd_caption">
                    <input type="time" id="dnnr_tm" class="rst_form" 
                        name="dnnr_tm" alt="<spring:message code="title.rst.dnnr_tm"/>" 
                        value="<c:out value="${rst.dnnr_tm}"/>">
                  </td>
                  <td class="tbtd_caption">
                    <input type="time" id="lo_tm" class="rst_form" 
                        name="lo_tm" alt="<spring:message code="title.rst.lo_tm"/>" 
                        value="<c:out value="${rst.lo_tm}"/>" required>
                  </td>
                  <td class="tbtd_caption"></td>
                </tr>
              </table>
            </div>
          </div>
        </form>
      </div>
    </div>
    <script>
      // rstDetail.jps의 상태를 저장하는 변수.
      let rst_formStatus;
      
      /**
       * rstDetail.jsp가 로드 될 때,
       * 'modify' 모드 라면
       * form의 input들에 disabled 속성을 줌.
       */
      $(function(){
        if( $('#mode').hasClass('modify') ) {
          $('.rst_form').attr('disabled', 'disabled');
          rst_formStatus = true;
        }
      });
      
      /**
       * input type file에 사진을 올리면
       * #preview에 사진을 보여줌.
       */
      $( "#img" ).change(function() {
        pic( this );
        function pic( input ) {
          if ( input.files && input.files[0] ) {
            var reader = new FileReader();
            reader.onload = function( e ) {
              $('#preview').css( 'background-image', 'url(' + e.target.result + ')' );
              $('#preview').hide();
              $('#preview').fadeIn(650);
            }
            reader.readAsDataURL(input.files[0]);
          }
        }
      });
      
      /**
       * 수정 버튼을 누르면
       * form의 input에 disabled 속성을
       * 토글 방식으로 주거나 뺌
       */
      function updateRst() {
        if ( rst_formStatus ) {
          $('.rst_form').removeAttr('disabled');
          rst_formStatus = false;
        } else {
          $('.rst_form').attr('disabled', 'disabled');
          rst_formStatus = true;
        }
      }
      
      /**
       * 게시물을 삭제하기 위한 function.
       */
      function removeRst() {
        let cnfrm;
        
        if ( rst_formStatus ) {
          alert('삭제 가능한 상태가 아닙니다.');
          return;
        } else {
          cnfrm = confirm( $('#rst_name').val() + ' 식당 정보를 삭제 하시겠 습니까?' );
        }
        if ( !cnfrm ) {
          alert( $('#rst_name').val() + ' 식당 정보 삭제를 취소 하셨 습니다.' );
          return;
        } else {
          let rst_no = { rst_no: $('#rst_no').val() };
          
          $.post( "/yummy/rst/delete", rst_no ).done( function( data ) {
            console.log( data );
            if (data === 'true' ) {
              window.location.href = '/yummy/rst/list';
            } else {
              alert( data );
            }
          });
        }
      }
      
      /**
       * select box에서 상위 분류를 바꾸면,
       * AJAX로 하위 catag 목록을 JSON 형태로 가져옴.
       * 가져온 JSON data를  catag_no에 넣어줌.
       */
      $('#upper_catag').change( function () {
        $.ajax("/yummy/catag/get" , {
          method: "POST",
          data:{
            "upper_no": $(this).val()
          },
          dataType: "json",
          success: function ( data ) {
            console.log( data );
            
            $('#catag_no').empty();
            
            if(data === null || data == '' || data.length < 1) {
              return;
            }
            
            for (i = 0; i < data.length; i++) {
              var options = $("<option></option");
              options.append(data[i].catag_nm);
              options.attr('value', data[i].catag_no);
              $('#catag_no').append(options);
            }
          },
          error: function(xhr, status, msg) {
            alert('오류가 발생 했습니다.\n다시 시도해 주세요.');
            console.log('xhr:\n ' + xhr);
            console.log('status:\n ' + status);
            console.log('msg:\n ' + msg);
          }
        });
      });
      
      /**
       * form의 input 값을 JSON형태로 바꾸는 function.
       */
      $.fn.serializeObject = function() {
        var result = {}
        var extend = function(i, element) {
          var node = result[element.name]
          if ("undefined" !== typeof node && node !== null) {
            if ($.isArray(node)) {
              node.push(element.value)
            } else {
              result[element.name] = [node, element.value]
            }
          } else {
            result[element.name] = element.value
          }
        }
        $.each(this.serializeArray(), extend)
        return result
      }
      
      
      /**
       * 새로 만들거나 수정된 rst정보를 저장
       */
      function saveRst(){
        let cnfrm;
        
        //  rst_name의 유효성 검사.
        if ( $('#rst_name').val() === '' || $('#rst_name').val().length < 0 ) {
          alert('필수 값 누락!');
          $('#rst_name').focus();
          return;
        }
        
        //  catag_no의 유효성 검사.
        if ( $('#catag_no').val() === '' || $('#catag_no').val() < 0 || typeof $('#catag_no') === "undefined" || $('#catag_no').val() === null ) {
          alert('필수 값 누락!');
          $('#upper_catag').focus();
          return;
        }
        
        //  opn_tm의 유효성 검사.
        if ( $('#opn_tm').val() === '' || $('#opn_tm').val().length < 0 ) {
          alert('필수 값 누락!');
          $('#opn_tm').focus();
          return;
        }
        
        //  lo_tm의 유효성 검사.
        if ( $('#lo_tm').val() === '' || $('#lo_tm').val().length < 0 ) {
          alert('필수 값 누락!');
          $('#lo_tm').focus();
          return;
        }
        
        //  form의 disabled 상태 검사
        if ( rst_formStatus ) {
          alert('수정 가능한 상태가 아닙니다.');
          return;
        } else {
          cnfrm = confirm($('#rst_name').val() + ' 식당 정보를 저장 하시겠 습니까?' );
        }
        
        //  재차 확인
        if ( !cnfrm ) {
          alert( $('#rst_name').val() + ' 식당 정보 저장을 취소 하셨 습니다.' );
          return;
        }
        
        //  form의 data를 JSON 형태로 변환
        var form = $('#rstForm').serializeObject();
        console.log( 'serializeObject\n' + form );
        //  JSON형태로 변환된 form data를 AJAX로 서버에 POST 요청 함.
        $.ajax("/yummy/rst/save" , {
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          method: "POST",
          dataType: "json",
          contentType : 'application/json; charset=UTF-8',
          data: JSON.stringify( form ),
          success: function ( data ) {
            console.log( data ); 
            if( $('#mode').hasClass('modify') ) {
              window.location.href = document.location.href;
            } else {
              window.location.href = '/yummy/rst/detail?id=' + data;
            }
          },
          error: function(xhr, status, msg) {
            console.log('xhr:\n ' + xhr);
            console.log('status:\n ' + status);
            console.log('msg:\n ' + msg);
          }
        });
      }
    </script>
  </body>
</html>