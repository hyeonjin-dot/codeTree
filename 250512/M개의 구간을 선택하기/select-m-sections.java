import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 총 수
        int M = sc.nextInt(); // 선택할 구간 수
        int[] arr = new int[N + 1];
        int[] prefix = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int[][] dp = new int[N + 1][M + 1];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MIN_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                // 1. 구간 선택 X
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }

            for (int j = 1; j <= M; j++) {
                // 구간 길이 l, 끝이 i
                for (int l = 1; l <= i; l++) {
                    int start = i - l + 1;
                    int end = i;
                    int before = start - 2;  // 비연속 조건: start ≥ 이전 end + 2 → 이전 끝 ≤ start - 2

                    if (before >= 0) {
                        int sum = prefix[end] - prefix[start - 1];
                        dp[i][j] = Math.max(dp[i][j], dp[before][j - 1] + sum);
                    }
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}
