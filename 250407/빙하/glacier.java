import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    // 격자 범위 확인
    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    // 외부 물(0)을 BFS로 찾기
    public static void markOutsideWater() {
        visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (inRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    // 빙하를 녹일 수 있는 위치 찾기
    public static List<int[]> findMeltTargets() {
        List<int[]> meltList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (inRange(nx, ny) && grid[nx][ny] == 0 && visited[nx][ny]) {
                            meltList.add(new int[]{i, j});
                            break;
                        }
                    }
                }
            }
        }

        return meltList;
    }

    // 전체 빙하가 다 녹았는지 체크
    public static boolean allMelted() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        int time = 0;
        int lastMeltCount = 0;

        while (!allMelted()) {
            markOutsideWater();  // 외부 물 탐색
            List<int[]> meltList = findMeltTargets();  // 녹일 빙하 찾기

            lastMeltCount = meltList.size();

            for (int[] pos : meltList) {
                grid[pos[0]][pos[1]] = 0;  // 빙하 녹이기
            }

            time++;
        }

        System.out.println(time + " " + lastMeltCount);
    }
}