package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private HttpClient client = HttpClient.newHttpClient();
    private HttpResponse<String> response;

    public String getStatusImage(int code)  {

        String uri ="https://http.cat/"+ code + ".jpg";
        HttpRequest request = HttpRequest.newBuilder(URI.create(uri))
                .header("Content-Type", "application/json").GET().build();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 404) {
                throw new  Exception();
            }
            return uri;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new PostNotFoundException();
        }

    }
}
