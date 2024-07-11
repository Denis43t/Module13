package org.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtils<T> {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String toJsonConvertor(T object) {
        return gson.toJson(object);
    }

    public T fromJsonConvertor(T typeOfData, T sourceOfData) {
        return gson.fromJson((String) sourceOfData, (Type) typeOfData);
    }

    public List<T> fromJsonConvertorToList(T typeOfData, T sourceOfData) {
        Type type = TypeToken.getParameterized(List.class, (Type) typeOfData).getType();
        return gson.fromJson((String) sourceOfData, type);
    }
}
