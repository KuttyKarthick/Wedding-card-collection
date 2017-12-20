<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<link rel="stylesheet" href="resources/css/log.css"/>
<title>Insert title here</title>
</head>
<body>
<!-- <img src="resources/images/giphy.gif" alt="gif"  class="loggif" width=100%, height="200">
 -->
 
 
<form action="isvaliduser" method="post">
<h2>Login Form</h2>
<div class="container">
    <label><b>UserEmail</b></label>
    <input type="text"  placeholder="Enter Email" name="email">

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="user_password">
        
    <button type="submit" name="submit">Login</button>
    <input type="checkbox" checked="checked"> Remember me
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>


 </div> 

</form>
 
</body>
</html>