import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        long[][] dp = new long[n][41];

        dp[0][numbers[0] + 20]++;
        dp[0][20 - numbers[0]]++;

        for (int i = 1; i < n; i++){
            for (int j = 0; j < 41; j++){
                if (dp[i - 1][j] == 0)
                    continue;

                if (j + numbers[i] < 41){
                    dp[i][j + numbers[i]] += dp[i - 1][j];
                }
                if (j - numbers[i] >= 0){
                    dp[i][j - numbers[i]] += dp[i - 1][j];
                }
            }
        }

        System.out.print(dp[n - 1][m + 20]);

    }
}