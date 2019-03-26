<%@ page   language="java"    contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
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
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/modal.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/common.css'/>"/>
    <script src="<c:url value='/js/jquery-3.3.1.min.js'/>"></script>
  </head>
  <body style="text-align: center; margin: 0 auto; display: inline; padding-top: 100px;">
    <div class="outter_container">
    <%-- ==== HEADER ==== --%>
      <jsp:include page="/WEB-INF/jsp/egovframework/include/HEADER.jsp" flush="true"/>
    <%-- ==== NAVBAR ==== --%>
      <jsp:include page="/WEB-INF/jsp/egovframework/include/NAVBAR.jsp" flush="true"/>
      <form id="rstForm" name="rstForm" enctype="multipart/form-data">
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
            <td class="tbtd_content" rowspan="5">
              <%-- rst_form이 생성용인지, 읽기 수정용인지에 따라 background image의 유무가 갈리므로 --%>
              <c:choose>
                <c:when test="${mode eq 'Create'}">
                  <img id="preview"/>
                </c:when>
                <c:otherwise>
                  <c:choose>
                    <%-- rst_phot가 없는 경우도 있으므로 --%>
                    <c:when test="${rst.rst_phot != null}">
                      <img id="preview"
                            src="<c:url value='/resources/images/rst/'/>${rst.rst_phot}"
                            onError="this.src=`<c:url value='/resources/images/rst/'/>${rst.rst_phot}`" />
                      <%--
                            img tag 에서 src가 에러가 날 경우
                            onError에 명시한 행동을 취함.
                            현재 코드는 같은 링크의 사진을 재 요청 시키는 것.
                       --%>
                    </c:when>
                    <c:otherwise>
                      <img id="preview"/>
                    </c:otherwise>
                  </c:choose>
                </c:otherwise>
              </c:choose>
              <%-- rst_form이 생성용인지, 읽기 수정용인지에 따라 background image의 유무가 갈리므로 --%>
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
            <td class="tbtd_content">
              <input type="text" id="rst_name" class="rst_form"
                  name="rst_name" value="<c:out value="${rst.rst_name}"/>" required>
            </td>
            
            <td class="tbtd_content">
              <select name="upper_catag" id="upper_catag" class="rst_form" required>
                <c:forEach var="catag" items="${upperCatagList}" varStatus="status" >
                  <option value="${catag.catag_no}"
                      <c:if test="${catag.catag_no eq rst.upper_no}">selected</c:if>>
                          ${catag.catag_nm}
                  </option>
                </c:forEach>
              </select>
            </td>
            
            <td class="tbtd_content">
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
            
            <td class="tbtd_content">
              <input type="tel" id="tel" class="rst_form" name="tel"
                  alt="<spring:message code="title.rst.tel"/>" 
                  value="<c:out value="${rst.tel}"/>">
            </td>
            <td class="tbtd_content">
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
            <td class="tbtd_content">
              <input type="text" id="loc" class="rst_form"
                  name="loc" alt="<spring:message code="title.rst.loc"/>"
                  value="<c:out value="${rst.loc}"/>">
            </td>
            <td class="tbtd_content" colspan="4">
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
            <td class="tbtd_content">
              <label for="img_input" id="img_label">
                <spring:message code="title.phot"/>
                <input type="file" id="img_input" class="rst_form" name="rst_phot" alt="사진" accept=".png, .jpg, .jpeg">
              </label>
            </td>
            <td class="tbtd_content">
              <input type="time" id="opn_tm" class="rst_form" 
                  name="opn_tm" alt="<spring:message code="title.rst.opn_tm"/>" 
                  value="<c:out value="${rst.opn_tm}"/>" required>
            </td>
            <td class="tbtd_content">
              <input type="time" id="brck_tm" class="rst_form" 
                  name="brck_tm" alt="<spring:message code="title.rst.brck_tm"/>" 
                  value="<c:out value="${rst.brck_tm}"/>" >
            </td>
            <td class="tbtd_content">
              <input type="time" id="dnnr_tm" class="rst_form" 
                  name="dnnr_tm" alt="<spring:message code="title.rst.dnnr_tm"/>" 
                  value="<c:out value="${rst.dnnr_tm}"/>">
            </td>
            <td class="tbtd_content">
              <input type="time" id="lo_tm" class="rst_form" 
                  name="lo_tm" alt="<spring:message code="title.rst.lo_tm"/>" 
                  value="<c:out value="${rst.lo_tm}"/>" required>
            </td>
            <td class="tbtd_content"></td>
          </tr>
        </table>
      </form>
      
      <c:if test="${mode eq 'Modify'}">
        <!-- ======= RVW INCLUDE ======= -->
          <jsp:include page="/WEB-INF/jsp/egovframework/rvw/rvw.jsp" flush="true"/>
        <!-- ==== RVW Modal INCLUDE ==== -->
          <jsp:include page="/WEB-INF/jsp/egovframework/rvw/rvwDetailModal.jsp" flush="true"/>
      </c:if>
    <%-- ==== FOOTER ==== --%>
      <jsp:include page="/WEB-INF/jsp/egovframework/include/FOOTER.jsp" flush="true"/>
      </div>
    <script src="<c:url value='/js/rstDetail.js'/>" charset="utf-8"></script>
    <c:if test="${mode eq 'Modify'}">
      <script src="<c:url value='/js/rvw.js'/>" charset="utf-8"></script>
      <script src="<c:url value='/js/modal.js'/>" charset="utf-8"></script>
    </c:if>
    <script src="<c:url value='/js/common.js'/>" charset="utf-8"></script>
  </body>
</html>