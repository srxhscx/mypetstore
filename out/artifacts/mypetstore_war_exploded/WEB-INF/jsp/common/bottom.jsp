<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>

<div id="Footer">

    <div id="PoweredBy">&nbsp<a href="http://www.csu.edu.cn">www.csu.edu.cn</a>
    </div>

    <div id="Banner">
        <c:if test="${sessionScope.loginAccount != null }">
            <c:if test="${sessionScope.loginAccount.bannerOption}">
                    ${sessionScope.loginAccount.bannerName}
            </c:if>
        </c:if>
    </div>

</div>
    <script src="js/address.js" type="text/javascript"></script>
    <script src="js/product.js"></script>
    <script src="js/test.js"></script>
<script src="js/mouseEvent.js" type="text/JavaScript"></script>

</body>
</html>