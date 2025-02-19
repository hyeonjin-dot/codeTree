import java.util.*;

public class Main {
    public static int n;
    public static int[][] lst;

    public static int find(int i, int j, int K){
        int cnt = 0;

        for (int dx = -K; dx <= K; dx++) {
            for (int dy = -(K - Math.abs(dx)); dy <= (K - Math.abs(dx)); dy++) {
                int nx = i + dx;
                int ny = j + dy;
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; // 범위 체크
                // (nx, ny)는 K 크기의 마름모 내부에 포함됨
                if (lst[nx][ny] == 1)
                    cnt++;
            }
        }

        return cnt;
    }

    public static int diff(int cnt, int k, int m){
        int dig = k * k + (k + 1) * (k + 1);
        int gold = cnt * m;

        if (gold - dig < 0)
            return 0;
        return gold - dig;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt(); // 금 가격

        lst = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                lst[i][j] = sc.nextInt();
        }

        int max_charge = 0;
        //채굴 금액 : k^2 + (k+1)^2
        int k_max = (n + 1) / 2;

        for (int i = 0; i < n; i++) {         // 중심점 i
            for (int j = 0; j < n; j++) {     // 중심점 j
                for (int K = 0; K <= n; K++) { // 마름모 크기
                    int goldCount = find(i, j, K);
                    int cost = K*K + (K+1)*(K+1);

                    if (goldCount * m >= cost) { // 수익이 나는 경우
                        max_charge = Math.max(goldCount, max_charge);
                    }
                }
            }
        }

        System.out.print(max_charge);

    }
}