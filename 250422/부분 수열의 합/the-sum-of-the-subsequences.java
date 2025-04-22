import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= arr[i]; j--) { // 역방향 순회!
                if (dp[j - arr[i]] != -1) {
                    if (dp[j] == -1)
                        dp[j] = dp[j - arr[i]] + 1;
                    else
                        dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }

        if (dp[m] == -1)
            System.out.print("No");
        else
            System.out.print("Yes");
    }
}