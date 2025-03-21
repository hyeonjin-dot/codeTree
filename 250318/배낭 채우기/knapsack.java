import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int[] w;
    public static int[] v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        w = new int[n];
        v = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1];

        // for (int i = 0; i < n; i++){
        //     if (dp[w[i]] == 0)
        //         dp[w[i]] = v[i];
        //     else
        //         dp[w[i]] = Math.max(dp[w[i]], v[i]);
        // }

        for (int i = 0; i < n; i++){
            for (int j = m; j >= w[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }

        int ans = 0;

        for (int i = 0; i <= m; i++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }
}