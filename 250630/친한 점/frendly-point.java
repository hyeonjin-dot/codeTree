import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<int[]> s = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int i = 0; i < n; i++) {
            int[] x = new int[2];
            x[0] = sc.nextInt();
            x[1] = sc.nextInt();
            s.add(x);
        }
        
        for (int i = 0; i < m; i++) {
            int[] x = new int[2];
            x[0] = sc.nextInt();
            x[1] = sc.nextInt();

            int[] tmp = s.ceiling(x);
            if (tmp == null)
                System.out.println(-1 + " " + -1);
            else
                System.out.println(tmp[0] + " " +tmp[1]);
        }
        
    }
}