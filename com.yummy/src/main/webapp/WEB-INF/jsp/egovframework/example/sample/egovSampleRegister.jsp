<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
			* @Class Name : egovSampleRegister.jsp
			* @Description : Sample Register 화면
			* @Modification Information
			*
			*   수정일         수정자                   수정내용
			*  -------    --------    ---------------------------
			*  2009.02.01            최초 생성
			*
			* author 실행환경 개발팀
			* since 2009.02.01
			*
			* Copyright (C) 2009 by MOPAS  All right reserved.
			*/
%>
<!DOCTYPE html>
<html lang="kor">
<head>
<meta charset="UTF-8">
  <c:set var="registerFlag" value="${empty sampleVO.id ? 'create' : 'modify'}" />
  <title>Sample
    <c:if test="${registerFlag == 'create'}">
      <spring:message code="button.create" />
    </c:if>
    <c:if test="${registerFlag == 'modify'}">
      <spring:message code="button.modify" />
    </c:if>
  </title>
<%--
  <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
--%>
  <style>
  * {margin:0;padding:0;}
  * html {height:1px;}
  body {margin:0; padding:0; font-family:"굴림"; font-size:12px; color:#666; scroll:auto;}
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
  button {cursor:hand; border:0px solid #FFFFFF; padding:0px 0px 0px 0px; background-color:#FFFFFF; white-space:nowrap;}
  .btn_blue_l {float:left; background:url(../../images/egovframework/example/btn_bg_l.gif) 0 0 no-repeat; height:20px; padding:0px 0px 0px 10px; margin:0px 0px 0px 0px;}
  .btn_blue_r {float:left; background:url(../../images/egovframework/example/btn_bg_r.gif) 0 0 no-repeat; background-position:right; height:20px; font-family:"돋움"; font-size:11px; color:#000000; margin:0px 0px 0px 0px; padding-top:0px; _padding-top:0px; padding-left:10px; padding-right:10px; padding-bottom:0px; text-align:center;}
  input { height:20px; font-family:"돋움"; font-size:12px; color:#000000; padding:2px 2px 0px 2px; margin-top:0px; _margin-top:-1px;}
  select {font-family:'돋움'; font-size:12px; margin-top:0px; height:20px; padding-top:0px;}
  .tbtd_caption {font-weight:bold; color:#003366; background-color:#E5EDF3; text-align:right; padding:10px 10px 9px 5px; margin:0;}
  .tbtd_content {background-color:#F5F8FA; padding:7px 10px 5px 10px; margin:0;}
  .tbtd_caption_re {font-weight:bold; color:#666633; background-color:#F6F5E5; text-align:right; padding:10px 10px 9px 5px; margin:0;}
  .tbtd_content_re {background-color:#F9F9F2; padding:7px 10px 5px 10px; margin:0;}
  input.txt               {height:18px; background-color:#FFF; border:1px solid #BCC8D8; padding-top:2px; color:#5e5e5e; cursor:text;}
  input.essentiality  {height:18px; background-color:#ebebeb; border:1px solid #BCC8D8; padding-top:2px; color:#000; cursor:text;}
  </style>

  <!--For Commons Validator Client Side-->
  <script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script>
  <validator:javascript formName="sampleVO" staticJavascript="false" xhtml="true" cdata="false" />
<!--
  <script type="text/javaScript" language="javascript" defer="defer">
    /* 글 목록 화면 function */
    function fn_egov_selectList() {
      document.detailForm.action = "<c:url value='/egovSampleList.do'/>";
      document.detailForm.submit();
    }
    
    /* 글 삭제 function */
    function fn_egov_delete() {
      document.detailForm.action = "<c:url value='/deleteSample.do'/>";
      document.detailForm.submit();
    }
    
    /* 글 등록 function */
    function fn_egov_save() {
      frm = document.detailForm;
      if(!validateSampleVO(frm)){
        return;
      } else {
        frm.action = "<c:url value="${registerFlag == 'create' ? '/addSample.do' : '/updateSample.do'}"/>";
        frm.submit();
      }
    }
  </script>
-->
</head>
<body style="text-align: center; margin: 0 auto; display: inline; padding-top: 100px;">
  <form:form commandName="sampleVO" id="detailForm" name="detailForm">
    <div id="content_pop">
      <!-- 타이틀 -->
      <div id="title">
        <ul>
          <li>
            <img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt="" />
            <c:if test="${registerFlag == 'create'}">
              <spring:message code="button.create" />
            </c:if>
            <c:if test="${registerFlag == 'modify'}">
              <spring:message code="button.modify" />
            </c:if>
          </li>
        </ul>
      </div>
      <!-- // 타이틀 -->
      <div id="table">
        <table width="100%" border="1" cellpadding="0" cellspacing="0" style="bordercolor: #D3E2EC; bordercolordark: #FFFFFF; BORDER-TOP: #C2D0DB 2px solid; BORDER-LEFT: #ffffff 1px solid; BORDER-RIGHT: #ffffff 1px solid; BORDER-BOTTOM: #C2D0DB 1px solid; border-collapse: collapse;">
          <colgroup>
            <col width="150" />
            <col width="?" />
          </colgroup>
          <c:if test="${registerFlag == 'modify'}">
            <tr>
              <td class="tbtd_caption">
                <label for="id">
                  <spring:message code="title.sample.id" />
                </label>
              </td>
              <td class="tbtd_content">
                <form:input path="id" cssClass="essentiality" maxlength="10" readonly="true" />
              </td>
            </tr>
          </c:if>
          <tr>
            <td class="tbtd_caption">
              <label for="name">
                <spring:message code="title.sample.name" />
              </label>
            </td>
            <td class="tbtd_content">
              <form:input path="name" maxlength="30" cssClass="txt" />
              &nbsp;
              <form:errors path="name" />
            </td>
          </tr>
          <tr>
            <td class="tbtd_caption">
              <label for="useYn">
                <spring:message code="title.sample.useYn" />
              </label>
            </td>
            <td class="tbtd_content">
              <form:select path="useYn" cssClass="use">
                <form:option value="Y" label="Yes" />
                <form:option value="N" label="No" />
              </form:select>
            </td>
          </tr>
          <tr>
            <td class="tbtd_caption">
              <label for="description">
                <spring:message code="title.sample.description" />
              </label>
            </td>
            <td class="tbtd_content">
              <form:textarea path="description" rows="5" cols="58" />
              &nbsp;
              <form:errors path="description" />
            </td>
          </tr>
          <tr>
            <td class="tbtd_caption">
              <label for="regUser">
                <spring:message code="title.sample.regUser" />
              </label>
            </td>
            <td class="tbtd_content">
              <c:if test="${registerFlag == 'modify'}">
                <form:input path="regUser" maxlength="10" cssClass="essentiality" readonly="true" />
        				&nbsp;
                <form:errors path="regUser" />
              </c:if>
              <c:if test="${registerFlag != 'modify'}">
                <form:input path="regUser" maxlength="10" cssClass="txt" />
        				&nbsp;
                <form:errors path="regUser" />
              </c:if>
            </td>
          </tr>
        </table>
      </div>
      <div id="sysbtn">
        <ul>
          <li>
            <span class="btn_blue_l">
              <a href="javascript:fn_egov_selectList();">
                <spring:message code="button.list" />
              </a>
              <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left: 6px;" alt="" />
            </span>
          </li>
          <li>
            <span class="btn_blue_l">
              <a href="javascript:fn_egov_save();">
                <c:if test="${registerFlag == 'create'}">
                  <spring:message code="button.create" />
                </c:if>
                <c:if test="${registerFlag == 'modify'}">
                  <spring:message code="button.modify" />
                </c:if>
              </a>
              <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left: 6px;" alt="" />
            </span>
          </li>
          <c:if test="${registerFlag == 'modify'}">
            <li>
              <span class="btn_blue_l">
                <a href="javascript:fn_egov_delete();">
                  <spring:message code="button.delete" />
                </a>
                <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left: 6px;" alt="" />
              </span>
            </li>
          </c:if>
          <li>
            <span class="btn_blue_l">
              <a href="javascript:document.detailForm.reset();">
                <spring:message code="button.reset" />
              </a>
              <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left: 6px;" alt="" />
            </span>
          </li>
        </ul>
      </div>
    </div>
    <!-- 검색조건 유지 -->
    <input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>" />
    <input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>" />
    <input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>" />
  </form:form>
</body>
</html>