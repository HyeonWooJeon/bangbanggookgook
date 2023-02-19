//아이디,비밀번호 찾기


const findCloseBtn = document.getElementById("findCloseBtn")
function modalOnf() {
    findmodal.style.display = "flex"
}
function isModalOnf() {
    return findmodal.style.display === "flex"
}
function modalOfff() {
    findmodal.style.display = "none"
}



findCloseBtn.addEventListener("click", e => {
    modalOfff()
})


findmodal.addEventListener("click", e => {
    const evTargetf = e.target
    if(evTargetf.classList.contains("findmodal-overlay")) {
        modalOfff()
    }
})
window.addEventListener("keyup", event => {
    if(isModalOnf() && event.key === "Escape") {
        modalOfff()
    }
})

