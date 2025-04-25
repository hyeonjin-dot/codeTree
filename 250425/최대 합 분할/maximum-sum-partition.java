import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int range = sum * 2 + 1;
        int[] dp = new int[range];
        Arrays.fill(dp, -1);
        dp[sum] = 0; // diff = 0 상태 (A - B = 0)

        for (int num : arr){
            int[] next = Arrays.copyOf(dp, range); // 갱신 영향 방지

            for (int diff = -sum; diff <= sum; diff++){
                if (dp[diff + sum] == -1)
                    continue;

                // A에 넣기
                int newDiffA = diff + num;
                if (Math.abs(newDiffA) <= sum)
                    next[newDiffA + sum] = Math.max(next[newDiffA + sum], dp[diff + sum] + num);

                // B에 넣기
                int newDiffB = diff - num;
                if (Math.abs(newDiffB) <= sum)
                    next[newDiffB + sum] = Math.max(next[newDiffB + sum], dp[diff + sum]);

                // C에 넣기: 그냥 무시 (next[diff] 그대로 유지됨)
            }

            dp = next;
        }

        System.out.print(dp[sum]); // diff == 0일 때의 A 최대합
    }
}
