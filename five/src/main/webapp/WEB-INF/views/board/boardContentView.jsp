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
tr{
text-align: center;
}
table{
table-layout: fixed;
}
td{
text-align: center;
overflow:hidden; text-overflow: ellipsis;white-space : nowrap;
border: 1px;
}
.td_header{
border-bottom-color: gray;
}
/* .showComment_tr{
background-color: #D0F5A9;
} */
</style>
<body>
<div id="container">
	<c:choose>
		<c:when test="${not empty boardVO}">
			<table border="1" style="width:100%; border-collapse: collapse;" id="table_">
				<tr style="border-bottom: soild; border-bottom-color: #cccccc; border-bottom-width: 0.5px;">
					<td style="width:15%; max-width: 15%; padding: 10px;" class="td_header">${boardVO.boardID }</td>
					<td style="width:55%; max-width: 55%; padding: 10px;" class="td_header">${boardVO.boardTitle }</td>
					<td style="width:20%; max-width: 20%; padding: 10px;" class="td_header">${boardVO.boardDate }</td>
					<td style="width:10%; max-width: 10%; padding: 10px;" class="td_header">${boardVO.boardCount }</td>
				</tr>
				<tr>
					<td colspan="4" style="text-align: left; padding-left: 30px; padding-right: 30px; padding-top: 30px; line-height:0;">
						<div style="min-height: 1000px;">
							<div style="display: block; margin-bottom: 200px; position: relative;">
								${boardVO.boardContent }
							</div>
<%-- 							<c:choose>
								<c:when test="${empty imageFileList }">
									<h1>시발</h1>
								</c:when>
								<c:otherwise>
									<c:forEach var="imageFileList" items="${imageFileList }" varStatus="i">
											<div style="display: block;">
												<img alt="drawing of a cat"
												src="${contextPath }/download.do?boardNum=${boardVO.boardNum}&imageFileName=${imageFileList.imageFileName}"
												>
											</div>
										</c:forEach>			 				
								</c:otherwise>
							</c:choose> --%>
						</div>
					</td>		
				</tr>
				<tr>
					<td colspan="4">
						 <button type="button" class="btn btn btn-info" id="upBTN" onclick="UP();">UP ${allCountUp }</button>
						  <button type="button" class="btn btn-danger" id="downBTN" onclick="DOWN();">DOWN ${allCountDown }</button>
					</td>
				</tr>					
				<tr style="border-bottom: soild; border-bottom-color: #cccccc; border-bottom-width: 0.5px;">
<%-- 					<c:if test="${(logIn == 'on' && memberVO.id == boardVO.boardID) || (logIn == 'on' && memberVO.role == 'admin') }">
						<td style="float: right; padding: 15px;"> 
							<div class="btn-group" role="group" aria-label="Basic example">
								 <button type="button" class="btn btn-secondary" id="rewriteBTN" onclick="rewrite();">rewrite</button>
								 <button type="button" class="btn btn-secondary" id="removeBTN" onclick="remove();">delete</button>
							</div>
						</td>
					</c:if> --%>
					<td colspan="4" style="padding: 15px;">
						<c:if test="${(logIn == 'on' && memberVO.id == boardVO.boardID) || (logIn == 'on' && memberVO.role == 'admin') }">
								<div style="float: left;" class="btn-group" role="group" aria-label="Basic example">
									 <button type="button" class="btn btn-secondary" id="rewriteBTN" onclick="rewrite();">rewrite</button>
									 <button type="button" class="btn btn-secondary" id="removeBTN" onclick="remove();">delete</button>
								</div>
						</c:if>
						<button type="button" style="float: right;" class="btn btn-secondary" id="homeBTN" onclick="home();" >Home</button>
					</td>				
				</tr>					
				<c:if test="${logIn =='on' && not empty memberVO.id }">
					<tr>
						<td colspan="4" style="text-align: left; padding-left: 30px; padding-right: 30px; padding-top: 30px; line-height:0;">
							<div style="min-height: 200px;">
								<div class="form-group">
									<label for="exampleTextarea" class="form-label mt-4" style="margin-bottom: 15px;">${memberVO.id }
									<button type="button" class="btn btn-primary" style="margin-left: 15px;" onclick="commentSubmit()">submit</button>
									</label>
									<textarea class="form-control" id="exampleTextarea" rows="3" name="commentContent"></textarea>
								 </div>
							</div>							
						</td>
					</tr>					
				</c:if>
