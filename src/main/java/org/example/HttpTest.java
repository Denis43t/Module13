package org.example;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpTest {

    public void postNewObject() throws IOException, InterruptedException, URISyntaxException {
        final String uri = "https://jsonplaceholder.typicode.com/users";
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .POST(HttpRequest.BodyPublishers.ofString(
                        "  \"name\": \"Leanne Graham\",\n" +
                                "  \"username\": \"Bret\",\n" +
                                "  \"email\": \"Sincere@april.biz\""))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.body() = " + response.body());
    }

    public void putObject() throws IOException, InterruptedException, URISyntaxException {
        final String uri = "https://jsonplaceholder.typicode.com/users/1";
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .PUT(HttpRequest.BodyPublishers.ofString("  \"name\": \"OLEGUS\",\n" +
                        "  \"username\": \"Bret\",\n" +
                        "  \"email\": \"Sincere@april.biz\""))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response = " + response);
    }

    public void deleteObject() throws IOException, InterruptedException, URISyntaxException {
        final String uri = "https://jsonplaceholder.typicode.com/users/1";
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response = " + response);
    }

    public void getAll() throws URISyntaxException, IOException, InterruptedException {
        final String uri = "https://jsonplaceholder.typicode.com/users";
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response = " + response.body());
    }
    public void getById(int id) throws URISyntaxException, IOException, InterruptedException {
        final String uri = "https://jsonplaceholder.typicode.com/users/"+id;
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response = " + response.body());
    }
    public void getByUsernames(String username) throws URISyntaxException, IOException, InterruptedException {
        final String uri = "https://jsonplaceholder.typicode.com/users?username="+username;
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response = " + response.body());
    }
}