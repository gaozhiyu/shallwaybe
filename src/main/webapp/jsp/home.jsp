<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	<script type="text/javascript" src="../js/jquery-1.4.min.js"></script>
	<script type="text/javascript" src="../js/jquery.json-2.4.min.js"></script>
	</head>
	<body>	
<!-- 		<form id="login" name="login" method="post" action="/newWebApp/CoreServlet/login"> -->
			
			<table id="regTable">
				<tbody>
					<tr>
						<td id="name">Name :</td>
					</tr>
					<tr>
						<td id="Email">E-mail :</td>
					</tr>
				</tbody>
			</table>
			<input type="button" id="loginButton" name="loginButton" value="Register" />
		
	</body>
</html>
<script type="text/javascript">
$(function(){
	var url=window.location.href;
	alert(url);
});
</script>