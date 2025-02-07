package API;

public class PATCH {
    public void patch(String url, String auth, Object data) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
        .newBuilder()
        .PATCH(BodyPublishers.ofString(data.toString()))
        .uri(URI.create(url))
        .header("Authorization", auth)
        .header("Content-Type", "application/json")
        .build();

        HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }
}
