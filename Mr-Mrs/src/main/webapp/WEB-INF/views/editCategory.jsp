<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function formEdit() {
		// Make quick references to our fields
		var Cname = document.getElementById('category_name');
		var Cdescrip = document.getElementById('category_Description');
		
	if (notEmpty(Cname, "category_name Should not be empty")) {
			
			if (isAlphabet(Cname,
						"Please enter only letters for category_name")) {
				
				if (notEmpty(Cdescrip, "category_Description Should not be empty")) {
					
					if (isAlphabet(Cdescrip,
								"Please enter only letters for category_Description")) {
						return true;
					}
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
	
	
	</script>
		
</head>
<body>
<h2 style="font-family: magneto;" align="center" >Edit Category</h2>

	<form action="afterEdit" method="post" onsubmit="return formEdit()">
		<table align="center" class="col-lg-8 col-lg-offset-1 col-sm-7 col-sm-offset-1">
			<tr>
				<td>Category ID:</td>
				<td><input class="form-control" type="text" name="category_Id" value="${category.category_Id}" readonly="true"></td>
			</tr>
			<tr>
				<td>Category Name:</td>
				<td><input class="form-control" type="text" name="category_name" value="${category.category_name}" id="category_name"></td>
			</tr>
			<tr>
				<td>Category Description:</td>
				<td><input class="form-control" type="text" name="category_Description" value="${category.category_Description}" id="category_Description"></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input class="btn btn-success" type="submit" name="submit" value="Edit"></a>
			   </td>
			</tr>
			
		</table>

	</form>

</body>
</html>