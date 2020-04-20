<!doctype html>
<html lang="en">
<%@ include file="/WEB-INF/layouts/include.jsp" %>
<%@ include file="/WEB-INF/layouts/head.jsp" %>
<body id="demo-body">
	<div id="demo-main-div" class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<!-- 
					TODO: Change "Widgets" to match your topic
				 -->
				<h1>Widgets</h1>
				
				<%-- User Message --%>
				<%@ include file="/WEB-INF/layouts/message.jsp" %>
				
				<%-- Add Widget Button --%>
				<div class="row mt-2">
					<div class="col-3">
						<!-- The button to add a widget goes here -->
						
					</div>
				</div>
				
				<%--
					Build a Bootstrap Table to hold your widgets
					(Replace the simple output below)
				 --%>				
				<c:if test="${empty widgetList}">
					No data found
				</c:if>
				<c:if test="${not empty widgetList}">
					<c:forEach var="item" items="${widgetList}">
						${item}
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>