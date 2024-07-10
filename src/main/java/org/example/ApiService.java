package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.dto.Todo;
import org.example.dto.User;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiService {
    private final HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build();
    private final JsonService jsonService = new JsonService();

    public User postNewObject(User user) throws IOException, InterruptedException, URISyntaxException {
        final String uri = "https://jsonplaceholder.typicode.com/users";

        String jsonUser = jsonService.toJsonConvertor(user);


        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonUser))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        return (User) jsonService.fromJsonConvertor(User.class, response.body());
    }


    public User putObject(User user) throws IOException, InterruptedException, URISyntaxException {
        final String uri = "https://jsonplaceholder.typicode.com/users/1";
        String jsonUser = jsonService.toJsonConvertor(user);
        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonUser))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return (User) jsonService.fromJsonConvertor(User.class, response.body());
    }

    public boolean deleteObject() throws IOException, InterruptedException, URISyntaxException {
        final String uri = "https://jsonplaceholder.typicode.com/users/1";

        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode() == 200 || response.statusCode() == 201 || response.statusCode() == 202
                || response.statusCode() == 203 || response.statusCode() == 204;
    }

    public List<User> getAll() throws URISyntaxException, IOException, InterruptedException {
        final String uri = "https://jsonplaceholder.typicode.com/users";
        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        List<User> users = jsonService.fromJsonConvertorToList(User.class, response.body());
        return users;
    }

    public User getById(int id) throws URISyntaxException, IOException, InterruptedException {
        final String uri = "https://jsonplaceholder.typicode.com/users/" + id;

        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return (User) jsonService.fromJsonConvertor(User.class, response.body());
    }

    public User getByUsername(String username) throws URISyntaxException, IOException, InterruptedException {
        final String uri = "https://jsonplaceholder.typicode.com/users?username=" + username;
        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return (User) jsonService.fromJsonConvertor(User.class, response.body().replace("]", "").replace("[", ""));
    }
}