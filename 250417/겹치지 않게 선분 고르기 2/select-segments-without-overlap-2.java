import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }

        Arrays.sort(segments, (a,b) -> Integer.compare(a[1], b[1]));
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                if (segments[i][0] > segments[j][1])
                    dp[i] = dp[j] + 1;
            }
        }

        Arrays.sort(dp);
        System.out.print(dp[n - 1]);
    }
}