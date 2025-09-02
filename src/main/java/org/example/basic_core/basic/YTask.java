package org.example.basic_core.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YTask {
    private static final Map<Integer, String> alphabet = Map.of(
            1,"-",
            2, "ABC",
            3, "DEF",
            4, "GHI",
            5, "JKL",
            6, "MNO",
            7, "PQRS",
            8, "TUV",
            9, "WXYZ"
    );

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String message = bufferedReader.readLine();
            char[] chars = message.toCharArray();

            StringBuilder stringBuilder = new StringBuilder();
            while (chars.length != 0) {
                int count = 1;
                char prevChar = 0;
                for (char ch : chars) {
                    if (prevChar == 0) {
                        prevChar = ch;
                        continue;
                    }

                    if (ch == prevChar) {
                        count++;
                    } else {
                        break;
                    }
                }
                message = message.substring(count);
                chars = message.toCharArray();

                int s = prevChar - '0';
                String value = alphabet.get(s);
                String val = "";

                if (count - 1 > value.length()) {
                    val = String.valueOf(value.charAt(value.length()));
                    count = count - value.length();
                }
                stringBuilder.append(val).append(value.charAt(count - 1));

            }

            int countDict = Integer.parseInt(bufferedReader.readLine());
            List<String> dictionary = new ArrayList<>();
            for (int i = 0; i < countDict; i++) {
                dictionary.add(bufferedReader.readLine());
            }

            List<String> result = new ArrayList<>();

            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(stringBuilder.toString().toCharArray()[0]).append(stringBuilder.toString().toCharArray()[1]);
            char[] a = stringBuilder.toString().toCharArray();
            for (char ch : a) {
                List<String> found = dictionary
                        .stream()
                        .filter(d -> d.startsWith(stringBuilder1.toString()))
                        .toList();

                if (found.isEmpty()) {
                    stringBuilder1.setLength(0);
                    stringBuilder1.append(ch);
                }
                if (found.size() == 1) {
                    result.add(found.get(0));
                    stringBuilder1.setLength(0);

                }
                if (found.size() > 1) {
                    stringBuilder1.append(ch);
                }
            }

            System.out.println(String.join(" ", result));
        }
    }
}
