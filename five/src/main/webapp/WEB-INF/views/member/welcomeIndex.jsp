<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:set value="${memberMap.memberVO }" var="memberVO" ></c:set>
<c:set value="${memberMap.logIn }" var="logIn" ></c:set> --%>
<c:set value="${pageContext.request.contextPath }" var="contextPath" ></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
<c:choose>
	<c:when test="${logIn eq 'on' && not empty memberVO.id}">
		<h3>WELCOME ${memberVO.id }!</h3> <br>
		<button type="button" onclick="logout('${memberVO.id}');" class="form-control"> Logout </button>
	</c:when>
	<c:when test="${logIn eq 'on' && empty memberVO.id}">
		<c:redirect url="${contextPath }/member/loginMemberForm.do" ></c:redirect>
	</c:when>	
	<c:otherwise>
		<c:redirect url="${contextPath }/member/loginMemberForm.do" ></c:redirect>
	</c:otherwise>
</c:choose>
</h1>
</body>
<script type="text/javascript">
	function logout(id) {

		alert(id);
		location.href='${contextPath}/member/logout.do?id='+id;
	}
</script>
</html>