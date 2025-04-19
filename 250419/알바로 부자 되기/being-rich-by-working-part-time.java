import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] s = new int[n][3];

        for (int i = 0; i < n; i++) {
            s[i][0] = sc.nextInt();
            s[i][1] = sc.nextInt();
            s[i][2] = sc.nextInt();
        }
        Arrays.sort(s, Comparator.comparingInt(a -> a[1]));
         // DP 배열 초기화
        int[] dp = new int[n];
        dp[0] = s[0][2]; // 첫 번째 아르바이트의 급여
        
        for (int i = 1; i < n; i++) {
            int[] current = s[i];
            int maxPay = current[2];
            
            // 현재 아르바이트와 겹치지 않는 이전 아르바이트를 찾아 최대 급여 합산
            for (int j = i - 1; j >= 0; j--) {
                if (s[j][1] < current[0]) { // 겹치지 않는 경우
                    maxPay = Math.max(maxPay, dp[j] + current[2]);
                }
            }
            
            // 현재 아르바이트를 선택하지 않을 경우와 선택할 경우의 최대값을 dp에 저장
            dp[i] = Math.max(dp[i - 1], maxPay);
        }
        
        // 마지막 값이 철수가 벌 수 있는 최대 금액
        System.out.print(dp[n - 1]);
        
    }
}