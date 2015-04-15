<%@ page import="java.sql.*,java.net.*,java.io.*,java.lang.*,java.util.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="keywords" content="jQuery ComboBox, jqxComboBox, DropDownList, List, ListBox, Popup List, jqxDropDownList, jqxListBox, List Widget, ListBox Widget, DropDownList Widget" />
<meta name="description" content="This demo shows how to display items in groups by setting each jqxDropDownList item's group property."/>
<title id='Description'>This demo shows how to display items in groups by setting each jqxComboBox item's group property.</title>
<link rel="stylesheet" href="../../jqwidgets/styles/jqx.base.css" type="text/css" />
<script type="text/javascript" src="../../scripts/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../../scripts/demos.js"></script>
<script type="text/javascript" src="../../jqwidgets/jqxcore.js"></script>
<script type="text/javascript" src="../../jqwidgets/jqxbuttons.js"></script>
<script type="text/javascript" src="../../jqwidgets/jqxscrollbar.js"></script>
<script type="text/javascript" src="../../jqwidgets/jqxlistbox.js"></script>
<script type="text/javascript" src="../../jqwidgets/jqxcombobox.js"></script>
</head>
<body>

url: <a href="http://oses4004.wal-mart.com:40181/asda-estore/healthcheck/testenv.jsp">Hit</a>

<%
try{
    URL oracle = new URL("http://oses4004.wal-mart.com:40181/asda-estore/healthcheck/testenv.jsp");
    BufferedReader in = new BufferedReader(
    new InputStreamReader(oracle.openStream()));

    String inputLine;
    while ((inputLine = in.readLine()) != null)
    	out.println(inputLine);
    in.close();
    }catch(Exception ex){}
%>

</body>
</html>