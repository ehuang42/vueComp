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
     * Complete the 'threatDetector' function below.
     *
     * The function accepts STRING_ARRAY textMessages as parameter.
     */

    public static void threatDetector(List<String> textMessages) {
        if (textMessages == null || textMessages.size() == 0) {
            System.out.print("n/a");
            return;
        } 
        
        for (int i = 1; i < textMessages.size(); i++) {
            String text = textMessages.get(i);
            String chopped = text.substring(0, text.length() - 3);
            System.out.println(chopped);

            if (chopped.length() <= 3) {
                System.out.println("n/a");
                continue;
            }

            int counting = helper(chopped);
            if (counting > 0) {
                System.out.println(text.substring(text.length() - 3, text.length() - 1) + " " + counting);
            } else {
                System.out.println("n/a");
            }
        }
    }
    private static int helper(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+3; j < str.length(); j++) {
                String sub = str.substring(i, j);
                System.out.println(sub);
                int start = 0;
                int end = sub.length() - 1;
                int check = 1;
                while (start < end) {
                    System.out.print(start + " " + end);
                    if (sub.charAt(start) != sub.charAt(end)) {
                        check = 0;
                        start++;
                        end--;
                        continue;
                    } else {
                        start++;
                        end--;
                    }
                    
                }
                if (check == 1) {
                    count += sub.length();
                }

            }

        }

        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int textMessagesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> textMessages = IntStream.range(0, textMessagesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        Result.threatDetector(textMessages);

        bufferedReader.close();
    }
}
