import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int max = 0;
    public static List<int[]> lst = new ArrayList<>(); // 폭탄을 놓을 후보 위치

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void one(int[][] tmp, int x, int y) { // 세로 십자가
        for (int i = x - 2; i <= x + 2; i++) {
            if (inRange(i, y))
                tmp[i][y] = 2;
        }
    }

    public static void two(int[][] tmp, int x, int y) { // 3x3 정사각형
        if (inRange(x - 1, y))
            tmp[x - 1][y] = 2;
        if (inRange(x + 1, y))
            tmp[x + 1][y] = 2;
        if (inRange(x, y - 1))
            tmp[x][y - 1] = 2;
        if (inRange(x, y + 1))
            tmp[x][y + 1] = 2;
    }

    public static void three(int[][] tmp, int x, int y) { // 대각선 십자가
        if (inRange(x - 1, y - 1))
            tmp[x - 1][y - 1] = 2;
        if (inRange(x - 1, y + 1))
            tmp[x - 1][y + 1] = 2;
        if (inRange(x + 1, y - 1))
            tmp[x + 1][y - 1] = 2;
        if (inRange(x + 1, y + 1))
            tmp[x + 1][y + 1] = 2;
    }

    public static int countBoom(int[][] tmp) { // 폭탄 터진 총 개수 카운트
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] > 0)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void boom(int idx, int[][] tmp) {
        if (idx == lst.size()) { // 모든 폭탄 배치 완료
            max = Math.max(max, countBoom(tmp));
            return;
        }

        int x = lst.get(idx)[0];
        int y = lst.get(idx)[1];

        // 기존 배열을 복사하여 폭탄을 놓을 위치마다 새로운 영향을 계산
        int[][] newGrid1 = new int[n][n];
        int[][] newGrid2 = new int[n][n];
        int[][] newGrid3 = new int[n][n];

        for (int i = 0; i < n; i++) {
            newGrid1[i] = tmp[i].clone();
            newGrid2[i] = tmp[i].clone();
            newGrid3[i] = tmp[i].clone();
        }

        one(newGrid1, x, y);
        boom(idx + 1, newGrid1);

        two(newGrid2, x, y);
        boom(idx + 1, newGrid2);

        three(newGrid3, x, y);
        boom(idx + 1, newGrid3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    lst.add(new int[]{i, j});
                }
            }
        }

        boom(0, grid);
        System.out.print(max);
    }
}