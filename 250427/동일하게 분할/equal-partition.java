import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++){
            for (int j = sum; j >= arr[i]; j--){
                if (dp[j - arr[i]] != -1)
                    dp[j] = Math.max(dp[j], dp[j - arr[i]] + arr[i]);
            }
        }

        int max = -1;
        for (int i = 0; i <= sum; i++){
            if (dp[i] != -1){
                int res = sum - dp[i];
                if (res == dp[i]){
                    max = Math.max(res, max);
                    break ;
                }
            }
        }
        
        if (max > -1)
            System.out.print("Yes");
        else
            System.out.print("No");

    }
}