
const itemDiv = document.getElementById("itemDiv");
const delChkAll = document.getElementById("delChkAll");
const delChks = document.getElementsByClassName("delChk");
const delAllBtn = document.getElementById("delAllBtn");

itemDiv.addEventListener("click", (e) => {
    if (e.target.classList.contains("delBtn")) {
        const wishNum = e.target.dataset.wishNum;
        for (const child of e.target.parentNode.childNodes) {
            if (child.classList !== undefined) {
                if (child.classList.contains("delChk")) {
                    if (child.checked) {
                        // Server에 삭제 요청
                        // option은 js의 객체 형식 
                        fetch("./deleteWishList?item_id=" + wishNum, {
                            method: "GET",
                        })
                            .then((r) => { return r.text(); })
                            .then((r) => {
                                r = r.trim();
                                if (r > 0) {
                                    e.target.parentNode.parentNode.remove();
                                } else {
                                    alert('삭제 실패');
                                }
                            })
                            .catch(() => { alert('삭제 실패'); });


                        // alert(wishNum + " remove");
                    }
                }
            }
            // console.log(child.classList);
        }
    } else if (e.target.classList.contains("delChk")) {
        if (!e.target.checked) {
            delChkAll.checked = false;
        } else {
            for (const delChk of delChks) {
                if (!delChk.checked) {
                    return;
                }
            }
            delChkAll.checked = true;
        }
    }
    // console.log(e);
});

delChkAll.addEventListener("click", () => {
    for (const delChk of delChks) {
        delChk.checked = delChkAll.checked;
    }
});

delAllBtn.addEventListener("click", () => {
    let wishNum = "";
    for (const delChk of delChks) {
        if (delChk.checked) {
            for (const child of delChk.parentNode.childNodes) {
                if (child.classList !== undefined) {
                    if (child.classList.contains("delBtn")) {
                        wishNum += child.dataset.wishNum + ",";
                    }
                }
                // console.log(child.classList);
            }
        }
    }
    if (wishNum != "") {
        fetch("./deleteWishList?item_id=" + wishNum.substring(0, wishNum.lastIndexOf(',')), {
            method: "GET",
        })
            .then((r) => { return r.text(); })
            .then((r) => {
                r = r.trim();
                if (r > 0) {
                    for (let i = 0; i < delChks.length; i++) {
                        if (delChks[i].checked) {
                            for (const child of delChks[i].parentNode.childNodes) {
                                if (child.classList !== undefined) {
                                    if (child.classList.contains("delBtn")) {
                                        child.parentNode.parentNode.remove();
                                        i--;
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    alert('삭제 실패');
                }
            })
            .catch(() => { alert('삭제 실패'); });
    }
});