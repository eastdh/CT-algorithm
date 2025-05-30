import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
         * * 1 1/1
         * *
         * * 2 1/2
         * * 3 2/1
         * *
         * * 4 3/1
         * * 5 2/2
         * * 6 1/3
         * *
         * * 7 1/4
         * * 8 2/3
         * * 9 3/2
         * * 10 4/1
         * *
         * * 11 5/1
         * * 12 4/2
         * * 13 3/3
         * * 14 2/4
         * * 15 1/5
         */

        Scanner sc = new Scanner(System.in);

        int numOfFraction = sc.nextInt();

        int area = 0;
        int increase = 0;
        while (area < numOfFraction) {
            increase++;
            area += increase;
//            System.out.println(area + " " + increase);
        }
        // while문 종료시, area는 해당 구간의 끝 부분, increase는 해당 구간의 분모/분자 최대값
        // increase가 홀수면 area 번째 분수의 분모가 increase, 짝수면 분자가 increase
        // area - numOfFraction == 분자 및 분모에서 증감할 숫자
        int up, down;
        int amount = area - numOfFraction;
        if (increase % 2 == 0) {
            up = increase - amount;
            down = 1 + amount;
        } else {
            up = 1 + amount;
            down = increase - amount;
        }

        System.out.println(up + "/" + down);
    }
}