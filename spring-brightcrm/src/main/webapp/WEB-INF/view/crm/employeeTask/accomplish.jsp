
<jsp:directive.include file="/WEB-INF/view/header.jsp"/>
<div class="col col-sm-9">
              <div class="panel">
   				 
              
              <div class="row">
              	<div class="col col-sm-6">
              	<h3>Accomplish my task</h3>
              	<br>
              	<c:if test="${not empty inputMessage}"><div class="errorblock">${inputMessage}</div><br></c:if>
              	
                 <form:form modelAttribute="taskId" method="post" class="form-inline" role="form" >
												
					
					<form:input path="parameter" class="form-control" placeholder="Deal id"/> 
					<form:errors path="parameter" cssClass="errorblock"/>
					
					<button type="submit" class="btn btn-info " >
					<span class="glyphicon glyphicon-remove"></span> Accomplish task</button>
				
		</form:form>
		<br>
		<br>
		<br>
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