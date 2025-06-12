import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int tmp = map.getOrDefault(x, 1000000001);
            map.put(x, Math.min(tmp, y));
        }

        long res = 0;
        for (int x : map.keySet()){
            res += (long)map.get(x);
        }

        System.out.print(res);
    }
}