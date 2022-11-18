<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath" ></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<style>
#container{
background-color: white;
min-height: 500px;
}
tr{
text-align: center;
}
td{
border: 1px;
}
</style>
<body>
<div id="container">

<form action="${contextPath }/member/updateMemberInfo.do" method="post" onsubmit="return valid();">
  <fieldset style="padding: 30px;">
    <legend style="margin-top: 50px;">Update Info</legend>
    <div class="form-group row">
		<input type="hidden" name="id" value="${id }">
		
<!--     <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4"> ID </label>
      <input type="text" class="form-control" placeholder="ID" name="id" id="signUpId">
      
    </div> -->
    <div class="form-group">
      <label for="exampleInputPassword1" class="form-label mt-4">Password</label>
      <input type="password" class="form-control" id="updatePassword" placeholder="Password" style="margin-bottom: 20px;" name="pwd">
      
        <button type="submit" class="btn btn-primary">submit</button>
        <button type="reset" class="btn btn-secondary" data-bs-dismiss="modal">reset</button>
    </div>
  </fieldset>
</form>
</div>

</body>
<script type="text/javascript">
/* var signUpId = document.getElementById("signUpId"); */
var updatePassword = document.getElementById("updatePassword");

function valid() {
	
	if(updatePassword.value == ""){
		alert('password를 입력하세요');
		updatePassword.focus();
		return false;
	} 
	
	return true; 
}
</script>
</html>