<!DOCTYPE HTML>

<HTML>
<HEAD>
<TITLE>Guest Page</TITLE>
<LINK REL=STYLESHEET
      HREF="mainstyle.css"
      TYPE="text/css">
</HEAD>

<BODY>

<jsp:include page="/WEB-INF/jsp/header.jsp" flush="true" />


<div id="mainDoc">

<H2>Hello!<br>
			Your's is only a trial membership. You are welcome, but not<br>
			allowed database access until you have paid your membership dues.</H2>
			<p>
			<H2><a id="logout" title="Log out" href="logout">Log out</a></H2>

</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" flush="true" />

</BODY>
</HTML>