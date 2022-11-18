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
a{
text-decoration: none;
}
#div1{
padding-right:5px;
border-right: 2px solid #CCCCCC;
}
#div2{
}
</style>
<body>
	<div style="float: right; ">
		<div id="div1" style="display: inline-block;">
			<a href="javascript:void(0);" onclick="LogIn();" style="font-weight: bold;">Login</a>
		</div>
		<div id="div2" style="border-right-color: white; border: 1px; display: inline-block;">
			<a href="javascript:void(0);" onclick="signUp();" style="font-weight: bold;">Sign Up</a>
		</div>
	</div>
</body>
<script type="text/javascript">

function signUp() {
	location.href='${contextPath}/member/addMemberForm.do';
}
function LogIn() {
	location.href='${contextPath}/member/loginMemberFormMain.do';
}

</script>
</html>