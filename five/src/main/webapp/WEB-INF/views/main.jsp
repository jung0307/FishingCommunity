<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath }" var="contextPath" ></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#container{
background-color: white;
min-height: 1200px; 
} 
table{
table-layout: fixed;
}
td{
text-align: center;
overflow:hidden; text-overflow: ellipsis;white-space : nowrap;
padding-top: 5px;
padding-bottom: 5px;
}
</style>
<body>
<div id="container" style="position: relative; padding-left: 100px; padding-right: 100px;">
<!-- 	메인페이지
<img src='resources/img/찹쌀떡.jpg' alt='sibal'/> -->
<!-- <div contenteditable="true" style="width: 700px; height: 700px; background-color: white;" id="div1" ></div>

<button type="button" onclick="wow();" >버튼</button> -->

<!-- <div id="editor" contenteditable="true">
</div>

<div id="console"></div> 
-->


<c:choose>
	<c:when test="${not empty boardList}">
		<div>
	
			<h1 style="margin-bottom: 30px; padding-top: 20px; text-align: center;"> <a style="text-decoration: none; color: #888;" href="${contextPath }/board/getBoardList">
			  <img style="width: 150px; height: 50px;" src="resources/img/fishBoard2.png"> 
			 </a></h1>
			
			<table border="1" style="width:100%">
				<tr>
					<td style="width: 7.%; font-style: oblique; "> 글번호 </td>
					<td style="width: 47.5%; font-style: oblique; "> 제목 </td>
					<td style="width: 15%; font-style: oblique;"> 아이디 </td>
					<td style="width: 15%; font-style: oblique;"> 게시일 </td>
					<td style="width: 7.5%; font-style: oblique;"> 조회수 </td>
					<td style="width: 7.5%; font-style: oblique;"> 추천수 </td>
				</tr>
			

						<c:forEach items="${boardList }" varStatus="i" var="boardList">
							<c:choose>
								<c:when test="${boardList.boardNum %2 == 0 }">
									<tr>
										<td style="width: 7.%; max-width: 7.%; background-color: #F0F0F0;"> 	${countBoardList1-i.index} </td>
							
										<td style="width: 47.5%;  max-width: 47.5%; background-color: #F0F0F0;"> 	
											<c:choose>
												<c:when test="${boardList.commentCount > 0 }">
													<a href="${contextPath }/board/getBoardContent.do?boardNum=${boardList.boardNum }" style="text-decoration: none;">
													${boardList.boardTitle } &nbsp; <span style="color: #F7819F"> ${boardList.commentCount } </span>
													</a> 
												</c:when>
												<c:otherwise>
													<a href="${contextPath }/board/getBoardContent.do?boardNum=${boardList.boardNum }" style="text-decoration: none;">
													${boardList.boardTitle }
													</a> 
												</c:otherwise>
											</c:choose>
										</td>
										<td style="width: 15%; max-width: 15%; background-color: #F0F0F0;"> 	<a href='javascript:void(0);' onclick="guestBook('${boardList.boardID }')" style="text-decoration: none; color: #A4A4A4;"> ${boardList.boardID } </a> </td>
										<td style="width: 15%; max-width: 15%; background-color: #F0F0F0;"> 	${boardList.boardDate } </td>
										<td style="width: 7.5%; max-width: 7.5%; background-color: #F0F0F0;"> 	${boardList.boardCount } </td>
										<td style="width: 7.5%; max-width: 7.5%; background-color: #F0F0F0;"> 	<span style="color: #F7819F" >${boardList.upCount }</span> </td>
									</tr>								
								</c:when>
								<c:otherwise>
									<tr>
										<td style="width: 7.%; max-width: 7.%;"> 	${countBoardList1-i.index} </td>
							
										<td style="width: 47.5%;  max-width: 47.5%;"> 	
											<c:choose>
												<c:when test="${boardList.commentCount > 0 }">
													<a href="${contextPath }/board/getBoardContent.do?boardNum=${boardList.boardNum }" style="text-decoration: none;">
													${boardList.boardTitle } &nbsp; <span style="color: #F7819F"> ${boardList.commentCount } </span>
													</a> 
												</c:when>
												<c:otherwise>
													<a href="${contextPath }/board/getBoardContent.do?boardNum=${boardList.boardNum }" style="text-decoration: none;">
													${boardList.boardTitle }
													</a> 
												</c:otherwise>
											</c:choose>
										</td>
										<td style="width: 15%; max-width: 15%;"> 	<a href='javascript:void(0);' onclick="guestBook('${boardList.boardID }')" style="text-decoration: none; color: #A4A4A4;"> ${boardList.boardID } </a> </td>
										<td style="width: 15%; max-width: 15%;"> 	${boardList.boardDate } </td>
										<td style="width: 7.5%; max-width: 7.5%;"> 	${boardList.boardCount } </td>
										<td style="width: 7.5%; max-width: 7.5%;"> 	<span style="color: #F7819F" >${boardList.upCount }</span> </td>
									</tr>								
								</c:otherwise>
							</c:choose>
						</c:forEach>	

			</table>
		</div>
	</c:when>
	<c:otherwise>
		<div >
	
			<h1 style="margin-bottom: 30px; text-align: center;"> <a style="text-decoration: none; color: #888;" href="${contextPath }/board/getBoardList">
			 <img style="width: 150px; height: 50px;" src="resources/img/fishBoard2.png">
			 </a></h1>
			
			<table border="1" style="width:100%; table-layout: fixed;">
				<tr>
					<td style="width: 7.%;  font-style: oblique;"> 글번호 </td>
					<td style="width: 47.5%;  font-style: oblique;"> 제목 </td>
					<td style="width: 15%; font-style: oblique;"> 아이디 </td>
					<td style="width: 15%; font-style: oblique;"> 게시일 </td>
					<td style="width: 7.5%; font-style: oblique;"> 조회수 </td>
					<td style="width: 7.5%; font-style: oblique;"> 추천수 </td>
				</tr>

			</table>
		</div>	
	</c:otherwise>
