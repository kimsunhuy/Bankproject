<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:out value="${title}" /></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <header>
        <h1>SinSun Bank</h1>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/members/home">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/deposits/list">Products</a></li>
                <li><a href="${pageContext.request.contextPath}/notices/list">Notices</a></li>
                <c:choose>
                    <c:when test="${not empty sessionScope.userId}">
                        <li><a href="${pageContext.request.contextPath}/accounts/${sessionScope.userId}">My Accounts</a></li>
                        <li><a href="${pageContext.request.contextPath}/transactions/details/${sessionScope.userId}">Transaction History</a></li>
                        <li><a href="${pageContext.request.contextPath}/members/profile">Profile</a></li>
                        <li><a href="${pageContext.request.contextPath}/transactions/transfer">Transfer</a></li>
                        <li><a href="${pageContext.request.contextPath}/transactions/depositWithdraw">입출금</a></li>
                        <li><a href="${pageContext.request.contextPath}/members/logout">Logout</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/members/register">Register</a></li>
                        <li><a href="${pageContext.request.contextPath}/members/login">Login</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
    </header>
    <main>
