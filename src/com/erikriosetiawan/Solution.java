package com.erikriosetiawan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    static int migratoryBirds(List<Integer> arr) {

        List<Integer> totals = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            totals.add(0);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (i + 1 == arr.get(j)) {
                    totals.set(i, totals.get(i) + 1);
                }
            }
        }

        int max = 0;

        for (int i = 1; i < totals.size(); i++) {
            if (totals.get(max) < totals.get(i)) {
                max = i;
            }
        }

        return max + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrItems = bufferedReader.readLine().replaceAll("\\\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr.add(arrItem);
        }

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
