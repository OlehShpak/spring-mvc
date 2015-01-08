
<jsp:directive.include file="/WEB-INF/view/header.jsp"/>
<div class="col col-sm-9">
              <div class="panel">
   				 
              
              <div class="row">
              	<div class="col col-sm-6">
              	<h3>Delete customer</h3>
              	<br>
              	<c:if test="${not empty deleteMessage}"><div class="errorblock">${deleteMessage}</div><br></c:if>
              	
                 <form:form modelAttribute="shortname" method="post" class="form-inline" role="form" >
												
					
					<form:input path="parameter" class="form-control" placeholder="Shortname"/> 
					<form:errors path="parameter" cssClass="errorblock"/>
					
					<button type="submit" class="btn btn-info " >
					<span class="glyphicon glyphicon-remove"></span> Delete customer</button>
				
		</form:form>
		<br>
		<br>
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