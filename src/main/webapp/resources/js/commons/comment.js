/**
 * 댓글 관리
 */

const commentContents = document.getElementById("commentContents");

const commentButton = document.getElementById("commentButton");
const commentClose = document.getElementById("commentClose");
const item_id = document.getElementById("item_id");
const commentList = document.getElementById("commentList");

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
})

commentList.addEventListener("click", (e)=>{
    // console.log(e.target.tagName); 
    if(e.target.tagName == 'A') getList(e.target);
    if(e.target.tagName == 'BUTTON') commentDelete(e.target.dataset.boardNum);
})


commentButton.addEventListener("click", ()=>{
    let contents = commentContents.value;
    if(contents.length > 60){
        alert("댓글의 최대 길이는 60자 입니다");
        commentClose.click();
        return;
    }

    fetch("./commentAdd", {
        method:"POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body:"boardContents="+contents+"&item_id="+item_id.innerHTML
    })
    .then((res)=>{return res.text()})
    .then((res)=>{
        res = res.trim();
        if(res > 0){
            alert("댓글 추가 성공");
            getList();
        } else {
            alert("댓글 추가 실패");
        }
    })
    .catch(()=> {
        alert("오류발생");
    });

    // alert(commentContents.value);
    commentClose.click();
});