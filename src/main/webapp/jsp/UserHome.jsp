<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ユーザーホーム</title>
    <style>
        /* 全体のレイアウト */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            text-align: center;
        }

        /* フォームのレイアウト */
        form {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            text-align: left;
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

        /* ログアウトリンクのスタイル */
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #ccc;
            border-radius: 5px;
            text-decoration: none;
            color: black;
        }

        a:hover {
            background-color: #bbb;
        }
    </style>
</head>
<body>
    <form action="/LyricsWebApp/lyrics" method="post">
        <div class="form-group">
            <label for="song">曲名:</label>
            <input type="text" id="song" name="song" required>
        </div>
        <button type="submit">送信</button>
    </form>
    <a href="Login.jsp">ログアウト</a>
</body>
</html>
