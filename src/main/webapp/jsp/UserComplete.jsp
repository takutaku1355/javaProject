<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登録完了</title>
</head>
<body>
    <h1>登録結果</h1>
    <p><%= request.getAttribute("message") %></p>

    <% if (request.getAttribute("name") != null && request.getAttribute("email") != null && request.getAttribute("password") != null) { %>
        <p>登録名: <%= request.getAttribute("name") %></p>
        <p>メールアドレス: <%= request.getAttribute("email") %></p>
        <p>パスワード: <%= request.getAttribute("password") %></p>
    <% } %>

    <a href="./jsp/Login.jsp">ログイン画面に戻る</a>
</body>
</html>
