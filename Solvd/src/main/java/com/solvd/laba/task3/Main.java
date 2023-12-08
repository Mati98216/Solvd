package com.solvd.laba.task3;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("src/main/resources/input");
        File outputFile = new File("src/main/resources/output.txt");

        try {
            String content = FileUtils.readFileToString(inputFile, "UTF-8");


            String[] words = StringUtils.split(content, "[\\p{Punct}\\p{Digit}\\s]+");


            int uniqueWordCount = Arrays.stream(words)
                    .filter(word -> !word.isEmpty())
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet())
                    .size();

            FileUtils.writeStringToFile(outputFile, "Number of unique words: " + uniqueWordCount, "UTF-8");

            System.out.println("Number of unique words: " + uniqueWordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}