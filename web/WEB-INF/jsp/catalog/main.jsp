<%@ include file="../common/top.jsp"%>

<div id="Welcome">
    <div id="WelcomeContent">
        <c:if
                test="${sessionScope.accountBean != null }">
            <c:if test="${sessionScope.accountBean.authenticated}">
                Welcome ${sessionScope.accountBean.account.firstName}!
            </c:if>
        </c:if>
    </div>
</div>

<div id="RollingPicture">
    <div id="container">
        <div id="photo">
            <a href="categoryForm?categoryId=CATS"><img src="images/main1.jpg" /></a>
            <a href="categoryForm?categoryId=DOGS"><img src="images/main2.jpg" /></a>
            <a href="categoryForm?categoryId=BIRDS"><img src="images/main3.jpg" /></a>
            <a href="categoryForm?categoryId=CATS"><img src="images/main1.jpg" /></a>
        </div>
    </div>
</div>
<br />
<br />
<br />

<center><h1>Recommended information</h1></center>
<br />



<div id="card1">
    <a href="itemForm?itemId=EST-5"	><img src="images/card1.jpeg"></a>
    <h2>learn EST-5</h2>
</div>
<div id="card2">
    <a href="itemForm?itemId=EST-15"	><img src="images/card2.jpeg"></a>
    <h2>learn EST-15</h2>
</div>
<div id="card3">
    <a href="itemForm?itemId=EST-13"	><img src="images/card3.jpeg"></a>
    <h2>learn EST-13</h2>
</div>
<div id="card4">
    <a href="itemForm?itemId=EST-6"	><img src="images/card4.jpeg"></a>
    <h2>learn EST-6</h2>
</div>







<%@ include file="../common/bottom.jsp"%>
