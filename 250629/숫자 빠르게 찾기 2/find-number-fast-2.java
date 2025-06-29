import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            s.add(arr[i]);
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++){
            queries[i] = sc.nextInt();
            if (s.ceiling(queries[i]) == null)
                System.out.println(-1);
            else
                System.out.println(s.ceiling(queries[i]));
        }
        
    }
}