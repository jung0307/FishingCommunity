<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath }" var="contextPath" ></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title> <tiles:insertAttribute name="title"/> </title>
</head>
<link rel="stylesheet" type="text/css" href="${contextPath }/resources/css/bootstrap.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

<style>
#container{
margin: 0 auto;
padding: 0;
/* width: 80%; */
}
#container2{
margin: 0 auto;
padding: 0;
width: 80%;
/*  padding-left: 200px;
 padding-right: 200px; */
  
}
#container3{
margin: 0 auto;
 /* width: 80%; */
padding: 0;
 background-color: #CCCCCC;
}
#header{
padding: 10px;
display: block;
height: 200px;
background-color: #F3F781;
}
#nav{
display: block;
}
#side{
display: block;
}
#body{
/* width: 1200px; */
display: block;
background-color: #CCCCCC;
}
#footer{
display: block;
height: 200px;
background-color: #F3F781;
}
</style>

<body>

<div id="container" >
	
	<div id="header" >
		<tiles:insertAttribute name="header" ></tiles:insertAttribute>
	</div>
	<div id="nav" >
		<tiles:insertAttribute name="nav" ></tiles:insertAttribute>
	</div>
<%-- 	<div id="side" >
		<tiles:insertAttribute name="side" ></tiles:insertAttribute>
	</div> --%>
	
	
	<div id="container3">
	
		<div id="container2">	
			<div id="body" >
				<tiles:insertAttribute name="body" ></tiles:insertAttribute>
			</div>
		</div>
		
	</div>
	
		<div id="footer" >
			<tiles:insertAttribute name="footer" ></tiles:insertAttribute>
		</div>
</div>

</body>
</html>