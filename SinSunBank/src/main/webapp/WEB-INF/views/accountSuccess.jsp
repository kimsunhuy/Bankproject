<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Creation Success</title>
</head>
<body>
    <h1>${message}</h1>
    <button onclick="location.href='${pageContext.request.contextPath}/home'">메인페이지로 이동</button>
</body>
</html>
<%@ include file="/WEB-INF/views/footer.jsp" %>
