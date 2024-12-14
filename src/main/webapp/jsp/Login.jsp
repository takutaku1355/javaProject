<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログインページ</title>
    <style>
        /* 全体のレイアウト */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
        }

        /* フォームのレイアウト */
        form {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }

        /* フォームの入力フィールド */
        .form-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 15px;
        }

        .form-group label {
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-group input {
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        /* ボタンのスタイル */
        button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            background-color: #0056b3;
        }

        /* エラーメッセージのスタイル */
        .error-message {
            color: red;
            text-align: center;
            font-weight: bold;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

    <h1 style="text-align: center;">ログインフォーム</h1>
    
    <!-- エラーメッセージ表示 -->
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
        <p class="error-message"><%= errorMessage %></p>
    <%
        }
    %>
    
    <form action="/LyricsWebApp/login" method="post">
        <div class="form-group">
            <label for="username">ユーザー名:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">パスワード:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">ログイン</button>
    </form>
    
    <br>
    <!-- ユーザー画面に遷移するボタン -->
    <form action="User.jsp" method="get">
        <button type="submit">ユーザー画面へ</button>
    </form>
</body>
</html>
