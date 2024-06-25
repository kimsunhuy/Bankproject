<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty sessionScope.userId}">
    <c:redirect url="${pageContext.request.contextPath}/members/login" />
</c:if>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
    <script type="text/javascript">
        function showAccountDetails() {
            var accountType = document.getElementById("accountType").value;
            var details = {
                "1": "신규계좌 생성시 기본으로 가입되는 상품입니다. 금리: 0.1%, 가입기간: 1년",
                "2": "가입기간 : 최대 3개월 / 가입금액 최대 10억원 / 중도해지 절대불가. 금리: 2%",
                "3": "가입기간 12개월 중 선택 / 최소 50만원 ~ 최대 1억원. 금리: 3.8%",
                "4": "가입제한 2024년도 기준 만 18세~ 39세. 금리: 8%",
                "5": "가입금액 월 최대 500만원 한도. 금리: 5%",
                "6": "가입금액 월 100만원 고정. 금리: 10%"
            };
            document.getElementById("accountDetails").innerText = details[accountType] || "계좌 상품을 선택해주세요.";
            document.getElementById("selectedProduct").value = accountType;
        }

        window.onload = function() {
            showAccountDetails();
        };
    </script>
</head>
<body>
    <h1>Create New Account</h1>
    <form action="${pageContext.request.contextPath}/accounts/createAccount" method="post">
        <div>
            <label for="accountType">Select Account Type:</label>
            <select name="accountType" id="accountType" onchange="showAccountDetails()">
                <option value="1">신선 편한 입출금 예금</option>
                <option value="2">신선 쇼킹파킹 예금</option>
                <option value="3">신선 플러스 정기예금</option>
                <option value="4">신선 청년 퍼스트 적금</option>
                <option value="5">신선 반갑다 목돈아</option>
                <option value="6">신선 빅뱅 적금</option>
            </select>
        </div>

        <div id="accountDetails" style="margin-top: 20px;">
            <!-- 계좌 상세 정보가 여기 표시됩니다 -->
        </div>

        <input type="hidden" name="product" id="selectedProduct" value="">

        <div style="margin-top: 20px;">
            <label for="alias">Account Alias:</label>
            <input type="text" id="alias" name="alias" required>
        </div>
        <div>
            <label for="password">Account Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>

        <button type="submit" style="margin-top: 20px;">Create Account</button>
    </form>
</body>
</html>

<%@ include file="/WEB-INF/views/footer.jsp" %>
