<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/register.css" />

<title>Insert title here</title>
<script type="text/javascript">
	function formRegister() {
		// Make quick references to our fields
		var Username = document.getElementById('user_name');
		var Firstname = document.getElementById('first_name');
		var Lastname = document.getElementById('last_name');
		var Email = document.getElementById('email');
		var Userpassword = document.getElementById('user_password');
		var Address = document.getElementById('address');
		var Zipcode = document.getElementById('zipcode');
		var Phone = document.getElementById('contact_no'); 
		    

		if (notEmpty(Username, "Username Should not be empty")) {
			
			if (isAlphabet(Username,
						"Please enter only letters for Username")) {
				
				if (notEmpty(Firstname, "Firstname Should not be empty")) {
					
					if (isAlphabet(Firstname,
								"Please enter only letters for Firstname")) {
						
						if (notEmpty(Lastname, "Lastname Should not be empty")) {
							
							if (isAlphabet(Lastname,
										"Please enter only letters for Lastname")) {
								
								if (notEmpty(Email,
								"EmailId Should not be empty")) {
									
							           if (emailValidator(Email,
								             	"EmailId Should be in format of abc@xyz.com ")) {
							        	   
					                       if (notEmpty(Userpassword, "password Should not be empty")) {
					                    	   
						                          if (isAlphanumeric(Userpassword,
								                        "Numbers and Letters Only for Passwords")) {
						                        	  
						                        	  if (notEmpty(Address, "location Should not be empty")) {
						                        		  
						                        		  if (isAlphabet(Address,
															"Please enter only letters for Location")) {
						                        			  
						                        		  if (notEmpty(Zipcode,
															"Zipcode Should not be empty")) {
						                        			  
														          if (isNumeric(Zipcode,
																          "Please enter a valid zip code")) {
														        	  
								                                       if (notEmpty(Phone,
								                                                 	"PhoneNumber Should not be empty")) {
								                                    	   
								                                                if (isNumeric(Phone,
									                                              	"Please enter only number for PhoneNumber")) {
								                                                	
									
												
														                     return true;
		}
		}
		}
		}
		}
		}
		}
            }
            }

        }
  	  }
		  }
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
	
	function isAlphanumeric(elem, helperMsg) {
		var alphaExp = /^[0-9a-zA-Z]+$/;
		if (elem.value.match(alphaExp)) {
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
	<!-- <img alt="registergif" src= "resources/images/giphy-downsized.gif" width=100%, height="300"> -->
	<form action="newUser" method="post" onsubmit="return formRegister()">
		<h3>register here..........</h3>
		<div class="container">

			<label><b>USER NAME</b></label> <input type="text"
				placeholder="enter your user name" name="user_name" id="user_name">

			<label><b>FIRST NAME</b></label> <input type="text"
				placeholder="enter your first name" name="first_name"
				id="first_name"> 
				<label><b>LAST NAME</b></label> <input
				type="text" placeholder="enter your last name" name="last_name"
				id="last_name">
				 <label><b>EMAIL ADDRESS</b></label> <input
				type="text" placeholder="enter your active email" name="email"
				id="email"> 
				<label><b>PASSWORD</b></label> <input
				type="password" placeholder="enter your password"
				name="user_password" id="user_password"> 
				<label><b>ADDRESS OR LOCATION</b></label>
			   <input type="text" placeholder="enter your location" name="address"
				id="address"> 
				<label><b>ZIPCODE</b></label> <input
				type="text" placeholder="enter your zipcode" name="zipcode"
				id="zipcode">
				 <label><b>CONTACT NO</b></label> <input
				type="text" placeholder="enter your contact number"
				name="contact_no" id="contact_no"> 
				<input type="checkbox"
				checked="checked"> remember me...

			<p>
				by creating an account you agree to our<a href="#"> TERMS &
					PRIVACY CONDITIONS...</a>
			</p>


			<div class="clearfix">
				<button type="button" class="cancel">cancel</button>
				<button type="submit" class="signup">sign up</button>
			</div>
		</div>
	</form>


</body>
</html>
