<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ユーザー登録</title>
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

        /* 戻るボタンのスタイル */
        .back-button {
            width: auto;
            margin: 10px auto;
            display: block;
            background-color: #ccc;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        .back-button:hover {
            background-color: #bbb;
        }
    </style>
</head>
<body>

    <h1 style="text-align: center;">ユーザー登録フォーム</h1>
    <form action="/LyricsWebApp/register" method="post">
        <div class="form-group">
            <label for="name">名前:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="email">メール:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">パスワード:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">登録</button>
    </form>
    
    <!-- 戻るボタン -->
    <button class="back-button" onclick="window.history.back()">戻る</button>

</body>
</html>
