package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.LoginDAO;
import Service.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public LoginServlet() {
        super();
    }

    /**
     * POSTリクエストを処理
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータからユーザー名とパスワードを取得
    	User user = new User();
    	user.setName(request.getParameter("username"));
    	user.setPassword(request.getParameter("password"));
    	
    	try {
            LoginDAO loginDAO = new LoginDAO();
            boolean isAuthenticated = loginDAO.LoginUser(user.getName(), user.getPassword());

            if (isAuthenticated) {
                // ログイン成功時、ホームページにリダイレクト
                response.sendRedirect("jsp/UserHome.jsp");
            } else {
                // ログイン失敗時、エラーメッセージをリクエストスコープに設定
                request.setAttribute("errorMessage", "ユーザー名またはパスワードが正しくありません。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "エラーが発生しました。");
        }
    }
}
