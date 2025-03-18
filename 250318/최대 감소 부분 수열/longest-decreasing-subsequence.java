import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int max = 0;

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++){
            if (arr[i - 1] > arr[i])
                dp[i] = dp[i - 1] + 1;
            else {
                for (int j = i - 1; j >= 0; j--){
                    if (arr[j] > arr[i]){
                        dp[i] = dp[j] + 1;
                        break ;
                    }
                }
            }
        }
        Arrays.sort(dp);
        System.out.print(dp[n - 1]);
    }
}