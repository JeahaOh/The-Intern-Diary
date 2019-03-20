//rstDetail.jps의 상태를 저장하는 변수.
let rst_form_status;

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
 * rstDetail.jsp가 로드 될 때,
 * 'modify' 모드 라면
 * form의 input들에 disabled 속성을 줌.
 */
$(function(){
  if( $('#mode').hasClass('modify') ) {
    $('.rst_form').attr('disabled', 'disabled');
    rst_form_status = true;
  }
});

/**
 * input type file에 사진을 올리면
 * #preview에 사진을 보여줌.
 */
$( "#img_input" ).change(function() {
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
  if ( rst_form_status ) {
    $('.rst_form').removeAttr('disabled');
    rst_form_status = false;
  } else {
    $('.rst_form').attr('disabled', 'disabled');
    rst_form_status = true;
  }
}

/**
 * 게시물을 삭제하기 위한 function.
 */
function removeRst() {
  let cnfrm;

  if ( rst_form_status ) {
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
      if (data === 'success' ) {
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
        var options = $("<option></option>");
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
  if ( rst_form_status ) {
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
  console.log( form );

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
    enctype: 'multipart/form-data',
    success: function ( data ) {
      console.log( data );
      if ( postPhot( data ) ) {
        
        
      }
    
//      if( $('#mode').hasClass('modify') ) {
//        window.location.href = document.location.href;
//      }
//      if( data === 0 ) {
//    	  window.location.href = '/yummy/rst/error';
//      }
//      else {
//        window.location.href = '/yummy/rst/detail?id=' + data;
//      }
      
    },
    error: function(xhr, status, msg) {
      console.log('xhr:\n ' + xhr.toString());
      console.log('status:\n ' + status);
      console.log('msg:\n ' + msg);
    }
  });
}
/**
 * AJAX로 사진 보내기
 * @param rst_no
 * @returns
 */
//  console.log( $('#img_input')[0].files[0] );
//  console.log( $('#img_input')[0].value );
function postPhot( rst_no ) {
  var formData = new FormData();
  formData.append( "rst_phot", $('#img_input')[0].files[0] );
  formData.append( "rst_no", rst_no );
  
  $.ajax({
    url:"/yummy/phot/rst_phot",
    data:formData,
    processData: false,
    contentType: false,
    type: 'POST',
    enctype: 'multipart/form-data',
    success: function( data ){
      console.log( data );
      return true;
    },
    error: function(xhr, status, msg, e) {
      console.log('xhr:\n ' + xhr.toString() );
      console.log('status:\n ' + status);
      console.log('msg:\n ' + msg);
      console.log('e:\n' + e);
      return false;
    }
  });
}

/**
 * rst 상세정보 JSON객체를 요청하는 함수
 */
function getRstDetail( rst_no ) {
  let param = {
    "rst_no" : rst_no
  }
  
  console.log( param );
  
  $.ajax("/yummy/rst/rstDetail" , {
      method: "POST",
      data: param,
      contentType : "application/json; charset=UTF-8",
      dataType: "json",
      success: function ( data ) {
        console.log( data );
      },
      error: function(xhr, status, msg) {
        console.debug('xhr:\n ' + xhr);
        console.debug('status:\n ' + status);
        console.debug('msg:\n ' + msg);
      }
    });
}