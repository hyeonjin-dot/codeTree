import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Long> minus = new PriorityQueue<>();
        PriorityQueue<Long> plus = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            if (x == 0){
                long p = (long)Math.pow(2, 32);
                long m = (long)Math.pow(2, 32);
                if (plus.size() > 0)
                    p = plus.peek();
                if (minus.size() > 0)
                    m = minus.peek();
                if (plus.size() == 0 && plus.size() == minus.size())
                    System.out.println(0);
                else if (m > p)
                    System.out.println(plus.poll());
                else
                    System.out.println(-1 * minus.poll());
            }
            else if (x > 0)
                plus.add(x);
            else
                minus.add(- 1 * x);
        }
    }
}