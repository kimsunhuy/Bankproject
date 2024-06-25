<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.userId}">
    <c:redirect url="${pageContext.request.contextPath}/members/login.jsp" />
</c:if>
<title>Transfer</title>

<body>
    <h1>이체</h1>
    <form action="/transaction/transfer" method="post">
        출금 계좌 아이디: <input type="text" name="fromAccountId" required><br>
        입금 계좌 아이디: <input type="text" name="toAccountId" required><br>
        금액: <input type="number" name="amount" required><br>
        계좌 비밀번호: <input type="password" name="accountPassword" required><br>
        <button type="submit">이체</button>
    </form>
    <c:if test="${not empty message}">
        <div style="color: green;">${message}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>
</body>

<%@ include file="/WEB-INF/views/footer.jsp" %>


