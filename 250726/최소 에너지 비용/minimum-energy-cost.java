import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dist = new long[n - 1];
        long[] cost = new long[n];
        for (int i = 0; i < n - 1; i++)
            dist[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            cost[i] = sc.nextInt();

        long[] lowCost = new long[n];
        lowCost[0] = cost[0];
        for (int i = 1; i < n; i++)
            lowCost[i] = Math.min(lowCost[i - 1], cost[i]);

        long sum = 0;
        for (int i = 0; i < n - 1; i++)
            sum += (long)(dist[i] * lowCost[i]);

        System.out.print(sum);
    }
}