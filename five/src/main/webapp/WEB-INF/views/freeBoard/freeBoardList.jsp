<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath }" var="contextPath" ></c:set>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#container{
/* 	margin: 20px; */
	background-color: white;
}
tr{
text-align: center;
}
table{
table-layout: fixed;
}
td{
text-align: center;
overflow:hidden; text-overflow: ellipsis;white-space : nowrap;
border: 1px;
padding-top: 5px;
padding-bottom: 5px;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="container" style="position: relative; padding-left: 100px; padding-right: 100px;">
<c:choose>
	<c:when test="${not empty boardList}">
		<div style="min-height: 1800px;">
	
			<!--  <img style="width: 100px; height: 50px;" src="resources/img/fishTitleBlue.png"> -->
			<h1 style="margin-bottom: 30px; padding-top: 20px; text-align: center;"> <a style="text-decoration: none; color: #888;" href="${contextPath }/freeBoard/getBoardList">
			 <img style="width: 220px; height: 60px;" src="resources/img/fishFreeboardCopy.png"> 
			 </a>
			 
			  </h1>
			
			<table border="1" style="width:100%">
				<tr>
					<td style="width: 10%; max-width: 10%; font-style: oblique;"> 글번호 </td>
					<td style="width: 50%; max-width: 50%; font-style: oblique;"> 제목 </td>
					<td style="width: 15%; max-width: 15%; font-style: oblique;"> 아이디 </td>
					<td style="width: 15%; max-width: 15%; font-style: oblique;"> 게시일 </td>
					<td style="width: 10%; max-width: 10%; font-style: oblique;"> 조회수 </td>
				</tr>
			
				<c:choose>
					<c:when test="${empty pagingNum || pagingNum == 1}">
						<c:forEach items="${boardList }" varStatus="i" var="boardList">
							<c:choose>
								<c:when test="${boardList.boardNum %2 == 0 }">
									<tr>
										<td style="width: 10%; max-width: 10%; background-color: #F0F0F0;"> 	${countBoardList -i.index} </td>
										<td style="width: 50%; max-width: 50%; background-color: #F0F0F0;"> 	
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
										<td style="width: 15%; max-width: 15%; background-color: #F0F0F0;"> 	${boardList.boardID } </td>
										<td style="width: 15%; max-width: 15%; background-color: #F0F0F0;"> 	${boardList.boardDate } </td>
										<td style="width: 10%; max-width: 10%; background-color: #F0F0F0;"> 	${boardList.boardCount } </td>
									</tr>								
								</c:when>
								<c:otherwise>
									<tr>
										<td style="width: 10%; max-width: 10%;"> 	${countBoardList -i.index} </td>
										<td style="width: 50%; max-width: 50%;"> 	
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
										<td style="width: 15%; max-width: 15%;"> 	${boardList.boardID } </td>
										<td style="width: 15%; max-width: 15%;"> 	${boardList.boardDate } </td>
										<td style="width: 10%; max-width: 10%;"> 	${boardList.boardCount } </td>
									</tr>								
								</c:otherwise>
							</c:choose>
						</c:forEach>					
					</c:when>
					<c:otherwise>
						<c:forEach items="${boardList }" varStatus="i" var="boardList">
							<c:choose>
								<c:when test="${boardList.boardNum %2 == 0 }">
									<tr>
										<td style="width: 10%; max-width: 10%; background-color: #F0F0F0;"> 	${countBoardList -i.index - (startNum-1 )} </td>
										<td style="width: 50%; max-width: 50%; background-color: #F0F0F0;"> 	
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
										<td style="width: 15%; max-width: 15%; background-color: #F0F0F0;"> 	${boardList.boardID } </td>
										<td style="width: 15%; max-width: 15%; background-color: #F0F0F0;"> 	${boardList.boardDate } </td>
										<td style="width: 10%; max-width: 10%; background-color: #F0F0F0;"> 	${boardList.boardCount } </td>
									</tr>								
								</c:when>
								<c:otherwise>
									<tr>
										<td style="width: 10%; max-width: 10%;"> 	${countBoardList -i.index - (startNum-1 )} </td>
										<td style="width: 50%; max-width: 50%;"> 	
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
										<td style="width: 15%; max-width: 15%;"> 	${boardList.boardID } </td>
										<td style="width: 15%; max-width: 15%;"> 	${boardList.boardDate } </td>
										<td style="width: 10%; max-width: 10%;"> 	${boardList.boardCount } </td>
									</tr>								
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</c:otherwise>
				</c:choose>
				

					<tr>
						<td colspan="5" style="padding:15px;"> <button class="btn btn-secondary" style="float: right;" onclick="writeBoardContent();" > 글쓰기 </button> </td>
					</tr>					

				<c:if test="${not empty pagingMessage }">
					<tr>
						<td colspan="5" style="padding: 30px;" >
						${pagingMessage }
						</td>
					</tr>
				</c:if>
				<table style="position: absolute; bottom: 50px; max-width: 100%;" >
					<tr>
						<td>
							<img style="max-width: 50%; margin: 0 auto;" src="resources/img/fish10.png"> 
						</td>
					</tr>
				</table>
			</table>
		</div>
	</c:when>
	<c:otherwise>
		<div style="min-height: 1500px;">
	
			<!--  <img style="width: 100px; height: 50px;" src="resources/img/fishTitleBlue.png"> -->
			<h1 style="margin-bottom: 30px; padding-top: 20px; text-align: center;"> <a style="text-decoration: none; color: #888;" href="${contextPath }/freeBoard/getBoardList">
			 <img style="width: 220px; height: 60px;" src="resources/img/fishFreeboardCopy.png"> 
			 </a>
			 
			  </h1>
			
			<table border="1" style="width:100%">
				<tr>
					<td style="width: 10%; max-width: 10%; font-style: oblique;"> 글번호 </td>
					<td style="width: 50%; max-width: 50%; font-style: oblique;"> 제목 </td>
					<td style="width: 15%; max-width: 15%; font-style: oblique;"> 아이디 </td>
					<td style="width: 15%; max-width: 15%; font-style: oblique;"> 게시일 </td>
					<td style="width: 10%; max-width: 10%; font-style: oblique;"> 조회수 </td>
				</tr>
			
					<tr>
						<td colspan="5" style="padding:15px;"> <button class="btn btn-secondary" style="float: right;" onclick="writeBoardContent();" > 글쓰기 </button> </td>
					</tr>					
					<table style="position: absolute; bottom: 200px; max-width: 100%; " >
						<tr>
							<td>
								<img style="max-width: 50%; margin: 0 auto;" src="resources/img/fish10.png"> 
							</td>
						</tr>
					</table>
			</table>
			
		</div>	
	</c:otherwise>
</c:choose>
</div>
</body>
<script type="text/javascript">
	function writeBoardContent() {
		location.href='${contextPath}/freeBoard/writeBoardContent.do';
		/* alert('a'); */
	}
	
/* 	function guestBook(id) {
		
		if(confirm(id+"님의 방명록으로 가기")){
			location.href='${contextPath}/member/guestBookForm.do?id='+id;
		}else{
			alert('tq');
		}
	} */
</script>
</html>