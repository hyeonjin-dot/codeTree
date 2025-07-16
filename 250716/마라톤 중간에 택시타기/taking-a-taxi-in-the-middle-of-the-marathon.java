import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // 1. 전체 경로 거리 저장
        int[] dist = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Math.abs(x[i] - x[i + 1]) + Math.abs(y[i] - y[i + 1]);
        }

        // 2. 누적합 구하기
        int[] prefixSum = new int[n];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + dist[i - 1];
        }

        int min = Integer.MAX_VALUE;

        // 3. i번째 점을 생략 (1 <= i <= n-2)
        for (int i = 1; i < n - 1; i++) {
            int total = prefixSum[n - 1];
            int skip = dist[i - 1] + dist[i];
            int direct = Math.abs(x[i - 1] - x[i + 1]) + Math.abs(y[i - 1] - y[i + 1]);
            int newTotal = total - skip + direct;
            min = Math.min(min, newTotal);
        }

        System.out.println(min);
    }
}
