<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Product Details</title>

<h2>Product Details</h2>
<p>Name: ${product.name}</p>
<p>Details: ${product.details}</p>
<p>Interest Rate: ${product.interestRate}</p>

<h3>Interest Calculator</h3>
<form action="calculateInterest" method="post">
    <label for="amount">Amount:</label>
    <input type="number" id="amount" name="amount" required><br>
    <label for="period">Period:</label>
    <input type="number" id="period" name="period" required><br>
    <label for="rate">Interest Rate:</label>
    <input type="number" id="rate" name="rate" value="${product.interestRate}" required readonly><br>
    <label for="compound">Compound:</label>
    <select id="compound" name="compound">
        <option value="simple">Simple</option>
        <option value="monthly">Monthly</option>
    </select><br>
    <button type="submit">Calculate</button>
    <button type="button" onclick="history.back()">Back</button>
</form>

<%@ include file="/WEB-INF/views/footer.jsp" %>

