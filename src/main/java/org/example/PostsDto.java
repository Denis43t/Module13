package org.example;

public class PostsDto {
    private int UserId;
    private int id;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String title;

    public PostsDto(int userId, int id, String title, String body) {
        UserId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    private String body;
}
