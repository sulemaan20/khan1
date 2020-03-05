
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function validateform() {
		var name = document.myform.name.value;
		var password = document.myform.password.value;
		var mnumber = document.myform.mnumber.value;

		if (name == null || name == "") {
			alert("Name can't be blank");
			return false;
		} else if (name.length < 4) {
			alert("Name Should be more then 4 Chars");
			return false;
		}

		else if (password == null || password == "") {
			alert("Password can't be blank");
			return false;
		}

		else if (password.length < 6) {
			alert("Password must be at least 6 characters long.");
			return false;
		}

		if (isNaN(mnumber) || mnumber.indexOf(" ") != -1) {
			alert("Enter numeric value")
			return false;
		}

		if (mnumber.charAt(0) != "9") {
			alert("it should start with 9 ");
			return false
		}
		if (mnumber.length > 5) {
			alert("enter 5 characters");
			return false;
		}
	}
</script>
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

select[type=course] {
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



<body bgcolor="white" align="center">

	<form name="myform" action="reg1" method="post"
		onsubmit="return validateform()">

		<table align="center">
			<center>
				<h2 style="color: green;">Basic Details Form Page</h2>
				<hr>
			</center>

			<tr>
				<td align="left">Profile For</td>
				<td align="left"><select name="pftype" required="required">
						<option value=''>--Select Profile--</option>
						<option value='Friend'>Friend</option>
						<option value='Self'>Self</option>
						<option value='Son'>Son</option>
						<option value='Brother'>Brother</option>
						<option value='Sister'>Sister</option>
				</select></td>
			</tr>

			<tr>
				<td align="left">Name</td>
				<td align="left"><input type="text" name="name"
					placeholder="Name" /><br /></td>
			</tr>

			<tr>
				<td align="left">DOB</td>
				<td align="left"><input type="date" name="dob" placeholder= /><br /></td>

			</tr>

			<tr>
				<td align="left">Religion</td>
				<td align="left"><select name="religion" required="required">
						<option value=''>--Select Religion--</option>
						<option value='Hindu'>Hindu</option>
						<option value='Muslim'>Muslim</option>
						<option value='Isai'>Isai</option>
						<option value='Shikh'>Shikh</option>
				</select></td>
			</tr>

			<tr>

				<td align="left">Mother Tongue</td>
				<td align="left"><select name="tongue" required="required">
						<option value=''>--Select Tongue--</option>
						<option value='Hindi'>Hindi</option>
						<option value='English'>English</option>
						<option value='Tamil'>Tamil</option>
						<option value='Urdu'>Urdu</option>
						<option value='Telagu'>Telagu</option>
				</select></td>
			</tr>

			<tr>
				<td align="left">Mobile Number</td>
				<td align="left"><input type="text" name="mno"
					required="required" placeholder="Mnumber"></td>
			</tr>

			<tr>
				<td align="left">Gender</td>
				<td align="left"><input type='radio' name='gender' value='M'
					checked>Male &nbsp;&nbsp; <input type='radio' name='gender'
					value='F'>FeMale</td>
			</tr>

			<tr>
				<td align="left">Email id:</td>
				<td align="left"><input type="email" name="email"
					required="required" placeholder="Email id" /><br /></td>
			</tr>

			<tr>
				<td align="left">Password</td>
				<td align="left"><input type="password" name="password"
					required="required" placeholder="Password" /><br /></td>
			</tr>
			<tr>
				<td></td>
				<td><br> <input type="Submit" value="Continue"> <input
					type="reset" value="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>