<!-- 			<tr>
						<td colspan="4" style="padding-left: 30px; padding-right: 30px; padding-top: 30px;">
							<div class="card border-primary  mb-3" style="width: auto;">
							  <div class="card-header">
							  	<div style="float: left;">
							  		이름
							  	</div>
							  	<div style="float: right;">
									 <button type="button" class="btn btn-secondary" id="" onclick="">delete</button>
							  	</div>
							  </div>
							  <div class="card-body">
							    <h4 class="card-title">Secondary card title</h4>
							    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
							</div>
						</td>							
				 </tr>	 -->
			</table>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert('게시판 오류!');
				location.href='${contextPath}/board/getBoardList.do';
			</script>
		</c:otherwise>
	</c:choose>
</div>
 <div>
	<form id="hiddenForm" style="display: none;">
		<input type="hidden" name="boardID" value="${boardVO.boardID }">
		<input type="hidden" name="boardNum" value="${boardVO.boardNum }">
		<input type="hidden" name="boardTitle" value="${boardVO.boardTitle }">
		<input type="hidden" name="boardDate" value="${boardVO.boardDate }">
		<input type="hidden" name="boardCount" value="${boardVO.boardCount }">
		<input type="hidden" name="boardContent" value="${boardVO.boardContent }">
		<input type="hidden" name="fileName" value="">
	</form>
</div> 
</body>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

var form = document.getElementById('hiddenForm');
var rewriteBTN = document.getElementById('rewriteBTN');
var commentContent = document.getElementById('exampleTextarea');

var removeBTN = document.getElementById('removeBTN');
var upBTN = document.getElementById('upBTN');
var downBTN = document.getElementById('downBTN');

