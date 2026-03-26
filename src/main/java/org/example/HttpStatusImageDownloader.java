package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class HttpStatusImageDownloader {
    void downloadStatusImage(int code) throws PostNotFoundException {
        String link = new HttpStatusChecker().getStatusImage(code);

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<Path> response;

        try {
            HttpRequest request = HttpRequest.newBuilder(URI.create(link)).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofFile(Path.of("src/main/resources/"+ code + ".jpg")));

            System.out.print("STATUS CODE:" + response.statusCode());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
