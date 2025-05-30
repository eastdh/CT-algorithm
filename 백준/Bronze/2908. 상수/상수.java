import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] numAB = sc.nextLine().split(" ");
        StringBuffer A = new StringBuffer(numAB[0]).reverse();
        StringBuffer B = new StringBuffer(numAB[1]).reverse();

        System.out.print(Integer.parseInt(String.valueOf(A)) > Integer.parseInt(String.valueOf(B)) ? A : B);
    }
}