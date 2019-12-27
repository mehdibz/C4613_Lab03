<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">


<%@ page isErrorPage="true" %>

<html lang="en">
	<head>
		<LINK REL=STYLESHEET HREF="mainstyle.css" TYPE="text/css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Error!!!</title>
	</head>
	<body>
		<div id="mainDoc">
		    <div>
		        <h1><%= exception.getMessage() %></h1>
		        <h2><a href="user.jsp">Query Again</a></h2><br>
				<h2><a id="logout" title="Log out" href="logout">Log out</a></h2>
		    </div>
	    </div>
	</body>
</html>