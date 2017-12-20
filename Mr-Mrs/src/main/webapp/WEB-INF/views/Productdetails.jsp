
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>

<h2 align="center" style="margin-top: 0em; margin-bottom: -2em;">${product.pname}</h2>


<div style="margin: 50px 10px 0px 300px">

<form>
<table>
<tr>
<td>
<img src="<c:url value="resources/images/Product/${product.pid}.jpg"/>" alt="${product.pid}" width="150" height="200">
</td></tr>
<tr><td>${outOfStock}</td></tr>
<tr><td>Product Name : ${product.pname}</td></tr>
<tr><td>Product Description : ${product.description}</td></tr>
<tr><td>Product Price : ${product.price}</td></tr>
<tr><td>Product Available : ${product.stock}</td></tr>
<h2 style="color: red;">${message}</h2>
<c:if test="${pageContext.request.userPrincipal.name != null }">

<tr><td><a href="addCart?pid=${product.pid}"><button style="color:green;" type="button" >Add To Cart</button></a></td></tr>
</c:if>

<c:if test="${pageContext.request.userPrincipal.name == null }">
<tr><td><a href="LoginPage"><input style="color:green;" type="button" name="button" value="Add To Cart"/></a></td></tr>
</c:if>

<tr><td><button class="btn-btn-primary" onclick="goBack()">Go Back</button></td></tr>
</table>
</form>
</div>



</body>
</html>