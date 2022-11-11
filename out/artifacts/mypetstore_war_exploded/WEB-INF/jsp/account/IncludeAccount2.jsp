<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes-dynattr.tld" %>
<h3>Account Information</h3>

<table>
    <tr>
        <td>First name:</td>
        <td><label>
            <input type="text" name="firstName" value="${sessionScope.errorAccount.firstName}">
        </label></td>
    </tr>
    <tr>
        <td>Last name:</td>
        <td><label>
            <input type="text" name="lastName" value="${sessionScope.errorAccount.lastName}">
        </label></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><label>
            <input type="text" name="email" value="${sessionScope.errorAccount.email}">
        </label></td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td><label>
            <input type="text" name="phone" value="${sessionScope.errorAccount.phone}">
        </label></td>
    </tr>
    <tr>
        <td>Address 1:</td>
        <td><label>
            <input type="text" name="address1" value="${sessionScope.errorAccount.address1}">
        </label></td>
    </tr>
    <tr>
        <td>Address 2:</td>
        <td><label>
            <input type="text" name="address2" value="${sessionScope.errorAccount.address2}">
        </label></td>
    </tr>
    <tr>
        <td>City:</td>
        <td><label>
            <input type="text" name="city" value="${sessionScope.errorAccount.city}">
        </label></td>
    </tr>
    <tr>
        <td>State:</td>
        <td><label>
            <input type="text" name="state" value="${sessionScope.errorAccount.state}">
        </label></td>
    </tr>
    <tr>
        <td>Zip:</td>
        <td><label>
            <input type="text" name="zip" value="${sessionScope.errorAccount.zip}">
        </label></td>
    </tr>
    <tr>
        <td>Country:</td>
        <td><label>
            <input type="text" name="country" value="${sessionScope.errorAccount.country}">
        </label></td>
    </tr>
</table>

<h3>Profile Information</h3>

<table>
    <tr>
        <td>Language Preference:</td>
        <td>
            <label>
                <select name="languagePreference">
                    <option value="english">English</option>
                    <option value="chinese">Chinese</option>
                </select>
            </label>
        </td>
    </tr>
    <tr>
        <td>Favourite Category:</td>
        <td>
            <label>
                <select name="favouriteCategoryId">
                    <option value="FISH">Fish</option>
                    <option value="DOGS">Dogs</option>
                    <option value="REPTILES">Reptiles</option>
                    <option value="CATS">Cats</option>
                    <option value="BIRDS">Birds</option>
                </select>
            </label>
        </td>
    </tr>
    <tr>

        <td>Enable MyList</td>
        <td>
            <label>
                <input type="radio" name="listOption" value="1">yes
                <input type="radio" name="listOption" value="0">no
            </label>
        </td>
    </tr>
    <tr>
        <td>Enable MyBanner</td>
        <td>
            <label>
                <input type="radio" name="bannerOption" value="1">yes
                <input type="radio" name="bannerOption" value="0">no
            </label>
        </td>
    </tr>

</table>


