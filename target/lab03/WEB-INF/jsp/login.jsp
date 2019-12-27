<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Welcome</TITLE>
<LINK REL=STYLESHEET
      HREF="mainstyle.css"
      TYPE="text/css">
</HEAD>

<BODY>

<jsp:include page="/WEB-INF/jsp/header.jsp" flush="true" />

<div id="mainDoc">
	<CENTER><img src="images/login.png">
	<br>
	<h1>Login</h1>
	<br> </CENTER>

  <form action="j_security_check" method="POST">
    <table align="center">

	  <tr>
        <td>Username: </td>
        <td>
          <input name="j_username" type="text" value=""></input>
        </td>
      </tr>

      <tr>
        <td>Password: </td>
        <td>
          <input name="j_password" type="password" value=""></input>
        </td>
      </tr>
    </table>

	<CENTER><input name="login" type="submit" value="Login"></input></CENTER>
  </form>

</div>

</BODY>
</HTML>
