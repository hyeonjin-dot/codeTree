import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                q.add(arr1[i] + arr2[j]);
            }
        }

        while (k-- > 1)
            q.poll();
        
        System.out.print(q.peek());
    }
}