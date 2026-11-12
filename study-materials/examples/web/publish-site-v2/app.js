const button = document.querySelector("#more");
const details = document.querySelector("#details");
let isOpen = false;
button.addEventListener("click", () => {
    isOpen = !isOpen;
    details.hidden = !isOpen;
    button.setAttribute("aria-expanded", String(isOpen));
    button.textContent = isOpen ? "안내 닫기 · v2" : "안내 다시 보기 · v2";
});