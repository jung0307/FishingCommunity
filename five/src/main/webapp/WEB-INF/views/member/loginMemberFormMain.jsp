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
#container{
background-color: white;
min-height: 500px;
}
/* .td_{
width: 50px;
}
#td{
width: 150px;
} */

</style>
<body>


<div id="container">

<form action="${contextPath }/member/loginMember.do" method="post">
  <fieldset style="padding: 30px;">
    <legend style="margin-top: 50px;">Login</legend>
    <div class="form-group row">

    <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4"> ID </label>
      <input type="text" class="form-control" placeholder="ID" name="id" id="id" required="required">
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1" class="form-label mt-4">Password</label>
      <input type="password" class="form-control" id="pwd" placeholder="Password" style="margin-bottom: 20px;" name="pwd" required="required">
      
        <button type="submit" class="btn btn-primary">submit</button>
        <button type="reset" class="btn btn-secondary" data-bs-dismiss="modal">reset</button>
    </div>
  </fieldset>
</form>
</div>

</body>
<script type="text/javascript">

/* var id = document.getElementById("id");
var pwd = document.getElementById("pwd");

function valid() {
	
 	if(signUpId.value == ""){
		alert('id를 입력하세요');
		signUpId.focus();
		return false;
	}
	if(signUpPassword.value == ""){
		alert('password를 입력하세요');
		signUpPassword.focus();
		return false;
	} 
	
	return true; 
} */
</script>
</html>