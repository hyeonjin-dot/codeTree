import java.util.*;

public class Main {
    static int n, k;
    static int[][] board;
    static int[][] rotated;
    static int[][] psum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        board = new int[n][n];
        int size = 2 * n - 1;

        rotated = new int[size][size];
        psum = new int[size + 1][size + 1]; // 1-based

        // Step 1. 좌표 변환 (u = x + y, v = x - y + (n - 1))
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                int u = i + j;
                int v = i - j + (n - 1);
                rotated[u][v] = board[i][j];
            }
        }

        // Step 2. 누적합 계산 (1-based)
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                psum[i][j] = rotated[i - 1][j - 1]
                           + psum[i - 1][j]
                           + psum[i][j - 1]
                           - psum[i - 1][j - 1];
            }
        }

        int maxSum = 0;

        // Step 3. 모든 좌표에서 가능한 마름모 영역 누적합 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int u = i + j;
                int v = i - j + (n - 1);

                int u1 = Math.max(0, u - k);
                int v1 = Math.max(0, v - k);
                int u2 = Math.min(size - 1, u + k);
                int v2 = Math.min(size - 1, v + k);

                // 1-based index에 맞게 +1
                int sum = psum[u2 + 1][v2 + 1] 
                        - psum[u1][v2 + 1] 
                        - psum[u2 + 1][v1] 
                        + psum[u1][v1];

                maxSum = Math.max(maxSum, sum);
            }
        }

        System.out.println(maxSum);
    }
}
