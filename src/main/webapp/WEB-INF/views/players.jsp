<!doctype html>
<html lang="en">
<%@ include file="/WEB-INF/layouts/include.jsp"%>
<%@ include file="/WEB-INF/layouts/head.jsp"%>
<body id="demo-body">
	<div id="demo-main-div" class="container-fluid">
		<div class="row">
			<div class="col-sm-12">

				<h1>Players</h1>

				<%-- User Message --%>
				<%@ include file="/WEB-INF/layouts/message.jsp"%>

				<div class="row mt-2">
					<div class="col-3">
						<!-- Add player button -->
						<div>
							<a class="btn btn-success" href="<%=request.getContextPath() %>/players/addEditPlayer">Add Player</a>
						</div>
						
					</div>
				</div>

				<table class="table table-hover">
					<c:if test="${empty playerList}">
					No data found
				</c:if>
					<c:if test="${not empty playerList}">
						<thead class="thead-dark">
							<tr>
								<th>
								<!-- Blank for the delete and edit option -->
								</th>
								<th>First</th>
								<th>Last</th>
								<th>Position</th>
								<th>Eligibility</th>
								<th>#</th>
							</tr>
						</thead>
						<c:forEach var="player" items="${playerList}">
							<tr>
								<td>
								<!-- Bootstrap Pencil -->
									<a class = "btn" href="<%=request.getContextPath() %>/players/addEditPlayer?id=${player.id}">
										<svg id="edit_${player.id}" class="bi bi-pencil" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
 											<path fill-rule="evenodd" d="M11.293 1.293a1 1 0 011.414 0l2 2a1 1 0 010 1.414l-9 9a1 1 0 01-.39.242l-3 1a1 1 0 01-1.266-1.265l1-3a1 1 0 01.242-.391l9-9zM12 2l2 2-9 9-3 1 1-3 9-9z" clip-rule="evenodd"/>
  											<path fill-rule="evenodd" d="M12.146 6.354l-2.5-2.5.708-.708 2.5 2.5-.707.708zM3 10v.5a.5.5 0 00.5.5H4v.5a.5.5 0 00.5.5H5v.5a.5.5 0 00.5.5H6v-1.5a.5.5 0 00-.5-.5H5v-.5a.5.5 0 00-.5-.5H3z" clip-rule="evenodd"/>
										</svg>
									</a>
								<!-- Bootstrap X -->
									<a class="btn" href="<%=request.getContextPath() %>/players/deletePlayer?id=${player.id}">
										<svg id="delete_${player.id}" class="bi bi-x" width="1em" height="1em" viewBox="0 0 16 16" fill="rgb(255,0,0)" xmlns="http://www.w3.org/2000/svg">
  											<path fill-rule="evenodd" d="M11.854 4.146a.5.5 0 010 .708l-7 7a.5.5 0 01-.708-.708l7-7a.5.5 0 01.708 0z" clip-rule="evenodd" />
  											<path fill-rule="evenodd" d="M4.146 4.146a.5.5 0 000 .708l7 7a.5.5 0 00.708-.708l-7-7a.5.5 0 00-.708 0z" clip-rule="evenodd" />
										</svg>
									</a>	
								</td>
								<!-- Player Data -->
								<td>${player.firstName}</td>
								<td>${player.lastName}</td>
								<td>${player.position}</td>
								<td>${player.eligibility}</td>
								<td>${player.number}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
		</div>
	</div>
</body>
</html>