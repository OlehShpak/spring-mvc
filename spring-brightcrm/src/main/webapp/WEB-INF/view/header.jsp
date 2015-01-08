<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Bright CRM</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
		
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
		
		 <style type="text/css">
            /* bootstrap 3 helpers */

.navbar-form input, .form-inline input {
	width:auto;
}

/* end */

/* custom theme */

header {
	min-height:230px;
  	margin-bottom:5px;
}

@media (min-width: 979px) {
  #sidebar.affix-top {
      position: static;
  }
  
  #sidebar.affix {
      position: fixed;
      top: 0;
      width:21.2%;
  }
}

.affix,.affix-top {
   position:static;
}

/* theme */

body {
  color:#828282;
  background-color:#eee;
}

a,a:hover,a:visited,a:active,a:link {
	color:#ff3333;
  	text-decoration:none;
}

.highlight-bk {
	background-color:#ff3333;
    padding:1px;
    width:100%;
}

.highlight {
	color:#ff3333;
}
  
h3.highlight  {
	padding-top:13px;
    padding-bottom:14px;
  	border-bottom:2px solid #ff3333;
}

.navbar {
	background-color:#ff3333;
  	color:#ffffff;
    border:0;
  	border-radius:0;
}
.navbar-nav > li > a {
  	color:#fff;
  	padding-left:20px;
  	padding-right:20px;
  	border-left:1px solid #ee3333;
}
.navbar-nav > li > a:hover, .navbar-nav > li > a:focus {
    color:#666666; 
}
.navbar-nav > li:last-child > a {
  	border-right:1px solid #ee3333;
}
.navbar-nav > .active > a, .navbar-nav > .active > a:hover, .navbar-nav > .active > a:focus {
    color: #ffffff;
	background-color:transparent;
}
.navbar-nav > .open > a, .navbar-nav > .open > a:hover, .navbar-nav > .open > a:focus {
	color: #f0f0f0;
	background-color:transparent;
  	opacity:.9;
    border-color:#ff3333;
}

.nav .open > a {
    border-color:#777777;
    border-width:0;
}

.accordion-group {
	border-width:0;
}

.dropdown-menu {
	min-width: 250px;
}

.accordion-heading .accordion-toggle, .accordion-inner, .nav-stacked li > a {
	padding-left:1px;
}

.caret {
	color:#fff;
}

.navbar-toggle {
	color:#fff;
    border-width:0;
}
  
.navbar-toggle:hover {
	background-color:#fff;
}
.panel {
	padding-left:27px;
    padding-right:27px;
}
.col-sm-5 > ul {
	margin-left: 20%;
}
.col-sm-5 > h3 {
	margin-left: 20%;
}
.accordion-inner {
	margin-left: 10%;
}
.errorblock {
	color: #2AABD2;
}
.col > img {
float:right;
}
.col-sm-6 > img {
	float:right;
}
.col-sm-7 > h1 {
color:#2AABD2;
font-family:'Monotype Corsiva', 'Apple Chancery',
'ITC Zapf Chancery', 'URW Chancery L', cursive;
}
/* end theme */
        </style>
	</head>
	<body>
	<!-- Logout function -->
	<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

	
		
<nav class="navbar navbar-static">
    <div class="container">
      <a class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
        <span class="glyphicon glyphicon-chevron-down"></span>
      </a>
      <div class="nav-collapse collase">
        <ul class="nav navbar-nav">  
          <li><a href="/spring-brightcrm/">Home</a></li>
          <sec:authorize access="hasRole('ROLE_USER')">
          <c:if test="${pageContext.request.userPrincipal.name != null}">
          <li><a href="#">${pageContext.request.userPrincipal.name}</a></li>
          </c:if>
          <li><a href="javascript:formSubmit()">Logout</a></li>
          </sec:authorize>
        </ul>
        <ul class="nav navbar-right navbar-nav">
         
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> <i class="glyphicon glyphicon-chevron-down"></i></a>
            <ul class="dropdown-menu">
              <li><a href="/spring-brightcrm/login">Login</a></li>
              <li><a href="/spring-brightcrm/registration">Registration</a></li>
              <li class="divider"></li>
              <li><a href="/spring-brightcrm/">About CRM</a></li>
             </ul>
          </li>  
        </ul>
      </div>		
    </div>
</nav><!-- /.navbar -->

