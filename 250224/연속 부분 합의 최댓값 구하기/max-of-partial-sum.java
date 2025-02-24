import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        int[] dp = new int[n];

        dp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--)
            dp[i] = Math.max(nums[i], dp[i + 1] + nums[i]);
        
        System.out.print(Arrays.stream(dp).max().getAsInt());

    }
}