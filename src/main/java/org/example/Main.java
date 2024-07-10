package org.example;

import org.example.dto.User;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApiService apiService = new ApiService();
        CommentsParser commentsParser =new CommentsParser();
        TodosParser todosParser=new TodosParser();
        User user=new User(3,"Oleg","dDd","3223W@gmail.com",
                new User.Adress("Sttrassa","zxf","CollCity","1324-5512",
                        new User.Adress.Geo(1234.7,98765.2))
        ,"1324567","gegegs",
                new User.Company("Suuu","141sda","ASd"));
//        try {
////            apiService.postNewObject(user);
////             apiService.putObject(user);
////            System.out.println("apiService.deleteObject() = " + apiService.deleteObject());
////            apiService.getAll();
////            System.out.println("apiService.getById(1).getEmail() = " + apiService.getById(1).getEmail());
////            System.out.println(apiService.getByUsername("Bret").getEmail());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//        commentsParser.getAllComentsToLastPost(1);
//        todosParser.taskTracker(1);
    }
}