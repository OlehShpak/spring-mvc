
<jsp:directive.include file="/WEB-INF/view/header.jsp"/>
<div class="col col-sm-9">
              <div class="panel">
   				 
              
              <div class="row">
              	<div class="col col-sm-12">
              	<h3>Search customer</h3>
              	<br>
              	<c:if test="${not empty inputMessage}"><div class="errorblock">${inputMessage}</div><br></c:if>
              	
                 <form:form modelAttribute="shortname" method="post" class="form-inline" role="form" >
												
					
					<form:input path="parameter" class="form-control" placeholder="Shortname"/> 
					<form:errors path="parameter" cssClass="errorblock"/>
					
					<button type="submit" class="btn btn-info " >
					<span class="glyphicon glyphicon-search"></span> Search customer</button>
				
		</form:form>
		<br>
		<br>
		<br>
		<c:if test="${not empty customer}">	 
   	<div class="table-responsive"> 
    <table class="table">
        <thead>
            <tr>
                <th>Short name</th>
                <th>Full name</th>
                <th>Email</th>
                <th>Phone number</th>
                <th>Contact person</th>
                <th>info</th>
            </tr>
        </thead>
        <tbody>
            <tr>
       			 <td>${customer.shortname}</td>
       			 <td>${customer.fullname}</td>
      			 <td>${customer.email}</td>
       			 <td>${customer.phonenumber}</td>   
       			 <td>${customer.contactperson}</td>
       			 <td>${customer.info}</td>    			 
    		</tr>    		    
        </tbody>
    </table>
   </div>
   <br>
   <h3>Customer address</h3>
   <br>
   <div class="table-responsive"> 
    <table class="table">
        <thead>
            <tr>
                <th>Country</th>
                <th>zip</th>
                <th>City</th>
                <th>street, house number</th>
            </tr>
        </thead>
        <tbody>
            <tr>
       			 <td>${customer.country}</td>
       			 <td>${customer.zip}</td>
      			 <td>${customer.city}</td>
       			 <td>${customer.street}</td>    			 
    		</tr>    		    
        </tbody>
    </table>
   </div>
    </c:if>          
		
				</div> 
      	</div> 
  	</div>
</div>
	<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
		<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
		
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