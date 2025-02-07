package API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class PUT {
    public void put(String url, String auth, Object data, String endpoint) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
        .newBuilder()
        .PUT(BodyPublishers.ofString(data.toString()))
        .uri(URI.create(url+endpoint))
        .header("Authorization", auth)
        .build();

        HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }
}
