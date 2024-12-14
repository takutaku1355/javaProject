package Service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SpotifyTrackSearch {

    private static final String SEARCH_URL = "https://api.spotify.com/v1/search";

    public static void searchTrack(String trackName, String accessToken) throws Exception {
        // HttpClientを作成
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 曲名をエンコードしてURLに追加
        String url = SEARCH_URL + "?q=" + trackName.replace(" ", "%20") + "&type=track&limit=1";
        HttpGet httpGet = new HttpGet(url);

        // Authorizationヘッダー追加
        httpGet.setHeader("Authorization", "Bearer " + accessToken);

        // リクエスト送信
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            String responseBody = EntityUtils.toString(response.getEntity());

            // JSONを解析して曲情報を取得
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(responseBody);
            JSONObject tracks = (JSONObject) jsonObject.get("tracks");
            JSONArray items = (JSONArray) tracks.get("items");

            if (items.isEmpty()) {
                System.out.println("曲が見つかりませんでした。");
                return;
            }

            JSONObject firstTrack = (JSONObject) items.get(0);
            String name = (String) firstTrack.get("name");
            JSONArray artists = (JSONArray) firstTrack.get("artists");
            JSONObject firstArtist = (JSONObject) artists.get(0);
            String artistName = (String) firstArtist.get("name");
            String albumName = (String) ((JSONObject) firstTrack.get("album")).get("name");

            System.out.println("曲名: " + name);
            System.out.println("アーティスト: " + artistName);
            System.out.println("アルバム: " + albumName);
        }
    }

    public static void main(String[] args) throws Exception {
        // トークン取得
        String token = SpotifyAuth.getAccessToken();

        // 曲を検索
        searchTrack("チャンカパーナ", token);
    }
}

