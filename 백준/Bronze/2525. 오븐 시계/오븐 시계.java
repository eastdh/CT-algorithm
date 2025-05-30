import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String timeInput = sc.nextLine();
        int minuteInput = sc.nextInt();

        String[] start = timeInput.split(" ");
        int startHour = Integer.parseInt(start[0]);
        int startMinute = Integer.parseInt(start[1]);

        int endHour = startHour;
        int endMinute = startMinute + minuteInput;
        if (endMinute >= 60) {
            endHour += endMinute/60;
            endMinute %= 60;
        }
        endHour %= 24;

        System.out.print(endHour + " " + endMinute);
    }
}