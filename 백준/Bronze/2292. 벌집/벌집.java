import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        * 1: 1개
        * 2~7: 2개
        * 8~19: 3개...
        * 시작점: 2, 8, 20, 38, 62, ... ==> a_1 = 1, a_2 = 2, a_n = a_(n-1) + 6(n-2)
        * a_n <= N < a_(n+1) 일 때 방의 거리 = n
        */
        Scanner sc = new Scanner(System.in);
        int roomN = sc.nextInt();
        int a_n = 2;
        int distance = 2;
        while (a_n <= roomN) {
            distance++;
            a_n += 6 * (distance-2);
        }
        System.out.print(distance-1);
    }
}