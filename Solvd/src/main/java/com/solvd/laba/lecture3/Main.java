package com.solvd.laba.lecture3;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("src/main/resources/input");
        File outputFile = new File("src/main/resources/output.txt");

        try {
            List<String> lines = FileUtils.readLines(inputFile, "UTF-8");

            // Concatenate all lines into a single string
            String text = StringUtils.join(lines, " ");

            // Split the text into words using StringUtils
            String[] words = StringUtils.split(text);

            // Count unique words
            Set<String> uniqueWords = new HashSet<>();
            for (String word : words) {
                if (StringUtils.isNotBlank(word)) {
                    uniqueWords.add(word.toLowerCase()); // Consider words in lowercase for uniqueness
                }
            }

            // Write the result to the output file
            FileUtils.writeStringToFile(outputFile, "Number of unique words: " + uniqueWords.size(), "UTF-8");

            System.out.println("Number of unique words: " + uniqueWords.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}