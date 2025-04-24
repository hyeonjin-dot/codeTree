import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : arr){
            for (int i = sum; i >= num; i--){
                if (dp[i - num])
                    dp[i] = true;
            }
        }

        int res = sum;
        for (int i = 1; i <= sum; i++){
            if (dp[i]){
                int other = sum - i;
                res = Math.min(res, Math.abs(other - i));
            }
        }

        System.out.print(res);
    }
}