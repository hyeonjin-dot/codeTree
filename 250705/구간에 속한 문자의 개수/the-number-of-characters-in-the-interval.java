import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 격자 크기
        int m = sc.nextInt(); 
        int k = sc.nextInt(); // 쿼리 개수

        String[] grid = new String[n];
        int[][] a = new int[n + 1][m + 1];
        int[][] b = new int[n + 1][m + 1];
        int[][] c = new int[n + 1][m + 1];

        // 누적합 배열 구성
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next();
            for (int j = 0; j < m; j++) {
                char ch = grid[i].charAt(j);
                a[i + 1][j + 1] = a[i][j + 1] + a[i + 1][j] - a[i][j];
                b[i + 1][j + 1] = b[i][j + 1] + b[i + 1][j] - b[i][j];
                c[i + 1][j + 1] = c[i][j + 1] + c[i + 1][j] - c[i][j];

                if (ch == 'a') a[i + 1][j + 1]++;
                else if (ch == 'b') b[i + 1][j + 1]++;
                else if (ch == 'c') c[i + 1][j + 1]++;
            }
        }

        // 쿼리 처리
        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            // x1, y1부터 x2, y2까지의 알파벳 개수 계산
            int cntA = getRangeSum(a, x1, y1, x2, y2);
            int cntB = getRangeSum(b, x1, y1, x2, y2);
            int cntC = getRangeSum(c, x1, y1, x2, y2);

            System.out.println(cntA + " " + cntB + " " + cntC);
        }
    }

    // (x1,y1) ~ (x2,y2)까지의 구간합 구하는 함수
    public static int getRangeSum(int[][] sum, int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
    }
}