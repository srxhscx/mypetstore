<%@ include file="../common/top.jsp"%>
<link rel="stylesheet" href=css/loginon.css>

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
                    <input type="password" value="${sessionScope.loginAccount.password}" name="repeatPassword">
                </td>
            </tr>

        </table>

        <%@ include file="IncludeAccount.jsp"%>

        <input type="submit" value="Save Account Information">

    </form>

    <a href="">My Orders</a>
    此处加一下购物车的链接
<%--        <stripes:link--%>
<%--        beanclass="org.mybatis.jpetstore.web.actions.OrderActionBean"--%>
<%--        event="listOrders">My Orders</stripes:link></div>--%>

<%@ include file="../common/bottom.jsp"%>