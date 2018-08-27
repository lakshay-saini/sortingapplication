package com.example.filereader;


/**
 * Created by Officials on 27-08-2018.
 */
public class Application {

    public static void main(String[] args) {

        InputReader inputReader = new InputReader();

        inputReader.readFile().entrySet().forEach(System.out::println);

    }
}
