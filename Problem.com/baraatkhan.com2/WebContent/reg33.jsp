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
<body bgcolor="white">
	<h1 style="color: red; text-align: center">Personal Details</h1>
	<hr>

	<form  action="reg3" method="post" enctype="multipart/form-data">
		<table border='0' align='center'>

<tr>
                    <td>Add Photo: </td>
                    <td><input type="file" name="photo"/></td>
                </tr>

			<tr>
				<td>Address::</td>
				<td><textarea name='adds' rows="5" cols="10">
              Hyderabad
           </textarea></td>
			</tr>
			
			<tr>
				<td>Qualification</td>
				<td><select name="qlfy">
						<option value=''>--Select a value--</option>
						<option value='engg'>Engg</option>
						<option value='medico'>Medical</option>
						<option value='ug'>UG</option>
						<option value='pg'>PG</option>
						<option value='p.hd'>P.hd</option>
						<option value='commerce'>B.com/M.com</option>
				</select></td>
			</tr>
			<tr>
				<td>Occupation</td>
				<td><select name="occup" multiple size="3">
						<option value='manager'>Manager</option>
						<option value='admin'>Admin</option>
						<option value='Clerk'>Clerk</option>
						<option value='Network'>Network</option>
				</select></td>
			</tr>
			<tr>
				<td>Anmual Income</td>
				<td><select name="income" multiple size="2">
						<option value='10000'>1lpa</option>
						<option value='20000'>2lpa</option>
						<option value='30000'>4lpa</option>
						<option value='30000'>3lpa</option>
				</select></td>
			</tr>

			<tr>
				<td>Hobies</td>
				<td><input type='checkbox' name="hb" value="sleeping">Meditation
					&nbsp;&nbsp; <input type='checkbox' name="hb" value="roaming">Travelling
					<input type='checkbox' name="hb" value="reading" checked>Book
					Reading</td>
			</tr>
			<tr>
			<td></td>
				<td><input type='submit' value='Submit'/>
				<input type='reset' value='Cancel'></td>
			</tr>
		</table>
	</form>

</body>
</html>