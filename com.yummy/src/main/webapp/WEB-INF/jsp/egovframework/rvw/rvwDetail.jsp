<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

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