package API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class POST {
    public void post(String url, String auth, Object data, String endpoint) throws IOException, InterruptedException {
        HttpRequest.BodyPublisher bodyPublisher;
        if (data == null) {
            bodyPublisher = HttpRequest.BodyPublishers.noBody();
        } else {
            bodyPublisher = HttpRequest.BodyPublishers.ofString(data.toString());
        }

        HttpRequest request = HttpRequest.newBuilder()
                .POST(bodyPublisher)
                .uri(URI.create(url+endpoint))
                .header("Authorization", auth)
                .build();

        HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }
}
