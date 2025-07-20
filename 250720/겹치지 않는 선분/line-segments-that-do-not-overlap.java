import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[] L, R;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][2];
        L = new int[n];
        R = new int[n];

        // 입력
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // 시작점 기준 정렬
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        // L, R 배열 초기화
        L[0] = arr[0][1];
        R[n - 1] = arr[n - 1][1];

        for (int i = 1; i < n; i++) {
            L[i] = Math.max(L[i - 1], arr[i][1]);
            R[n - 1 - i] = Math.min(R[n - i], arr[n - 1 - i][1]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (L[i] == R[i])
                ans++;
        }

        System.out.println(ans);
    }
}
