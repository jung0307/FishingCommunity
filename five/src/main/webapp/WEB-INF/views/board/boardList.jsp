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
table{
table-layout: fixed;
}
td{
text-align: center;
overflow:hidden; text-overflow: ellipsis;white-space : nowrap;
padding-top: 5px;
padding-bottom: 5px;
}
tr{
text-align: center;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <div>
  <ul class="pagination">
    <li class="page-item disabled">
      <a class="page-link" href="#">&laquo;</a>
    </li>
    <li class="page-item active">
      <a class="page-link" href="#">1</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">2</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">3</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">4</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">5</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">&raquo;</a>
    </li>
  </ul>
</div> -->

<div id="container" style="position: relative; padding-left: 100px; padding-right: 100px;">
<c:choose>
	<c:when test="${not empty boardList}">
		<div style="min-height: 1800px; ">
	
<!-- 			 <img style="width: 100px; height: 50px;" src="resources/img/fishTitleBlue.png"> -->
			<h1 style="margin-bottom: 30px; padding-top: 20px; text-align: center;"> <a style="text-decoration: none; color: #888;" href="${contextPath }/board/getBoardList">
			 <img style="width: 150px; height: 50px;" src="resources/img/fishBoard2.png"> 
			 
			  </a></h1>
			
			<table border="1" style="width:100%;" >
				<tr>
					<td style="width: 7.5%; max-width: 7.5%;  font-style: oblique;"> 글번호 </td>
					<td style="width: 47.5%; max-width: 47.5%;  font-style: oblique;"> 제목 </td>
					<td style="width: 15%; max-width: 15%;  font-style: oblique;"> 아이디 </td>
					<td style="width: 15%; max-width: 15%;  font-style: oblique;"> 게시일 </td>
					<td style="width: 7.5%; max-width: 7.5%;  font-style: oblique;"> 조회수 </td>
					<td style="width: 7.5%; max-width: 7.5%;  font-style: oblique;"> 추천수 </td>
				</tr>
			
				<c:choose>
					<c:when test="${empty pagingNum || pagingNum == 1}">
						<c:forEach items="${boardList }" varStatus="i" var="boardList">
							<c:choose>
								<c:when test="${boardList.boardNum %2 == 0 }">
									<tr>
										<td style="width: 7.5%; max-width: 7.5%; background-color: #F0F0F0;"> 	${countBoardList -i.index} </td>
										<td style="width: 47.5%; max-width: 47.5%; background-color: #F0F0F0;"> 	
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
										<td style="width: 7.5%; max-width: 7.5%;"> 	${countBoardList -i.index} </td>
										<td style="width: 47.5%; max-width: 47.5%;"> 	
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
					</c:when>
					<c:otherwise>
						<c:forEach items="${boardList }" varStatus="i" var="boardList">
							<c:choose>
								<c:when test="${boardList.boardNum %2 == 0 }">
									<tr>
										<td style="width: 7.5%; max-width: 7.5%; background-color: #F0F0F0;"> 	${countBoardList -i.index - (startNum-1 )} </td>
										<td style="width: 47.5%; max-width: 47.5%; background-color: #F0F0F0;"> 	
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
										<td style="width: 15%; max-width: 15%; background-color: #F0F0F0;"> 	${boardList.boardID } </td>
										<td style="width: 15%; max-width: 15%; background-color: #F0F0F0;"> 	${boardList.boardDate } </td>
										<td style="width: 7.5%; max-width: 7.5%; background-color: #F0F0F0;"> 	${boardList.boardCount } </td>
										<td style="width: 7.5%; max-width: 7.5%; background-color: #F0F0F0;"> 	${boardList.upCount } </td>
									</tr>								
								</c:when>
								<c:otherwise>
									<tr>
										<td style="width: 7.5%; max-width: 7.5%;"> 	${countBoardList -i.index - (startNum-1 )} </td>
										<td style="width: 47.5%; max-width: 47.5%;"> 	
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
										<td style="width: 15%; max-width: 15%;"> 	${boardList.boardID } </td>
										<td style="width: 15%; max-width: 15%;"> 	${boardList.boardDate } </td>
										<td style="width: 7.5%; max-width: 7.5%; "> 	${boardList.boardCount } </td>
										<td style="width: 7.5%; max-width: 7.5%;"> 	${boardList.upCount } </td>
									</tr>								
								</c:otherwise>
							</c:choose>
						</c:forEach>				
					</c:otherwise>
				</c:choose>
				
				<c:if test="${logIn == 'on' }">
					<tr>
						<td colspan="6" style="padding:15px;"> <button class="btn btn-secondary" style="float: right;" onclick="writeBoardContent('${memberVO.id}');" > 글쓰기 </button> </td>
					</tr>					
				</c:if>
				<c:if test="${not empty pagingMessage }">
					<tr>
						<td colspan="6" style="padding: 30px;" >
						${pagingMessage }
						</td>
					</tr>
				</c:if>
				<table style="position: absolute; bottom: 150px; max-width: 100%;" >
					<tr>
						<td>
							<img style="max-width: 50%; margin: 0 auto;" src="resources/img/fishBoard.png"> 
						</td>
					</tr>
				</table>
			</table>
		</div>
	</c:when>
	<c:otherwise>
		<div style="min-height: 1800px;">
	
<!-- 			 <img style="width: 100px; height: 50px;" src="resources/img/fishTitleBlue.png"> -->
			<h1 style="margin-bottom: 30px; padding-top: 20px; text-align: center;"> <a style="text-decoration: none; color: #888;" href="${contextPath }/board/getBoardList">
			 <img style="width: 150px; height: 50px;" src="resources/img/fishBoard2.png"> 
			 
			  </a></h1>
			
			<table border="1" style="width:100%">
				<tr>
					<td style="width: 7.5%; max-width: 7.5%;  font-style: oblique;"> 글번호 </td>
					<td style="width: 47.5%; max-width: 47.5%;  font-style: oblique;"> 제목 </td>
					<td style="width: 15%; max-width: 15%;  font-style: oblique;"> 아이디 </td>
					<td style="width: 15%; max-width: 15%;  font-style: oblique;"> 게시일 </td>
					<td style="width: 7.5%; max-width: 7.5%;  font-style: oblique;"> 조회수 </td>
					<td style="width: 7.5%; max-width: 7.5%;  font-style: oblique;"> 추천수 </td>
				</tr>
			
	
				<c:if test="${logIn == 'on' }">
					<tr>
						<td colspan="6" style="padding:15px;"> <button class="btn btn-secondary" style="float: right;" onclick="writeBoardContent('${memberVO.id}');" > 글쓰기 </button> </td>
					</tr>					
				</c:if>
				<table style="position: absolute; bottom: 200px; max-width: 100%; " >
					<tr>
						<td>
							<img style="max-width: 50%; margin: 0 auto;" src="resources/img/fishBoard.png"> 
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
	function writeBoardContent(a) {
		location.href='${contextPath}/board/writeBoardContent.do?boardID='+a;
	}
	
	function guestBook(id) {
		
		if(confirm(id+"님의 방명록으로 가기")){
			location.href='${contextPath}/member/guestBookForm.do?id='+id;
		}
	}
</script>
</html>