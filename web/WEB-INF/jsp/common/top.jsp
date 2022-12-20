<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html >

<html >

<head>
    <title>MyPetStore</title>
    <link rel="StyleSheet" href="css/mypetstore.css" type="text/css" media="screen" />
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>

<body>

    <div id="Header">
        <div id="Logo">
            <div id="LogoContent">
            <a href="mainForm" ><img src="images/logo-topbar.gif" /></a>
            </div>
        </div>

        <div id="Menu">
            <div id="MenuContent">
                <a href="cartForm"> <img align="middle" name="img_cart" src="images/cart.gif" /></a>
                <img align="middle" src="images/separator.gif" />
                <c:if test="${sessionScope.loginAccount==null}">
                    <a href="signonForm">Sign In</a>
                    <img align="middle" src="images/separator.gif" />
                </c:if>
                <c:if test="${sessionScope.loginAccount!=null}">
                    <a href="signOut">Sign Out</a>
                    <img align="middle" src="images/separator.gif" />
                    <a href="editeAccountForm">My Account</a>
                    <img align="middle" src="images/separator.gif" />
                </c:if>
                <a href="help.html">?</a>
            </div>
        </div>

        <div id="Search">
            <div id="SearchContent">
                <form action="" method="post">
                    <input type="text" name=name="keyword" size="14" class="input-search" id="keyword" autocomplete="false"/>
                    <input type="submit" value="Search" class="button-search"/>
                </form>
                <div id="selectedId" ><ul id="drop"></ul></div>
            </div>
        </div>

        <div id="QuickLinks">
            <br /> <br /> <br /> <br /><br />
            <a href="categoryForm?categoryId=FISH" ><img src="images/sm_fish.gif" /></a>&nbsp&nbsp&nbsp&nbsp
            <img src="images/separator.gif" />&nbsp&nbsp&nbsp&nbsp
            <a href="categoryForm?categoryId=DOGS"> <img src="images/sm_dogs.gif" /></a>&nbsp&nbsp&nbsp&nbsp
            <img src="images/separator.gif" />&nbsp&nbsp&nbsp&nbsp
            <a href="categoryForm?categoryId=REPTILES"> <img src="images/sm_reptiles.gif" /></a>&nbsp&nbsp&nbsp&nbsp
            <img src="images/separator.gif" />&nbsp&nbsp&nbsp&nbsp
            <a href="categoryForm?categoryId=CATS"> <img src="images/sm_cats.gif" /></a>&nbsp&nbsp&nbsp&nbsp
            <img src="images/separator.gif" />&nbsp&nbsp&nbsp&nbsp
            <a href="categoryForm?categoryId=BIRDS"> <img src="images/sm_birds.gif" /></a>&nbsp&nbsp&nbsp
            <img src="images/separator.gif" /><br />
        </div>


<div id="Content">


