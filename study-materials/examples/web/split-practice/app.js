const button = document.querySelector("#show");
const message = document.querySelector("#message");
function showMessage() {
  message.textContent = "상담 안내를 열었어요.";
}
button.addEventListener("click", showMessage);