<%@ include file="../common/top.jsp"%>

<div id="BackLink">
    <a href="mainForm">Return to Main Menu</a>
</div>

<div id="Catalog">

     <form action="signOn" method="post">
         <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
         <script>
             $(function () {
                 var username = $('#username');
                 var password = $('#password');
                 var captcha = $('#captcha');

                 username.blur(function () {
                     if(username.val() === ""){
                         $('#UMSG').text("please input your name");
                     }else{
                         $('#UMSG').text("");
                     }
                 })

                 password.blur(function () {
                     if(password.val() === ""){
                         $('#PMSG').text("please input your password");
                     }else{
                         $('#PMSG').text("");
                     }
                 })

                 captcha.blur(function () {
                     if(captcha.val() === ""){
                         $('#CMSG').text("please input your captcha");
                     }else{
                         $('#CMSG').text("");
                     }
                 })

                 $('#login').mouseover(function(){
                     if(username.val() !== ""&&password.val() !== ""&&captcha.val() !== ""){
                         $('#login').prop('disabled', false);
                     }else{
                         $('#login').prop('disabled', true);
                     }
                 })
             })
         </script>

         <p>Please enter your username and password.</p>
         <c:if test="${requestScope.signOnMsg!=null}">
             <p id="errorMSG"><font color="red">${requestScope.signOnMsg}</font> </p>
         </c:if>
         <td>
             <label for="username">Username:</label><input type="text" name="username" id="username"><br>
             <font id="UMSG"></font><br>
         </td>
         <td>
             <label for="password">Password:</label><input type="password" name="password" id="password"><br>
             <font id="PMSG"></font><br>
         </td>
         <td>
             <label for="captcha">Captcha:</label><input type="text" name="captcha" id="captcha">
         </td>
         <td>
             <img id="img" src="<%= request.getContextPath()%>/checkcodeServlet"/><br>
             <font id="CMSG"></font><br>
         </td>
         <input type="submit" value="login" id="login">
     </form>

    Need a user name and password?
    <a href="NewAccountForm">Register now</a>

</div>

<%@ include file="../common/bottom.jsp"%>