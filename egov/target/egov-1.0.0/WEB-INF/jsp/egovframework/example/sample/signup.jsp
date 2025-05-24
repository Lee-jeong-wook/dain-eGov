<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사인업</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>사인업</h2>
        <form action="SignupServlet" method="post">
            <div class="input-group">
                <label for="newUsername">아이디</label>
                <input type="text" id="newUsername" name="newUsername" required>
            </div>
            <div class="input-group">
                <label for="newPassword">비밀번호</label>
                <input type="password" id="newPassword" name="newPassword" required>
            </div>
            <div class="input-group">
                <label for="confirmPassword">비밀번호 확인</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>
            </div>
            <button type="submit">사인업</button>
            <p>이미 회원이신가요? <a href="login.jsp">로그인</a></p>
        </form>
    </div>
</body>
</html>
