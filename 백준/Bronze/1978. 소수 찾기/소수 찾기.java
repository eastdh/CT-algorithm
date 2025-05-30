import java.util.Scanner;

public class Main {
    public static int getNumOfDivisor(int n) {
        int num = 0;
        for (int i=1; i<=Math.sqrt(n); i++) {
            if (n % i == 0) {
                num++;
                if (i != n/i)
                    num++;
            }
        }
        return num;
    }

    public static boolean isPrime(int n) {
        return getNumOfDivisor(n) == 2;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfNum = sc.nextInt();
        int numOfPrime = 0;
        for (int i=0; i<numOfNum; i++) {
            int num = sc.nextInt();
            if (isPrime(num))
                numOfPrime++;
        }

        System.out.println(numOfPrime);
    }
}