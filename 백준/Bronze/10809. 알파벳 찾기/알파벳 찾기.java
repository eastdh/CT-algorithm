import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        String[] alphabetIndex = new String[26];
        Arrays.fill(alphabetIndex, "-1");

        for (int c=0; c<26; c++) {
            char alphabet = (char) ((int)('a')+ c);
            alphabetIndex[c] = String.valueOf(word.indexOf(alphabet));
        }

        System.out.print(String.join(" ", alphabetIndex));
    }
}