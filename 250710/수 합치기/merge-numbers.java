import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            q.add(tmp);
        }
        
        while (q.size() >= 2){
            int a = q.poll();
            int b = q.poll();
            q.add(a + b);
            res += (a + b);
        }


        System.out.print(res);
    }
}