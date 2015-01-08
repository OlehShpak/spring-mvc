<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:directive.include file="/WEB-INF/view/header.jsp"/>
<div class="col col-sm-9">
              <div class="panel">
   				 
              
              <div class="row">
              	<div class="col col-sm-12">
              	<h3>Search deal by created date</h3>
              	<br>
              	 
            <form:form modelAttribute="createdDate" method="post" class="form-inline" role="form" >
												
					<form:input type="date" class="form-control" path="from"/>
					
					<form:input type="date" class="form-control" path="to"/>
					
					<button type="submit" class="btn btn-info " >
					<span class="glyphicon glyphicon-search"></span> Search deal</button>
				
		</form:form>
   		 <br>
   		 <br>
   		 
   	<c:if test="${not empty dealList}">	 
   	<div class="table-responsive"> 
    <table class="table">
        <thead>
            <tr>
                <th>Deal id</th>
                <th>Description</th>
                <th>Total price</th>
                <th>Created date</th>
                <th>Deadline</th>
                <th>Customer</th>
                <th>Employee</th>
            </tr>
        </thead>
        <tbody>
           
            <c:forEach var="deal" items="${dealList}">
            <tr>
       			 <td>${deal.id}</td>
       			 <td>${deal.description}</td>
      			 <td>${deal.totalprice}</td>
       			 <td><fmt:formatDate value="${deal.createdDate}" pattern="yyyy/MM/dd" /> </td>
       			 <td><fmt:formatDate value="${deal.deadline}" pattern="yyyy/MM/dd" /> </td>
       			 <td>${deal.customerShortname}</td>   
       			 <td>${deal.employeeName}</td>  			 
    		</tr>
    		  </c:forEach>
           
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