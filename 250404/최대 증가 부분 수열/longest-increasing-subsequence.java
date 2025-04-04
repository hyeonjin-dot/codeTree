import java.util.*;
public class Main {
    public static int n;
    public static int[] arr;
    public static int[] dp;

    public static int findMax(int idx){
        int max = 0;

        for (int i = idx - 1; i >= 0; i--){
            if (arr[idx] > arr[i])
                max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int max = 0;

        dp = new int[n];
        dp[0] = 1;
        
        for (int i = 1; i < n; i++){
            dp[i] = findMax(i) + 1;
        }

        Arrays.sort(dp);
        System.out.print(dp[n - 1]);
    }
}