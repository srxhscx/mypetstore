<%@ include file="../common/top.jsp"%>
<link rel="stylesheet" href="css/mouseEventInform.css" type="text/css">
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
            <a href="categoryForm?categoryId=CATS" ><img src="images/main1.jpg" /></a>
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

<div id="card1" >
    <div id="inform2" style="display: none">
        <ul>
            <li>productid : FI-FW-01</li>
            <li>listprice : 18.50</li>
            <li>unitcost : 12.00</li>
            <li>attr1 : Spotless</li>
        </ul>
    </div>
    <a href="itemForm?itemId=EST-5"	><img src="images/card1.jpeg" onmouseover="processResponse2()" onmouseout="processResponse22()"></a>
    <h2>learn EST-5</h2>
</div>


<div id="card2">
    <div id="inform" style="display: none">
        <ul>
            <li>productid : FL-DSH-01</li>
            <li>listprice : 23.50</li>
            <li>unitcost : 12.00</li>
            <li>attr1 : With tail</li>
        </ul>
    </div>
    <a href="itemForm?itemId=EST-15"><img src="images/card2.jpeg" onmouseover="processResponse()" onmouseout="processResponse1()"></a>
    <h2>learn EST-15</h2>
</div>


<div id="card3">
    <div id="info3" style="display: none">
        <ul>
            <li>productid : RP-LI-02</li>
            <li>listprice : 18.50</li>
            <li>unitcost : 12.00</li>
            <li>attr1 : Green Adult</li>
        </ul>
    </div>
    <a href="itemForm?itemId=EST-13"><img src="images/card3.jpeg" onmouseover="show3()" onmouseout="show33()"></a>
    <h2>learn EST-13</h2>
</div>


<div id="card4">
    <div id="info4" style="display: none">
        <ul>
            <li>productid : K9-BD-01</li>
            <li>listprice : 18.50</li>
            <li>unitcost : 12.00</li>
            <li>attr1 : Male Adult</li>
        </ul>
    </div>
    <a href="itemForm?itemId=EST-6"	><img src="images/card4.jpeg" onmouseover="processResponse4()" onmouseout="processResponse44()"></a>
    <h2>learn EST-6</h2>
</div>
<script src="js/mouseEvent.js" type="text/JavaScript"></script>





<%@ include file="../common/bottom.jsp"%>
