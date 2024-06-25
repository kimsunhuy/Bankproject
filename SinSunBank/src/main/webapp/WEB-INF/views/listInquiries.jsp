<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.user}">
    <c:redirect url="${pageContext.request.contextPath}/login.jsp" />
</c:if>
<title>Inquiry List</title>

<h2>My Inquiries</h2>
<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Content</th>
            <th>Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="inquiry" items="${inquiries}">
            <tr>
                <td>${inquiry.title}</td>
                <td>${inquiry.content}</td>
                <td>${inquiry.date}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<button type="button" onclick="history.back()">Back</button>

<%@ include file="/WEB-INF/views/footer.jsp" %>

