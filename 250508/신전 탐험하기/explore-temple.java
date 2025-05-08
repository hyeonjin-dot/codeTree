import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] data = new int[N][3];
        for (int i = 0; i < N; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            data[i][2] = sc.nextInt();
        }
        
        int[][] dp = new int[N][3];
        dp[0][0] = data[0][0];
        dp[0][1] = data[0][1];
        dp[0][2] = data[0][2];

        for (int i = 1; i < N; i++){
            for (int j = 0; j < 3; j++){
                int max = 0;
                for (int k = 0; k < 3; k++){
                    if (k == j)
                        continue;
                    max = Math.max(max, dp[i - 1][k]);
                }
                dp[i][j] = max + data[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < 3; i++)
            max = Math.max(max, dp[N - 1][i]);
        
        System.out.print(max);
    }
}