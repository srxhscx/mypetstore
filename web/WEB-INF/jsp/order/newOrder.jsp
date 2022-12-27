<%@ include file="../common/top.jsp"%>


<div id="Catalog">
    <!-- 覆盖层 -->
    <div class="login-bg"></div>

    <div class="selectAddress">
        <div class="bar">Please choose a consignee</div>
        <span class="close">x</span>
        <div class="addressItem">
            <div class="address-item active">
                <div id="firstName" class="detail">firstName</div>
                <div id="lastName" class="detail">lastName</div>
                <div id="address1" class="detail">address1</div>
                <div id="address2" class="detail">address2</div>
                <div id="city" class="detail">city</div>
                <div id="state" class="detail">state</div>
                <div id="zip" class="detail">zip</div>
                <div id="country" class="detail">country</div>
                <div class="address-operator">
                    <span class="link">edit</span>
                    <span class="link">delete</span>
                </div>
            </div>
        </div>
        <div class="addressItem">
            <div class="address-item active">
                <div id="firstName" class="detail">firstName</div>
                <div id="lastName" class="detail">lastName</div>
                <div id="address1" class="detail">address1</div>
                <div id="address2" class="detail">address2</div>
                <div id="city" class="detail">city</div>
                <div id="state" class="detail">state</div>
                <div id="zip" class="detail">zip</div>
                <div id="country" class="detail">country</div>
                <div class="address-operator">
                    <span class="link">edit</span>
                    <span class="link">delete</span>
                </div>
            </div>
        </div>
        <div class="addressItem">
            <div class="address-item active">
                <div id="firstName" class="detail">firstName</div>
                <div id="lastName" class="detail">lastName</div>
                <div id="address1" class="detail">address1</div>
                <div id="address2" class="detail">address2</div>
                <div id="city" class="detail">city</div>
                <div id="state" class="detail">state</div>
                <div id="zip" class="detail">zip</div>
                <div id="country" class="detail">country</div>
                <div class="address-operator">
                    <span class="link">edit</span>
                    <span class="link">delete</span>
                </div>
            </div>
        </div>
        <div class="addressItem">
            <div class="address-item active">
                <div id="firstName" class="detail">firstName</div>
                <div id="lastName" class="detail">lastName</div>
                <div id="address1" class="detail">address1</div>
                <div id="address2" class="detail">address2</div>
                <div id="city" class="detail">city</div>
                <div id="state" class="detail">state</div>
                <div id="zip" class="detail">zip</div>
                <div id="country" class="detail">country</div>
                <div class="address-operator">
                    <span class="link">edit</span>
                    <span class="link">delete</span>
                </div>
            </div>
        </div>
        <div class="addressItem">
            <div class="address-item active">
                <div id="firstName" class="detail">firstName</div>
                <div id="lastName" class="detail">lastName</div>
                <div id="address1" class="detail">address1</div>
                <div id="address2" class="detail">address2</div>
                <div id="city" class="detail">city</div>
                <div id="state" class="detail">state</div>
                <div id="zip" class="detail">zip</div>
                <div id="country" class="detail">country</div>
                <div class="address-operator">
                    <span class="link">edit</span>
                    <span class="link">delete</span>
                </div>
            </div>
        </div>
        <div class="addressItem">
            <div class="address-item active">
                <div id="firstName" class="detail">firstName</div>
                <div id="lastName" class="detail">lastName</div>
                <div id="address1" class="detail">address1</div>
                <div id="address2" class="detail">address2</div>
                <div id="city" class="detail">city</div>
                <div id="state" class="detail">state</div>
                <div id="zip" class="detail">zip</div>
                <div id="country" class="detail">country</div>
                <div class="address-operator">
                    <span class="link">edit</span>
                    <span class="link">delete</span>
                </div>
            </div>
        </div>
        <div class="addressItem">
            <div class="address-item active">
                <div id="firstName" class="detail">firstName</div>
                <div id="lastName" class="detail">lastName</div>
                <div id="address1" class="detail">address1</div>
                <div id="address2" class="detail">address2</div>
                <div id="city" class="detail">city</div>
                <div id="state" class="detail">state</div>
                <div id="zip" class="detail">zip</div>
                <div id="country" class="detail">country</div>
                <div class="address-operator">
                    <span class="link">edit</span>
                    <span class="link">delete</span>
                </div>
            </div>
        </div>
        <div class="addressItem">
            <div class="add_address">
                <i class="fa fa-plus"></i>
                <div class="addNew">Add new consignee</div>
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

        <tr>
            <td>First name:</td>
            <td><input type="text" name="order.billToFirstName" value="${sessionScope.order.billToFirstName}"></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><input type="text" name="order.billToLastName" value="${sessionScope.order.billToLastName}"></td>
        </tr>
        <tr>
            <td>Address 1:</td>

            <td><input type="text" size="40" name="order.billAddress1" value="${sessionScope.order.billAddress1}"></td>
        </tr>
        <tr>
            <td>Address 2:</td>
            <td><input type="text" size="40" name="order.billAddress2" value="${sessionScope.order.billAddress2}"></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><input type="text" name="order.billCity" value="${sessionScope.order.billCity}" ></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><input type="text" size="4" name="order.billState" value="${sessionScope.order.billState}"></td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td><input type="text" size="10" name="order.billZip" value="${sessionScope.order.billZip}"></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><input type="text" size="15" name="order.billCountry" value="${sessionScope.order.billCountry}"></td>
        </tr>

        <tr>
            <td colspan=2><input type="checkbox" name="shippingAddressRequired">
                Ship to different address...</td>
        </tr>

    </table>

    <input type="submit" name="newOrder" value="Continue">

</form></div>



<%@ include file="../common/bottom.jsp"%>