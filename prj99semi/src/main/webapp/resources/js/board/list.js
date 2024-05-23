function deleteCheckedBoard(){
	//체크박스 전부 가져오기
	const checkboxArr = document.querySelectorAll("main>table>tbody input[type=checkbox]");
	console.log("checkboxArr : " , checkboxArr)
	
	//체크박스 순회하며 체크상태인 요소만 챙기기
	//해당 체크박스들으 value값을 이용해 no채우기
	let str ="";
	for(let i =0; i<checkboxArr.length; i++){
		if(checkboxArr[i].checked){
			//잘선택됐나 확인
			console.log(checkboxArr[i].value);
			//쿼리스트링만들어 str에 담는 과정
			str += "no="+checkboxArr[i].value;
			str += "&";
	}
	//	console.log(checkboxArr[i].checked);
	}
	location.href="http://127.0.0.1:8888/app/admin/board/delete?"+str;
	
}
//전체선택가능하게=>일괄삭제기능