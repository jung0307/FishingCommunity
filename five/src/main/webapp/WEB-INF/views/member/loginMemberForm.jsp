<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath }" var="contextPath" ></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<style>
/* .td_{
width: 50px;
}
#td{
width: 150px;
} */

</style>
<body>
<form action="${contextPath }/member/loginMember.do" method="post">
<table style="border-spacing: 3px; border-collapse: separate;">
<!-- 	<tr align="center">
		<td colspan="1" style="padding: 0px; border: 0px;">
			<input type="text" name="id" id="id" class="form-control" style="width: 200px" placeholder="ID">
		</td>
	</tr>
	<tr align="center">
		<td class="td_" colspan="1" style="padding: 0px; border: 0px;">
			<input type="password" name="pwd" id="pwd" class="form-control" style="width: 200px" placeholder="password">
		</td>
	</tr> -->
	<tr align="center">
		<td class="td_" style="padding: 0px; border: 0px;">
			<input type="submit" value="Login" class="btn btn-primary" style="background-color: #cccccc; width: 100px;">
			<input type="button" value="Sign Up" class="btn btn-primary" style="background-color: #cccccc; width: 100px;" onclick="signUp();">
		</td>
	</tr>
</table>
</form>
</body>
<script type="text/javascript">

function signUp() {
	location.href='${contextPath}/member/addMemberForm.do';
}
</script>
</html>