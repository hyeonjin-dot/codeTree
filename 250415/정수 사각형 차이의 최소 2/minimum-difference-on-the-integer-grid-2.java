import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    // 주어진 최소 min, 최대 max 범위 내에서 (0,0) → (n-1,n-1) 이동 가능한지 확인
    public static boolean isReachable(int minVal, int maxVal) {
        if (grid[0][0] < minVal || grid[0][0] > maxVal) return false;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == n - 1 && y == n - 1) return true;

            for (int d = 0; d < 2; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (inRange(nx, ny) && !visited[nx][ny]) {
                    int val = grid[nx][ny];
                    if (val >= minVal && val <= maxVal) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        int minNum = 100, maxNum = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                minNum = Math.min(minNum, grid[i][j]);
                maxNum = Math.max(maxNum, grid[i][j]);
            }

        int answer = Integer.MAX_VALUE;

        for (int minVal = minNum; minVal <= maxNum; minVal++) {
            int lo = minVal, hi = maxNum;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (isReachable(minVal, mid)) {
                    answer = Math.min(answer, mid - minVal);
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }

        System.out.println(answer);
    }
}
