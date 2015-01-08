    
<jsp:directive.include file="/WEB-INF/view/header.jsp"/>
<div class="col col-sm-9">
              <div class="panel">    
              <div class="row">
              	<div class="col col-sm-6">
              	<h3>Add new task</h3>
              	<br>
              	
                  <form:form modelAttribute="task" method="post" class="form-signin" role="form" >		
								
					<form:input path="description" class="form-control" placeholder="Description"/> 
					<form:errors path="description" cssClass="errorblock"/>
					<br>
					<form:input path="employeeFullname" class="form-control" placeholder="Employee full name"/> 
					<form:errors path="employeeFullname" cssClass="errorblock"/>
					<br>
					<button type="submit" class="btn btn-info btn-lg" autofocus >
					<span class="glyphicon glyphicon-edit"></span> Create task</button>
					<br>
					<br>
					<br>
					
		</form:form>
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