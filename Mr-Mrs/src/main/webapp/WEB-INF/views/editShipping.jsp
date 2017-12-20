<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function formShip() {
		// Make quick references to our fields
		var User_name = document.getElementById('user_name');
		var Contact_no = document.getElementById('contact_no');
		var Address = document.getElementById('address');
		var Zip_code = document.getElementById('zip_code');
		
		
if (notEmpty(User_name, "User_name Should not be empty")) {
			
			if (isAlphabet(User_name,
						"Please enter only letters for User_name")) {
				if (notEmpty(Contact_no, "Contact_no Should not be empty")) {
					
					if (isNumeric(Contact_no,
								"Please enter only numbers for Contact_no")) {
						if (notEmpty(Address, "Address Should not be empty")) {
							
							if (isAlphabet(Address,
										"Please enter only letters for Address")) {
								if (notEmpty(Zip_code, "Zip_code Should not be empty")) {
									
									if (isNumeric(Zip_code,
												"Please enter only numbers for Zip_code")) {
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


<div class="container" style="color: #1F618D">
		<div class="jumbotron" style="background-color:">
			
			<h3 align="center" style="color: #27A4F7">Edit  your ShippingAddress</h3>
			<form action="aftereditshipping"class="form-horizontal"  method="post" role="form" name="Shippingaddress"  onsubmit="return formShip()">                                                                         
				<div style="color: #27A4F7" class="form-group">
					<label for="text">Id of the ShippingAddress:</label> 
					<input class="form-control"  type="text"  id="shippingId" name="shippingId" value="${Shippingaddress.shippingId}" readonly>
				</div>
                    <div style="color: #27A4F7" class="form-group">
					<label for="text">Username</label> 
					<input class="form-control" placeholder="Username" type="text"  id="user_name" name="user_name" value="${Shippingaddress.user_name}" >
				</div>
			
			
				<div style="color: #27A4F7" class="form-group">
					<label for="text">Contact</label> 
					<input name="contact_no" class="form-control" placeholder="Contact" type="text"  id="contact_no"  value="${Shippingaddress.contact_no}" >
				</div>
				
				<div style="color: #27A4F7" class="form-group">
					<label for="text">Address</label> 
					<input class="form-control" placeholder="Address" type="text"  id="address" name="address" value="${Shippingaddress.address}" >
				</div>
				<div style="color: #27A4F7" class="form-group">
					<label for="text">Zipcode</label> 
					<input class="form-control" placeholder="Zipcode" type="text"  id="zip_code" name="zipcode" value="${Shippingaddress.zipcode}" >
				</div>
				<button style="background-color: #27A4F7;color:white" type="submit" value="submit" class="btn btn-default">Upload</button>
				
				</form></div></div>
</body>
</html>