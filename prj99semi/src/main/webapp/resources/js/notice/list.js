console.log("zzz")


$.ajax({
	url:"http://127.0.0.1:8888/app/rest/notice/list",
	method:"GET",
	data:{pno: 1},
	success:function(x){//x==서버가 응답해준 데이터
		console.log("통신 성공!")
		console.log(x);//전달받은 x는 리스트
		
		let str ="";
		for(let i =0 ; i<x.length; ++i){
			
		str +="<tr>";
		str +="<td>"+x[i].no+"</td>";
		str +="<td>"+x[i].title+"</td>";
		str +="<td>"+x[i].writerNick+"</td>";
		str +="<td>"+x[i].hit+"</td>";
		str +="<td>"+x[i].createDate+"</td>";	
		str +="</tr>";
			
		}
		
		
		const tbody = document.querySelector("main table tbody");
		tbody.innerHTML=str;
		
		
	},
	fail:function(){
		console.log("통신 실패....")	
	},	
});