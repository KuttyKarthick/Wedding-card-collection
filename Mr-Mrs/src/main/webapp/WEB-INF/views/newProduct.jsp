<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Newproduct</title>
<script type="text/javascript">
function formProduct()
{
	var Pname = document.getElementById('pname');
	var Pdescrip = document.getElementById('description');
	var Price = document.getElementById('price');
	var Stock = document.getElementById('stock');
	
	if (notEmpty(Pname, "product_name Should not be empty")) {
		
		if (isAlphabet(Pname,
					"Please enter only letters for product_name")) {
			if (notEmpty(Pdescrip, "product_description Should not be empty")) {
				
				if (isAlphabet(Pdescrip,
							"Please enter only letters for product_description")) {
					if (notEmpty(Price, "Price Should not be empty")) {
						
						if (isNumeric(Price,
									"Please enter price in numbers only")) {
							if (notEmpty(Stock, "Stock Should not be empty")) {
								
								if (isNumeric(Stock,
											"Please enter stock in numbers only")) {
									return true;
								
								}}}}}
						}
				}
		}
					return false;
				}
				
				function isAlphabet(elem, helperMsg) {
					var alphaExp = /^[a-z A-Z]+$/;
					if (elem.value.match(alphaExp)) {
						return true;
					} else {
						alert(helperMsg);
						elem.focus();
						return false;
					}
				}
				
				function notEmpty(elem, helperMsg) {
					if (elem.value.length == 0) {
						alert(helperMsg);
						elem.focus(); // set the focus to this input
						return false;
					}
					return true;
				}
				function isNumeric(elem, helperMsg) {
					var numericExpression = /^[0-9]+$/;
					if (elem.value.match(numericExpression)) {
						return true;
					} else {
						alert(helperMsg);
						elem.focus();
						return false;
					}
				}
			</script>
	
</head>
<body>
<h2 style="font-family:cursive ; margin-left: 5em;" align="left" >NewProduct</h2>
<form action="newProduct" method="post" enctype="multipart/form-data" onsubmit="return formProduct()">

<table align="center" class="col-lg-8 col-lg-offset-1 col-sm-7 col-sm-offset-1">

<tr>
			<td>Product Name:</td>
			<td><input class="form-control" type="text" name="pname" id="pname" required="true"></td>
		</tr>
		<tr>
			<td>Product Description:</td>
			<td><input class="form-control" type="text" name="description" id="description" required="true"></td>
		</tr>
		<tr>
			<td>Product Category:</td>
			<td >
			<select style="width: 50%;" class="form-control" name="category">
			
			<option>Select Category</option>
			<c:forEach items="${categoryList}" var="category">					
			<option value="${category.category_name}">${category.category_name}</option>			
			</c:forEach>
			
			</select>			
			</td>
		</tr>
		<tr>
			<td>Product Supplier:</td>
			<td>
			<select style="width: 50%;" class="form-control" name="supplier" >
			
			<option>Select Supplier</option>
			<c:forEach items="${supplierList}" var="supplier">					
			<option value="${supplier.name}">${supplier.name}</option>			
			</c:forEach>
			
			</select>			
			
					
			
			</td>
		</tr>
		
		<tr>
			<td>Price:</td>
			<td><input class="form-control" type="text" name="price"  id="price" required="true"></td>
		</tr>
		
		<tr>
			<td>Stock:</td>
			<td><input class="form-control" type="text" name="stock" id="stock" required="true"></td>
		</tr>
		 <tr>
		 <td>Image:</td>
          <td> <input class="form-control" type="file" name='image' placeholder=""/></td>    
            
         </tr>	
		<tr>
			<td colspan="2" align="center">
			<input class="btn btn-success" type="submit" value="Add">
			<input class="btn btn-danger" type="reset" value="Reset"></td>
		</tr>
		
		
         
		</table>
		</form>
	
		
		
		
</body>
</html>