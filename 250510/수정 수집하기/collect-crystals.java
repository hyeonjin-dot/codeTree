import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++){
            if (s.charAt(i - 1) == 'L')
                arr[i] = 0;
            else
                arr[i] = 1;
        }
        
        int[][][] dp = new int[n + 1][2][k + 1]; // 방향 바꾼 수 1 ~ k

        if (arr[1] == 0)   
            dp[1][0][0] = 1;
        else
            dp[1][1][1] = 1;
        

        for (int i = 2; i <= n; i++){
            for (int c = 0; c <= k; c++){
                for (int d = 0; d < 2; d++){
                    if (arr[i] == d) {
                        // 같은 방향 유지
                        dp[i][d][c] = Math.max(dp[i][d][c], dp[i - 1][d][c] + 1);
                        // 다른 방향에서 전환해서 옴
                        if (c > 0)
                            dp[i][d][c] = Math.max(dp[i][d][c], dp[i - 1][1 - d][c - 1] + 1);
                    } else {
                        // 같은 방향에서 그냥 무시 (전환 안 씀)
                        dp[i][d][c] = Math.max(dp[i][d][c], dp[i - 1][d][c]);
                        // 다른 방향에서 전환해서 넘어옴
                        if (c > 0)
                            dp[i][d][c] = Math.max(dp[i][d][c], dp[i - 1][1 - d][c - 1] + 1);
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= n; i++) {
            for (int d = 0; d < 2; d++) {
                for (int c = 0; c <= k; c++) {
                    result = Math.max(result, dp[i][d][c]);
                }
            }
        }

        System.out.print(result);
    }
}