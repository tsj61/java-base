package org.example.basic_core.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");

        int floors = Integer.parseInt(strings[0]);
        int flats = Integer.parseInt(strings[1]);

        int x = Integer.parseInt(strings[2]);
        int y = Integer.parseInt(strings[3]);
        int allWindows = x * y;

        String[] lines = new String[x * floors];
        for (int i = 0; i < x * floors; i++) {
            lines[i] = bufferedReader.readLine();
        }

        int count = 0;
        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < flats; j++) {
                int l = 0;
                for (int d = 0; d < x; d++) {
                    String row = lines[i * x + d];
                    for (int f = 0; f < y; f++) {
                        char window = row.charAt(j * y + f);
                        if (window == 'X' || window =='Х') {
                            l++;
                        }
                    }
                }
                if (l >= ((allWindows+1) / 2)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
