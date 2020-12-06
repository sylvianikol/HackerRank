package SalesByMatch;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pairsCount = 0;

        char[] checked = new char[n];

        // 10 20 20 10 10 30 50 10 20
        // *  *  *  * 10 30 50 10 20
        for (int i = 0; i < ar.length; i++) {

            int pair = 0;

            for (int j = i + 1; j < ar.length; j++) {

                if (checked[i] == '*') {
                    break;
                }

                if (checked[j] == '*') continue;

                if (ar[i] == ar[j]) {
                    pair++;
                    checked[i] = '*';
                    checked[j] = '*';

                    break;
                }
            }

            pairsCount += pair;
        }

        return pairsCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
