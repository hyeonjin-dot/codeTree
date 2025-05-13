import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt() - 1;
            e[i] = sc.nextInt() - 1;
            v[i] = sc.nextInt();
        }
        
        int[][] dp = new int[m][n];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        for (int i = 0; i < n; i++){
            if (s[i] == 0)
                dp[0][i] = 0; 
        }

        for (int i = 1; i < m; i++){
            for (int j = 0; j < n; j++){
                if (dp[i - 1][j] == -1)
                    continue;
                
                for (int k = 0; k < n; k++){
                    if (i >= s[k] && i <= e[k]){
                        int diff = Math.abs(v[j] - v[k]);
                        dp[i][k] = Math.max(dp[i - 1][j] + diff, dp[i][k]);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[m - 1][i]);
        }

        System.out.println(ans);

    }
}