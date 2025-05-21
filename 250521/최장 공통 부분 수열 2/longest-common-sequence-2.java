import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int aLen = a.length();
        int bLen = b.length();

        int[][] dp = new int[aLen + 1][bLen + 1];
        String[][] arr = new String[aLen + 1][bLen + 1];
        StringBuffer str = new StringBuffer();

        for (int i = 1; i <= aLen; i++){
            for (int j = 1; j <= bLen; j++){
                if (a.charAt(i - 1) == b.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (arr[i - 1][j - 1] != null)
                        str.append(arr[i - 1][j - 1]);
                    str.append(a.charAt(i - 1));
                    arr[i][j] = str.toString();
                    str.setLength(0);
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (dp[i][j] == dp[i - 1][j])
                        arr[i][j] = arr[i - 1][j];
                    else
                        arr[i][j] = arr[i][j - 1];
                }
            }
        }

        System.out.print(arr[aLen][bLen]);

    }
}