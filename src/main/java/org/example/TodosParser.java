package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.dto.Todo;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class TodosParser {
    public void taskTracker(int userid) {
        final String uri = "https://jsonplaceholder.typicode.com/users/" + userid + "/todos";
        String doc = null;
        try {
            doc = Jsoup.connect(uri)
                    .ignoreContentType(true)
                    .execute()
                    .body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Type type = TypeToken.getParameterized(List.class, Todo.class).getType();
        Gson gson = new Gson();

        List<Todo> todoList = gson.fromJson(doc, type);
        StringBuilder tasks = new StringBuilder("");
                todoList.forEach(todo-> {
            if (!todo.getCompleted()){
                tasks.append(todo.getTitle()).append("\n");
            }
        });
        System.out.println(tasks);
    }
}
