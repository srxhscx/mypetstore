<%@ include file="../common/top.jsp"%>


<div id="Catalog">
    <!-- 覆盖层 -->
    <div class="login-bg"></div>

    <div class="selectAddress">
        <div class="bar">Please choose a consignee</div>
        <span class="close">x</span>
        <div class="selectAddress_list">
            <c:forEach var="consignee" items="${sessionScope.consigneeList}">
                <div class="addressItem chooseItem">
                    <div name="firstName" class="detail">${consignee.firstName}</div>
                    <div name="lastName" class="detail">${consignee.lastName}</div>
                    <div name="address1" class="detail">${consignee.address1}</div>
                    <div name="address2" class="detail">${consignee.address2}</div>
                    <div name="city" class="detail">${consignee.city}</div>
                    <div name="state" class="detail">${consignee.state}</div>
                    <div name="zip" class="detail">${consignee.zip}</div>
                    <div name="country" class="detail">${consignee.country}</div>
                    <div class="address-operator">
                        <span class="link edit_address">edit</span>
                        <span class="link delete_address">delete</span>
                    </div>
                </div>
            </c:forEach>
            <div class="addressItem" id="add_new_consignee">
                <div class="add_address">
                    <i class="fa fa-plus"></i>
                    <div class="addNew">Add new consignee</div>
                </div>
            </div>
            <div class="new_address_detail">
                <span class="tip">Please enter new consignee info</span>
                <%--            <form action="" method="post">--%>
                <ul class="detailList">
                    <li class="item">First name:<input type="text" class="firstname"></li>
                    <li class="item">Last name:<input type="text" class="lastname"></li>
                    <li class="item">Address 1:<input type="text" class="address1"></li>
                    <li class="item">Address 2:<input type="text" class="address2"></li>
                    <li class="item">City:<input type="text" class="city"></li>
                    <li class="item">State:<input type="text" class="state"></li>
                    <li class="item">Zip:<input type="text" class="zip"></li>
                    <li class="item">Country:<input type="text" class="country"></li>
                </ul>

                <button type="submit" id="add">Add new consignee</button>
                <button class="cancel">Cancel</button>
                <%--            </form>--%>
            </div>
        </div>
    </div>


    <form action="conFirmOrderForm" method="post">


    <table>
        <tr>
            <th colspan=2>Payment Details</th>
        </tr>
        <tr>
            <td>Card Type:</td>
            <td>


                <select name="order.cardType" class="select-group">

                        <option value="Visa" selected="selected">Visa</option>
                        <option value="MasterCard">MasterCard</option>
                        <option value="American Express">American Express</option>

                </select>
            </td>
        </tr>
        <tr>
            <td>Card Number:</td>
            <td>
            <input type="text" name="ororder.creditCard">* Use a fake
            number!</td>
        </tr>
        <tr>
            <td>Expiry Date (MM/YYYY):</td>
            <td><input type="text" name="order.expiryDate" value="12/03"></td>
        </tr>
        <tr>
            <th colspan=2>Billing Address <span class="change_address"> switch to other Address</span></th>
        </tr>
<%--收货人信息--%>
        <tr>
            <td>First name:</td>
            <td><input type="text" name="order.billToFirstName" value="${sessionScope.order.billToFirstName}" id="firstName"></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><input type="text" name="order.billToLastName" value="${sessionScope.order.billToLastName}" id="lastName"></td>
        </tr>
        <tr>
            <td>Address 1:</td>

            <td><input type="text" size="40" name="order.billAddress1" value="${sessionScope.order.billAddress1}" id="address1"></td>
        </tr>
        <tr>
            <td>Address 2:</td>
            <td><input type="text" size="40" name="order.billAddress2" value="${sessionScope.order.billAddress2}" id="address2"></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><input type="text" name="order.billCity" value="${sessionScope.order.billCity}" id="city"></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><input type="text" size="4" name="order.billState" value="${sessionScope.order.billState}" id="state"></td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td><input type="text" size="10" name="order.billZip" value="${sessionScope.order.billZip}" id="zip"></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><input type="text" size="15" name="order.billCountry" value="${sessionScope.order.billCountry}" id="country"></td>
        </tr>

        <tr>
            <td colspan=2><input type="checkbox" name="shippingAddressRe