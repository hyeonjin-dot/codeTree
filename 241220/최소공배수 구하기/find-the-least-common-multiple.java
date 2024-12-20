import java.util.*;

public class Main {
    public static int find(int a, int b){
        if (b == 0)
            return a;
        return find(b, a % b);
    }

    public static int big(int a, int b){
        return a * (b / find(a, b));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int res = 0;
        if (n >= m)
            res = big(n, m);
        else
            res = big(m, n);

        System.out.print(res);
    }
}