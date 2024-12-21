import java.util.*;

public class Main {
    public static int print(int cnt, int n){
        if (cnt == 2 * n + 1)
            return 0;
        
        if (cnt == n)
            cnt++;
        int star = n - cnt;
        if (cnt > n)
            star = cnt - n;
        
        for (int i = 0; i < star; i++)
            System.out.print("* ");
        System.out.println();

        cnt++;
        return print(cnt, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        print(0, n);
    }
}