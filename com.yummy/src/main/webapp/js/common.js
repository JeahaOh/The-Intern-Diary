/**
 * NAV BAR에 종속되어 화면 이동기능을 하는 function들.
 * 
 */

$('#to_rst_list').click( function() {
  location.href = "/yummy/rst/list";
});

$('#to_rpt_list').click( function() {
  alert("아직 준비중입니다.");
});

$('#logout').click( function() {
  location.href = "/yummy";
});