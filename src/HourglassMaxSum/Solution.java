package HourglassMaxSum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int maxSum = Integer.MIN_VALUE;

        for (int r = 1; r < arr.length - 1; r++) {
            for (int c = 1; c < arr[r].length - 1; c++) {

                int sum = innerSum(arr, r, c);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    private static int innerSum(int[][] arr, int row, int col) {

        int sum = arr[row][col];

        // UP
        sum += arr[row - 1][col];
        // UP LEFT
        sum += arr[row - 1][col - 1];
        // UP RIGHT
        sum += arr[row - 1][col + 1];
        // DOWN
        sum += arr[row + 1][col];
        // DOWN LEFT
        sum += arr[row + 1][col - 1];
        // DOWN RIGHT
        sum += arr[row + 1][col + 1];

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split("\\s+");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

