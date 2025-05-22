import java.util.*;

public class Main {
    public static int[] A;
    public static int[] B;
    public static int n;
    public static int m;
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        B = new int[m];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        for (int i = 0; i < m; i++) B[i] = sc.nextInt();
        
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (A[i - 1] == B[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        // 실제 LCS 중 사전순으로 가장 빠른 것 구하기
        List<Integer> lcs = new ArrayList<>();
        getLCS(n, m, lcs);
        for (int num : lcs)
            System.out.print(num + " ");
    }

    static void getLCS(int i, int j, List<Integer> lcs) {
        if (i == 0 || j == 0) return;

        if (A[i - 1] == B[j - 1]) {
            getLCS(i - 1, j - 1, lcs);
            lcs.add(A[i - 1]);
        } else {
            // 둘 다 가능하면 사전순 빠른 쪽 먼저
            if (dp[i - 1][j] == dp[i][j] && dp[i][j - 1] == dp[i][j]) {
                if (findFirstCommon(i - 1, j, true) <= findFirstCommon(i, j - 1, false)) {
                    getLCS(i - 1, j, lcs);
                } else {
                    getLCS(i, j - 1, lcs);
                }
            } else if (dp[i - 1][j] == dp[i][j]) {
                getLCS(i - 1, j, lcs);
            } else {
                getLCS(i, j - 1, lcs);
            }
        }
    }

    // 사전순 판단을 위한 함수
    static int findFirstCommon(int i, int j, boolean fromA) {
        while (i > 0 && j > 0) {
            if (A[i - 1] == B[j - 1]) return A[i - 1];
            if (fromA) i--;
            else j--;
        }
        return Integer.MAX_VALUE; // 사전순 가장 뒤로
    }
}