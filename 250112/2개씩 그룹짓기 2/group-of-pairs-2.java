import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] lst = new long[2 * n];

        for (int i = 0; i < 2 * n; i++)
            lst[i] = sc.nextLong();

        Arrays.sort(lst); // 정렬

        long minMax = Long.MAX_VALUE; // 최솟값 중 최댓값 저장

        for (int i = 0; i < n; i++) {
            long diff = lst[n + i] - lst[i];
            minMax = Math.min(minMax, diff); // 최솟값 중 최대를 갱신
        }

        System.out.print(minMax);
    }
}
