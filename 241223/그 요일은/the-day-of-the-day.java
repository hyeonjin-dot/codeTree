import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int firDate = d1;
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        sc.nextLine();
        int secDate = d2;
        String date = sc.nextLine().trim();

        int[] mon = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int weekNum = 0;

        for (int i = 0; i < 7; i++){
            if (week[i].equals(date)){
                weekNum = i;
                break;
            }
        }
        
        for (int i = 0; i < m1 - 1; i++)
            firDate += mon[i];

        for (int i = 0; i < m2 - 1; i++)
            secDate += mon[i];

        int diff = secDate - firDate;

        int res = diff / 7;
        if (weekNum > 0)
            res++;
        System.out.print(res);

    }
}