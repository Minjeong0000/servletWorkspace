/*
[원인] : AJAX 요청을 보내는 JavaScript 함수가 포함된 js파일 작성 (아래 조건 참고)
0. 제이쿼리 함수를 이용할 것
1. /item/list 에 요청 보낼 것
(기존 요청과 같은 ip, port 에 요청을 보낸다.)
2. 요청 방식은 get 으로 할 것
3. 임의의 자연수를 전달할 것
(키값은 pageNum 으로 한다.)
4. ajax 통신에 실패하면, "통신 실패..." 알람 메세지를 띄울 것
5. ajax 통신에 성공하면, 결과값에 따라 알람 메세지를 띄울 것
결과값이 정상인 경우 : "데이터 잘 받음"
결과값이 이상한 경우 : "데이터 못 받음"
(정상적인 경우, 서버측은 "ok" 라는 문자열을 응답하도록 설계되어 있다.)

$.ajax({
    url: '/ajax/sample1.ajax',
    method: 'get',
    dataType : 'text',
    data : obj,
    success: function (data, status, xhr) {
        console.log(data);
    }
});


*/

$.ajax({

    url: '/item/list',
    type: 'get',
    data : {"pageNum" : pageNum },
    success: function (x) {
        if(x=="ok"){
            alert("데이터 잘 받음");
        }else{
            alert("데이터 못 받음");
        }
    },
    error : function(){alert("통신 실패...")}



})


function sendAjaxRequest(pageNum) {
    $.ajax({
        url: '/item/list',
        type: 'get',
        data: {"pageNum": pageNum},
        success: function (response) {
            if (response === "ok") {
                alert("데이터 잘 받음");
            } else {
                alert("데이터 못 받음");
            }
        },
        error: function () {
            alert("통신 실패...");
        }
    });
}
