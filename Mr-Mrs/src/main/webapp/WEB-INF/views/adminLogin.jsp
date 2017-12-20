<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Lemon'
	rel='stylesheet'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>

	<h4>
		<font face="lemon" color="red">Welcome Admin !!! Here is Your
			Page....</font>
	</h4>
	<jsp:include page="Menu.jsp"></jsp:include>



	<c:choose>
		<c:when test="${not empty isadminClickedviewCategory}">
			<%@include file="viewCategory.jsp"%>
		</c:when>

		<c:when test="${not empty isadminClickednewCategory}">
			<%@include file="/WEB-INF/views/newCategory.jsp"%>
		</c:when>


		<c:when test="${not empty isadminClickedviewProduct}">
			<%@include file="/WEB-INF/views/viewProduct.jsp"%>
		</c:when>


		<c:when test="${not empty isadminClickednewProduct}">
			<%@include file="/WEB-INF/views/newProduct.jsp"%>
		</c:when>


		<c:when test="${not empty isadminClickedviewSupplier}">
			<%@include file="/WEB-INF/views/viewSupplier.jsp"%>
		</c:when>

		<c:when test="${not empty isadminClickednewSupplier}">
			<%@include file="/WEB-INF/views/newSupplier.jsp"%>
		</c:when>

		<c:when test="${not empty isAddProductClicked}">
			<%@include file="/WEB-INF/views/newProduct.jsp"%>
		</c:when>

		<c:when test="${not empty isadminClickedaddSupplier}">
			<%@include file="/WEB-INF/views/newSupplier.jsp"%>
		</c:when>

		<c:when test="${not empty isadminClickedaddCategory}">
			<%@include file="newCategory.jsp"%>
		</c:when>

		<c:when test="${not empty isadminClickededitCategory}">
			<%@include file="editCategory.jsp"%>
		</c:when>

		<c:when test="${not empty isadminClickededitProduct}">
			<%@include file="editProduct.jsp"%>
		</c:when>

		<c:when test="${not empty isadminClickededitSupplier}">
			<%@include file="editSupplier.jsp"%>
		</c:when>
		

	</c:choose>






</body>
</html>
