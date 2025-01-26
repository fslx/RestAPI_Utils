import java.net.http.*;
import java.net.URI;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import ApiClient;

public class Main {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        try {
            System.out.println(apiClient.makeRequest("GET", "resource/1", null));
            System.out.println(apiClient.makeRequest("POST", "resource", Map.of("name", "New Item")));
            System.out.println(apiClient.makeRequest("PUT", "resource/1", Map.of("name", "Updated Item")));
            System.out.println(apiClient.makeRequest("DELETE", "resource/1", null));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}