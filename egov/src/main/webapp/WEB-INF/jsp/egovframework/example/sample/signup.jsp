<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/style.css'/>"/>
    <title>Document</title>
</head>
<body>
<c:if test="${not empty error}">
    <script>
        alert("${error}");
    </script>
</c:if>
<div class="background">
    <form action="addUser.do">
        <div class="login-main-wrapper">
            <div class="login-top-section">
                <h2>회원가입</h2>
            </div>
            <div class="login-main-section">
                <div class="login-input-wrapper">
                    <div class="login-input login-id">
                        <input type="text" id="id" name="id" required>
                        <label for="id" id="id-label">아이디</label>
                    </div>
                    <div class="login-input login-pw">
                        <input id="pw" name="pw" type="password" required>
                        <label for="pw" id="pw-label">비밀번호</label>
                    </div>
                    <div class="login-input login-name">
                        <input type="text" id="name" name="name" required>
                        <label for="pw" id="name-label">이름</label>
                    </div>
                </div>
                <a href="/egov_war/login.do">로그인</a>
            </div>
            <div class="login-bottom-section">
                <button class="login-button">
                    회원가입
                </button>
            </div>
        </div>
    </form>
</div>
</body>
<script type="module" src="./js/client.js"></script>
</html>