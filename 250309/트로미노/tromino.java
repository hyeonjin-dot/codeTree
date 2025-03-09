import java.util.*;

public class Main {
    public static int[][] grid;
    public static int n;
    public static int m;

    public static int[] dx = {0, 1, 2, 0, 0, -1, -2, 0};
    public static int[] dy = {0, 0, 0, 1, 2, 0, 0, -1};

    public static int[] ldx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] ldy = {1, 0, -1, 1, -1, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public static int maxSum() {
        int ret = Integer.MIN_VALUE;

        // 1. 가로/세로 3칸 합 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 2; j++) {
                int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                ret = Math.max(ret, sum);
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n - 2; i++) {
                int sum = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
                ret = Math.max(ret, sum);
            }
        }

        // 2. L자형 블록 (8가지 방향 고려)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {  // 8방향 탐색
                    int sum = grid[i][j];  // 기준점 포함
                    boolean valid = true;

                    for (int d = 0; d < 3; d++) {
                        int nx = i + dx[d] + ldx[k];
                        int ny = j + dy[d] + ldy[k];

                        if (!inRange(nx, ny)) {
                            valid = false;
                            break;
                        }
                        sum += grid[nx][ny];
                    }

                    if (valid) {
                        ret = Math.max(ret, sum);
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxSum());
    }
}
