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
#container{
background-color: white;
}
table{
table-layout: fixed;
}
tr{
text-align: center;
}
td{
text-align: center;
overflow:hidden; text-overflow: ellipsis;white-space : nowrap;
border: 1px;
}
.td_header{
border-bottom-color: gray;
}
</style>
<body>
<div id="container">
<%-- <c:choose>
		<c:when test="${logIn != 'on'}">
			<form action="${contextPath}/freeBoard/rewriteBoardContent.do" method="post" enctype="multipart/form-data"> 
				<table border="1" style="width:100%; border-collapse: collapse;">
					<tr style="border-bottom: soild; border-bottom-color: #cccccc; border-bottom-width: 0.5px;">
						<td style="width:70%" class="td_header"> <input type="text" style="width: inherit;" class="form-control" name="boardTitle" required="required"> </td>
						
						<td style="width:30%" class="td_header">
							guest
							<input type="hidden" name="boardNum_" value="${boardVO.boardNum }">
							<input type="hidden" name="boardPwd" value="${boardVO.boardPwd }">
						</td>
					</tr>
					<tr style="border-bottom: soild; border-bottom-color: #cccccc; border-bottom-width: 0.5px;">
						<td>
							<button type="button" class="btn btn-outline-primary" onclick="fn_addFile();">file</button>
							<button type="button" class="btn btn-outline-success">Success</button>
							<button type="button" class="btn btn-outline-info">Info</button>
							<button type="button" class="btn btn-outline-warning">Warning</button>
							<button type="button" class="btn btn-outline-danger">Danger</button>				
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: left; padding-left: 30px; padding-right: 30px; padding-top: 30px;">
							<div style="min-height: 1500px;" contenteditable="true" class="form-control" id="div_image">
								${boardVO.boardContent }
							</div>
						</td>
						<td>
							<textarea name="boardContent" style="display: none;" id="hiddenText">
							</textarea>
						</td>

					</tr>
					<tr style="border-bottom: soild; border-bottom-color: #cccccc; border-bottom-width: 0.5px;">
						<td class="td_header" colspan="2" style="padding: 15px;">  
							<!-- <input type="button" class="btn btn-primary" id="submitBTN" onclick="submit(this.form);" value="수정"></input> -->
							<input type="submit" class="btn btn-primary" value="수정"></input>
 							<!-- <input type="button" class="btn btn-primary" id="submitBTN" onclick="rewrite();" value="수정"></input> -->
	 						<button type="reset" class="btn btn-primary">취소</button>
						</td>
					</tr>
				</table>				
			</form>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert('게시판 오류!');
				location.href='${contextPath}/freeBoard/getBoardList.do';
			</script>
		</c:otherwise>
	</c:choose> --%>
			<form action="${contextPath}/freeBoard/rewriteBoardContent.do" method="post" enctype="multipart/form-data"> 
				<table border="1" style="width:100%; border-collapse: collapse;">
					<tr style="border-bottom: soild; border-bottom-color: #cccccc; border-bottom-width: 0.5px;">
						<td style="width:70%; max-width: 70%;" class="td_header"> <input type="text" style="width: inherit;" class="form-control" name="boardTitle" required="required" placeholder="title"> </td>
						
						<td style="width:30%; max-width: 30%;" class="td_header">
							guest
							<input type="hidden" name="boardNum_" value="${boardVO.boardNum }">
							<input type="hidden" name="boardPwd" value="${boardVO.boardPwd }">
						</td>
					</tr>
					<tr style="border-bottom: soild; border-bottom-color: #cccccc; border-bottom-width: 0.5px;">
						<td>
							<button type="button" class="btn btn-outline-primary" onclick="fn_addFile();">file</button>
							<button type="button" class="btn btn-outline-success">Success</button>
							<button type="button" class="btn btn-outline-info">Info</button>
							<button type="button" class="btn btn-outline-warning">Warning</button>
							<button type="button" class="btn btn-outline-danger">Danger</button>				
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: left; padding-left: 30px; padding-right: 30px; padding-top: 30px;">
							<div style="min-height: 1500px; overflow:hidden; text-overflow: ellipsis;
							white-space : nowrap;" contenteditable="true" class="form-control" id="div_image">
								<p>
								   <br>
								</p>
								${boardVO.boardContent }
							</div>
						</td>
						<td>
							<textarea name="boardContent" style="display: none;" id="hiddenText">
							</textarea>
						</td>

					</tr>
					<tr style="border-bottom: soild; border-bottom-color: #cccccc; border-bottom-width: 0.5px;">
						<td class="td_header" colspan="2" style="padding: 15px;">  
							<!-- <input type="button" class="btn btn-primary" id="submitBTN" onclick="submit(this.form);" value="수정"></input> -->
							<input type="submit" class="btn btn-primary" value="수정"></input>
 							<!-- <input type="button" class="btn btn-primary" id="submitBTN" onclick="rewrite();" value="수정"></input> -->
	 						<button type="reset" class="btn btn-primary">취소</button>
						</td>
					</tr>
				</table>				
			</form>	
