<%@ include file="../common/top.jsp"%>

<div id="Catalog">
    <form id="RegistForm" action="NewAccount" method="post">
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
        <c:if test="${requestScope.NewAccountMSG != null}">
            <p><font color="red">${requestScope.NewAccountMSG}</font></p>
        </c:if>
        <h3>User Information</h3>
        <table>
            <tr>
                <td>User ID:</td>
                <td><label>
                    <input id="username" type="text" name="username" value="${sessionScope.errorAccount.username}">
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

        <input id="RegistButtun" type="submit" name="newAccount">

    </form>

    </div>

    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
        $("#RegistForm").blur(function () {

        })
    </script>

<%@ include file="../common/bottom.jsp"%>