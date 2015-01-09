 
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Registration success</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <style type="text/css">
    @import url("http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,400,300,700");

body {
    font-family: Open Sans;
    font-size: 14px;
    line-height: 1.42857;
    background: #eee;
    height: 350px;
    padding: 0;
    margin: 0;
}
.container-login {
    min-height: 0;
    width: 480px;
    color: #333333;
    margin-top: 120px;
    padding: 0;
}
.center-block {
    display: block;
    margin-left: auto;
    margin-right: auto;
}
.container-login > section {
    margin-left: 0;
    margin-right: 0;
    padding-bottom: 10px;
}
#top-bar {
    display: inherit;
}
.nav-tabs.nav-justified {
    border-bottom: 0 none;
    width: 100%;
}
.nav-tabs.nav-justified > li {
    display: table-cell;
    width: 1%;
    float: none;
}
.container-login .nav-tabs.nav-justified > li > a,
.container-login .nav-tabs.nav-justified > li > a:hover,
.container-login .nav-tabs.nav-justified > li > a:focus {
    background: #ff3333 ;
    border: medium none;
    color: #ffffff;
    margin-bottom: 0;
    margin-right: 0;
    border-radius: 0;
}
.container-login .nav-tabs.nav-justified > .active > a,
.container-login .nav-tabs.nav-justified > .active > a:hover,
.container-login .nav-tabs.nav-justified > .active > a:focus {
    background: #ffffff;
    color: #333333;
}
.container-login .nav-tabs.nav-justified > li > a:hover,
.container-login .nav-tabs.nav-justified > li > a:focus {
    background: #de2f18;
}
.error-msg{
	color: #ff0000;
}
.tabs-login {
    background: #ffffff;
    border: medium none;
    margin-top: -1px;
    padding: 10px 30px;
}
.container-login h2 {
    color: #ff3333 ;
}
.form-control {
    background-color: #ffffff;
    background-image: none;
    border: 1px solid #999999;
    border-radius: 0;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
    color: #333333;
    display: block;
    font-size: 14px;
    height: 34px;
    line-height: 1.42857;
    padding: 6px 12px;
    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
    width: 100%;
}
.container-login .checkbox {
    margin-top: -15px;
}
.container-login button {
    background-color: #ff3333 ;
    border-color: #e73e28;
    color: #ffffff;
    border-radius: 0;
    font-size: 18px;
    line-height: 1.33;
    padding: 10px 16px;
    width: 100%;
}
.container-login button:hover,
.container-login button:focus {
    background: #de2f18;
    border-color: #be2815;
}
.errorblock {
	color: #ff3333;
}

    </style>
		 </head>
       
<body>
<div class="login-body">
    <div class="container-login center-block">
		<section>
			<ul id="top-bar" class="nav nav-tabs nav-justified">
				<li><a href="/spring-brightcrm/login">Login</a></li>
				<li class="active"><a href="/spring-brightcrm/registration">Registration</a></li>
			</ul>
			<div class="tab-content tabs-login col-lg-12 col-md-12 col-sm-12 cols-xs-12">
				<div id="login-access" class="tab-pane fade active in">							
			<table border="0">
           		 <tr>
               		 <td colspan="2" align="center"><h2>Registration Succeeded!</h2></td>
          		  </tr>
           		  <tr>
               		 <td colspan="2" align="center">
                    <h3>Thank you for registering! Here's the review of your details:</h3>
               		 </td>
           		  </tr>
           		  <br>
           		  <tr>
                	 <td>User Name:</td>
               		 <td>${userForm.username}</td>
           	    </tr>
           	     <tr>
                	 <td>Full Name:</td>
               		 <td>${userForm.fullname}</td>
           	    </tr>
           	      <tr>
                	 <td>Email:</td>
               		 <td>${userForm.email}</td>
           	    </tr>
           	      <tr>
                	 <td>Phone number:</td>
               		 <td>${userForm.phonenumber}</td>
           	    </tr>
           	    <tr>
                	 <td>Position:</td>
               		 <td>${userForm.position}</td>
           	    </tr>
       	    </table>	
       	    <br>
       	    <br>
       	    <br>
			</div>
			</div>
		</section>
	</div>
</div>

	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
   
</body>
</html>
  
       
