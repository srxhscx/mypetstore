<%@ include file="../common/top.jsp"%>

<div id="Catalog">
    <form action="editeAccount" method="post">

        <c:if test="${requestScope.errorMSG != null}">
            <p><font color="red">${requestScope.errorMSG}</font></p>
        </c:if>

            <h3>User Information</h3>


        <table>

            <tr>
                <td>User ID:</td>
                <td>
                    <input type="text" value="${sessionScope.loginAccount.username}" name="username">
                </td>
            </tr>

            <tr>
                <td>New password:</td>
                <td>
                    <input type="password" value="${sessionScope.loginAccount.password}" name="password">
                </td>
            </tr>

            <tr>
                <td>Repeat password:</td>
                <td>
                    <input type="password" value="${sessionScope.loginAccount.repeatedPassword}" name="repeatPassword">
                </td>
            </tr>

        </table>

        <%@ include file="IncludeAccount.jsp"%>

        <input type="submit" value="Save Account Information">

    </form>

<%@ include file="../common/bottom.jsp"%>