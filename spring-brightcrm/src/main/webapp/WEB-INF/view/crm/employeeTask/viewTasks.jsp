<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:directive.include file="/WEB-INF/view/header.jsp"/>
<div class="col col-sm-9">
              <div class="panel">
   				 
              
              <div class="row">
              	<div class="col col-sm-12">
              	<h3>My tasks</h3>
              	<br>
              	 
    		 <div class="table-responsive"> 
   		 	 <table class="table">
        	 <thead>
             <tr>
                <th>Task id</th>
                <th>Description</th>
                <th>Added by</th>
                <th>Created date</th>
               
            </tr>
            </thead>
            <tbody>
           
            <c:forEach var="task" items="${taskList}">
            <tr>
       			 <td>${task.id}</td>
       			 <td>${task.description}</td>
      			 <td>${task.addedBy}</td>
       			 <td><fmt:formatDate value="${task.createdDate}" pattern="yyyy/MM/dd" /> </td>
       			 		 
    		</tr>
    	    </c:forEach>
        </tbody>
    </table>
   </div>
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