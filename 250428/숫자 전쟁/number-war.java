import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][n + 1]; // 가로 a, 세로 b
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        
        dp[0][0] = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (dp[i][j] == -1)
                    continue;
                
                if (a[i] <= b[j]){
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i + 1][j]);
                    dp[i + 1][j + 1] = Math.max(dp[i][j], dp[i + 1][j + 1]);
                }
                else if (b[j] < a[i])
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + b[j]);
                
            }
        }
        
        int max = 0;
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++){
                if (dp[i][j] > -1)
                    max = Math.max(dp[i][j], max);
            }
        }

        System.out.print(max);
    }
}