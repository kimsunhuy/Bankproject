<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>입출금</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>입출금</h1>
    <form id="transactionForm">
        <label for="accountNumber">계좌번호:</label>
        <input type="text" id="accountNumber" name="accountNumber" required><br>
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="amount">금액:</label>
        <input type="number" id="amount" name="amount" required><br>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br>
        <button type="button" onclick="deposit()">입금</button>
        <button type="button" onclick="withdraw()">출금</button>
    </form>
    <div id="result"></div>
    <script>
        function deposit() {
            $.ajax({
                url: '<c:url value="/transactions/deposit" />',
                type: 'POST',
                data: {
                    accountNumber: $('#accountNumber').val(),
                    amount: $('#amount').val(),
                    name: $('#name').val(),
                    password: $('#password').val()
                },
                success: function(response) {
                    $('#result').text(response);
                },
                error: function(xhr, status, error) {
                    $('#result').text('오류: ' + error);
                }
            });
        }

        function withdraw() {
            $.ajax({
                url: '<c:url value="/transactions/withdraw" />',
                type: 'POST',
                data: {
                    accountNumber: $('#accountNumber').val(),
                    amount: $('#amount').val(),
                    name: $('#name').val(),
                    password: $('#password').val()
                },
                success: function(response) {
                    $('#result').text(response);
                },
                error: function(xhr, status, error) {
                    $('#result').text('오류: ' + error);
                }
            });
        }
    </script>
<%@ include file="footer.jsp" %>
</body>
</html>
