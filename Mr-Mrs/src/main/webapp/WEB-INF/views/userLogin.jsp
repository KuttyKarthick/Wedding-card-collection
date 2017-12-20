<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Condiment'
	rel='stylesheet'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.msg {
	padding: 180px 50px 50px 50px;
	text-align: center;
}
</style>

</head>
<body>

	<c:if test="${ empty isUserClickedimage}">
		<h4 style="font-family: condiment; font-size: 30px; color: green;">Welcome
			User....</h4>
			</c:if>
		<jsp:include page="Menu.jsp"></jsp:include>
	


	<c:choose>
		

		<c:when test="${not empty isUserClickedAddtocart}">
			<%@ include file="/WEB-INF/views/addCart.jsp"%>
		</c:when>
      
        
		<c:when test="${not empty isUserClickedShippingAddressClicked}">
			<%@ include file="/WEB-INF/views/Shippingaddress.jsp"%>

		</c:when>
		<c:when test="${not empty isUserClickedNewShiiping}">
			<%@ include file="/WEB-INF/views/newShippingaddress.jsp"%>

		</c:when>
		<c:when test="${isuserclickedthankyou }">
		<%@include file="/WEB-INF/views/End.jsp" %>
		</c:when>

		<c:when test="${not empty isUserClickededitShippingAddress}">
			<jsp:include page="editShipping.jsp"></jsp:include>
		</c:when>

	<%-- 	<c:when test="${not empty isUserClickedSend}">
			<jsp:include page="Shippingaddress.jsp"></jsp:include>
		</c:when> --%>

		<c:when test="${not empty isUserClickedaddtocart}">
			<h1 style="color: red" class="msg">${message}</h1>
		</c:when>


		<c:otherwise>

			<jsp:include page="Productlist.jsp"></jsp:include>
		</c:otherwise>

	</c:choose>
	<br>
	<br>
	<br>
	<%-- <jsp:include page="Productlist.jsp" > --%>
	<%-- </jsp:include> --%>

</body>
</html>