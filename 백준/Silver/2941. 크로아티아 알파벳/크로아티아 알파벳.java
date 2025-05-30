import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("");

        int wordCount = 0;
        for (int i=0; i< input.length; i++) {
            switch (input[i]) {
                case "c":
                    if (i+1<input.length && (input[i+1].equals("=") || input[i+1].equals("-")))
                        i++;
                    break;
                case "d":
                    if (i+1<input.length) {
                        if (input[i+1].equals("-")) {
                            i++;
                        } else if (i + 2 < input.length && input[i + 1].equals("z") && input[i + 2].equals("=")) {
                            i += 2;
                        }
                    }
                    break;
                case "l":
                case "n":
                    if (i+1<input.length && input[i+1].equals("j"))
                        i++;
                    break;
                case "s":
                case "z":
                    if (i+1<input.length && input[i+1].equals("="))
                        i++;
                    break;

            }
            wordCount++;
        }

        System.out.print(wordCount);
    }
}