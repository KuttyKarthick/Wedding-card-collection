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
<title>Newcategory</title>
<script type="text/javascript">
function formCategory()
{
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
<h2 style="font-family: cursive; margin-left: 5em;" align="left" >NewCategory</h2>
<form action="newCategory" method="post" onsubmit="return formCategory()">

<table align="center" class="col-lg-8 col-lg-offset-1 col-sm-7 col-sm-offset-1">
<tr>
			<td>Category Name:</td>
			<td><input class="form-control" type="text" name="category_name" id="category_name" required="true"></td>
		</tr>
		<tr>
			<td>Category Description:</td>
			<td><input class="form-control" type="text" name="category_Description" id="category_Description" required="true"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input class="btn btn-success" type="submit" value="Add">
			<input class="btn btn-danger" type="reset" value="Reset"></td>
		</tr>
		</table>
		</form>