import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            set.add(num);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            if (set.contains(num))
                res++;
        }

        System.out.print(n + m - 2 * res);
        // Please write your code here.
    }
}