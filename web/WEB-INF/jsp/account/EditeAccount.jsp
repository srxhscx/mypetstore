<%@ include file="../common/top.jsp"%>

<div id="Catalog">
    <form action="editeAccount" method="post">

        <c:if test="${requestScope.errorMSG != null}">
            <p><font color="red">${requestScope.errorMSG}</font></p>
        </c:if>

            <h3>User Information</h3>

        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
        <script>
            $(function () {
                var username = $('#username');

                username.on('blur',function () {
                    if(username.val()===''){
                        console.log("ok?");
                    }else{
                        console.log("???");
                        $.ajax({
                            type    :'POST',
                            url     :'check?username='+username.val(),
                            // data    :{"username":username.val()},
                            success :function (data) {
                                if(data.name === 'name') {
                                        username.val("repeated username");
                                }
                                console.log(data.name);
                                console.log("success")
                            },
                            error   :function () {
                                console.log("error");
                            }
                        });
                    }
                })
            })
        </script>
        <table>

            <tr>
                <td>User ID:</td>
                <td>
                    <input type="text" value="${sessionScope.loginAccount.username}" name="username" id="username">
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