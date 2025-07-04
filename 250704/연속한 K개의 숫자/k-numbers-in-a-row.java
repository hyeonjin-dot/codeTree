import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int b = sc.nextInt();
        int[] missingNumbers = new int[b];
        int[] numbers = new int[n + 1];
        
        for (int i = 0; i < b; i++) {
            missingNumbers[i] = sc.nextInt();
            numbers[missingNumbers[i]] = 1;
        }

        int cnt = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = n; i >= 1; i--){
            sum += numbers[i];
            cnt++;
            if (cnt == k){
                min = Math.min(min, sum);
            }
            if (cnt >= k){
                sum -= numbers[i + k - 1];
                cnt--;
            }
        }
        
        System.out.print(min);
    }
}