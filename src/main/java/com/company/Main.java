package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        ListWords listWords = new ListWords();

        Charset charset = Charset.forName("windows-1251");
        try (BufferedReader reader = (BufferedReader) Files.newBufferedReader(Paths.get("test.txt"), charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] wordsInLine = line.split("\\W");
                for(int i = 0; i < wordsInLine.length; i++) {
                    listWords.addWord(wordsInLine[i]);
                }
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        System.out.println(listWords.toString());
    }


}
