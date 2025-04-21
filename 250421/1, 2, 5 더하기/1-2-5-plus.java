import java.util.*;
public class Main {
    public static int n;
    public static int[] dx = {1, 2, 5};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        // dp[1] = 1;
        for (int i = 0; i <= n; i++){
            for (int j = 0; j < 3; j++){
                if (dx[j] <= i){
                    dp[i] = (dp[i] + dp[i - dx[j]]) % 10007;
                }
            }
        }

        System.out.print(dp[n]);
    }
}