function UP() {
	
	if("${memberVO.id}" != ""){

	 	var goodAndBadVO = {
				boardNum :  "${boardVO.boardNum}",
				id : "${memberVO.id}",
				up : 1,
				down : 0
		} 
		
	  	$.ajax({

			type:"post",
			async:true,
			contentType:"application/json",
			url:"${contextPath}/board/goodAndBad.do",
			data:JSON.stringify(goodAndBadVO),
			success:function(data,textStatus){
				/* alert('UP 성공'); */
				var jsonInfo = JSON.parse(data);
				upBTN.innerHTML = "UP "+jsonInfo.allCountUp;
				downBTN.innerHTML = "DOWN "+jsonInfo.allCountDown;
			},
			error:function(request, status, error){
				alert("status : " + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
			
		}); 
	}else{
		alert('로그인이 필요합니다!');
	}
	
}

function DOWN() {
	
	if("${memberVO.id}" != ""){

	 	var goodAndBadVO = {
				boardNum :  "${boardVO.boardNum}",
				id : "${memberVO.id}",
				up : 0,
				down : 1
		} 
		
	  	$.ajax({

			type:"post",
			async:true,
			contentType:"application/json",
			url:"${contextPath}/board/goodAndBad.do",
			data:JSON.stringify(goodAndBadVO),
			success:function(data,textStatus){
				/* alert('DOWN 성공'); */
				var jsonInfo = JSON.parse(data);
				upBTN.innerHTML = "UP "+jsonInfo.allCountUp;
				downBTN.innerHTML = "DOWN "+jsonInfo.allCountDown;
			},
			error:function(request, status, error){
				alert("status : " + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
			
		}); 
	}else{
		alert('로그인이 필요합니다!');
	}
	
}

function rewrite() {
	/* alert('와우'); */
	form.action = "${contextPath}/board/rewriteBoardContentForm.do";
	form.method = "post";
	form.submit();
}

function remove() {
	location.href="${contextPath}/board/removeBoardContent.do?boardID=${boardVO.boardID}&boardNum=${boardVO.boardNum}&role=${memberVO.role}";
}

function home() {
	location.href='${contextPath}/board/getBoardList';
}

// 댓글 입력하면 insert하고 댓글 보여주기
function commentSubmit() {
	 
	/* alert(commentContent.value); */
	
	
	var commentVO = {
			commentID : "${memberVO.id}",
			commentContent : commentContent.value,
			commentDate : "",
			commentGroup : "",
			commentHir : "",
			commentNum : "",
			boardNum : "${boardVO.boardNum}"
	}
	
	$.ajax({
		
		type:"post",
		async : true,
		contentType:"application/json",
		url : "${contextPath}/board/addComment.do",
		data : JSON.stringify(commentVO),
		success: function (data,textStatus) {
		
			
			/*  console.log(data.commentList[0].commentID);  */
			
			
			if($(".showComment_tr").length){
				/* alert('showComment_tr 확인'); */
				$(".showComment_tr").remove();
			}
			if($(".showComment_tr2").length){
				/* alert('showComment_tr2 확인'); */
				$(".showComment_tr2").remove();
			}
			if($(".showComment_tr2_").length){
				/* alert('showComment_tr2_ 확인'); */
				$(".showComment_tr2_").remove();
			}
			
			commentFunction(data);
		},
		error: function (request, status, error) {
			alert("status : " + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		},
		complete: function () {
			
			commentContent.value = '';
			$('.showComment_tr2').attr('style' , 'display:none;');
			/* alert('댓글 완료'); */
		}
		
	});
}

// 대댓글 insert 하고 댓글 리스트 보여주기

function comment2Submit(commentNum,cnt){
	
	/* alert(commentNum); */
	
	var commentContent2 = document.getElementById('exampleTextarea'+cnt);
	
 /* 	alert(commentContent2.value); */
	
	var commentVO = {
		commentID : "${memberVO.id}",
		commentContent : commentContent2.value,
		commentDate : "",
		commentGroup : commentNum,
		commentHir : 1,
		commentNum : "",
		boardNum : "${boardVO.boardNum}"
	}
	
	
	$.ajax({
		type : "post",
		async : true,
		contentType : "application/json",
		url : "${contextPath}/board/addComment2.do",
		data : JSON.stringify(commentVO),
		success : function (data,textStatus) {
			
			/* alert('댓글2 성공 확인'); */
			
			if($(".showComment_tr").length){
				/* alert('showComment_tr 확인'); */
				$(".showComment_tr").remove();
			}
			if($(".showComment_tr2").length){
				/* alert('showComment_tr2 확인'); */
				$(".showComment_tr2").remove();
			}
			if($(".showComment_tr2_").length){
				/* alert('showComment_tr2_ 확인'); */
				$(".showComment_tr2_").remove();
			}
				
			/* (i > 0 ? '<img src="/img.jpg"/>': '') */
			commentFunction(data);
  				
		},
		error: function (request, status, error) {
			/* alert("status : " + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error); */
			alert('댓글 달 수 없어요');
		},
		complete : function () {
			commentContent2.value = '';
			$('.showComment_tr2').attr('style' , 'display:none;');
		}
	})
}




// 페이지가 로딩되면 댓글 보여주기
$(function showComment() {
	
	$.ajax({
		type:"GET",
		async : true,
		url : "${contextPath}/board/getCommentList.do?boardNum=${boardVO.boardNum}",
		success: function (data,textStatus) {
			
			commentFunction(data);
  			
  			/*   $('.showComment_tr2').attr('style', "display:none;");  */
			
		},
		error: function (request, status, error) {
			alert("status : " + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		},
		complete: function () {
			/* alert('로딩 완료'); */
			$('.showComment_tr2').attr('style', "display:none;");
		}
		
	});	
	
})

// 댓글 클릭하면 대댓글 보여주고 감추기
function switchComment(cnt) {
	if($('#showComment_tr2_'+cnt).attr('style') == "display:none;"){
		
		/* alert(cnt+'none일 때'); */
		$('#showComment_tr2_'+cnt).attr('style', "display:''"); 
		
	}else{
		/* alert(cnt+'none이 아닐 때'); */
		$('#showComment_tr2_'+cnt).attr('style', "display:none;"); 
		}

}
// 댓글 삭제한 후 댓글 리스트 보여주기
function removeComment(id,commentNum,role) {
	
/* 	alert(commentNum); */

 	// 로그인한 아이디하고 댓글 작성 id가 같으면 또는 admin이면
	if(id=="${memberVO.id}" || role=='admin'){
		alert("삭제 할 수 있어요!");
		
		var commentVO = {
			commentID : "${memberVO.id}",
			commentContent : "",
			commentDate : "",
			commentGroup : commentNum,
			commentHir : 1,
			commentNum : commentNum,
			boardNum : "${boardVO.boardNum}"
		}
		
		
		$.ajax({
			type : "post",
			async : true,
			contentType : "application/json",
			url : "${contextPath}/board/removeComment.do",
			data : JSON.stringify(commentVO),
			success : function (data,textStatus) {
				
				 /* alert('삭제 성공 확인'); */ 
		/* 		let cnt = 0; */
				
				
		/* 		var jsonInfo = JSON.parse(data); */
				
				if($(".showComment_tr").length){
				/* 	alert('showComment_tr 확인'); */
					$(".showComment_tr").remove();
				}
				if($(".showComment_tr2").length){
				/* 	alert('showComment_tr2 확인'); */
					$(".showComment_tr2").remove();
				}
				if($(".showComment_tr2_").length){
				/* 	alert('showComment_tr2_ 확인'); */
					$(".showComment_tr2_").remove();
				}
					
				commentFunction(data);
	  				
			},
			error: function (request, status, error) {
				alert("status : " + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			},
			complete : function () {
				$('.showComment_tr2').attr('style' , 'display:none;');
				 /* alert('삭제 완료'); */
			}
		})		
		
	}
	// 아이디가 같지 않으면
	else{
		alert('삭제 할 수 없어요');
		return false;
	} 
	
}

function commentFunction(data) {
	
	var jsonInfo = JSON.parse(data);
	let cnt = 0;
	jsonInfo.commentList.forEach((key , value)=>{
			if(key.commentHir == 0){
					
					$("#table_").append(
							
	 						"<tr class='showComment_tr' id='showComment_tr_"+ cnt +"' ><td colspan='4' style='padding-left: 30px; padding-right: 30px; padding-top: 15px;'>"
							+"<div class='card border-primary  mb-3' style='width: auto;'>"
							+  "<div class='card-header'>"
							+  	"<div style='float: left; margin-right:15px;'>"
							+  		key.commentID
							+  	"</div>"
							+  	"<div style='float: left;'>"
							+  		key.commentDate
							+  	"</div>"
							+  	"<div style='float: right;'>"
							+		 "<button type='button' class='btn btn-secondary' id='' onclick=\"removeComment(\'"+key.commentID+"\',"+key.commentNum+",\'${memberVO.role}\');\">delete</button>"
							+  	"</div>"
							+  "</div>"
							+  "<div class='card-body' style='background-color: #FBFBEF; white-space:pre-line;' onclick='switchComment("+cnt+");'>"
							+    "<p class='card-text' style='text-align: left;'>"+key.commentContent+"</p>"
							+"</div>"
							+"</td></tr>"
							
/* 	  							+"<tr class='showComment_tr2' id='showComment_tr2_"+ cnt +"'><td colspan='4' style='padding-left: 30px; padding-right: 30px;'>"
							+"<div class='card border-secondary mb-3' style='width: auto;'>"
							+  "<div class='card-header'>"
							+  	"<div style='float: left; margin-right:15px;'>"
							+  		jsonInfo.commentList[key].commentID
							+  	"</div>"
							+  	"<div style='float: left;'>"
							+  		jsonInfo.commentList[key].commentDate
							+  	"</div>"
							+  	"<div style='float: right;'>"
							+		 "<button type='button' class='btn btn-primary' id='' onclick='comment2Submit("+jsonInfo.commentList[key].commentNum+","+cnt+")'>submit</button>"
							+  	"</div>"
							+  "</div>"
							+  "<div class='card-body' style='background-color:#FBEFEF;'>"
							+  "<textarea class='form-control' id='exampleTextarea"+cnt+"' rows='3' name='commentContent'></textarea>"
							+"</div>"
							+"</td></tr>"  */
							
						+"<tr class='showComment_tr2' id='showComment_tr2_"+ cnt +"'><td colspan='4' style='padding-left: 30px; padding-right: 30px;'>"
						+"<div class='card border-secondary mb-3' style='width: auto;'>"
						+  "<div class='card-header'>"
						+  	"<div style='float: left;'>"
						+  		"${memberVO.id}"
						+  	"</div>"
						+  	"<div style='float: right;'>"
						+		 "<button type='button' class='btn btn-primary' id='' onclick='comment2Submit("+key.commentNum+","+cnt+")'>submit</button>"
						+  	"</div>"
						+  "</div>"
						+  "<div class='card-body' style='background-color:#FBEFEF;'>"
/* 						+  "<label for='exampleTextarea' class='form-label mt-4' style='margin-bottom: 15px;'>"
						+  "</label>" */
						+  "<textarea class='form-control' id='exampleTextarea"+cnt+"' rows='3' name='commentContent'></textarea>"    
						+"</div>"
						+"</td></tr>"
							
					);
					cnt++
					    
				}else if(key.commentHir !=0){
					
					$("#table_").append(
							"<tr class='showComment_tr2_' id='showComment_tr2__"+ cnt +"'><td colspan='4' style='padding-left: 30px; padding-right: 30px;'>"
							+"<div class='card border-secondary mb-3' style='width: auto;'>"
							+  "<div class='card-header'>"
							+  	"<div style='float: left; margin-right:15px;'>"
							+  		key.commentID
							+  	"</div>"
							+  	"<div style='float: left;'>"
							+  		key.commentDate
							+  	"</div>"
							+  	"<div style='float: right;'>"
							+		 "<button type='button' class='btn btn-secondary' id='' onclick=\"removeComment(\'"+key.commentID+"\',"+key.commentNum+",\'${memberVO.role}\');\">delete</button>"
							+  	"</div>"
							+  "</div>"
							+  "<div class='card-body' style='background-color:#FBEFEF; white-space:pre-line;'>"
							+ 	"<p class='card-text' style='text-align: left;'>"+key.commentContent+"</p>" 
							+"</div>"
							+"</td></tr>" 
							
					);
					cnt++
					
					}
	});
		
}


/*   function RewriteBoardContent(boardNum,boardID) {
	 alert(a); 
	 location.href='${contextPath}/board/rewriteBoardContentForm.do?boardID='+boardID+'&boardNum='+boardNum; 
	
}  */

/* $(function(){
	$("#rewriteBTN").click(function(){

		var boardVO = {
				boardID:"${boardVO.boardID}",
				boardNum:${boardVO.boardNum},
				boardTitle:"${boardVO.boardTitle}",
				boardDate:"${boardVO.boardDate}",
				boardCount:${boardVO.boardCount},
				boardContent:"",
				fileName:""
		};
		
		$.ajax({
			type:"POST",
			async: false,
			url:"${contextPath}/board/rewriteBoardContentForm.do",
			contentType:"application/json",
			data : JSON.stringify(boardVO),
			success:function (data,textStatus){
				alert('성공');

			},
		     error:function(request, status, error) {
		         alert("status : " + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		        },
 			complete:function(data,textStatus){
 				alert('완료');
 			}
		});		
	});
}); */

</script>
</html>