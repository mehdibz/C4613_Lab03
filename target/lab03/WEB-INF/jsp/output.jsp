<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<%@page import="ca.bcit.comp4613.dao.DBBean"%>
<%@page import="java.util.Vector"%>
<HTML>
<HEAD>
<TITLE>Lab09 Select Query Results</TITLE>
<LINK REL=STYLESHEET
      HREF="mainstyle.css"
      TYPE="text/css">
</HEAD>

<BODY>

<div id="mainDoc">

<%@ page errorPage="WEB-INF/jsp/error.jsp"%>



<h2><a href="user.jsp">Query Again</a></h2><br>
<h2><a id="logout" title="Log out" href="logout">Log out</a></h2>
<TABLE border="1">
	
	<TR>
	<%
		DBBean db = (DBBean) request.getSession().getAttribute("db");
		for ( String col: db.getColumnNames() )
		{
			out.println( "<th>" + col + "</th>" );
		}
		
		System.out.println (db.getResults());
		for ( Vector<String> row: db.getResults() )
		{
			out.println("<TR>");
			for (String data: row ){
				out.println( "<TD>" + data + "</TD>");
			}
			out.println("</TR>");
		}
		
	 %>
	 </TR>
  
</TABLE>

</div>
</BODY>
</HTML>