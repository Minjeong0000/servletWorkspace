console.log("zzz");

//document.querySelector(~~~~)
//$(~~~~);


function checkDup(){
    const id = document.querySelector("input[name=id]").value;
    const obj={
    url :"/app/member/id-dup",
    type:"get",
    data : { "id" : id },//키:밸류
    success: function(x){//x==통신성공했을때 응답받은데이터
        console.log(x);
        //사용가능한 아이디인지 여부에 따라 알람을 띄워주기

        if(x==="good"){
            alert("사용 가능한 아이디입니다!");
        }else{
            alert("사용 불가능한 아이디입니다...");
        }

    },
    error:function(){console.log("통신 실패...");},
    
    };
    
    $.ajax(obj);
}


