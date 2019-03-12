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
  <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
  <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/modal.css'/>"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  </head>
  <body style="text-align: center; margin: 0 auto; display: inline; padding-top: 100px;">
    <div class="outter_container">
      <div class="inner_container">
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
                  <td class="tbtd_content" rowspan="5">
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
                    <input type="file" id="img" class="rst_form" name="img" alt="사진" accept=".png, .jpg, .jpeg">
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
                  <td class=tbtd_content>
                    <input type="time" id="lo_tm" class="rst_form" 
                        name="lo_tm" alt="<spring:message code="title.rst.lo_tm"/>" 
                        value="<c:out value="${rst.lo_tm}"/>" required>
                  </td>
                  <td class="tbtd_content"></td>
                </tr>
              </table>
            </div>
          </div>
        </form>
      </div>
        <c:if test="${mode eq 'Modify'}">
          <%-- <jsp:include page="<c:url value='/jsp/egovframework/rvw/rvw.jsp'/>"/> --%>
          <div class="inner_container">
            <table id="rate">
              <colgroup>
                <col width="100"/>
                <col width="100"/>
                <col width="100"/>
                <col width="100"/>
              </colgroup>
              <tr>
                <!-- 1, 2, 3, 4, 5, 후기 갯수, 평점 -->
                <td id="score_best" class="rvw_dtl tbtd_content"></td>
                <td id="score_good" class="rvw_dtl tbtd_content"></td>
                <td id="score_soso" class="rvw_dtl tbtd_content"></td>
                <td id="score_bad" class="rvw_dtl tbtd_content"></td>
                <td id="score_worst" class="rvw_dtl tbtd_content"></td>
                <td id="score_cnt" class="rvw_dtl tbtd_content"></td>
                <td id="score_grade" class="rvw_dtl tbtd_content"></td>
              </tr>
            </table>
          </div>
          <hr>
          <div class="inner_container">
        <hr>
            <table id="rvwTable">
              <colgroup>
                <col width="100"/>
                <col width="500"/>
                <col width="50"/>
                <col width="200"/>
              </colgroup>
              <thead>
                <tr>
                  <td class="tbtd_caption"><spring:message code="rvw.no"/></td>
                  <td class="tbtd_caption"><spring:message code="rvw.id"/></td>
                  <td class="tbtd_caption"><spring:message code="rvw.score"/></td>
                  <td class="tbtd_caption"><spring:message code="rvw.cdt"/></td>
                </tr>
              </thead>
              <tbody id="rvw">
              </tbody>
            </table>
          </div>
        </c:if>
      </div>
    
    <%-- Modal --%>
    <div id="modal" class="modal">
      <span class="close">&times;</span>
      <%-- ModalContent --%>
      <div class="modal_content">
        <h2><spring:message code="rvw.dtl"/></h2>
        <table>
          <tr>
            <td class="tbtd_caption">
              <spring:message code="rvw.no"/>
            </td>
            <td class="rvw_dtl tbtd_content">
              <input type="text" id="rvw_no" name="rvw_no" readonly="readonly"/>
            </td>
          </tr>
          <tr>
            <td class="tbtd_caption">
              <spring:message code="rvw.id"/>
            </td>
            <td class="rvw_dtl tbtd_content">
              <input type="text" id="id" name="id" readonly="readonly"/>
            </td>
          </tr>
          <tr>
            <td class="tbtd_caption">
              <spring:message code="rvw.score"/>
            </td>
            <td class="rvw_dtl tbtd_content">
              <input type="text" id="score" name="score" readonly="readonly"/>
            </td>
          </tr>
          <tr>
            <td class="tbtd_caption">
              <spring:message code="rvw.cont"/>
            </td>
            <td class="rvw_dtl tbtd_content">
              <textarea id="cont" name="cont" cols="40" rows="8" readonly="readonly" style="resize: none;"></textarea>
            </td>
          </tr>
          <tr>
            <td class="tbtd_caption">
              <spring:message code="rvw.cdt"/>
            </td>
            <td class="rvw_dtl tbtd_content">
              <input type="datetime" id="cdt" name="cdt" readonly="readonly" />
            </td>
          </tr>
          <tr>
            <td></td>
            <td>
              <button onclick="rvw_edit()">수정</button>
              <button onclick="rvw_update()">저장</button>
              <button onclick="deleteRvw()">삭제</button>
              
            </td>
          </tr>
        </table>
      </div>
    </div>
    <script src="<c:url value='/js/rstDetail.js'/>"></script>
    <script src="<c:url value='/js/rvw.js'/>"></script>
    <script src="<c:url value='/js/modal.js'/>"></script>
  </body>
</html>