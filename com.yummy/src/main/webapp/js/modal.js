//  모달 열기.
var modal = document.getElementById('modal');
function openModal() {
  modal.style.display = "block";
}
//  모달 닫기.
function exitModal(){
  modal.style.display = "none";
  //  모달 닫을 시 할 행동.
}
// span의 X를 눌러 모달 닫기.
var span = document.getElementsByClassName("close")[0];
span.onclick = function() {
  exitModal();
}
// modal 밖 클릭시 닫기.
window.onclick = function(event) {
  if (event.target == modal) {
    exitModal();
  }
}
