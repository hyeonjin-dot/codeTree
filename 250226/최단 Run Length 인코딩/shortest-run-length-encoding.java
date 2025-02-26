import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next().trim();

        int len = A.length();
        
        boolean vaild = true;
        for (int i = 0; i < len - 1; i++){
            if (A.charAt(i) != A.charAt(i + 1)){
                vaild = false;
                break ;
            }
        }

        if (vaild){
            if (len < 10)
                System.out.print(2);
            else
                System.out.print(3);
            return ;
        }

        int cnt = 0;
        for (int i = len - 1; i > 0; i--){
            if (A.charAt(i) == A.charAt(0))
                cnt++;
            else
                break ;
        }
        
        int res = 2;
        for (int i = 1; i < len - cnt; i++){
            if (A.charAt(i) != A.charAt(i - 1)){
                res += 2;
            }
        }

        System.out.print(res);
    }
}