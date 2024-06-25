<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.userId}">
    <c:redirect url="${pageContext.request.contextPath}/members/login" />
</c:if>
<title>Account List</title>

<h2>My Accounts</h2>
<table>
    <thead>
        <tr>
            <th>계좌번호</th>
            <th>계좌별칭</th>
            <th>잔액</th>
            <th>계좌타입</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="account" items="${accounts}">
            <tr>
                <td>${account.acNumber}</td>
                <td>${account.acName}</td>
                <td>${account.acBalance}</td>
                <td>${account.acType }</td>
            </tr>
        </c:forEach>
        
        <div style="margin-top: 20px;">
        <form action="${pageContext.request.contextPath}/accounts/create" method="get">
            <button type="submit">신규 계좌 생성</button>
        </form>
    </div>
    </tbody>
</table>

<button type="button" onclick="history.back()">Back</button>

<%@ include file="/WEB-INF/views/footer.jsp" %>

