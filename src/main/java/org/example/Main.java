package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Document document=Jsoup.connect("https://www.amazon.de/-/en/gp/browse.html?node=427957031&ref_=nav_em__desk_0_2_14_14")
                .get();
        Elements element = document.select("span.a-offscreen");
    }
}