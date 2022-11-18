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
<style type="text/css">
#container{
	background-color: white;
}
tr{
text-align: center;
}
td{
border: 1px;
}
</style>
<body>
<div id="container" >
	<c:forEach varStatus="i" var="memberList" items="${memberList }">
		<c:if test="${memberList.id != 'admin' }">
			<div class="toast show" role="alert" aria-live="assertive" aria-atomic="true" style="display: inline-block;">
			  <div class="toast-header">
			    <strong class="me-auto"> <a href='${contextPath }/member/updateMemberInfoForm.do?id=${memberList.id}' style="text-decoration: none;"> ${memberList.id } </a> </strong>
			    <small>${memberList.signUpDate }</small>
			    <button type="button" class="btn-close ms-2 mb-1" data-bs-dismiss="toast" aria-label="Close" onclick="removeMember('${memberList.id}');">
			      <span aria-hidden="true"></span>
			    </button>
			  </div>
			  <div class="toast-body">
			    password : &nbsp;&nbsp; ${memberList.pwd } <br>
			    role : &nbsp;&nbsp; ${memberList.role } <br>
			  </div>
			</div>
		</c:if>
	</c:forEach>
</div>
</body>
<script type="text/javascript">
function removeMember(id) {
	
 	if(confirm("회원 "+id+"님을 정말 삭제하시겠습니까?")){
		location.href = '${contextPath}/member/removeMember.do?id='+id;
	} 
	
}
</script>
</html>