package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import Service.User;

@WebServlet("/register")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	User user = new User();
    	user.setName(request.getParameter("name"));
    	user.setEmail(request.getParameter("email"));
    	user.setPassword(request.getParameter("password"));

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        try {
            UserDAO userDAO = new UserDAO();
            boolean isInserted = userDAO.insertUser(user.getName(), user.getEmail(), user.getPassword());

            // リクエストスコープにメッセージを設定
            if (isInserted) {
                request.setAttribute("message", "ユーザー登録が成功しました！");
                request.setAttribute("name", user.getName());
                request.setAttribute("email", user.getEmail());
                request.setAttribute("password", user.getPassword());
            } else {
                request.setAttribute("message", "ユーザー登録に失敗しました。");
            }

            // UserComplete.jsp にフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/UserComplete.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "エラーが発生しました: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/UserComplete.jsp");
            dispatcher.forward(request, response);
        }
    }
}
