/**
 * 
 */
const addPics = document.getElementById("add");
const result = document.getElementById("result");

//부모의 id값
let idx=0;

//최대 첨부파일 개수
let max=1;

//만든 횟수
let count=0;

function setMax(m) {
    max = m;
}

result.addEventListener("click", function(e) {
    let x = e.target.id;
    if(x=='del') {
        //console.log(e.target.parentNode.parentNode);
        //e.target.parentNode.parentNode.remove();
        let ids = e.target.getAttribute("data-del-id");
        document.getElementById(ids).remove();
        count--;
    }
    

})
 
 addPics.addEventListener("click", function() {

    if(count >= max) {
        alert("첨부파일은 최대 "+ max +"개만 가능");
        return;
    }

    let parent = document.createElement("div");
    parent.id = "file"+idx;
    parent.classList.add("input-group", "mb-3");

    let input = document.createElement("input"); //input이라는 element에
    let div = document.createElement("div");
    let span = document.createElement("span");
    input.type = "file"; //속성 type에 file을 넣음
    input.name = "files";
    input.classList.add("form-control");
    parent.append(input);
    
    div.classList.add("input-group-append")
    span.classList.add("input-group-text");
    span.id = "del";

    //id값과 동일한 이름으로 다른 속성에 넣어줌
    span.setAttribute("data-del-id", "file"+idx); //data- 뒤에는 내맘대로: 글로벌 속성임. 
    span.innerHTML = "X";
    
    div.append(span);
    parent.append(div);
    result.append(parent);
    idx++;
    count++;
})