</div>
 <div>
<%-- 	<form id="hiddenForm" style="display: none;" enctype="multipart/form-data">
		<input type="hidden" name="boardID" value="${boardVO.boardID }">
		<input type="hidden" name="boardNum" value="${boardVO.boardNum }">
		<input type="hidden" name="boardNum_" value="${boardVO.boardNum }">
		<input type="hidden" name="boardTitle" value="${boardVO.boardTitle }">
		<input type="hidden" name="boardDate" value="${boardVO.boardDate }">
		<input type="hidden" name="boardCount" value="${boardVO.boardCount }">
		<input type="hidden" name="boardContent" value="${boardVO.boardContent }">
		<input type="hidden" name="fileName" value="">
	</form> --%>
</div> 
</body>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
var cnt = 1;
var div_image = document.getElementById('div_image');
var submitBTN = document.getElementById('submitBTN');
var hiddenText = document.getElementById('hiddenText');

/* var form = document.getElementById('hiddenForm');
var rewriteBTN = document.getElementById('rewriteBTN');

function rewrite() {
	alert('와우');
	form.action = "${contextPath}/freeBoard/rewriteBoardContent.do";
	form.method = "POST";
	form.submit();
} */

/* var e = jQuery.Event( "keypress", { keyCode: 13 } ); 

	$(document).ready(function () {
		$("#div_image").trigger("click");
		$("#div_image").trigger(e);
	}) */

	
/* 	$(function(){
		$("#div_image").trigger("click");
		}); */

	function fn_addFile() {
 		$("#div_image").append("<p>" 
 		+ "<input style='display: none;' type='file' name='file"+cnt+"' id='file"+cnt+"' onchange='readURL(this , "+ cnt +")' accept='.jpeg, .jpg, .png'/>"
 		+ "<img id='preview"+cnt+"' style='max-width:100%;'/>" +"</p>"
 		); 
/* 		$("#div_image").append("<br>" + "<input type='file' name='file"+cnt+"' id='file"+cnt+"' />"); */
		document.getElementById('file'+cnt).click();
/* 		const file = document.getElementById('file'+cnt);
		const filePath = file.value; */
	
		/* $("#div_image").append("<br>" + "<img src='resources/img/찹쌀떡.jpg'; alt='sibal'/>");  */
 		/* fn_fileShow(filePath); */

		cnt++;
	}
	
	div_image.onkeyup = function() {
		  console.log(div_image.innerHTML);
 		  document.getElementById('hiddenText').innerHTML = div_image.innerHTML.replace(/(\n|\r\n)/g, '<br>'); 
/* 		  document.getElementById('hiddenText').innerHTML = div_image.innerHTML.replace(/<div>/g, '<p>');
		  document.getElementById('hiddenText').innerHTML = div_image.innerHTML.replace(/</div>/g, '</p>'); */
/* 		  alert(document.getElementById('hiddenText').innerHTML); */
		}	
	
	
/* 	div_image.onchange = function() {
		  console.log(div_image.innerHTML)
 		  document.getElementById('hiddenText').innerHTML = div_image.innerHTML;
		}	 */
	
		function readURL(input,a) {

			 var fileVal = $("#file"+a).val();
			 	if(fileVal != ""){
			 		var ext = fileVal.split('.').pop().toLowerCase();
			 		if($.inArray(ext, ['jpg','jpeg','png']) == -1){
			 	        alert('jpg,jpeg,png' + ' 파일만 업로드 할수 있습니다.');
			 	        return ;
			 		}else{
			 			  if (input.files && input.files[0]) {
			 				    var reader = new FileReader();
			 				    reader.onload = function(e) {
			 				      document.getElementById('preview'+a).src = e.target.result;
			 					  console.log(div_image.innerHTML);
			 			 		  document.getElementById('hiddenText').innerHTML = div_image.innerHTML.replace(/(\n|\r\n)/g, '<br>'); 
			 				    };
			 				    reader.readAsDataURL(input.files[0]);
			 				  } else {
			 				    document.getElementById('preview'+a).src = "";
			 				  }	 			
			 		}
			 	}
			 	
				}
	
/* 	function submit(form) {
		text = div_image.innerHTML;
		alert(text);
	} */
</script>
</html>