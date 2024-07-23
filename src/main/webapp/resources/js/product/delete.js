
const itemDiv = document.getElementById("itemDiv");

itemDiv.addEventListener("click", (e)=>{
    if (e.target.classList.contains("delBtn")){
        const wishNum = e.target.dataset.wishNum;
        for(const child of e.target.parentNode.childNodes){
            if(child.classList !== undefined){
                if (child.classList.contains("delChk")){
                    if(child.checked){
                        alert(wishNum + "remove");
                        e.target.parentNode.parentNode.remove();
                    }
                }
            }
            // console.log(child.classList);
        }
    }
    // console.log(e);
})
 