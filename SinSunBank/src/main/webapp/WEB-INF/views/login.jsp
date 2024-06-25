<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<title>Login</title>

<body>
    <h1>로그인</h1>
    <form action="${pageContext.request.contextPath}/members/login" method="post">
        아이디: <input type="text" name="username" required><br>
        비밀번호: <input type="password" name="password" required><br>
        <button type="submit">로그인</button>
    </form>
    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>
</body>

<%@ include file="/WEB-INF/views/footer.jsp" %>


