import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] prex = new int[n];
        int[] fir = new int[7];  // 나머지는 0~6
        Arrays.fill(fir, -1);    // ❗초기화
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            prex[i] = (nums[i] + (i == 0 ? 0 : prex[i - 1])) % 7;

            int mod = prex[i];

            if (mod == 0) {
                // 누적합 자체가 7의 배수인 경우
                maxLen = Math.max(maxLen, i + 1);
            }

            if (fir[mod] == -1) {
                fir[mod] = i; // 처음 본 나머지면 기록
            } else {
                maxLen = Math.max(maxLen, i - fir[mod]); // 같은 나머지 → 구간합 7의 배수
            }
        }

        System.out.println(maxLen);
    }
}
