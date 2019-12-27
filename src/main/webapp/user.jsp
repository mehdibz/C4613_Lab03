<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<HTML>
<HEAD>
<TITLE>Using Custom Tags</TITLE>
<LINK REL=STYLESHEET
      HREF="mainstyle.css"
      TYPE="text/css">
</HEAD>

<BODY>

<jsp:include page="/WEB-INF/jsp/header.jsp" flush="true" />


<div id="mainDoc">

<form action = "lab" method = "post">
	<p><H1>Enter the query string.</H1>
      
	<p><input type="text" name="queryInput" value="SELECT * FROM Beatles" size="80" maxlength="80"/><BR><BR>
	<input type="submit" value="Submit" />
	</p>
</form>

</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" flush="true" />

</BODY>
</HTML>