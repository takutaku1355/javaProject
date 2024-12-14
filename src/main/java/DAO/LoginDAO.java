package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.DBUtil;

public class LoginDAO {
	
	public boolean LoginUser(String name, String password) {
        String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setString(1, name);
            statement.setString(2, password);
            
            // クエリを実行
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // 一致する行があれば認証成功
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
}
