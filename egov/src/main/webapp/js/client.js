document.querySelectorAll("input").forEach(e => {
    e.addEventListener("focus", () => {
        if(!e.parentElement.querySelector("label").classList.contains("active")){
            e.parentElement.querySelector("label").classList.add("active");
        }
    })
    e.addEventListener("blur", () => {
        if(e.value === ""){
            e.parentElement.querySelector("label").classList.remove("active");
        }
    })
})