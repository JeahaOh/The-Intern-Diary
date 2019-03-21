<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="kor">

<head>
  <meta charset="UTF-8">
  <title>RVW Test</title>
    <script src="<c:url value='/js/jquery-3.3.1.min.js'/>"></script>
</head>
<body>
  <form id="form" method="post" action="/yummy/rvw/saveWith" enctype="multipart/form-data">
    <h3>rst_no</h3>
    <input type="text" name="rst_no" id="rst_no" value="211"/>
    <br>
    <h3>user_id</h3>
    <input type="text" name="id" id="id" value="asdf1020"/>
    <br>
    <h3>cont</h3>
    <input type="textarea" name="cont" id="cont" />
    <br>
    <h3>score</h3>
    <input type="number" name="score" id="score" min="1" max="5" step="1" value="3"/>
    <br>
    <h3>rvw_phot</h3>
    <input type="file" name="phot" id="phot" accept="image/*"/>
    <br>
    <input type="submit">
    <input type="button" value="test" onClick="btn();"/>
  </form>
  
  
  <script src="<c:url value='/js/rvwTEST.js'/>"></script>
  <script>
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
    
    function btn() {
      console.log("btn Clicked!!");
      /* 
      var formData = new FormData();
      
      formData.append( "rst_no", $('#rst_no').val() );
      formData.append( "id", $('#id').val() );
      formData.append( "cont", $('#cont').val() );
      formData.append( "score", $('#score').val() );
      formData.append( "phot", $('#phot')[0].files[0] );
       */
      var rvw = $('#form').serializeObject();
       //formData.phot=$('#phot')[0].files[0];
      
      console.log( rvw );
      
      $.ajax({
        url:"/yummy/rvw/saveWith",
        data: JSON.stringify( rvw ),
        /* data: rvw, */
        /* processData: false,
        contentType: false, */
        /* dataType: "json", */
        contentType : 'application/json; charset=UTF-8',
        method: 'POST',
        enctype: 'multipart/form-data',
        /* async : false, */
        success: function( data ){
          console.log( data );
        },
        error: function(xhr, status, msg, e) {
          console.log('xhr:\n ' + xhr.toString() );
          console.log('status:\n ' + status);
          console.log('msg:\n ' + msg);
          console.log('e:\n' + e);
        }
      });
      
    }
  </script>
</body>
</html>