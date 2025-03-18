import java.util.Scanner;
public class Main {
    public static int n;
    public static int[] dp;

    public static int find(int num){
        if (num <= 5)
            return dp[num];
        
        return find(num - 2) + find(num - 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[1001];
    
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        System.out.print(find(n));
    }
}