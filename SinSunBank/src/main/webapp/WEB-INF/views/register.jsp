<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ include file="/WEB-INF/views/footer.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
    <script>
        function execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    document.getElementById('mAdress').value = data.address;
                }
            }).open();
        }

        function sendVerificationCode() {
            const phoneNumber = document.getElementById('mPhone_num').value;
            fetch('${pageContext.request.contextPath}/member/sendVerificationCode', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: new URLSearchParams({ phoneNumber: phoneNumber }),
            })
            .then(response => response.text())
            .then(data => {
                alert(data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
        }

        function checkForm() {
            let f = document.forms['signUpForm'];
            let name = f['mName'].value;
            let id = f['mId'].value;
            let password = f['mPassword'].value;
            let phone = f['mPhone_num'].value;
            let email = f['mEmail'].value;
            let address = f['mAdress'].value;
            let birth = f['mBirth'].value;
            let verificationCode = f['verification_Code'].value;

            const specialChars = /[`~!@#$%^&*()\-_=+{};:'|,.<>\/?]+/g;
            const repeatedChars = /(.)\1{2,}/g;
            const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;

            if (name === '') {
                alert("성함을 입력해주세요.");
                f['mName'].focus();
                return false;
            }

            if (id === '') {
                alert("ID를 입력해주세요.");
                f['mId'].focus();
                return false;
            }

            if (id.length < 4) {
                alert("ID는 4글자 이상으로 만들어주세요.");
                f['mId'].focus();
                return false;
            }

            if (id.indexOf('admin') === 0 || id.indexOf('master') === 0) {
                alert("사용 금지된 단어가 포함되어 있습니다.");
                f['mId'].focus();
                return false;
            }

            if (password === '') {
                alert("비밀번호를 입력해주세요.");
                f['mPassword'].focus();
                return false;
            }

            if (password.length < 8 || !specialChars.test(password)) {
                alert("비밀번호는 최소 8글자 이상, 영문자 + 특수문자의 조합이어야 합니다.");
                f['mPassword'].focus();
                return false;
            }

            if (repeatedChars.test(password)) {
                alert("연속된 문자가 포함될 수 없습니다.");
                f['mPassword'].focus();
                return false;
            }

            if (phone === '') {
                alert("핸드폰 번호를 입력해주세요.");
                f['mPhone_num'].focus();
                return false;
            }

            if (verificationCode === '') {
                alert("인증번호를 입력해주세요.");
                f['verification_Code'].focus();
                return false;
            }

            if (address === '') {
                alert("주소를 입력해주세요.");
                f['mAdress'].focus();
                return false;
            }

            if (email === '' || !emailRegex.test(email)) {
                alert("유효하지 않은 메일주소입니다.");
                f['mEmail'].focus();
                return false;
            }

            if (birth === '') {
                alert("생년월일을 선택해 주세요.");
                f['mBirth'].focus();
                return false;
            }

            return true;
        }

        function checkId() {
            var mId = $('#mId').val();
            $.ajax({
                url: '${pageContext.request.contextPath}/member/checkId',
                type: 'GET',
                data: { mId: mId },
                success: function(response) {
                    if (response) {
                        $('#idCheckResult').text('ID already exists.').css('color', 'red');
                    } else {
                        $('#idCheckResult').text('ID is available.').css('color', 'green');
                    }
                }
            });
        }
    </script>
</head>
<body>
    <h1>Register</h1>
    <form:form name="signUpForm" modelAttribute="member" action="${pageContext.request.contextPath}/member/register" method="post" onsubmit="return checkForm()">
        <form:label path="mName">Name:</form:label>
        <form:input path="mName" required="true" placeholder="성함"/><br/>

        <form:label path="mId">ID:</form:label>
        <form:input path="mId" required="true" placeholder="계정은 4자 이상으로 만들어주세요" onkeyup="checkId()"/><br/>
        <span id="idCheckResult"></span><br/>

        <form:label path="mPassword">Password:</form:label>
        <form:password path="mPassword" required="true" placeholder="영문자,숫자,특수문자 포함 8자이상"/><br/>

        <form:label path="mPhone_num">Phone Number:</form:label>
        <form:input path="mPhone_num" id="mPhone_num" required="true" placeholder="'-' 없이 입력" /><br/>
        <button type="button" onclick="sendVerificationCode()">Send Verification Code</button><br/>

        <form:label path="verification_Code">Verification Code:</form:label>
        <form:input path="verification_Code" id="verification_Code" placeholder="인증코드" /><br/>

        <form:label path="mBirth">Birth Date:</form:label>
        <form:input path="mBirth" required="true" placeholder="yyyy-mm-dd"/><br/>

        <form:label path="mAdress">Address:</form:label>
        <form:input path="mAdress" id="mAdress" required="true" onclick="execDaumPostcode()" placeholder="거주지 주소를 입력해주세요."/>
        <br/>

        <form:label path="mEmail">Email:</form:label>
        <form:input path="mEmail" type="email" required="true" placeholder="example@exam.com"/><br/>

        <input type="submit" value="Register"/>
    </form:form>

    <c:if test="${not empty errorMessage}">
        <div class="error">${errorMessage}</div>
    </c:if>
</body>
</html>
