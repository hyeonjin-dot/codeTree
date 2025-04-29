import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[][] dp = new int[n][k + 2];
        for (int[] tmp : dp)
            Arrays.fill(tmp, Integer.MIN_VALUE);

        // 초기화
        if (arr[0] >= 0) {
            dp[0][0] = arr[0];
        } else {
            dp[0][1] = arr[0]; // 처음이 음수면 1번 사용한 것으로 시작
        }

        // int answer = arr[0]; // 최대합 초기값

        // for (int i = 1; i < n; i++) {
        //     for (int j = 0; j <= k; j++) {
        //         if (dp[i-1][j] == Integer.MIN_VALUE) continue;

        //         if (arr[i] >= 0) {
        //             // 양수: 그냥 이어서 더하기 or 새로 시작
        //             dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + arr[i]);
        //             dp[i][0] = Math.max(dp[i][0], arr[i]);
        //         } else {
        //             if (j + 1 <= k) {
        //                 // 음수: j+1로 관리
        //                 dp[i][j+1] = Math.max(dp[i][j+1], dp[i-1][j] + arr[i]);
        //                 dp[i][j+1] = Math.max(dp[i][j+1], arr[i]);
        //             }
        //         }
        //     }
        // }

        int ans = arr[0];
        for (int i = 1; i < n; i++){
            if (arr[i] >= 0) {
                for(int j = 0; j <= k; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j] + arr[i], arr[i]);
                    ans = Math.max(ans, dp[i][j]);
                }
            } else {
                for (int j = 0; j < k; j++)
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i - 1][j] + arr[i]);
            }

        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j <= k; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(ans);
    }
}
