import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year:");
        int year = sc.nextInt();
        System.out.println("Enter the month number");
        int month = sc.nextInt();
        LocalDate LdNow = LocalDate.of(year, month, 1);
        System.out.println(LdNow);    
        DayOfWeek dofw = LdNow.getDayOfWeek();
        int daysInMonth = LdNow.lengthOfMonth();
        int startDay = LdNow.getDayOfWeek().getValue();
        System.out.println("Calender for the month of " + LdNow.getMonth() + ", " + year);
         System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");
        int spaceCount = startDay % 7;
        for (int i = 0; i < spaceCount; i++) System.out.print("    ");
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%-4d", day);
            if ((day + spaceCount) % 7 == 0) System.out.println();
        }
    }
}