<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath }" var="contextPath" ></c:set>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#container{

	background-color: white;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="container" >
	<div style="min-height: 1200px; padding: 30px;">
		
		
		
		<h1 style="text-align: center; margin-bottom: 100px;"><img style="width: 100px; height: 70px; margin-right: 20px;" src="resources/img/fishGuestBook3.png">GuestBook</h1>
		
		<div style="display: inline-block; margin-top: 15px; margin-bottom: 30px; width: auto;
		   overflow: auto;">
			<div class="card text-white bg-dark mb-3" style="width: 20rem; display: inline-block;">
			  <div class="card-header" style="max-height: 50px;">
				<p class="card-text" id="cardHeader" style="overflow: auto;">Header</p> 
			  </div>
			  <div class="card-body" style="max-height: 150px;">
			   <!--  <h4 class="card-title" id="cardTitle">Dark card title</h4> -->
			    <p class="card-text" id="console" style="overflow: auto;">Some quick example text to build on the card title and make up the bulk of the card's content.</p> 
			  </div>
			</div>
			
			<div style="display: inline-block;  width: 450px; height: 200px;" >
				<form action="${contextPath }/member/addGuestBook.do" method="post" onsubmit="return valid();">
					<div class="form-group" style="margin-bottom: 15px;">
					  <fieldset>
					    <input class="form-control" style="width: 200px;" id="readOnlyInput" type="text" readonly="readonly" value="${memberVO.id }" name="guestID">
					    <input type="hidden" name="role" value="${memberVO.role }">
					    <input type="hidden" name="id" value="${id }">
					  </fieldset>
					</div>
				    <div class="form-group">
				      <textarea class="form-control" id="input" rows="3" style="height: 98px; overflow: auto;" maxlength="50" name="message"></textarea>
				    </div>
					<div class="btn-group" role="group" aria-label="Basic example" style="margin-top: 15px;">
					  <button type="submit" class="btn btn-primary">submit</button>
					  <button type="reset" class="btn btn-primary">reset</button>
					</div>
				</form>
			</div>
		</div>

		<div style="overflow: hidden;">
<!-- 			<div class="card text-white bg-primary mb-3" style="max-width: 20rem; display: inline-block;">
			  <div class="card-header">Header</div>
			  <div class="card-body">
			    <h4 class="card-title">Primary card title</h4>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			  </div>
			</div>
			<div class="card text-white bg-secondary mb-3" style="max-width: 20rem; display: inline-block;">
			  <div class="card-header">Header</div>
			  <div class="card-body">
			    <h4 class="card-title">Secondary card title</h4>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			  </div>
			</div>
			<div class="card text-white bg-success mb-3" style="max-width: 20rem; display: inline-block;">
			  <div class="card-header">Header</div>
			  <div class="card-body">
			    <h4 class="card-title">Success card title</h4>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			  </div>
			</div>
			<div class="card text-white bg-danger mb-3" style="max-width: 20rem; display: inline-block;">
			  <div class="card-header">Header</div>
			  <div class="card-body">
			    <h4 class="card-title">Danger card title</h4>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			  </div>
			</div>
			<div class="card text-white bg-warning mb-3" style="max-width: 20rem; display: inline-block;">
			  <div class="card-header">Header</div>
			  <div class="card-body">
			    <h4 class="card-title">Warning card title</h4>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			  </div>
			</div>
			<div class="card text-white bg-info mb-3" style="max-width: 20rem; display: inline-block;">
			  <div class="card-header">Header</div>
			  <div class="card-body">
			    <h4 class="card-title">Info card title</h4>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			  </div>
			</div>
			<div class="card bg-light mb-3" style="max-width: 20rem; display: inline-block;">
			  <div class="card-header">Header</div>
			  <div class="card-body">
			    <h4 class="card-title">Light card title</h4>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			  </div>
			</div>
			<div class="card text-white bg-dark mb-3" style="max-width: 20rem; display: inline-block;">
			  <div class="card-header">Header</div>
			  <div class="card-body">
			    <h4 class="card-title">Dark card title</h4>
			    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
			  </div>
			</div> -->
			
			
			<c:forEach var="guestBookList" items="${guestBookList }" varStatus="i">
				<div class="${guestBookList.classColor }" style="max-width: 20rem; display: inline-block;">
				  <div class="card-header">${guestBookList.guestID }</div>
				  <div class="card-body">
				    <!-- <h4 class="card-title">Dark card title</h4> -->
				    <p class="card-text">${guestBookList.message }</p>
				  </div>
				</div>					
			</c:forEach>
			
			
		</div>

			
	</div>
</div>

</body>
<script type="text/javascript">

var readOnlyInput = document.getElementById('readOnlyInput');


	document.getElementById('cardHeader').innerHTML = readOnlyInput.value;



var input = document.getElementById('input');

input.onkeyup = function() {
	/* alert(input.innerText); */
/* 	console.log(input.innerHTML); */
	document.getElementById('console').innerHTML = input.value.replace(/(\n|\r\n)/g, '<br>'); 
} 

function valid() {
	if(readOnlyInput.value == ""){
		alert('로그인이 필요합니다!');
		return false;
	}
	if(input.value == ""){
		alert('입력하세요!');
		return false;
	}
	return true;
}

</script>
</html>