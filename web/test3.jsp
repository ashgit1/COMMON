<!DOCTYPE html>
<html>
<head>
<title>Lingulo.com - Custom Select Boxes</title>
<link rel="stylesheet" href="css/lingulo_style.css" />
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
if (!window.jQuery){
	document.write('<script src="js/jquery-1.11.1.min.js"><\/script>');
}     
</script>
<script src="js/lingulo-select.min.js"></script>
</head>
<body>

<center><h1>Compoent Version</h1></center>
	
	<div class="lg-select style3"> 
		<span class="lg-placeholder"><i class="fa fa-paw"></i>Select Tenant</span>
		 	<select name="tenant">
		 		<!-- <option selected="selected" value="Select Tenant">Select Tenant</option> -->
				<option value="ASDA">ASDA</option>
				<option value="GMC">GMC</option>
				<option value="USG">USG</option>
				<option value="USG">SAMS</option>
			</select>
			
		<span class="lg-placeholder"><i class="fa fa-paw"></i>Select Environment</span>
		 	<select name="environment">
				<!-- <option selected="selected" value="Select Environment">Select Environment</option> -->
				<option value="PQA">PQA</option>
				<option value="PROD">PROD</option>
				<option value="QA1">QA1</option>
				<option value="QA2">QA2</option>
				<option value="GQA">GQA</option>
				<option value="STAG">Stag</option>
			</select>
			
		<span class="lg-placeholder"><i class="fa fa-paw"></i>Select Application</span>
		 	<select name="application"> <!-- onchange="this.form.submit()" -->
		 		<!-- <option selected="selected" value="Select Application">Select Application</option> -->
				<option value="Estore">Estore</option>
				<option value="CSC">CSC</option>
				<option value="CA">CA</option>
				<option value="Mobile">Mobile</option>
				<option value="OFS">OFS</option>
				<option value="Search">Search</option>
			</select>	
	</div>
		
</body>
</html>