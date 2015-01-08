    
<jsp:directive.include file="/WEB-INF/view/header.jsp"/>
<div class="col col-sm-9">
              <div class="panel">
   				 
              
              <div class="row">
              	<div class="col col-sm-6">
              	<h3>Add new deal</h3>
              	<br>
              	<c:if test="${not empty inputError}"><div class="errorblock">${inputError}</div><br></c:if>
              	
                  <form:form modelAttribute="dealForm" method="post" class="form-signin" role="form" >		
								
					<form:input path="description" class="form-control" placeholder="Description"/> 
					<form:errors path="description" cssClass="errorblock"/>
					<br>
					<form:input path="totalprice" class="form-control" placeholder="Total price"/> 
					<form:errors path="totalprice" cssClass="errorblock"/>
					<br>
					<form:input path="employeeName" class="form-control" placeholder="Employee name"/> 
					<form:errors path="employeeName" cssClass="errorblock"/>
					<br>
					<form:input path="customerShortname" class="form-control" placeholder="Customer short name"/> 
					<form:errors path="customerShortname" cssClass="errorblock"/>
					<br>
					<h4>Please input deadline date</h4>
					<br>
					<form:input type="date" path="deadline"/>
					<br><br>
					<button type="submit" class="btn btn-info btn-lg" autofocus >
					<span class="glyphicon glyphicon-edit"></span> Create deal</button>
					<br>
					<br>
					<br>
					
		</form:form>
		</div> 
		
        		<div class="col col-sm-5">
				<h3>All customers :</h3>
				<br>
			<ul>
       			 <li>Customer 1</li>
      		 	 <li>Customer 2</li>
        		 <li>Customer 3</li>
      		     <li>Customer 4</li>
    		</ul>
                
       
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