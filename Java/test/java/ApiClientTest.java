import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApiClientTest {
    
    @Test
    void testGetRequest() throws Exception {
        HttpClient mockClient = mock(HttpClient.class);
        HttpResponse<String> mockResponse = mock(HttpResponse.class);

        when(mockResponse.body()).thenReturn("{\"data\":\"test\"}");
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler))).thenReturn(mockResponse);

        ApiClient apiClient = new ApiClient(mockClient);
        String result = apiClient.makeRequest("GET", "resource/1", null);

        assertEquals("{\"data\":\"test\"}", result);
    }
    @Test
    void testPostRequest() throws Exception {
        HttpClient mockClient = mock(HttpClient.class);
        HttpResponse<String> mockResponse = mock(HttpResponse.class);

        when(mockResponse.body()).thenReturn("{\"success\":true}");
        when(mockResponse.statusCode()).thenReturn(201);
        when(mockClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        ApiClient apiClient = new ApiClient(mockClient);
        String result = apiClient.makeRequest("POST", "resource", Map.of("name", "Test"));

        assertEquals("{\"success\":true}", result);
    }

    @Test
    void testPutRequest() throws Exception {
        HttpClient mockClient = mock(HttpClient.class);
        HttpResponse<String> mockResponse = mock(HttpResponse.class);

        when(mockResponse.body()).thenReturn("{\"updated\":true}");
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        ApiClient apiClient = new ApiClient(mockClient);
        String result = apiClient.makeRequest("PUT", "resource/1", Map.of("name", "Updated"));

        assertEquals("{\"updated\":true}", result);
    }

    @Test
    void testDeleteRequest() throws Exception {
        HttpClient mockClient = mock(HttpClient.class);
        HttpResponse<String> mockResponse = mock(HttpResponse.class);

        when(mockResponse.body()).thenReturn("{\"deleted\":true}");
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        ApiClient apiClient = new ApiClient(mockClient);
        String result = apiClient.makeRequest("DELETE", "resource/1", null);

        assertEquals("{\"deleted\":true}", result);
    }
}