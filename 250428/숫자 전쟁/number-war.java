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

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                // if (dp[i][j] == -1)
                //     continue;
                
                if (a[i - 1] <= b[j- 1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                }
                else if (b[j - 1] < a[i - 1]){
                    if (dp[i][j - 1] == -1)
                        dp[i][j] = Math.max(dp[i][j], b[j - 1]);
                    else
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + b[j - 1]);
                }
                    
                
            }
        }
        
        System.out.print(dp[n][n]);
    }
}