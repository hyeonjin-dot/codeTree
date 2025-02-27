import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        if ((a == 11 && b < 11) || (a == 11 && b == 11 && c < 11)){
            System.out.print(-1);
            return ;
        }
        int A = 11;
        int B = 11;
        int C = 11;
        int res = 0;

        while (A < a){
            res++;
            C++;

            if (C == 60){
                B++;
                C = 0;
            }

            if (B == 24){
                B = 0;
                A++;
            }
        }

        while (B <= b){
            if (B == b && C == c)
                break ;
            res++;
            C++;

            if (C == 60){
                B++;
                C = 0;
            }
        }

        System.out.print(res);
    }
}