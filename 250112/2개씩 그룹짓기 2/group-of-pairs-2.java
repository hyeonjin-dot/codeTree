import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] lst = new long[n];

        for (int i = 0; i < n; i++) {
            lst[i] = sc.nextLong();
        }

        Arrays.sort(lst); // 정렬

        long minMax = Long.MIN_VALUE; // 최솟값 중 최댓값 저장

        // i번째 작은 값과 n/2 + i번째 큰 값을 비교
        for (int i = 0; i < n / 2; i++) {
            long diff = lst[n / 2 + i] - lst[i];
            minMax = Math.max(minMax, diff); // 최솟값 중 최대를 갱신
        }

        System.out.print(minMax);
    }
}
