import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            q.add(arr[i]);
            small.add(q.poll());
            if (small.size() < 3){
                System.out.println(-1);
                continue;
            }
            else if (small.size() > 3){
                while (small.size() > 3)
                    q.add(small.poll());
            }
            int a = small.poll();
            int b = small.poll();
            int c = small.poll();
            System.out.println((long)a * b * c);
            small.add(a);
            small.add(b);
            small.add(c);
        }
        // Please write your code here.
    }
}