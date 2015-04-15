<%@page import="com.compmon.daoimpl.ComponentDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.compmon.model.Component, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Component Filter</title>

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
	<font color="#3b5998" size="6px">View Component By Filter :</font><br><br>

	<form action="ComponentServlet" method="post">
		<label> 
			<span>Tenant :</span>
			 	<select name="tenant">
			 		<option selected="selected" value="Select Tenant">Select Tenant</option>
					<option value="ASDA">ASDA</option>
					<option value="GMC">GMC</option>
					<option value="USG">USG</option>
				</select>
		</label>
		<label> 
			<span>Environment :</span>
			 	<select name="environment">
					<option selected="selected" value="Select Environment">Select Environment</option>
					<option value="PQA">PQA</option>
					<option value="PROD">PROD</option>
				</select>
		</label>	
		<label> 
			<span>Application :</span>
			 	<select name="application" onchange="this.form.submit()">
			 		<option selected="selected" value="Select Application">Select Application</option>
					<option value="Estore">Estore</option>
				</select>
		</label>
		<br><br>
		<!-- <label> 
			<span>Box :</span>
			 	<select name="box">
					<option value="stgs4074">stgs4074</option>
					<option value="stgs4075">stgs4075</option>
					<option value="oses4004">oses4004</option>
				</select>
		</label>
		<label> 
			<span>Instance :</span>
			 	<select name="instance">
					<option value="atg01">atg01</option>
					<option value="atg02">atg02</option>
					<option value="atg03">atg03</option>
				</select>
		</label> 
		<br><br><br>
		
		<label> 
			<span>&nbsp;</span> 
				<input type="submit" class="button" name="submit_status" value="Submit"> &nbsp;&nbsp; 
				<input type="reset" class="button">
		</label>
		-->
	</form>
</center>
<hr>
<%
ArrayList<Component> allComponents = null;
Component component;
allComponents = (ArrayList<Component>) session.getAttribute("ComponentsByFilter");
ComponentDaoImpl daoimpl = new ComponentDaoImpl();
if(allComponents!=null)
{	
%>
<center>
<font color="#3b5998" size="5px"><%= allComponents.get(0).getTenant() %></font>			&nbsp;&nbsp;
<font color="#3b5998" size="5px"><%= allComponents.get(0).getEnvironment() %></font>	&nbsp;&nbsp;
<font color="#3b5998" size="5px"><%= allComponents.get(0).getApplication() %></font>
</center>
<hr><br>

<TABLE BORDER="1" id="componentTable">
				<thead>
					<TR class="noExl">
						<!-- <TH>TENANT</TH>
						<TH>ENVIRONMENT</TH>
						<TH>APPLICATION</TH> -->
						<TH>BOX</TH>
						<TH>INSTANCE</TH>
						<!-- <TH>COMPONENT NAME</TH> -->
						<TH>COMPONENT VERSION</TH>
						<TH>COMPONENT HEALTH CHECK</TH>
					</TR>
				</thead>
				<%
					for (int i=0; i < allComponents.size(); i++) {
						component= allComponents.get(i);						
				%>
					<TR>
						<%-- <td><%= component.getTenant() %></td>
						<td><%= component.getEnvironment() %></td>
						<td><%= component.getApplication() %></td> --%>
						<td><%= component.getBox() %></td>
						<td><%= component.getInstance() %></td>
						<%-- <td><%= component.getComponentName() %></td> --%>
						<td><%= component.getComponentVersion() %></td>
						<td>
							<a href="<%=component.getComponentUrl()%>" target="_blank">
								<% 
									if(daoimpl.checkFailure(component.getComponentUrl())){
								%>	
									<img src="images/redbutton.gif"/>
								<% }else{ %>
									<img src="images/greenbutton.gif"/>	
								<%	} %>
							</a>
						</td>
					</TR>
				<%
					} 
				%>
			</TABLE>
<% 
}else{
%>
<font color="#3b5998" size="5px">Select the Search Parameters</font>
<% 	
}%>

</body>
</html>