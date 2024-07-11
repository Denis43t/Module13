package org.example.utils;

import org.example.dto.User;

public class UserUtils {
    public static User getUser(){
        User user=new User(3,"Oleg","dDd","3223W@gmail.com",
                new User.Adress("Sttrassa","zxf","CollCity","1324-5512",
                        new User.Adress.Geo(1234.7,98765.2))
                ,"1324567","gegegs",
                new User.Company("Suuu","141sda","ASd"));
        return user;
    }
}
