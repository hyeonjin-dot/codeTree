import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = n / 5;
        n = n % 5;
        
        if (n % 2 == 0)
            System.out.print(cnt + (n / 2));
        else {
            n += 5;
            cnt--;
            if (cnt > 0 && n % 2 == 0)
                System.out.print(cnt + (n / 2));
            else
                System.out.print(-1);
        }
    }
}