</c:choose>



<c:choose>
	<c:when test="${not empty freeBoardList}">
		<div >
	
			<h1 style="margin-top: 30px; margin-bottom: 30px; text-align: center;"> <a style="text-decoration: none; color: #888;" href="${contextPath }/freeBoard/getBoardList">
			 <img style="width: 220px; height: 60px; margin-right: 10px;" src="resources/img/fishFreeboard.png"> 
			 </a> </h1>
			
			<table border="1" style="width:100%;">
				<tr>
					<td style="width: 10%; font-style: oblique;"> 글번호 </td>
					<td style="width: 50%; font-style: oblique;"> 제목 </td>
					<td style="width: 15%; font-style: oblique;"> 아이디 </td>
					<td style="width: 15%; font-style: oblique;"> 게시일 </td>
					<td style="width: 10%; font-style: oblique;"> 조회수 </td>
				</tr>
			
	
						<c:forEach items="${freeBoardList }" varStatus="i" var="boardList">
							<c:choose>
								<c:when test="${boardList.boardNum %2 == 0  }">
									<tr>
										<td style="width: 10%; overflow:hidden; text-overflow: ellipsis; max-width: 10%;white-space : nowrap; background-color: #F0F0F0;"> 	${countBoardList2-i.index} </td>
							
										<td style="width: 50%; overflow:hidden; text-overflow: ellipsis; max-width: 50%;white-space : nowrap; background-color: #F0F0F0;"> 	
											<c:choose>
												<c:when test="${boardList.commentCount > 0 }">
													<a href="${contextPath }/freeBoard/getBoardContent.do?boardNum=${boardList.boardNum }" style="text-decoration: none;">
													${boardList.boardTitle } &nbsp; <span style="color: #F7819F"> ${boardList.commentCount } </span>
													</a> 
												</c:when>
												<c:otherwise>
													<a href="${contextPath }/freeBoard/getBoardContent.do?boardNum=${boardList.boardNum }" style="text-decoration: none;">
													${boardList.boardTitle }
													</a> 
												</c:otherwise>
											</c:choose>
										</td>
										<td style="width: 15%; overflow:hidden; text-overflow: ellipsis; max-width: 15%;white-space : nowrap; background-color: #F0F0F0;"> 	${boardList.boardID } </td>
										<td style="width: 15%; max-width: 15%; background-color: #F0F0F0;"> 	${boardList.boardDate } </td>
										<td style="width: 10%; max-width: 10%; background-color: #F0F0F0;"> 	${boardList.boardCount } </td>
									</tr>								
								</c:when>
								<c:otherwise>
									<tr>
										<td style="width: 10%; overflow:hidden; text-overflow: ellipsis; max-width: 10%;white-space : nowrap;"> 	${countBoardList2-i.index} </td>
							
										<td style="width: 50%; overflow:hidden; text-overflow: ellipsis; max-width: 50%;white-space : nowrap;"> 	
											<c:choose>
												<c:when test="${boardList.commentCount > 0 }">
													<a href="${contextPath }/freeBoard/getBoardContent.do?boardNum=${boardList.boardNum }" style="text-decoration: none;">
													${boardList.boardTitle } &nbsp; <span style="color: #F7819F"> ${boardList.commentCount } </span>
													</a> 
												</c:when>
												<c:otherwise>
													<a href="${contextPath }/freeBoard/getBoardContent.do?boardNum=${boardList.boardNum }" style="text-decoration: none;">
													${boardList.boardTitle }
													</a> 
												</c:otherwise>
											</c:choose>
										</td>
										<td style="width: 15%; overflow:hidden; text-overflow: ellipsis; max-width: 15%;white-space : nowrap;"> 	${boardList.boardID } </td>
										<td style="width: 15%; max-width: 15%;"> 	${boardList.boardDate } </td>
										<td style="width: 10%; max-width: 10%;"> 	${boardList.boardCount } </td>
									</tr>								
								</c:otherwise>
							</c:choose>
						</c:forEach>	
		
			</table>
		</div>
	</c:when>
	<c:otherwise>
				<div >
	
			 <h1 style="margin-top: 30px; margin-bottom: 30px; text-align: center;"> <a style="text-decoration: none; color: #888;" href="${contextPath }/freeBoard/getBoardList">
			 <img style="width: 220px; height: 60px; margin-right: 10px;" src="resources/img/fishFreeboard.png">
			 </a> </h1>
			
			<table border="1" style="width:100%">
				<tr>
					<td style="width: 10%; font-style: oblique;"> 글번호 </td>
					<td style="width: 50%; font-style: oblique;"> 제목 </td>
					<td style="width: 15%; font-style: oblique;"> 아이디 </td>
					<td style="width: 15%; font-style: oblique;"> 게시일 </td>
					<td style="width: 10%; font-style: oblique;"> 조회수 </td>
				</tr>
		
			</table>
		</div>
	</c:otherwise>
	
</c:choose>

<!-- <div style="position: absolute; bottom: 50px; width: 100%;">
	<table style="width: 100%;" >
		<tr>
			<td>
				<img style="max-width: 20%; margin: 0 auto;" src="resources/img/fish.png"> 
			</td>
		</tr>
	</table>
</div>  -->

</div> 
</body>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

function guestBook(id) {
	
	if(confirm(id+"님의 방명록으로 가기")){
		location.href='${contextPath}/member/guestBookForm.do?id='+id;
	}
}

/* function wow() {
	var div1 = $('#div1').children();
	var div2 = $('#div1 > div').children();
	var div3 = $('#div1').innerText;
	var div4 = $('#div1').innerHTML;

	console.log(div3);
	console.log(div4);
} */


/*   var input = document.getElementById('editor');

input.onkeyup = function() {
  console.log(input.textContent)
  document.getElementById('console').innerHTML = input.innerText.replace(/(\n|\r\n)/g, '<br>'); 
}  
 */

</script>
</html>