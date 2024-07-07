package org.example;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpTest httpTest = new HttpTest();
        CommentsParser commentsParser =new CommentsParser();
        TodosParser todosParser=new TodosParser();
//        try {
////            httpTest.postNewObject();
////            httpTest.putObject();
////            httpTest.deleteObject();
////            httpTest.getAll();
////            httpTest.getById(1);
////            httpTest.getByUsernames("Bret");
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//        commentsParser.getAllComentsToLastPost(1);
        todosParser.taskTracker(1);
    }
}