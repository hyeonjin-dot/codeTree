import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        
        int[][][] dp = new int[n][3][3]; // 지금 층  1층

        dp[0][0][0] = arr[0][0];
        dp[0][1][1] = arr[0][1];
        dp[0][2][2] = arr[0][2];

        for (int i = 1; i < n; i++){
            for (int j = 0; j < 3; j++){
                for (int k = 0; k < 3; k++){
                    for (int s = 0; s < 3; s++){
                        if (j == k)
                            continue ;
                        dp[i][j][s] = Math.max(dp[i - 1][k][s] + arr[i][j], dp[i][j][s]);
                    }
                }
            }
        }
        
        int result = 0;
        for (int j = 0; j < 3; j++) {
            for (int s = 0; s < 3; s++) {
                if (j == s) continue;  // 마지막 층 선택 ≠ 첫 층 선택
                result = Math.max(result, dp[n-1][j][s]);
            }
        }

        System.out.print(result);

    }
}