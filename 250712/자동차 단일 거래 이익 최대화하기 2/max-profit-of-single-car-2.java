import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        int max = 0;
        int res = 0;
        for(int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        
        System.out.print(max);
        // Please write your code here.
    }
}