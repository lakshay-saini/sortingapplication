package com.example.filereader;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Officials on 27-08-2018.
 */
public class InputReader  {

    private static final String FILE_NAME = "/story.txt";

    public Map<String, Long> readFile(){
        try {
            InputStream inputStream = InputReader.class.getResourceAsStream(FILE_NAME);
            String input = IOUtils.toString(inputStream);
            ArrayList<String> wordsList = new ArrayList<>();
            Matcher matcher = Pattern.compile("\\w+").matcher(input);
            while (matcher.find()) {
                wordsList.add(matcher.group());
            }
            return wordsList.stream().collect(groupingBy(Function.identity(), counting()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
