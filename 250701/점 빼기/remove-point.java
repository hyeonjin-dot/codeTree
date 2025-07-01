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

        for (int i = 0; i < n; i++){
            int[] tmp = new int[2];
            tmp[0] = sc.nextInt();
            tmp[1] = sc.nextInt();
            s.add(tmp);
        }

        for (int i = 0; i < m; i++){
            int[] tmp = new int[2];
            tmp[0] = sc.nextInt();
            tmp[1] = -1;
            if (s.ceiling(tmp) != null){
                int[] res = s.ceiling(tmp);
                System.out.println(res[0] + " " + res[1]);
                s.remove(s.ceiling(tmp));
            } else
                System.out.println(-1 + " " + -1);
        }
    }
}