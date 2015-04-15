<%@page import="com.compmon.daoimpl.ComponentDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.compmon.model.Component, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Components</title>

<link rel="stylesheet"	href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>

<script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css">

<script>
$(document).ready(function(){
    $('#componentTable').DataTable();
});
</script>

</head>
<body>
<center>
	<h3>
		<font color="#1E90FF">View All Component:</font>
	</h3>
</center>
<%
Component component;
ComponentDaoImpl componentDaoObj = new ComponentDaoImpl();
ArrayList<Component> allComponents = new ArrayList<Component>();
allComponents = componentDaoObj.getAllComponents();
%>
<TABLE BORDER="1" id="componentTable">
				<thead>
					<TR class="noExl">
						<TH>TENANT</TH>
						<TH>ENVIRONMENT</TH>
						<TH>APPLICATION</TH>
						<TH>BOX</TH>
						<TH>INSTANCE</TH>
						<TH>COMPONENT NAME</TH>
						<TH>COMPONENT VERSION</TH>
						<TH>COMPONENT URL</TH>
					</TR>
				</thead>
				<%
					for (int i=0; i < allComponents.size(); i++) {
						component= allComponents.get(i);						
				%>
					<TR>
						<td><%= component.getTenant() %></td>
						<td><%= component.getEnvironment() %></td>
						<td><%= component.getApplication() %></td>
						<td><%= component.getBox() %></td>
						<td><%= component.getInstance() %></td>
						<td><%= component.getComponentName() %></td>
						<td><%= component.getComponentVersion() %></td>
						<td><a href=""><%= component.getComponentUrl() %></a></td>
					</TR>
				<%
					} 
				%>
			</TABLE>

</body>
</html>