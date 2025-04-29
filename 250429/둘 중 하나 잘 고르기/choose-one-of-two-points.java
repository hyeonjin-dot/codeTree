import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] card = new int[2 * n][2];

        for (int i = 0; i < 2 * n; i++) {
            card[i][0] = sc.nextInt(); // 빨간 카드
            card[i][1] = sc.nextInt(); // 파란 카드
        }

        int[][] dp = new int[2 * n + 1][n + 1];
        for (int[] tmp : dp)
            Arrays.fill(tmp, -1);

        dp[0][0] = 0;

        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j <= n; j++) {
                if (dp[i][j] == -1) continue; // 아직 만들어진 적 없는 상태는 스킵

                // 빨간 카드 선택하는 경우
                if (j + 1 <= n)
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + card[i][0]);

                // 파란 카드 선택하는 경우
                if (i - j + 1 <= n)
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + card[i][1]);
            }
        }

        System.out.println(dp[2 * n][n]); // 총 2n개 다 썼고, 빨간 카드 n개 고른 상태
    }
}
