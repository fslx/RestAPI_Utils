import java.net.http.*;
import java.net.URI;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ApiClient {
    private static final String BASE_URL = "http://example.com";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String makeRequest(String method, String endpoint, Map<String, Object> data) throws IOException, InterruptedException {
        String url = BASE_URL + "/" + endpoint;
        httpRequest.Builder requestBuilder = httpRequest.newBuilder(URI.create(url));
        String requestBody = data != null ? mapper.writeValueAsString(data) : "";

        switch(method.toUpperCase()) {
            case "GET":
                requestBuilder.GET();
                break;
            case "POST":
                requestBuilder.POST(httpRequest.BodyPublishers.ofString(requestBody));
                break;
            case "PUT":
                requestBuilder.PUT(httpRequest.BodyPublishers.ofString(requestBody));
                break;
            case "DELETE":
                requestBuilder.DELETE();
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method");
        }

        httpRequest request = requestBuilder
            .header("Content-Type", "application/json")
            .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}