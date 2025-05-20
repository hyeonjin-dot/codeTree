import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        
        int aLen = a.length();
        int bLen = b.length();

        int[][] dp = new int[aLen + 1][bLen + 1];
        
        for (int i = 0; i <= aLen; i++) dp[i][0] = i; // 삭제
        for (int j = 0; j <= bLen; j++) dp[0][j] = j; // 삽입
        
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        int max = dp[aLen][bLen];
        System.out.print(max);
        
    }
}