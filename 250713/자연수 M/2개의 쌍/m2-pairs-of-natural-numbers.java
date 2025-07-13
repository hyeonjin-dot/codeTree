import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] count = new int[100_001];  // y 값 범위 제한을 이용
        int total = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(); // 개수
            int y = sc.nextInt(); // 값
            count[y] += x;
            total += x;
        }

        int left = 0;
        int right = 100_000;
        int max = 0;

        while (left <= right) {
            // left가 0개면 이동
            while (left <= 100_000 && count[left] == 0) left++;
            while (right >= 0 && count[right] == 0) right--;

            if (left > right) break;
            if (left == right && count[left] < 2) break; // 홀수 남은 경우

            int pair = Math.min(count[left], count[right]);
            if (left == right) pair = count[left] / 2;

            max = Math.max(max, left + right);
            count[left] -= pair;
            count[right] -= pair;
        }

        System.out.println(max);
    }
}
