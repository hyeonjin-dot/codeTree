import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        String[] res = {"Spring", "Summer", "Fall", "Winter"};
        boolean check = true;
        int idx = -1;
       
        if (m >= 3 && m <= 5) {
            if (m % 2 == 0 && d >= 31)
                check = false;
            idx = 0;
        } else if (m >= 6 && m <= 8) {
            if (m == 6 && d == 31)
                check = false;
            idx = 1;
        } else if (m >= 9 && m <= 11) {
            if (m % 2 == 1 && d == 31)
                check = false;
            idx = 2;
        } else {
            if (m == 2){
                if (d > 29)
                    check = false;
                else if (y % 4 == 0 && y % 100 != 0 && d <= 29)
                    check = true;
                else if (y % 4 == 0 && y % 100 == 0 && y % 400 == 0 && d <= 29)
                    check = true;
                else if (d >= 29)
                    check = false;
            }
            idx = 3;
        }

        if (!check)
            System.out.print(-1);
        else
            System.out.print(res[idx]);
    }
}