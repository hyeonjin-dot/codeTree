import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];

        int buy = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            prices[i] = sc.nextInt();
            if (buy == 0)
                buy = prices[i];
            
            if (buy < prices[i])
                max = Math.max(prices[i] - buy, max);
            else if (buy > prices[i])
                buy = prices[i];
        }

        System.out.print(max);
    }
}