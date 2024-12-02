<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agreement</title>
</head>
<body>
    <h1>Account Creation Agreement</h1>
    <form action="${pageContext.request.contextPath}/accounts/createAccountStep2" method="post">
        <div>
            <h3>Privacy Policy Agreement</h3>
            <h3>정책에 동의하십시오.</h3>
            <label><input type="checkbox" name="privacyAgreement" value="agree"> I agree to the privacy policy</label>
        </div>
        <div>
            <h3>Account Opening Policy Agreement</h3>
            <label><input type="checkbox" name="accountPolicyAgreement" value="agree"> I agree to the account opening policy</label>
        </div>
        <button type="submit">Next</button>
    </form>
</body>
</html>
<%@ include file="/WEB-INF/views/footer.jsp" %>
