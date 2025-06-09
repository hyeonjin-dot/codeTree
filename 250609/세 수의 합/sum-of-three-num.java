import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] arr = new int[n];
        // HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int cnt = 0;
                
        for (int i = 0; i < n - 1; i++){
            HashMap<Long, Integer> map = new HashMap<>();
            for (int x = 0; x < i; x++){
                map.put((long)arr[x], map.getOrDefault((long)arr[x], 0) + 1);
            }

            for (int j = i + 1; j < n; j++){
                long sum = (long)arr[i] + (long)arr[j];
                long remain = k - sum;
                cnt += map.getOrDefault(remain, 0);
            }


        }

        System.out.print(cnt);
    }
}