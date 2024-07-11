package org.example;

import org.example.service.ApiService;
import org.example.service.CommentsService;
import org.example.service.TodosService;
import org.example.dto.User;
import org.example.utils.UserUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApiService apiService = new ApiService();
        CommentsService commentsService =new CommentsService();
        TodosService todosService =new TodosService();
        User user=UserUtils.getUser();
//        try {
////            System.out.println(apiService.postNewObject(user));
////            System.out.println(apiService.putObject(user));
////            System.out.println("apiService.deleteObject() = " + apiService.deleteObject());
////            System.out.println(apiService.getAll());
////            System.out.println("apiService.getById(1).getEmail() = " + apiService.getById(1).getEmail());
////            System.out.println(apiService.getByUsername("Bret").getEmail());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
        commentsService.getAllComentsToLastPost(1);
//        todosService.taskTracker(1);
    }
}