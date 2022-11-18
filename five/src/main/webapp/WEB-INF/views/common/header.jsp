<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath }" var="contextPath" ></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

#loginForm{
	float: right;
	position: relative;
 	top: 40px; 
	margin-right: 50px;
	
}
</style>
<body>


<!-- <h1> header </h1> -->

<div style="position: absolute; width: 100%; ">
<div style="margin-right: 30px;">
<c:choose>
	<c:when test="${logIn == 'on' }">
		<div id="loginForm">
			<c:import url="/member/welcomeIndex.do"></c:import>
		</div>
	</c:when>
	<c:otherwise>
		<div>
			<c:import url="/member/loginMemberForm2.do"></c:import>
		</div>
	</c:otherwise>
</c:choose>
</div>
	<div style="display: inline-block; position: relative; left: 50%; margin-left: -100px;">
		<!-- <img src="resources/img/header.png" style="width: 170px; height: 170px;"> -->
		 <a href="${contextPath }/"> <img src="resources/img/Fishing_mania.png" style="width: 200px; height: 200px;">  </a>
	</div>


<%-- <c:choose>
	<c:when test="${logIn == 'on' }">
		<div id="loginForm">
			<c:import url="/member/welcomeIndex.do"></c:import>
			<a style="text-decoration: none; color: #888;" href="${contextPath }/board/getBoardList">
			  <img style="width: 150px; height: 50px;" src="resources/img/fishTitleBlue.png"> 
			 </a>
		</div>
	</c:when>
	<c:otherwise>
		<div id="loginForm" >
			 <c:import url="/member/loginMemberForm.do"></c:import> 
						<a style="text-decoration: none; color: #888;" href="${contextPath }/board/getBoardList">
			  <img style="width: 150px; height: 50px;" src="resources/img/fishTitleBlue.png"> 
			 </a>
		</div>
	</c:otherwise>
</c:choose> --%>

</div>
<!-- <div style="display: block; height: 10px;">
</div> -->

</body>
</html>