<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%--
   /**
    * @Class Name : rstList.jsp
    * @Description : rst List 화면
    * @Modification Information
    *
    *   수정일         수정자                   수정내용
    *  -------    --------    ---------------------------
    *  2019.03.05            최초 생성
    *
    * author JeahaOh
    * since 2019.03.05
    *
    * Copyright (C) 2019 by JeahaOh  All right reserved.
    */
--%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>레스토랑 목록</title>
  <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
<style>
* {margin:0;padding:0;}
* html {height:1px;}
body {margin:0; padding:0; font-family:"굴림"; font-size:12px; color:#666; scroll:auto; text-align: center;}
table, tr, td, th {font-family:"돋움"; font-size:11px; color:#333333;}
.listtd {padding:10px 5px 8px 5px; border-bottom:1px solid #e5e5e5;}
th {background-color:#F3F5E0; background:url(/yummy/images/egovframework/example/th_bg.gif) 0 0 repeat; height:26px; text-align:center; vertical-align:middle; color:#003366;}
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
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">

  <%-- 여기서부터  rst List를 출력할 TABLE --%>
  <div id="table" style="display: inline-block">
    <table width="100%" border="0" cellpadding="0" 
        cellspacing="0" summary="rstID(래스토랑 번호), rstName(레스토랑 이름), star(미슐랭 별점), loc(위치하는 구), catag(메뉴 대분류)를 표시하는 테이블">
      <caption style="visibility: hidden">
        rstID(래스토랑 번호), rstName(레스토랑 이름), star(미슐랭 별점), loc(위치하는 구), catag(메뉴 대분류)를 표시하는 테이블
      </caption>
      <colgroup>
        <%-- <col width="40" /> --%>
        <col width="40" />
        <col width="?" />
        <col width="80" />
        <col width="80" />
        <col width="120" />
      </colgroup>
      <tr>
        <td colspan="4"></td>
        <td>
          <button type="button" id="create" onclick="createRst();">
            <spring:message code="title.rst.create"/>
          </button>
        </td>
      </tr>
      <tr>
        <!-- <th align="center">No</th> -->
        <th align="center"><spring:message code="title.rst.id" /></th>
        <th align="center"><spring:message code="title.rst.name" /></th>
        <th align="center"><spring:message code="title.rst.star" /></th>
        <th align="center"><spring:message code="title.rst.loc" /></th>
        <th align="center"><spring:message code="title.rst.catag" /></th>
      </tr>
      <c:forEach var="result" items="${rstList}" varStatus="status">
        <tr onClick="toRstDetail('${result.rst_no}');">
          <%--
          <td align="center" class="listtd">
            <c:out value="${paginationInfo.totalRecordCount+1 - ((searchVO.pageIndex-1) * searchVO.pageSize + status.count)}" />
          </td>
          --%>
          <td align="center" class="listtd">
            <a href="javascript:fn_egov_select('<c:out value="${result.rst_no}"/>')">
              <c:out value="${result.rst_no}" />
            </a>
          </td>
          <td align="left" class="listtd"><c:out value="${result.rst_name}" />&nbsp;</td>
          <td align="center" class="listtd"><c:out value="${result.star}" />&nbsp;</td>
          <td align="center" class="listtd"><c:out value="${result.loc}" />&nbsp;</td>
          <td align="center" class="listtd"><c:out value="${result.catag_nm}" />&nbsp;</td>
        </tr>
      </c:forEach>
    </table>
  </div>
  <%-- 여기까지  rst List를 출력하는 TABLE --%>
  <%-- PAGING --%>
  <%-- 
  <div id="paging">
    <ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
    <form:hidden path="pageIndex" />
  </div>

  <div id="sysbtn">
    <ul>
      <li>
        <span class="btn_blue_l">
          <a href="javascript:fn_egov_addView();">
            <spring:message code="button.create" />
          </a>
          <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
              style="margin-left: 6px;"
              alt="" />
        </span>
      </li>
    </ul>
  </div>
   --%>
  <%-- PAGING --%>

  <script>
    /**
     * Rst 상세 페이지로 이동하기 위한 function
     */
    function toRstDetail( data ) {
      console.log( data );
      location.href = "/yummy/rst/detail?id=" + data
    }
    
    function createRst() {
    	location.href = "/yummy/rst/save"
    }
  </script>
</body>
</html>