
<%@page import="in.co.rays.project_3.controller.CustomerListCtl"%>
<%@page import="in.co.rays.project_3.dto.CustomerDTO"%>

<%@page import="java.util.Map"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project_3.model.ModelFactory"%>
<%@page import="in.co.rays.project_3.model.RoleModelInt"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>

<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Customer List</title>
<script src="<%=ORSView.APP_CONTEXT%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=ORSView.APP_CONTEXT%>/js/CheckBox11.js"></sc ript>
<script src="<%=ORSView.APP_CONTEXT%>/js/utility.js"></script>

<script type="text/javascript">
	function validatephone(event) {
		const input = event.target;
		input.value = input.value.replace(/[^0-9.]/g, '')
		if (input.value.length > 0 && input.value[0] <= '5') {
			input.value = '';
		}
	}
</script>
<script>
	function validateNumberKey(event, validationMessageId) {
		// Allow only digits, minus sign, and dot for latitude and longitude input
		if (!/[0-9\.\-]/.test(event.key)) {
			// Show validation message
			var validationMsg = document.getElementById(validationMessageId);
			validationMsg.style.display = 'inline';
			event.preventDefault(); // Prevent typing the invalid character
		} else {
			// Hide validation message if input is valid
			var validationMsg = document.getElementById(validationMessageId);
			validationMsg.style.display = 'none';
		}
	}
</script>

<style>
.hm {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/1234.jpeg');
	background-size: cover;
	background-repeat: no-repeate;
	padding-top: 6%;
}

.p1 {
	padding: 4px;
	width: 200px;
	font-size: bold;
}

.text {
	text-align: center;
}
</style>
</head>

