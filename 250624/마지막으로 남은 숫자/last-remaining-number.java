import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            q.add(x);
        }

        while (q.size() > 1){
            int x = q.poll();
            int y = q.poll();
            int diff = x - y;
            if (diff > 0)
                q.add(diff);
        }

        if (q.size() == 1)
            System.out.print(q.poll());
        else 
            System.out.print(-1);
    }
}