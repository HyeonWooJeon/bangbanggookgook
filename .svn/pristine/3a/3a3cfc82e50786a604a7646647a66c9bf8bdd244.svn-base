

const modal = document.getElementById("loginmodal");
const findmodal = document.getElementById("findmodal");
const btnModal = document.getElementById("btn-modal");
const btn_backLogin = document.getElementById("btn-backLogin"); 

btnModal.addEventListener("click", e => {
    modal.style.display = "flex"
})




function modalOn() {
    modal.style.display = "flex"
}
function isModalOn() {
    return modal.style.display === "flex"
}
function modalOff() {
    modal.style.display = "none"
}
btn_backLogin.addEventListener("click", e => {
 findmodal.style.display ='none'
 modalOn();})

btnModal.addEventListener("click", e => {
	findmodal.style.display ='none'
    modalOn()
})
const closeBtn = modal.querySelector(".close-area")
closeBtn.addEventListener("click", e => {
    modalOff()
})

const find_login = modal.querySelector(".find_login")
find_login.addEventListener("click", e => {
    modalOff()
    findmodal.style.display = "flex"
})
modal.addEventListener("click", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
        modalOff()
    }
})
window.addEventListener("keyup", e => {
    if(isModalOn() && e.key === "Escape") {
        modalOff()
    }
})

//아이디,비밀번호 찾기


function modalOnf() {
	findmodal = document.getElementById('findmodal')
    findmodal.style.display = "flex"
}
function isModalOnf() {
    return findmodal.style.display === "flex"
}
function modalOfff() {
    findmodal.style.display = "none"
}
const findCloseBtn = findmodal.querySelector(".findCloseBtn")

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
	console.log('asd')
    modalOfff()
})


findmodal.addEventListener("click", e => {
    const evTargetf = e.target
    if(evTargetf.classList.contains("findmodal-overlay")) {
        modalOfff();
    }
})
window.addEventListener("keyup", event => {
    if(isModalOnf() && event.key === "Escape") {
        modalOfff();
    }
})




