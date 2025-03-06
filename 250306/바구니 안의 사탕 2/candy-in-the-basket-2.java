import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] candies = new int[101];

        for (int i = 0; i < n; i++) {
            int cnt = sc.nextInt();
            int position = sc.nextInt();
            candies[position] = cnt;
        }
        
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 101 - 2 * k; i++){
            int sum = 0;
            for (int j = i; j <= i + 2 * k; j++)
                sum += candies[j];
            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}