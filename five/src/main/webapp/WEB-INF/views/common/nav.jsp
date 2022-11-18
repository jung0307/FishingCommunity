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
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid" style="width: 80%;">
    <a class="navbar-brand" href="${contextPath }/" >Main</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto">
<!--         <li class="nav-item">
          <a class="nav-link active" href="#">Home
            <span class="visually-hidden">(current)</span>
          </a>
        </li> -->
<%--         <li class="nav-item">
          <a class="nav-link" href="${contextPath }/board/getBoardList">Board</a>
        </li> --%>
<!--         <li class="nav-item">
			 <a class="btn btn-primary" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button" aria-controls="offcanvasExample">
			  Link with href
			</a>
        </li> -->
  		 <li class="nav-item">
          <a class="nav-link" href="${contextPath }/board/getBoardList">Board</a>
        </li>
  		 <li class="nav-item">
          <a class="nav-link" href="${contextPath }/freeBoard/getBoardList">Freeboard</a>
        </li>
  		 <li class="nav-item">
          <a class="nav-link" href="${contextPath }/fishInfo/getFishInfoMain.do">FishInfo</a>
        </li>
<!--         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">JSP&Servlet</a>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Model1</a>
            <a class="dropdown-item" href="#">Model2</a>
            <a class="dropdown-item" href="#">Something else here</a> 
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Separated link</a>
          </div>
        </li> -->
		<c:if test="${memberVO.role == 'admin' }">
			 <li class="nav-item">
	          <a class="nav-link" href="${contextPath }/member/memberPage.do">MemberPage</a>
	        </li>
		</c:if>
      </ul>
      <form class="d-flex" action="${contextPath }/board/getBoardList" method="get">
		<select class="form-control me-sm-2" style="width: 100px;" name="searchSection" id="searchSection">
			<option value='' disabled>section</option>
			<option value='boardID'>ID</option>
			<option value="boardTitle">Title</option>
<!-- 			<option value="boardContent">Content</option> -->
		</select>
        <input class="form-control me-sm-2" type="text" placeholder="Search" name="searchText">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </div>
  
  
  


</nav>
<%-- <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="offcanvasExampleLabel">Offcanvas</h5>
    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body">
    <div>
      Some text as placeholder. In real life you can have the elements you have chosen. Like, text, images, lists, etc.
    </div>
    <div class="dropdown mt-3">
      <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown">
        Board
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <li><a class="dropdown-item" href="${contextPath }/board/getBoardList">Board</a></li>
        <li><a class="dropdown-item" href="${contextPath }/freeBoard/getBoardList">FreeBoard</a></li>
       <!--  <li><a class="dropdown-item" href="#">GameBoard</a></li> -->
      </ul>
    </div>
  </div>
</div> --%>
</body>
<!-- <script type="text/javascript">
	function searchText() {
		
	}
</script> -->
</html>