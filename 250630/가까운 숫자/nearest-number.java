import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] queries = new int[n];
        TreeSet<Integer> s = new TreeSet<>();
        s.add(0);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            queries[i] = sc.nextInt();
            for (int a : s)
                min = Math.min(min, Math.abs(a - queries[i]));
            System.out.println(min);
            s.add(queries[i]);
        }
        
    }
}