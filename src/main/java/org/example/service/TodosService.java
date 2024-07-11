package org.example.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.dto.Todo;
import org.example.utils.JsonUtils;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static org.example.properties.Constans.BASE_URL;

public class TodosService {
    JsonUtils jsonUtils=new JsonUtils();
    public void taskTracker(int userid) {
        final String uri = BASE_URL + "/users/" + userid + "/todos";
        String doc = null;
        try {
            doc = Jsoup.connect(uri)
                    .ignoreContentType(true)
                    .execute()
                    .body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Todo> todoList=jsonUtils.fromJsonConvertorToList(Todo.class,doc);

        StringBuilder tasks = new StringBuilder("");
        todoList.forEach(todo -> {
            if (!todo.getCompleted()) {
                tasks.append(todo.getTitle()).append("\n");
            }
        });
        System.out.println(tasks);
    }
}
