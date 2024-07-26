/**
 * 댓글 관리
 */

const commentContents = document.getElementById("commentContents");

const commentButton = document.getElementById("commentButton");
const commentClose = document.getElementById("commentClose");
const item_id = document.getElementById("item_id");
const commentList = document.getElementById("commentList");

let btn;

getList();

function getList (page) {
    let url = "";
    if(page == null){
        url = "./commentList?item_id="+item_id.innerHTML+"&page=1"
    } else {
        url = page.dataset.commentList;
    }
    fetch(url, {
        method:"GET"
    })
    .then((res)=>{
        return res.text();
    })
    .then((res)=>{
        res = res.trim();
        commentList.innerHTML = res;
    })
}

function commentDelete(boardNum){
    let result = fetch("./commentDelete", {
        method:"POST",
        headers:{
            "Content-Type":"application/x-www-form-urlencoded"
        },
        body:"boardNum="+boardNum
    })
    .then((res)=>{return res.text()})
    .then((res)=>{
      res = res.trim();  
      if(res < 0) {
        alert("댓글 삭제 실패");
        return false;
    }
      else {
        alert("댓글 삭제");
        return true;
      }
    });
    if(result){
        getList();
    }
}

commentClose.addEventListener("click", ()=>{
    commentContents.value="";
    commentContents.dataset.isUpdate = 'false';
    commentButton.innerHTML = '등록';
})

commentList.addEventListener("click", (e)=>{
    // console.log(e.target.tagName); 
    if(e.target.tagName == 'A') getList(e.target);
    else if(e.target.tagName == 'BUTTON' && e.target.innerHTML == 'X') commentDelete(e.target.dataset.boardNum);
    else if(e.target.tagName == 'BUTTON' && e.target.innerHTML == '수정') {
        btn = e.target;
        console.log(e);
        console.log(btn.parentNode.parentNode.parentNode.childNodes);
        for(let tableChild of btn.parentNode.parentNode.parentNode.childNodes){
            if(tableChild.classList != null && tableChild.classList.contains('boardContents')) {
                for(let trChild of tableChild.childNodes){
                    if(trChild.classList != null && trChild.classList.contains('boardContents')) {
                        commentButton.innerHTML = '수정';
                        commentContents.value=trChild.innerHTML;
                        break;
                    }
                
                }
            }
        
        }
        commentContents.dataset.isUpdate=true;
    }
})


commentButton.addEventListener("click", ()=>{
    let contents = commentContents.value;
    if(contents == null || contents == ""){
        alert("댓글을 입력하세요");
        return;
    } else if(contents.length > 60){
        alert("댓글의 최대 길이는 60자 입니다");
        return;
    }

    let url = "./commentAdd";

    const form = new FormData();
    form.append("boardContents", contents);
    form.append("item_id", item_id.innerHTML);
    form.append("boardNum", btn.dataset.boardNum);

    if(commentButton.innerHTML == '수정'){
        url = "./commentUpdate";
    }
    
    fetch(url, {
        method:"POST",
        body:form
    })
    .then((res)=>{return res.text()})
    .then((res)=>{
        res = res.trim();
        if(res > 0){
            getList();
        } else {
            alert("실패");
        }
        commentClose.click();
    })
    .catch(()=> {
        alert("오류발생");
    });
    
});