package API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GET {
    public void get(String url, String auth) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
        .newBuilder()
        .GET()
        .uri(URI.create(url))
        .header("Autorization", auth)
        .build();

        HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }
}