import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++){
            String cmd = sc.next();

            if (cmd.equals("size"))
                System.out.println(pq.size());
            else if (cmd.equals("push")){
                int a = sc.nextInt();
                pq.add(a);
            } else if (cmd.equals("empty")){
                if (pq.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if (cmd.equals("pop"))
                System.out.println(pq.poll());
            else
                System.out.println(pq.peek());
        }
        
    }
}