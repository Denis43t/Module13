package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

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

        Type type = TypeToken.getParameterized(List.class, TodosDto.class).getType();
        Gson gson = new Gson();

        List<TodosDto> todosDtoList = gson.fromJson(doc, type);
        StringBuilder tasks = new StringBuilder("");
                todosDtoList.forEach(todo-> {
            if (!todo.getCompleted()){
                tasks.append(todo.getTitle()).append("\n");
            }
        });
        System.out.println(tasks);
    }
}
