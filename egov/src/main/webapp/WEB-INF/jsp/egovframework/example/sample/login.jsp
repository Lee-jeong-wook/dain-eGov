<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
</head>
<body>
    <div class="container">
        <h2>로그인</h2>
        <form id="loginForm" action="getUser.do">
            <div class="input-group">
                <label for="id">아이디</label>
                <input type="text" id="username" name="id" required>
            </div>
            <div class="input-group">
                <label for="password">비밀번호</label>
                <input type="password" id="pw" name="pw" required>
            </div>
            <button type="submit">로그인</button>
            <p>회원이 아니신가요? <a href="signup.jsp">사인업</a></p>
        </form>
    </div>
</body>
</html>
