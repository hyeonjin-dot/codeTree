import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        String[] day = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int[] mon = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = 0;
        
        if (m1 > m2 || (m1 == m2 && d1 > d2)){
            while (m1 != m2){
                res--;
                d2++;

                if (d2 > mon[m2 - 1]){
                    m2++;
                    d2 = 1;
                }
            }

            while (d1 != d2){
                res--;
                d2++;
            }
            
            while (res < 0)
                res += 7;
            
            System.out.print(day[res % 7]);
        }else {
            while (m1 != m2){
                res++;
                d1++;
                
                if (d1 > mon[m1 - 1]){
                    m1++;
                    d1 = 1;
                }
            }

            while (d1 != d2){
                res++;
                d1++;
            }

            System.out.print(day[res % 7]);
        }
    }
}