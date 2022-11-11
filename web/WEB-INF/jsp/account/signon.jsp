<%@ include file="../common/top.jsp"%>
<link rel="stylesheet" href=css/loginon.css>


<div id="Catalog">
<section>

    <div id="color"></div>
    <div id="color"></div>
    <div id="color"></div>
    <div id="box">
        <!--背景圆-->
        <div id="circlre" style="--x:0"></div>
        <div id="circlre" style="--x:1"></div>
        <div id="circlre" style="--x:2"></div>
        <div id="circlre" style="--x:3"></div>
        <div id="circlre" style="--x:4"></div>


        <div id="container">
            <div id="form">
                <h2>login</h2>
                 <form action="signOn" method="post">
                   <p>Please enter your username and password.</p>
                       <c:if test="${requestScope.signOnMsg!=null}">
                            <p><font color="red">${requestScope.signOnMsg}</font> </p>
                       </c:if>
                              <td>
                              Username:<div id="inputBox"><input type="text" name="username"></div><br>
                              </td>
                              <td>
                              Password:<div id="inputBox"><input type="password" name="password"></div><br>
                             </td>
                             <td>
                             Captcha:<div id="inputBox"><input type="text" name="captcha"></div>
                             </td>
                             <td>
                             <img id="img" src="<%= request.getContextPath()%>/checkcodeServlet"/><br>
                             </td>
                               </p>
                               <div id="inputBox">
                              <input type="submit" value="login on">
                              </div>
                 </form>

            </div>
        </div>
<p id="forget">
    Need a user name and password?
    <a href="NewAccountForm">Register now</a>
</p>
<span style="text-align: center">${msg}</span>

</div>
</section>
<div id="BackLink">
    <a href="mainForm">Return to Main Menu</a>
</div>


<%@ include file="../common/bottom.jsp"%>
