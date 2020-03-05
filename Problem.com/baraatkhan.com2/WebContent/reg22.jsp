<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
legend {
	
}

  fieldset {
	height: 430px;
	width: 450px;
}

.fieldset {
	float: none;
}

input[type=text] {
	height: 30px;
	background-color: silver;
}

input[type=date] {
	height: 30px;
	width: 173px;
	background-color: silver;
}

input[type=password] {
	height: 30px;
	background-color: silver;
}

input[type=email] {
	height: 30px;
	background-color: silver;
}
select[type=course]{
height: 30px;
	background-color: silver;
}

label {
	color: red;
	font-weight: bold;
}

input[type=submit] {
	height: 40px;
	width: 80px;
	background-color: Green;
}

input[type=reset] {
	height: 40px;
	width: 80px;
	background-color: red;
}
</style>
</head>

<script>  
	function validateform() {
		var st = document.myform.st.value;
		var con = document.myform.con.value;
		var height = document.myform.height.value;
		var weight = document.myform.weight.value;

		if (st == null || st == "" ) {
			alert("State can't be blank");
			return false;
		}
		
		else if (con == null || con == "") {
			alert("Country can't be blank");
			return false;
		}
		
else if(height == "")  {  
    return true;
}
//check if age is a number or less than or greater than 100
if (isNaN(height)||height<4.8||height>7.2)
{ 
    alert("The Height must be a number between 4.8 and 7.2");
    return false;
}
else if(weight == "") {   
    return true;
}
//check if age is a number or less than or greater than 100
if (isNaN(weight)||weight<30||weight>112)
{ 
    alert("The Weight must be a number between 30 and 112");
    return false;
}

		
	}
</script>
<br>
<body bgcolor="white">
	<h1 style="color: red; text-align: center">Personal Details</h1>
	<hr>

	<form name="myform" action="reg2" method="post" onsubmit="return validateform()">
		<table border='0' align='center'>
			<tr>
				<td>Cast Division</td>
				<td><select name="div" required="required">
						<option value=''>--Select a value--</option>
						<option value='Pathan'>Pathan</option>
						<option value='Khan'>Khan</option>
						<option value='Syed'>Syed</option>
						<option value='Saikh'>Saikh</option>
						<option value='Malik'>Malik</option>

				</select></td>
			</tr>


			<tr>
				<td>Firka Division</td>
				<td><select name="fk" required="required">
						<option value=''>--Select a value--</option>
						<option value='Sunni'>Sunni</option>
						<option value='Sia'>Sia</option>
						<option value='Devband'>Devband</option>
						<option value='AhleHadees'>Ahlehadees</option>
						<option value='Tablig'>Tablig</option>

				</select></td>
			</tr>

			<tr>
				<td>State</td>
				<td><input type="text" name="st" placeholder="State"></td>
			</tr>

			<tr>
				<td>Country</td>
				<td><input type="text" name="con" placeholder="Country"></td>
			</tr>

			<tr>
				<td align="left">Marital Status</td>
				<td align="left"><input type='radio' name='mt' value='Single'
					checked>Single &nbsp;&nbsp; <input type='radio' name='mt'
					value='Married'>Married</td>
			</tr>

			<tr>
				<td>Height</td>
				<td><input type="text" name="height" required="required" placeholder="Height(inch)"></td>
			</tr>

			<tr>
				<td>Weight</td>
				<td><input type="text" name="weight"  required="required" placeholder="Weight(kg)"></td>
			</tr>


			<tr>
				<td></td>
				<td><input type='submit' value='Submit' /> <input type='reset'
					value='Cancel'></td>
			</tr>
		</table>
	</form>

</body>
</html>