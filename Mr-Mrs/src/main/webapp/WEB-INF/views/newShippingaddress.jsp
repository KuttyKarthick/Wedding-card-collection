<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function formNewship() {
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
<div class="container">
	<div style="margin-left: 15em;" align="center">
		<form method="post" action="address" onsubmit="return formNewship()">
			<table align="center">
				<tr>
					<td colspan="1" align="center"><h3>Provide your Details</h3></td>
				</tr>
                
                
            
				<tr>
					<td>User Name :</td>
					<td style="width: 25em;"><input class="form-control"
						type="text" name="user_name" id="user_name"  >
				</tr>

				<tr>
					<td>Phone Number :</td>
					<td><input class="form-control" type="text" name="contact_no"
						id="contact_no" >
				</tr>
				
				<tr>
					<td>Address :</td>
					<td><input class="form-control" type="text" name="address"
						id="address" ></td>
				</tr>

				<tr>
					<td>Zipcode :</td>
					<td><input class="form-control" type="text" name="zipcode"
						id="zip_code" ></td>
				</tr>
				<tr>

					<td align="left"><input class="btn btn-success" type="submit"
						value="submit"></td>
						<!-- <td>
						 <input class="btn btn-danger"
						type="button" value="Cancel"></td> -->
				</tr>
			</table>
		</form>
	</div>
	</div>
	
</body>
</html>