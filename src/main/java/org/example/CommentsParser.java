package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.Comment;
import org.example.dto.Post;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;


public class CommentsParser {
    private Optional<Integer> findLastId(int userId) {
        Optional<Integer> id;
        final String uri = "https://jsonplaceholder.typicode.com/users/" + userId + "/posts";

        String doc = null;
        try {
            doc = Jsoup.connect(uri)
                    .ignoreContentType(true)
                    .execute()
                    .body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Type type = TypeToken.getParameterized(List.class, Post.class).getType();
        Gson gson = new Gson();

        List<Post> postList = gson.fromJson(doc, type);
        id = postList.stream().map(Post::getId).max(Integer::compareTo);

        return id;
    }

    public void getAllComentsToLastPost(int userId) {
        int postId;

        Optional optionalId = findLastId(userId);
        if (optionalId.isPresent()) {
            postId = (int) optionalId.get();
        } else {
            System.out.println("User not found");
            return;
        }

        final String uri = "https://jsonplaceholder.typicode.com/posts/" + postId + "/comments";

        String doc = null;
        try {
            doc = Jsoup.connect(uri)
                    .ignoreContentType(true)
                    .execute()
                    .body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Type type = TypeToken.getParameterized(List.class, Comment.class).getType();
        Gson gson = new Gson();
        List<Comment> commentList = gson.fromJson(doc, type);

        List<String> comments =
                commentList.stream()
                .map(Comment::getBody)
                        .toList();
        comments.forEach(System.out::println);

        commentLoger(postId, userId, comments);
    }

    private void commentLoger(int postId, int userId, List<String> comments){
        File file=new File("user-"+userId+"-post-"+postId+"-comments.json");

        Type listType = new TypeToken<List<String>>() {}.getType();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(comments,listType);
        try (FileWriter writer = new FileWriter(file))
        {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
