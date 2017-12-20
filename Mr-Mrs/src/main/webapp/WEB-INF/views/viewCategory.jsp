<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<style>
.row {
	margin-right: -15px;
	margin-left: -15px
}


.form-control {
	display: block;
	width: 100%;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
}



</style>



</head>
<body>
 


<form action="searchCategory" >
<div class="row">
<h4 style="float: left; margin-left: 2em;">List of available Categories</h4>
<input class="form-control" type="text" name="search" style="width: 25em; float: left; margin-left: 2em;">
<input type="submit" name="submit" value="Search" id="submit" class="btn btn-primary" style="float: left;">
</div>
</form>




<table width="25%" class="table table-hover">
	<tr>
 <th align="left">S.No</th>
		<th align="left">category_Id</th>
		<th align="left">category_name</th>
		<th align="left">category_Description</th>
		<th align="left">Edit</th>
		<th align="left">Delete</th>
	</tr>
	
	 <c:forEach items="${categoryList}" var="category" varStatus="status"> 
	        <tr>
	        <td align="left">${status.count}</td>
			<td align="left">${category.category_Id}</td>
			<td align="left">${category.category_name}</td>
			<td align="left">${category.category_Description}</td>
			<td align="left"><a href="editCategory?category_Id=${category.category_Id}">Edit</a></td>
			<td align="left"><a href="deletecategory?category_Id=${category.category_Id}" onclick="return confirm('Are You Sure? Do you Want Delete Category : ${category.category_Id} ?')">Delete</a></td>
		</tr>
	 </c:forEach>
</table>

</body>
</html>