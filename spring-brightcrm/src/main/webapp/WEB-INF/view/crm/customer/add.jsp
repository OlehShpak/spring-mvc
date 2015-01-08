    
<jsp:directive.include file="/WEB-INF/view/header.jsp"/>
<div class="col col-sm-9">
              <div class="panel">
   				 
              
              <div class="row">
              	<div class="col col-sm-6">
              	<h3>Add new customer</h3>
              	<br>
              	<c:if test="${not empty inputError}"><div class="errorblock">${inputError}</div><br></c:if>
              	
                  <form:form modelAttribute="addCustomer" method="post" class="form-signin" role="form" >		
								
					<form:input path="shortname" class="form-control" placeholder="Shortname"/> 
					<form:errors path="shortname" cssClass="errorblock"/>
					<br>
					<form:input path="fullname" class="form-control" placeholder="Full name"/> 
					<form:errors path="fullname" cssClass="errorblock"/>
					<br>
					<form:input path="phonenumber" class="form-control" placeholder="Phone number"/> 
					<form:errors path="phonenumber" cssClass="errorblock"/>
					<br>
					<form:input path="email" class="form-control" placeholder="Email"/> 
					<form:errors path="email" cssClass="errorblock"/>
					<br>
					<form:input path="contactperson" class="form-control" placeholder="Contactperson"/> 
					<form:errors path="contactperson" cssClass="errorblock"/>
					<br>
					<form:input path="info" class="form-control" placeholder="Additional info"/> 
					<form:errors path="info" cssClass="errorblock"/>

					<h3>Customer address</h3>
				
					<form:input path="street" class="form-control" placeholder="Street, number"/> 
					<form:errors path="street" cssClass="errorblock"/>
					<br>
					<form:input path="city" class="form-control" placeholder="City"/> 
					<form:errors path="city" cssClass="errorblock"/>
					<br>
					<form:input path="zip" class="form-control" placeholder="Zip"/> 
					<form:errors path="zip" cssClass="errorblock"/>
					<br>
					<form:input path="country" class="form-control" placeholder="Country"/> 
					<form:errors path="country" cssClass="errorblock"/>
					<br>
					<button type="submit" class="btn btn-info btn-lg" autofocus >
					<span class="glyphicon glyphicon-edit"></span> Add customer</button>
					
		</form:form>
		</div> 
		
        		  <div class="col col-sm-5">
        	<c:if test="${not empty customerList}">
        	<h3>All customers :</h3>
        	<br>
        		<ul>
        			<c:forEach var="cust" items="${customerList}">
        			<h4><li>${cust}</li></h4>
        			</c:forEach>
				</ul>
			</c:if>
			<br>	
        </div>
      	</div> 
  	</div>
</div>
	<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
		<script type='text/javascript'>
        
        $(document).ready(function() {
        
           $('#sidebar').affix({
     		 offset: {
       		 top: 240
      			}
			});	
        
        });
        
        </script>
	</body>
</html>