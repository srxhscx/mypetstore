<%@ include file="../common/top.jsp"%>

<div id="BackLink">
    <a href="mainForm">Return to Main Menu</a>
</div>

<div id="Catalog">

     <form action="signOn" method="post">
         <p>Please enter your username and password.</p>
         <c:if test="${requestScope.signOnMsg!=null}">
             <p><font color="red">${requestScope.signOnMsg}</font> </p>
         </c:if>
         <p>
             Username:<input type="text" name="username"> <br />
             Password:<input type="password" name="password">
         </p>
         <input type="submit" value="login">
     </form>

    Need a user name and password?
    <a href="registerform">Register now</a>

</div>

<%@ include file="../common/bottom.jsp"%>