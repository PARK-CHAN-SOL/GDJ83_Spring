const addWish = document.getElementById("addWish");
const wishResult = document.getElementById("wishResult");

//Arrow Function
addWish.addEventListener("click", (e)=>{
    fetch("./addWish?item_id="+e.target.dataset.itemId, {
        method:"GET"
    })
    .then((res)=>{return res.text();})
    .then((res)=>{
        if(res>0){
            let check = confirm('Wish List로 이동하시겠습니까?');
            if(check){
                location.href = "./wishList";
            }
        }else{
            alert('Wish List 추가 실패');
        }
        // wishResult.append(text);
    })
    .catch(()=>{
        alert('오류 발생');
    })
})


// function(res){
//     return res.text();
// }

// addWish.addEventListener("click", function(){
//     fetch("./addWish?num=1293871&name=kkkkkk3", {
//         method:"GET"
//     })
// })