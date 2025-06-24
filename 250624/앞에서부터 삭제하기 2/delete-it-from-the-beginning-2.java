import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        double max = (double)arr[n - 1] / 1.0;
        double sum = arr[n - 1];
        q.add(arr[n - 1]);
        
        for (int i = n - 2; i >= 0; i--){
            sum += arr[i];
            q.add(arr[i]);
            int min = q.poll();
            double tmp_sum = sum - (double)min;
            max = Math.max(max, (tmp_sum / (n - i - 1)));
            q.add(min);
        }

        System.out.printf("%.2f", max);
    }
}