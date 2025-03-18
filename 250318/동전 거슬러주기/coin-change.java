import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int[] coin;
    public static int[] dp;

    public static int find(int num){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            if (num - coin[i] >= 0 && dp[num - coin[i]] != 0){
                min = Math.min(dp[num - coin[i]], min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        coin = new int[n];
        dp = new int[m + 1];

        for (int i = 0; i < n; i++){
            coin[i] = sc.nextInt();
            dp[coin[i]] = 1;
        }

        dp[0] = 0;
        int res = find(m);
        if (res == Integer.MAX_VALUE)
            res = -2;
        System.out.print(res + 1);
        
    }
}