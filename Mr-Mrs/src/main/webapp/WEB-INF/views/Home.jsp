<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/alter.css"/>
<link href='https://fonts.googleapis.com/css?family=Faster One' rel='stylesheet'>

<title>Firstnew</title>
	
<style>
.user
{
font-family:monospace;
text-align: center;
 padding: 10px;
}
.logo

{
float:left;
}


.option ul
{
    list-style-type: none;
    margin: 0;
    padding: 0px;
    overflow: hidden;
    background-color:black;
    position: fixed;
    top: 0;
    width: 100%;
}

.option li
{
    float: left;
}
.option a {
     font-family:quickstand;
     font-style: italic;
    display: block;
    color: white;
    text-align: center;
    padding: 8px 20px;
    text-decoration: none;
    font-size:30px;
}

.option a:hover:not(.active) {
    background-color: green;
}

.active {
    background-color: white;
} 
</style>
</head>

<body ><!-- style="background-color:white;margin:0" -->

<jsp:include page="Menu.jsp"></jsp:include>









<div class="user">
 
 
 

	

	</div>	
<br>
<c:choose>
	<c:when test="${isUserClickedLogin=='true'}">
	     <jsp:include page="Login.jsp"></jsp:include>
	</c:when>


	<c:when test="${isUserClickedRegister=='true' }">
		<jsp:include page="Registration.jsp"></jsp:include>
	</c:when>
	<c:when test="${not empty isUserClickedimage}">
			<%@include file="/WEB-INF/views/Productdetails.jsp"%>
		</c:when>
	<c:otherwise>
	<jsp:include page="slider.jsp"></jsp:include>
	<jsp:include page="Productlist.jsp"></jsp:include>
	</c:otherwise>
	</c:choose>
</body>
<div>


</div>	
</html>