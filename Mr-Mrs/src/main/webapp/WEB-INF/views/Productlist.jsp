<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProductList</title>
</head>
<body>

<br><br><br>

<c:forEach items="${productList}" var="product">


<c:if test="${userid != null }">
<div class="img col-lg-2 col-lg-offset-1 col-sm-2 col-sm-offset-1" style="margin-top: 20px">
  <a href="addCart?pid=${product.pid }">
    <img src="<c:url value="/resources/image/products/${product.pid}.jpg"/>" alt="${product.pid}" width="150" height="200">
  </a>
  <div class="desc">
  <ul style="list-style-type:none">
  <li class="span2"><h5 style="color: red" >${product.pname}</h5>
  <h6>Price:${product.price}</h6>
  <h6>Description:${product.description}</h6>
  <h6>Product Available : ${product.stock}</h6></li></ul>
  </div>
</div>

</c:if>
<c:if test="${userid == null }">
<div class="img col-lg-2 col-lg-offset-1 col-sm-2 col-sm-offset-1" style="margin-top: 20px">
  <a href="Productdetails?pid=${product.pid}">
   <img src="<c:url value="resources/images/Product/${product.pid}.jpg"/>" alt="${product.pid}" width="250" height="200">
  </a>
  <div class="desc">
  <ul style="list-style-type:none">
  <li class="span2"><h5 style="color: red" >${product.pname}</h5>
  <h6>Price:${product.price}</h6>
  <h6>Description:${product.description}</h6>
  <h6>Product Available : ${product.stock}</h6></li></ul>
  </div>
  </div>
</c:if>
</c:forEach> 


</body>
</html>