import java.util.*;

public class Main {
    static class State {
        int x, y, min, max;

        public State(int x, int y, int min, int max) {
            this.x = x;
            this.y = y;
            this.min = min;
            this.max = max;
        }
    }

    static int n;
    static int[][] grid;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static int bfs() {
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int initVal = grid[0][0];
        queue.add(new State(0, 0, initVal, initVal));
        visited.add("0,0," + initVal + "," + initVal);

        int result = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.x == n - 1 && cur.y == n - 1) {
                result = Math.min(result, cur.max - cur.min);
                continue;
            }

            for (int dir = 0; dir < 2; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (!inRange(nx, ny)) continue;

                int nextVal = grid[nx][ny];
                int newMin = Math.min(cur.min, nextVal);
                int newMax = Math.max(cur.max, nextVal);

                String key = nx + "," + ny + "," + newMin + "," + newMax;
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(new State(nx, ny, newMin, newMax));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        System.out.println(bfs());
    }
}
