import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Queue<Integer> q = new LinkedList();

        for (int i = 0; i < n; i++){
            String tmp = sc.nextLine().trim();
            if (tmp.charAt(0) == 's')
                System.out.println(q.size());
            else if (tmp.charAt(0) == 'e'){
                if (q.size() == 0)
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if (tmp.charAt(0) == 'f')
                System.out.println(q.peek());
            else if (tmp.charAt(1) == 'o')
                System.out.println(q.poll());
            else {
                // System.out.println(tmp.substring(5));
                int num = Integer.parseInt(tmp.substring(5));
                q.add(num);
            }
        }
    }
}