<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.btn-info {
    color: #fff;
    background-color: rgba(232, 81, 102, 0.67);
    border-color: #d65b72;
    </style>
<body>
<br>
<br>
<br>
 <a href="addShipping" class="btn btn-info pull-right"> New Shipping Address </a>
 
 
  <div class="container">
            <div class="row">
            <c:forEach items="${shippingList}" var="Shippingaddress">
                <div class="col-sm-5 col-left"> 
                    <div class="panel panel-danger">
                        <div class="panel-heading" >
                            <h1>Shipping Address     <a href="deleteshippingAddress?shippingId=${Shippingaddress.shippingId}"><br>
                            <br>
          <span class="glyphicon glyphicon-trash"></span>
        </a></h1>
                        </div>
              
                          <div class="form-group">
                            <div class="input-group">
				


                   
                             
                  <!--  &nbsp Shipping ID  :  ${Shippingaddress.shippingId}<br>    -->      
                   &nbsp Name         :  ${Shippingaddress.user_name}<br>
                  <!--  &nbsp Email        :  ${Shippingaddress.email}<br> -->
                   &nbsp Phone        :  ${Shippingaddress.contact_no }<br>
                   &nbsp Address      :  ${Shippingaddress.address }<br>
                   &nbsp Zipcode      :  ${Shippingaddress.zipcode }<br>
                            
                          
                     
                        <a href ="thankyou" button type="submit" class="btn btn-info pull-right"> Way To Home Deliver !! <span class="glyphicon glyphicon-share-alt"></span></a>
                        <!-- <a href="thankyou" button >End shopping</a> -->
                            <a href ="editshippingAddress?shippingId=${Shippingaddress.shippingId }" button type="" value="" name="EDIT" class="btn">EDIT <span class="glyphicon glyphicon-pencil"></span></a>
                  </div></div></div></div>
                    
                   </c:forEach>
                   </div></div>
					

</body>
</html>