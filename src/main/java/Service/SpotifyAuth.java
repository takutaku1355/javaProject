package Service;

import java.util.Base64;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SpotifyAuth {

    private static final String CLIENT_ID = "b918c526e8c34252bcba0a06bc1b1fb7"; // 取得したClient ID
    private static final String CLIENT_SECRET = "41318d7e93634b2b9a4b368cae474844"; // 取得したClient Secret
    private static final String TOKEN_URL = "https://accounts.spotify.com/api/token";

    public static String getAccessToken() throws Exception {
        // Base64でClient IDとSecretをエンコード
        String credentials = CLIENT_ID + ":" + CLIENT_SECRET;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        // HttpClientを作成
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(TOKEN_URL);

        // Authorizationヘッダー追加
        httpPost.setHeader("Authorization", "Basic " + encodedCredentials);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

        // リクエストボディ追加
        StringEntity entity = new StringEntity("grant_type=client_credentials");
        httpPost.setEntity(entity);

        // リクエスト送信
        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("Response: " + responseBody);

            // トークンを返す
            return responseBody.split("\"access_token\":\"")[1].split("\"")[0];
        }
    }

    public static void main(String[] args) throws Exception {
        String token = getAccessToken();
        System.out.println("Access Token: " + token);
    }
}
