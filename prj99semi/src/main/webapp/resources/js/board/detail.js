//연결확인
console.log("detail.js");

function loadReplyList(refNo){
	
	$.ajax({ 
		url: "http://127.0.0.1:8888/app/board/reply/list",
		method: "GET",
		data : {"refNo" : refNo},
		success:function(data){

				const replyVoList = JSON.parse(data);
				console.log(replyVoList);
		
         let str = "";
		for(let i = 0; i<replyVoList.length; i++){
	         str += "<tr>";
	         str += "<td>" + replyVoList[i].no + "</td>";
	         str += "<td>" + replyVoList[i].content + "</td>";
	         str += "<td>" + replyVoList[i].writerNick + "</td>";
	         str += "<td>" + replyVoList[i].createDate + "</td>";
	         str += "</tr>";
		}
			
		const replyTbody = document.querySelector("#replyArea > table > tbody");
		
         replyTbody.innerHTML = str;
		},
		fail:function(error){
			console.log(error);
		},
		
	});
	
}


function writeReply(refNo){
	
	const replyValue = document.querySelector("input[name=reply-content]").value;
	document.querySelector("input[name=reply-content]").value = "";//댓글작성하면 작성칸 비우기
	
	$.ajax({
		url:"http://127.0.0.1:8888/app/board/reply/write",
		type:"POST",
		data:{
			"refNo" : refNo,
			"content" : replyValue,
		},
		success : function(x){
			console.log(x);
			loadReplyList(refNo);
		},
		fail: function(x){
			console.log(x);
		},
		
	})
	
}