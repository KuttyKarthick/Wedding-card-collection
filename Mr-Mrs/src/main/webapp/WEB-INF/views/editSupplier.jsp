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
		var Name = document.getElementById('name');
		var email = document.getElementById('email_id');
		var Address = document.getElementById('address');
		var phone = document.getElementById('phone_no');
		
if (notEmpty(Name, "supplier_name Should not be empty")) {
			
			if (isAlphabet(Name,
						"Please enter only letters for supplier_name")) {
				if (notEmpty(email, "email_id Should not be empty")) {
					
					if (emailValidator(email,
								"Please enter only in the format of abc@xyz.com for email_id")) {
						if (notEmpty(Address, "Address Should not be empty")) {
							
							if (isAlphabet(Address,
										"Please enter only letters for Address")) {
								if (notEmpty(phone, "phone_no Should not be empty")) {
									
									if (isNumeric(phone,
												"Please enter only numbers for phone_no")) {
										return true;
									}

							}
								
							}}}         
							
								
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
	
	function emailValidator(elem, helperMsg) {
		var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
		if (elem.value.match(emailExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
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
<h2 style="font-family: magneto;" align="center" >Edit Product</h2>

	<form action="afterEditSupplier" method="post" onsubmit="return formEdit()">
		<table align="center" class="col-lg-8 col-lg-offset-1 col-sm-7 col-sm-offset-1">
			<tr>
				<td>Supplier ID:</td>
				<td><input class="form-control" type="text" name="id" value="${supplier.id}" readonly="true"></td>
			</tr>
			<tr>
				<td>Supplier Name:</td>
				<td><input class="form-control" type="text" name="name" value="${supplier.name}" id="name"></td>
			</tr>
			<tr>
				<td>Supplier Email-ID:</td>
				<td><input class="form-control" type="text" name="email_id" value="${supplier.email_id}" id="email_id"></td>
			</tr>
			<tr>
				<td>Product Price:</td>
				<td><input class="form-control" type="text" name="address" value="${supplier.address}" id="address"></td>
			</tr>
			<tr>
				<td>Product Stock:</td>
				<td><input class="form-control" type="text" name="phone_no" value="${supplier.phone_no}" id="phone_no"></td>
			</tr>
			

			<tr>
				<td colspan="2" align="center"><input class="btn btn-success" type="submit" name="submit" value="Edit">
				                                
			   </td>
			</tr>
			
		</table>

	</form>

</body>
</html>