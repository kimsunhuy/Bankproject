<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Product List</title>

<h2>Products</h2>
<table>
    <thead>
        <tr>
        	<th>No</th>
            <th>Name</th>
            <th>Details</th>
            <th>Interest Rate</th>
            <th>Duration</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${deposits}" var="deposit">
            <tr>
            	<td>${deposit.dsType }</td>
                <td>${deposit.dsName}</td>
                <td>${deposit.dsDetail}</td>
                <td>${deposit.dsInterest}</td>
                <td>${deposit.dsDuration }</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<button type="button" onclick="history.back()">Back</button>

<%@ include file="/WEB-INF/views/footer.jsp" %>
