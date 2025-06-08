import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        Map<Long, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            long target = k - arr[i];
            cnt += map.getOrDefault(target, 0); // 앞에 target 값이 몇 번 나왔는지

            map.put((long)arr[i], map.getOrDefault((long)arr[i], 0) + 1); // 현재 숫자 기록
        }

        System.out.print(cnt);
    }
}
