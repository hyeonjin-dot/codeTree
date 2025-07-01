import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            s.add(sc.nextInt());
        }

        int ans = Integer.MAX_VALUE;

        for (int x : s) {
            Integer target = s.ceiling(x + m);
            if (target != null) {
                ans = Math.min(ans, target - x);
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
