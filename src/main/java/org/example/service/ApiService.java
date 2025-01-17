package org.example.service;

import org.example.utils.JsonUtils;
import org.example.dto.User;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.example.properties.Constans.BASE_URL;

public class ApiService {
    private final HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build();
    private final JsonUtils jsonUtils = new JsonUtils();

    public User postNewObject(User user) throws IOException, InterruptedException, URISyntaxException {
        final String uri = BASE_URL + "/users";

        String jsonUser = jsonUtils.toJsonConvertor(user);


        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonUser))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        return (User) jsonUtils.fromJsonConvertor(User.class, response.body());
    }


    public User putObject(User user) throws IOException, InterruptedException, URISyntaxException {
        final String uri = BASE_URL + "/users/1";
        String jsonUser = jsonUtils.toJsonConvertor(user);
        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonUser))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return (User) jsonUtils.fromJsonConvertor(User.class, response.body());
    }

    public boolean deleteObject() throws IOException, InterruptedException, URISyntaxException {
        final String uri = BASE_URL + "/users/1";

        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode() == 200 || response.statusCode() == 201 || response.statusCode() == 202
                || response.statusCode() == 203 || response.statusCode() == 204;
    }

    public List<User> getAll() throws URISyntaxException, IOException, InterruptedException {
        final String uri = BASE_URL + "/users";
        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        List<User> users = jsonUtils.fromJsonConvertorToList(User.class, response.body());
        return users;
    }

    public User getById(int id) throws URISyntaxException, IOException, InterruptedException {
        final String uri = BASE_URL + "/users/" + id;

        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return (User) jsonUtils.fromJsonConvertor(User.class, response.body());
    }

    public User getByUsername(String username) throws URISyntaxException, IOException, InterruptedException {
        final String uri = BASE_URL + "/users?username=" + username;
        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return (User) jsonUtils.fromJsonConvertor(User.class, response.body().replace("]", "").replace("[", ""));
    }
}