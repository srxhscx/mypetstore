<%@ include file="../common/top.jsp"%>

<div id="Catalog">
    <form action="NewAccount" method="post">
        <c:if test="${requestScope.NewAccountMSG != null}">
            <p><font color="red">${requestScope.NewAccountMSG}</font></p>
        </c:if>
        <h3>User Information</h3>
        <table>
            <tr>
                <td>User ID:</td>
                <td><label>
                    <input type="text" name="username" value="${sessionScope.errorAccount.username}">
                </label></td>
            </tr>
            <tr>
                <td>New password:</td>
                <td><label>
                    <input type="password" name="password" value="${sessionScope.errorAccount.password}">
                </label></td>
            </tr>
            <tr>
                <td>Repeat password:</td>
                <td><label>
                    <input type="password" name="repeatedPassword" value="${sessionScope.errorAccount.repeatedPassword}">
                </label></td>
            </tr>
        </table>

    <%@ include file="IncludeAccount2.jsp"%>

            <tr>
                <td>Email captcha:</td>
                <td>
                    <label>
                        <input type="text" name="emailCaptcha">
                    </label><br>
                </td>
                <td>
                    <button formaction="Email" formmethod="post"><font>get Email</font></button>
                </td>
            </tr>

        <input type="submit" name="newAccount">

    </form>
</div>

<%@ include file="../common/bottom.jsp"%>