<header class="masthead">
  <div class="container">
    <div class="row">
      <div class="col col-sm-6">
        <h1><a href="#" title="scroll down for your viewing pleasure">BrightCRM</a>
          <p class="lead">Just register in 30 seconds and start using it</p></h1>
      </div>
      <div class="col col-sm-6">
        
         <img src="/spring-brightcrm/resources/img/BrightCRM.png"       
        
      </div>
    </div>
  </div>
  
  <div class="container">
	<div class="row">
      <div class="col col-sm-12">
        
        <div class="panel">
        <div class="panel-body">
          Place for some news  <span class="glyphicon glyphicon-bullhorn"></span>
        </div>
        </div>
        
      </div>
  	</div>
  </div>
</header>

<!-- Begin Body -->
<div class="container">
	<div class="row">
  			<div class="col col-sm-3">
              	<div id="sidebar">
      			<ul class="nav nav-stacked">
                    <li><h3 class="highlight">Functions <span class="glyphicon glyphicon-dashboard pull-right"></span></h3></li>
                  	
				</ul>
                <div class="accordion" id="accordion2">
                     <div class="accordion-group">
                            <div class="accordion-heading">
                              <h4> <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                                    Deal management &nbsp&nbsp<span class="glyphicon glyphicon-usd"></span>
                                </a></h4> 
                            </div>
                            <div id="collapseOne" class="accordion-body collapse">
                                <div class="accordion-inner">
                                <br>
                                 <h4><a href="/spring-brightcrm/crm/deal/add">Create new deal</a></h4>
                                  
                                  <h4><a href="/spring-brightcrm/crm/deal/delete">Delete deal</a></h4>
                                 
                                  <h4><a href="/spring-brightcrm/crm/deal/searchByCreatedDate">Search deal by created date</a></h4>
                                  
                                  <h4><a href="/spring-brightcrm/crm/deal/searchByDeadline">Search deal by deadline</a></h4>
                                </div>
                            </div>
                        </div>
                    <br>
                    <div class="accordion-group">
                            <div class="accordion-heading">
                               <h4> <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
                                    My tasks  &nbsp&nbsp<i class="glyphicon glyphicon-list-alt"></i>
                                </a></h4>
                            </div>
                            <div id="collapseTwo" class="accordion-body collapse">
                                <div class="accordion-inner">
                                <br>
                                  <h4><a href="/spring-brightcrm/crm/employeeTask/viewTasks">View tasks</a></h4>
                                  
                                 <h4><a href="/spring-brightcrm/crm/employeeTask/accomplish">Accomplish task</a></h4> 
                                 
                                 <h4><a href="/spring-brightcrm/crm/employeeTask/add">Add new task</a></h4> 
                                </div>
                            </div>
                        </div>
                        <br>
                         <div class="accordion-group">
                        <div class="accordion-heading">
                              <h4> <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
                                    Customer management &nbsp&nbsp<span class="glyphicon glyphicon-globe"></span>
                                </a></h4> 
                            </div>
                            <div id="collapseThree" class="accordion-body collapse">
                                <div class="accordion-inner">
                                <br>
                                  <h4><a href="/spring-brightcrm/crm/customer/add">Create new customer</a></h4>
                                  
                                  <h4><a href="/spring-brightcrm/crm/customer/delete">Delete customer</a></h4>
                                  
                                  <h4><a href="/spring-brightcrm/crm/customer/searchByShortname">Search customer</a></h4>
                                </div>
                            </div>
                        </div>
                        <br>
                         <div class="accordion-group">
                            <div class="accordion-heading">
                               <h4><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour">
                                    Analytics  &nbsp&nbsp<span class="glyphicon glyphicon-hdd"></span>
                                </a></h4>
                            </div>
                            <div id="collapseFour" class="accordion-body collapse">
                                <div class="accordion-inner">
                                <br>
                                <h4><a href="#">To do</a></h4>  
                                 
                                  <h4><a href="#">To do</a></h4>
                                </div>
                            </div>
                        </div>
                        <br>
                         <div class="accordion-group">
                            <div class="accordion-heading">
                               <h4><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFive">
                                    Chief section &nbsp&nbsp<span class="glyphicon glyphicon-bullhorn"></span>
                                </a></h4> 
                            </div>
                            <div id="collapseFive" class="accordion-body collapse">
                                <div class="accordion-inner">
                                <br>
                                <h4><a href="/spring-brightcrm/chief/addNews">Add news</a></h4>  
                                <h4><a href="/spring-brightcrm/chief/findTasks">Find employee tasks</a></h4> 
                                </div>
                            </div>
                        </div>
               	</div>
               </div>
      		</div>  