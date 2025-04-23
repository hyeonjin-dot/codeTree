import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] weight = new int[n][2];
        for (int i = 0; i < n; i++) {
            weight[i][0] = sc.nextInt();
            weight[i][1] = sc.nextInt();
        }

        Arrays.sort(weight, (a, b) -> Integer.compare(b[1], a[1]));

        int[] dp = new int[m + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++){
            for (int j = weight[i][0]; j <= m; j++)
                if (dp[j - weight[i][0]] != -1){
                    dp[j] = Math.max(dp[j], dp[j - weight[i][0]] + weight[i][1]);
            }
        }

        System.out.print(Arrays.stream(dp).max().getAsInt());
    }
}