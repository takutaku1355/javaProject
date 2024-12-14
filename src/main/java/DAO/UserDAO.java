package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.DBUtil;

public class UserDAO {

    public boolean insertUser(String name, String email, String password) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            int rows = statement.executeUpdate();
            return rows > 0; // 登録が成功したかどうかを返す
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // エラーが発生した場合は false を返す
        }
    }
}
