<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>


<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Sofia'
	rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Aladin'
	rel='stylesheet'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>







<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.dropdown1 {
	position: static; 
	display: inline-block; 
	 font-size: 20px;
	padding: 10px 30px 0px 10px;
	color: white;
}

.dropdown {
	position: static;
	display: inline-block;
	font-size: 20px;
	padding: 3px 40px 1px 40px;
	color: white;
}

a {
	font-size:20px;
	color:white;
}


.dropdown-content1 {
	display: none;
	position: fixed;
	background-color: black;
	min-width: 80px;
	opacity: 1;
	padding: 8px 25px;
	z-index: 10;
	font-size: 30px;
}

.dropdown1:hover .dropdown-content1 {
	display: block;
	color: red;
}


.login 
{
padding:0px 0px 0px 900px;
font-size:10px;
}
.log
{
float:right;
padding:0px 0px 0px 500px;
}


</style>

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				
				<li><img src="resources/images/Logo.jpg"
					width="60px" height="55px"></li>
				
			<!--  <div class="dropdown1"> -->
				<li><a href="LoginPage">Home</a></li>
		    <!--  </div>
		 <div class="dropdown1"> -->
				<li>
				<a href="About">About</a></li> 
				<!-- </div> -->
				
				<c:if test="${not empty isLoggedInAdmin}">
             	<div class="dropdown1"> 
                       Category
                      
						<ul class="dropdown-content1" style="list-style-type:none">
							<li><a href="viewCategory" >View</a></li>
							<li><a href="addCategory">Add</a></li>
						</ul>
				</div> 
				
				<!-- <div class="dropdown1"> 
				<a href="About">Category</a>
				<ul class="dropdown-content1" style="list-style-type:none">
							<li><a href="viewCategory" >View</a></li>
							<li><a href="addCategory">Add</a></li>
						</ul>
				
				</div> -->
				

					<div class="dropdown1">
						Product
						<ul class="dropdown-content1" style="list-style-type:none">
							<li><a href="viewProduct">View</a></li>
							<li><a href="addProduct">Add</a></li>
						</ul>
					</div>


					<div class="dropdown1">
						Supplier
						<ul class="dropdown-content1" style="list-style-type:none">
							<li><a href="viewSupplier">View</a></li>
							<li><a href="addSupplier">Add</a></li>
						</ul>
					</div>
				</c:if>

				
			
			
			<c:if test="${pageContext.request.userPrincipal.name == null }">
			 
			<div class="login">
			
				<a href="LoginPage" class="btn btn-info btn-lg" 
				class="nav navbar-nav navbar-right">
				<span class="glyphicon glyphicon-log-in">
				</span> Login</a>
				
				
				
              <!--  <div class="register"> -->
			
				<a href="RegistrationPage" class="btn btn-info btn-lg"
						class="nav navbar-nav navbar-right"><span
					class="glyphicon glyphicon-user"></span> Register</a>
				
					
					</div>
			</c:if>
			
			<c:if test="${pageContext.request.userPrincipal.name != null }">
	<div class="log"> 
						<li><a href="logout"  class="btn btn-info btn-lg"
						class="nav navbar-nav navbar-right"> <span
						class="glyphicon glyphicon-log-out"></span> Log out
					</a>
					</li>
			 </div> 
				
			</c:if>
			</ul>
		</div>


	</nav>



</body>
</html>