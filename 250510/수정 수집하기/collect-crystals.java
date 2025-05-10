import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int len = s.length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++){
            if (s.charAt(i) == 'L')
                arr[i] = 0;
            else
                arr[i] = 1;
        }
        
        int[][][] dp = new int[n][2][k + 1]; // 방향 바꾼 수 1 ~ k

        if (arr[0] == 0)
            dp[0][0][1] = 1;
        else
            dp[0][1][1] = 1;

        for (int i = 1; i < n; i++){
            for (int c = 1; c <= k; c++){
                for (int d = 0; d < 2; d++){
                    if (arr[i] == d){
                        dp[i][d][c] = Math.max(dp[i][d][c], dp[i - 1][d][c] + 1);
                        dp[i][d][c] = Math.max(dp[i][d][c], dp[i-1][1-d][c-1] + (arr[i] == d ? 1 : 0));
                    } else {
                        dp[i][d][c] = Math.max(dp[i-1][1-d][c-1] + (arr[i] == d ? 1 : 0), dp[i - 1][d][c]);
                        // dp[i][d][c] = Math.max(dp[i][d][c], dp[i-1][1-d][c-1] + (arr[i] == d ? 1 : 0));
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int d = 0; d < 2; d++) {
                for (int c = 0; c <= k; c++) {
                    result = Math.max(result, dp[i][d][c]);
                }
            }
        }

        System.out.print(result);
    }
}