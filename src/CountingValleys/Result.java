package CountingValleys;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {

        int valeys = 0;
        char[] pathArray = path.toCharArray();

        int index = 0;
        int alt = 0;
        boolean isValey = false;

        while (true) {

            while (index < steps && pathArray[index] == 'D') {
                --alt;
                ++index;
            }

            if (alt < 0 && !isValey) {
                isValey = true;
            }

            while (index < steps && pathArray[index] == 'U') {
                ++alt;
                ++index;

                if (alt == 0 && isValey) {
                    ++valeys;
                    isValey = false;
                }
            }

            if (index >= steps - 1) break;
        }

        return valeys;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}


