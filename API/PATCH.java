package API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class PATCH {
    public void patch(String url, String auth, Object data, String endpoint) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
        .newBuilder()
        .method("PATCH", BodyPublishers.ofString(data.toString()))
        .uri(URI.create("http://"+url+endpoint))
        .header("Authorization", auth)
        .build();

        HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }
}
