import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x > 0)
                q.add(x);
            else if (q.size() > 0)
                System.out.println(q.poll());
            else
                System.out.println(0);
        }
    }
}