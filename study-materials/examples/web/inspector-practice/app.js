document.querySelector("#greet").addEventListener("click", () => {
  document.querySelector("#message").textContent = "안녕하세요. 마음쉼 상담실입니다.";
  console.log("인사 버튼 클릭");
});

document.querySelector("#error").addEventListener("click", () => {
  // 학습용: 아직 없는 함수를 호출합니다. 교재를 따라 함수를 추가하세요.
  showCounselTip();
});

document.querySelector("#imageError").addEventListener("click", () => {
  // 학습용: 없는 파일입니다. sample.svg로 바꿔 보세요.
  document.querySelector("#practiceImage").src = "missing-photo.png";
});
