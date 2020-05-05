<!doctype html>
<html lang="en">
<%@ include file="/WEB-INF/layouts/include.jsp" %>
<%@ include file="/WEB-INF/layouts/head.jsp" %>
<body id="demo-body">
	<div id="demo-main-div" class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<h1>${title}</h1>
				<%@ include file="/WEB-INF/layouts/message.jsp" %>
				<%-- 
					The Add/Edit Widget Form
					We are using ${pageContext.request.contextPath} to reference the context path.
					The order of parsing does not allow us to use <%=request.getContextPath() %>  
				--%>
				<form:form method="post" id="playerForm" modelAttribute="command" 
					action="${pageContext.request.contextPath}/players/addEditPlayer">
					
					<div class="form-group col-sm-3">
						
						<label for="firstName">First Name</label>
						<form:input class="form-control" path="firstName" placeholder="Enter First Name" />

						<label for="lastName">Last Name</label>
						<form:input class="form-control" path="lastName" placeholder="Enter Last Name" />
						
						<label for="position">Position</label>
						<form:input class="form-control" path="position" placeholder="Enter Position" />
						
						<label for="eligibility">Eligibility</label>
						<form:input class="form-control" path="eligibility" placeholder="Enter Player Eligibility (eg. Freshman)" />
						
						<label for="number">Number</label>
						<form:input class="form-control" type="number" step="1" path="number" placeholder="Enter Player Number" />
						
						<form:hidden class="form-control" path="id" />
					
						<button class="btn btn-primary mt-3" type="button" id="submitBtn">
							Submit
						</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<style>
		#widgetForm .form-group {
			padding-left: 0px !important;
		}
	</style>
	<script>
		// Client Side Validation
		window.addEventListener("DOMContentLoaded", (event) => {

			let submitBtn = document.getElementById("submitBtn")
			
			// Handle/Process Submit Button Click
			submitBtn.addEventListener("click", (event) => {
				// Stop old versions of IE from processing the form 
				// even though the button type is button
				event.preventDefault();
				
				// Variables
				let firstName = document.getElementById("firstName").value;
				let lastName = document.getElementById("lastName").value;
				let num = document.getElementById('number').value;
				
				let form = document.getElementById("playerForm"); 
	
				if (firstName.length == 0 || lastName.length == 0 ) {
					alert("Error: Please make sure First Name and Last Name forms are filled.");
				}else if(num.includes(".")){
					alert("Error: The number field only takes integers");
				}
				else {
					
					form.submit();
				}
			});
		});
	</script>

</body>
</html>