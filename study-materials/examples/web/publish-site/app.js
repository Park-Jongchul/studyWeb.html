const button = document.querySelector("#more");
const details = document.querySelector("#details");
let isOpen = false;
button.addEventListener("click", () => {
    isOpen = !isOpen;
    details.hidden = !isOpen;
    button.setAttribute("aria-expanded", String(isOpen));
    button.textContent = isOpen ? "상담 안내 접기" : "상담 안내 보기";
});