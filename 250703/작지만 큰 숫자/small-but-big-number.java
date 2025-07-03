import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] sequence = new int[n];
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
            s.add(sequence[i]);
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
            if (s.floor(queries[i]) == null)
                System.out.println(-1);
            else{
                System.out.println(s.floor(queries[i]));
                s.remove(s.floor(queries[i]));
            }
        }
        // Please write your code here.
    }
}