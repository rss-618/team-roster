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
				<form:form method="post" id="widgetForm" modelAttribute="command" 
					action="${pageContext.request.contextPath}/users/addEditUser">
					
					<div class="form-group col-sm-3">
						<%--
							The label and input for firstName 
							path="firstName" is converted to: 
								id="firstName" name="firstName" 
							in the HTML 
						 --%>
						<label for="firstName">First Name</label>
						<form:input class="form-control" path="firstName" placeholder="Enter First Name" />

						<!-- TODO: Add your other form element inputs here -->


						
						<%-- 
							The submit button. Notice that the type is "button" and not submit. We do 
							not want to submit the form when the button is clicked. Instead we want to
							validate the form (client-side), and then send the form to the server. 
						--%>
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
			
			// Get access to submit button element 
			let submitBtn = document.getElementById("submitBtn")
			
			// Handle/Process Submit Button Click
			submitBtn.addEventListener("click", (event) => {
				// Stop old versions of IE from processing the form 
				// even though the button type is button
				event.preventDefault();
				
				// Variables that hold your form element values
				let firstName = document.getElementById("firstName").value;
 				
				if (firstName.length == 0 || lastName.length == 0) {
					// TODO: Add your own error message here
					alert("Error: Please enter a first name.");
				} else {				
					// TODO: Submit the form to the server
					
				}
			});
		});
	</script>
</body>
</html>