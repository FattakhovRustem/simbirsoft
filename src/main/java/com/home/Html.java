package com.home;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Html {
    private static final Logger logger = LoggerFactory.getLogger(Html.class);

    private Document document;

    public Html(Document document) {
        this.document = document;
    }


    public void saveToFile() {
        Path file = Paths.get(document.title() + ".html");
        try {
            Files.createFile(file);
        } catch (IOException e) {
            logger.error("saveToFile -> crateFile -> " + file.toString() + ": " + e.getMessage());
            return;
        }

        try {
            Files.write(file, document.outerHtml().getBytes());
        } catch (IOException e) {
            logger.error("saveToFile -> write -> " + file.toString() + ": " + e.getMessage());
        }
    }

    public Map<String, Integer> uniqueWords() {
        Map<String, Integer> map = new HashMap<>();

        String body = this.document.tagName("body").text();
        Pattern pattern = Pattern.compile("[\\s\".,!?:;()\\[\\]\\n\\r\\t][а-яА-Яa-zA-Z]+?[\\s\".,!?:;()\\[\\]\\n\\r\\t]");
        Matcher matcher = pattern.matcher(body);
        int start = 0;
        while (matcher.find(start)) {
            String word = body.substring(matcher.start() + 1, matcher.end() - 1);
            Integer count = map.get(word);
            if (count == null) {
                map.put(word, 1);
            } else {
                map.put(word, count + 1);
            }
            start = matcher.end() - 1;
        }
        return map;
    }
}