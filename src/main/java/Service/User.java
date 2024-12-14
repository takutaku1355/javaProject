package Service;

/**
 * Userクラスはユーザー情報を保持するデータモデルです。
 */
public class User {
    private String name;  // ユーザー名
    private String email; // メールアドレス
    private String password; // パスワード

    // コンストラクタ（デフォルト）
    public User() {}

    // GetterとSetter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // デバッグ用のtoStringメソッド
    @Override
    public String toString() {
        return "User [name=" + name + ", email=" + email + "]";
    }
}
