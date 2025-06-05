import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            pq.add(-1 * num);
        }
        
        for (int i = 0; i < M; i++){
            int num = -1 * pq.peek();
            num--;
            pq.poll();
            pq.add(-1 * num);
        }
        
        System.out.print(-1 * pq.peek());
    }
}