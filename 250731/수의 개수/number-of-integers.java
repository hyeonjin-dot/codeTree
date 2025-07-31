import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            System.out.println(map.getOrDefault(x, 0));
        }
    }
}