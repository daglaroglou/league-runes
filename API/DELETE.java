package API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DELETE {
    public void delete(String url, String auth, String endpoint) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
        .newBuilder()
        .DELETE()
        .uri(URI.create("http://"+url+endpoint))
        .header("Autorization", auth)
        .build();

        HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }
}
