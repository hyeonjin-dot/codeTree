import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int sLen = s.length();
        int tLen = t.length();

        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= sLen; i++)
            dp[i][0] = i;
        for (int j = 0; j <= tLen; j++)
            dp[0][j] = j; 

        for (int i = 1; i <= sLen; i++){
            for (int j = 1; j <= tLen; j++){
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 2);
                }
            }
        }

        System.out.print(dp[sLen][tLen]);
    }
}