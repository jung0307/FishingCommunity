<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath }" var="contextPath" ></c:set>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#container{
/* 	margin: 20px; */
	background-color: white;
}
table{
table-layout: fixed;
}
td{
text-align: center;
overflow:hidden; text-overflow: ellipsis;white-space : nowrap;
border: 1px solid #F0F0F0;
/* padding-top: 5px;
padding-bottom: 5px; */
}
tr{
text-align: center;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="container" style="position: relative; padding-left: 100px; padding-right: 100px;">
<c:choose>
	<c:when test="${not empty fishInfoList}">
		<div style="min-height: 1800px; ">
	
<!-- 			 <img style="width: 100px; height: 50px;" src="resources/img/fishTitleBlue.png"> -->
			<h1 style="margin-bottom: 30px; padding-top: 20px; text-align: center;"> <a style="text-decoration: none; color: #888;" href="${contextPath }/fishInfo/getFishInfoMain.do">
			 <img style="width: 220px; height: 60px;" src="resources/img/fishInfo.png"> 
			 
			  </a></h1>
			
			<table border="0" style="width:100%; " >
				<tr>
					<td style="width: 7.5%; max-width: 7.5%;  font-style: oblique; background-color: #F0F0F0;"> 번호 </td>
					<td style="width: 47.5%; max-width: 47.5%;  font-style: oblique; background-color: #F0F0F0;"> 사진 </td>
					<td style="width: 15%; max-width: 15%;  font-style: oblique; background-color: #F0F0F0;"> 이름 </td>
					<td style="width: 15%; max-width: 15%;  font-style: oblique; background-color: #F0F0F0;"> 위치 </td>
					<td style="width: 7.5%; max-width: 7.5%;  font-style: oblique; background-color: #F0F0F0;"> 시간 </td>
					<td style="width: 7.5%; max-width: 7.5%;  font-style: oblique; background-color: #F0F0F0;"> 기타 </td>
				</tr>
			
				<c:choose>
					<c:when test="${empty pagingNum || pagingNum == 1}">
						<c:forEach items="${fishInfoList }" varStatus="i" var="fishInfoList">
									<tr>
										<td style="width: 7.5%; max-width: 7.5%; word-break:break-all;"> 	
<a href='javascript:void(0);' onclick="removeFishInfo('${fishInfoList.fishNum }','${memberVO.role }')" style="text-decoration: none; color: #A4A4A4;"> ${fishInfoList.fishNum } </a>
										 </td>
										<td style="width: 47.5%; max-width: 47.5%;"> 	
													<a href="#" style="text-decoration: none;">
													${fishInfoList.fishImage }
													</a> 				
										</td>
										<td style="width: 15%; max-width: 15%; word-break:break-all;"> 	<a href='javascript:void(0);' onclick="updateFishInfo('${fishInfoList.fishNum }','${memberVO.role }')" style="text-decoration: none; color: #A4A4A4;"> ${fishInfoList.fishName } </a> </td>
										<td style="width: 15%; max-width: 15%; word-break:break-all;"> 	${fishInfoList.fishLocation } </td>
										<td style="width: 7.5%; max-width: 7.5%; word-break:break-all;"> 	${fishInfoList.fishTime } </td>
										<td style="width: 7.5%; max-width: 7.5%; word-break:break-all; color: #F7819F;"> 	${fishInfoList.fishWeather } </td>
									</tr>	
						</c:forEach>					
					</c:when>
					<c:otherwise>
						<c:forEach items="${fishInfoList }" varStatus="i" var="fishInfoList">
									<tr>
										<td style="width: 7.5%; max-width: 7.5%; word-break:break-all;"> 	
	<a href='javascript:void(0);' onclick="removeFishInfo('${fishInfoList.fishNum }','${memberVO.role }')" style="text-decoration: none; color: #A4A4A4;"> ${fishInfoList.fishNum } </a>
										</td>
										<td style="width: 47.5%; max-width: 47.5%;"> 	
													<a href="#" style="text-decoration: none;">
													${fishInfoList.fishImage }
													</a> 				
										</td>
										<td style="width: 15%; max-width: 15%; word-break:break-all;"> 	<a href='javascript:void(0);' onclick="updateFishInfo('${fishInfoList.fishNum }','${memberVO.role }')"  style="text-decoration: none; color: #A4A4A4;"> ${fishInfoList.fishName } </a> </td>
										<td style="width: 15%; max-width: 15%; word-break:break-all;"> 	${fishInfoList.fishLocation } </td>
										<td style="width: 7.5%; max-width: 7.5%; word-break:break-all;"> 	${fishInfoList.fishTime } </td>
										<td style="width: 7.5%; max-width: 7.5%; word-break:break-all; color: #F7819F;"> 	${fishInfoList.fishWeather } </td>
									</tr>				
						</c:forEach>				
					</c:otherwise>
				</c:choose>
				
				<c:if test="${logIn == 'on' && memberVO.role == 'admin'}">
					<tr>
						<td colspan="6" style="padding:15px; border-bottom: 0px;"> <button class="btn btn-secondary" style="float: right;" onclick="writeFishInfo('${memberVO.id}');" > 글쓰기 </button> </td>
					</tr>					
				</c:if>
				<c:if test="${not empty pagingMessage }">
					<tr>
						<td colspan="6" style="padding: 30px; border-top: 0px;" >
						${pagingMessage }
						</td>
					</tr>
				</c:if>

			</table>
		</div>
		<div style="display: block; height: 100px;">
		</div>		
		<div style="display: block;">
				<table style= max-width: 100%;" >
					<tr>
						<td style="border: 0px;">
							<img style="max-width: 50%; margin: 0 auto;" src="resources/img/fishInfoBottom.png">
						</td>
					</tr>
				</table>		
		</div>
		<div style="display: block; height: 100px;">
		</div>
	</c:when>
	<c:otherwise>
		<div style="min-height: 1800px;">
	
<!-- 			 <img style="width: 100px; height: 50px;" src="resources/img/fishTitleBlue.png"> -->
			<h1 style="margin-bottom: 30px; padding-top: 20px; text-align: center;"> <a style="text-decoration: none; color: #888;" href="${contextPath }/fishInfo/getFishInfoMain.do">
			 <img style="width: 220px; height: 60px;" src="resources/img/fishInfo.png"> 
			 
			  </a></h1>
			
			<table border="1" style="width:100%">
				<tr>
					<td style="width: 7.5%; max-width: 7.5%;  font-style: oblique; background-color: #F0F0F0;"> 번호 </td>
					<td style="width: 47.5%; max-width: 47.5%;  font-style: oblique; background-color: #F0F0F0;"> 사진 </td>
					<td style="width: 15%; max-width: 15%;  font-style: oblique; background-color: #F0F0F0;"> 이름 </td>
					<td style="width: 15%; max-width: 15%;  font-style: oblique; background-color: #F0F0F0;"> 위치 </td>
					<td style="width: 7.5%; max-width: 7.5%;  font-style: oblique; background-color: #F0F0F0;"> 시간 </td>
					<td style="width: 7.5%; max-width: 7.5%;  font-style: oblique; background-color: #F0F0F0;"> 기타 </td>
				</tr>
<%-- 					<tr>
						<td colspan="6" style="padding:15px;"> <button class="btn btn-secondary" style="float: right;" onclick="writeBoardContent('${memberVO.id}');" > 글쓰기 </button> </td>
					</tr>			 --%>
	
				<c:if test="${logIn == 'on' && memberVO.role == 'admin'}">
					<tr>
						<td colspan="6" style="padding:15px;border: 0px;"> <button class="btn btn-secondary" style="float: right;" onclick="writeFishInfo('${memberVO.id}');" > 글쓰기 </button> </td>
					</tr>					
				</c:if>

			</table>	
		</div>
		<div style="display: block; height: 100px;">
		</div>		
		<div style="display: block;">
				<table style= max-width: 100%;" >
					<tr>
						<td style="border: 0px;">
							<img style="max-width: 50%; margin: 0 auto;" src="resources/img/fishInfoBottom.png">
						</td>
					</tr>
				</table>		
		</div>
		<div style="display: block; height: 100px;">
		</div>
	</c:otherwise>
</c:choose>
</div>
</body>
<script type="text/javascript">
	function writeFishInfo(a) {
		location.href='${contextPath}/fishInfo/writeFishInfo.do?boardID='+a;
	}

	function updateFishInfo(fishNum,role) {
		
		if(role == 'admin'){
			if(confirm("수정하겠습니까?")){
				location.href='${contextPath}/fishInfo/updateFishInfoForm.do?fishNum='+fishNum;
			}
		}
	}
	
 	function removeFishInfo(fishNum,role) {
		
		if(role == 'admin'){
			if(confirm("정말 삭제 하시겠습니까?")){
				location.href='${contextPath}/fishInfo/removeFishInfo.do?fishNum='+fishNum;
			}
		}
	} 
</script>
</html>