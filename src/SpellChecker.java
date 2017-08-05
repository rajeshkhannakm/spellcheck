import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {

    private static int minEditDist(String s1, String s2) {
        int[][] d = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            d[i][0] = i;
        }

        for (int i = 1; i <= s2.length(); i++) {
            d[0][i] = i;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    d[i][j] = Math.min(Math.min(d[i - 1][j], d[i][j - 1]), d[i - 1][j - 1]) + 1;
                }
            }
        }

        return d[s1.length()][s2.length()];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
        String line;
        ArrayList<String> wordList = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            wordList.add(line.toLowerCase());
        }

        System.out.print("Enter a misspelled word: ");
        String misspelledWord = new Scanner(System.in).nextLine().toLowerCase();

        int minDist = Integer.MAX_VALUE;
        String minDistWord = null;
        for (String word : wordList) {
            int dist = minEditDist(misspelledWord, word);
            if (dist < minDist) {
                minDist = dist;
                minDistWord = word;
            }
        }

        if (minDist > 0) {
            System.out.println("Did you mean " + minDistWord + "?");
        } else {
            System.out.println("This is a correct word!");
        }

        System.out.println(minDist);
    }

}
