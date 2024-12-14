<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ユーザーホーム</title>
</head>
<body>
    <h1>ログイン成功！</h1>
    <p>ようこそ！</p>
    <form action="/LyricsWebApp/lyrics" method="post">
        <label for="username">曲名:</label>
        <input type="text" id="song" name="song" required><br><br>
        <button type="submit">送信</button>
    </form>
    <a href="Login.jsp">ログアウト</a>
</body>
</html>
