<%@ include file="../common/top.jsp"%>


     <div id="content-3">
     			<div id="login_form">
     				<div class="login_title">
     					welcome
     				</div>
     				<form action="signOn"method="post" >
     				<c:if test="${requestScope.signOnMsg!=null}">
                                 <p><font color="red">${requestScope.signOnMsg}</font> </p>
                             </c:if>
     					<div id="login_content">
     					<br>
     					<div><img src="images/user.png" class="icon_btn"></div>
     					<input type="text" placeholder="user id" name="username" class="text"/>
     					<br>
     					<div><img src="images/password.png" class="icon_btn"></div>
     					<input type="password" placeholder="password " name="password" class="text"/>
     					<br>
     					<div><img src="<%= request.getContextPath()%>/checkcodeServlet" class="icon_btn"></div>
     					<input type="text" placeholder="type what you see " name="vcode" id="vcode" />
     					<img  id="icode" src="" style="margin-top: -10%; margin-left: 55%;" />
     					<div id="login_passwd">
     						<a href="#">forget your password ?</a>
     					</div>
     					<input  type="submit" value="login on" class="btn" >
     					<br>
     					<div id="login_copyright">
     						 csu ed
     						 </div>
     					</div>
     				</form>
     			</div>
     		</div>

    Need a user name and password?
    <a href="NewAccountForm">Register now</a>

<div id="BackLink">
    <a href="mainForm">Return to Main Menu</a>
</div>



<%@ include file="../common/bottom.jsp"%>
