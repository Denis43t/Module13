package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonService<T> {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public String toJsonConvertor(T object) {
        return gson.toJson(object);
    }
    public T fromJsonConvertor(T objectClass, T sourceOfData){
        return gson.fromJson((String) sourceOfData, (Type) objectClass);
    }
    public List<T> fromJsonConvertorToList(T objectClass, T sourceOfData){
        Type type =  TypeToken.getParameterized(List.class, (Type) objectClass).getType();
        return gson.fromJson((String) sourceOfData,type);
    }
}