<body class="hm">
	<%@include file="Header.jsp"%>
	<%@include file="calendar.jsp"%>
	<div></div>
	<div>
		<form class="pb-5" action="<%=ORSView.CUSTOMER_LIST_CTL%>"
			method="post">
			<jsp:useBean id="dto" class="in.co.rays.project_3.dto.CustomerDTO"
				scope="request"></jsp:useBean>


			<%
				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;
				int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());

				List list = ServletUtility.getList(request);

				Iterator<CustomerDTO> it = list.iterator();
				if (list.size() != 0) {
			%>
			<center>
				<h1 class="text-secondary font-weight-bold pt-3">
					<u>Customer List</u>
				</h1>
			</center>



			<%
				Map map = (Map) request.getAttribute("imp");
					System.out.println("map = " + map);
			%>

			<div class="row">
				<div class="col-md-4"></div>
				<%
					if (!ServletUtility.getSuccessMessage(request).equals("")) {
				%>

				<div class="col-md-4 alert alert-success alert-dismissible"
					style="background-color: #80ff80">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4>
						<font color="#008000"><%=ServletUtility.getSuccessMessage(request)%></font>
					</h4>
				</div>
				<%
					}
				%>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>

				<%
					if (!ServletUtility.getErrorMessage(request).equals("")) {
				%>
				<div class=" col-md-4 alert alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4>
						<font color="red"> <%=ServletUtility.getErrorMessage(request)%></font>
					</h4>
				</div>
				<%
					}
				%>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-sm-1"></div>
				<div class="col-sm-2">
					<input type="text" name="clientName" onkeydown="return /[a-zA-Z]/i.test(event.key)" maxlength="20"placeholder="Enter clientName"
						class="form-control"
						oninput="handleLetterInput(this, 'clientNameError', 30)"
						onblur="validateLetterInput(this, 'clientNameError', 30)"
						value="<%=ServletUtility.getParameter("clientName", request)%>">


					<font color="red" class="pl-sm-5" id="clientNameError"></font>
				</div>


				<div class="col-sm-2">
					<input type="text" name="location" placeholder="Enter location"
						class="form-control"
						oninput="handleLetterInput(this, 'locationError', 30)"
						onblur="validateLetterInput(this, 'locationError', 30)"
						value="<%=ServletUtility.getParameter("location", request)%>">


					<font color="red" class="pl-sm-5" id="locationError"></font>
				</div>

				<div class="col-sm-2">
					<input type="text" name="contactNumber" oninput="validatephone(event)"
						name="phoneNo" maxlength="10"
						placeholder="Enter contactNumber" class="form-control"
						oninput="handleIntegerInput(this, 'contactNumberError', 30)"
						onblur="validateIntegerInput(this, 'contactNumberError', 30)"
						value="<%=ServletUtility.getParameter("contactNumber", request)%>">


					<font color="red" class="pl-sm-5" id="contactNumberError"></font>
				</div>




				<%-- <div class="col-sm-2">
					<input type="text" name="status" placeholder="Enter status"
						class="form-control"
						value="<%=ServletUtility.getParameter("status", request)%>">
						
						
				</div> --%>

				<div class="col-sm-2">
					<%=HTMLUtility.getList1("importance", String.valueOf(dto.getImportance()), map)%>
				</div>

					<div class="col-sm-2">
						<input type="submit" class="btn btn-primary btn-md"
							style="font-size: 15px" name="operation"
							value="<%=CustomerListCtl.OP_SEARCH%>"> &emsp; <input
							type="submit" class="btn btn-dark btn-md" style="font-size: 15px"
							name="operation" value="<%=CustomerListCtl.OP_RESET%>">
					</div>
			

				<div class="col-sm-2"></div>
			</div>

			</br>
			<div style="margin-bottom: 20px;" class="table-responsive">
				<table class="table table-bordered table-dark table-hover">
					<thead>
						<tr style="background-color: purple;">

							<th width="10%"><input type="checkbox" id="select_all"
								name="Select" class="text"> Select All</th>
							<th width="5%" class="text">S.NO</th>
							<th width="15%" class="text">ClientName</th>
							<th width="15%" class="text">Location</th>
							<th width="15%" class="text">ContactNumber</th>
							<th width="15%" class="text">Importance</th>
							<th width="5%" class="text">Edit</th>
						</tr>
					</thead>
					<%
						while (it.hasNext()) {
								dto = it.next();
					%>
					<tbody>
						<tr>
							<td align="center"><input type="checkbox" class="checkbox"
								name="ids" value="<%=dto.getId()%>"></td>
							<td class="text"><%=index++%></td>
							<td class="text"><%=dto.getClientName()%></td>
							<td class="text"><%=dto.getLocation()%></td>
							<td class="text"><%=dto.getContactNumber()%></td>
							<td class="text"><%=map.get(Integer.parseInt(dto.getImportance()))%></td>

							<td class="text"><a href="CustomerCtl?id=<%=dto.getId()%>">Edit</a></td>
						</tr>
					</tbody>
					<%
						}
					%>
				</table>
			</div>
			<table width="100%">
				<tr>
					<td><input type="submit" name="operation"
						class="btn btn-warning btn-md" style="font-size: 17px"
						value="<%=CustomerListCtl.OP_PREVIOUS%>"
						<%=pageNo > 1 ? "" : "disabled"%>></td>

					<td><input type="submit" name="operation"
						class="btn btn-primary btn-md" style="font-size: 17px"
						value="<%=CustomerListCtl.OP_NEW%>"></td>

					<td><input type="submit" name="operation"
						class="btn btn-danger btn-md" style="font-size: 17px"
						value="<%=CustomerListCtl.OP_DELETE%>"></td>

					<td align="right"><input type="submit" name="operation"
						class="btn btn-warning btn-md" style="font-size: 17px"
						style="padding: 5px;" value="<%=CustomerListCtl.OP_NEXT%>"
						<%=(nextPageSize != 0) ? "" : "disabled"%>></td>
				</tr>
				<tr></tr>
			</table>

			<%
				}
				if (list.size() == 0) {
			%>
			<center>
				<h1 style="font-size: 40px; color: #162390;">Customer List</h1>
			</center>
			</br>
			<div class="row">
				<div class="col-md-4"></div>

				<%
					if (!ServletUtility.getErrorMessage(request).equals("")) {
				%>
				<div class=" col-md-4 alert alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4>
						<font color="red"> <%=ServletUtility.getErrorMessage(request)%></font>
					</h4>
				</div>
				<%
					}
				%>




				<%
					if (!ServletUtility.getSuccessMessage(request).equals("")) {
				%>

				<div class="col-md-4 alert alert-success alert-dismissible"
					style="background-color: #80ff80">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4>
						<font color="#008000"><%=ServletUtility.getSuccessMessage(request)%></font>
					</h4>
				</div>
				<%
					}
				%>
				<div style="padding-left: 48%;">
					<input type="submit" name="operation"
						class="btn btn-primary btn-md" style="font-size: 17px"
						value="<%=CustomerListCtl.OP_BACK%>">
				</div>

				<div class="col-md-4"></div>
			</div>

			<%
				}
			%>

			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">
		</form>


	</div>


</body>
<%@include file="FooterView.jsp"%>
</html>