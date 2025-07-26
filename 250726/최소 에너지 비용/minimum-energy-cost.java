import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dist = new int[n];
        int[] cost = new int[n];
        for (int i = 1; i < n; i++)
            dist[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            cost[i] = sc.nextInt();

        int[] lowCost = new int[n];
        lowCost[0] = cost[0];
        for (int i = 1; i < n; i++)
            lowCost[i] = Math.min(lowCost[i - 1], cost[i]);

        int sum = 0;
        for (int i = 0; i < n - 1; i++)
            sum += (dist[i + 1] * lowCost[i]);

        System.out.print(sum);
    }
}