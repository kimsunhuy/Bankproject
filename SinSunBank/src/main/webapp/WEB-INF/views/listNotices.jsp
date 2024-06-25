<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Notice List</title>

<h2>Notices</h2>
<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Content</th>
            <th>Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="notice" items="${notices}">
            <tr>
                <td>${notice.title}</td>
                <td>${notice.content}</td>
                <td>${notice.date}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<button type="button" onclick="history.back()">Back</button>

<%@ include file="/WEB-INF/views/footer.jsp" %>


