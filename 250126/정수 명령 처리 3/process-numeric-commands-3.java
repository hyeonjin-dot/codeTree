import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Deque<Integer> dq = new ArrayDeque();


        for (int i = 0; i < n; i++){
            String str = sc.nextLine().trim();

            if (str.charAt(0) == 's')
                System.out.println(dq.size());
            else if (str.charAt(0) == 'e'){
                if (dq.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if (str.charAt(0) == 'f')
                System.out.println(dq.peekFirst());
            else if (str.charAt(0) == 'b')
                System.out.println(dq.peekLast());
            else if (str.charAt(1) == 'u'){
                if (str.charAt(5) == 'f'){
                    int num = Integer.parseInt(str.substring(11));
                    dq.addFirst(num);
                }else{
                    int num = Integer.parseInt(str.substring(10));
                    dq.addLast(num);
                }
            }else {
                if (str.charAt(4) == 'f')
                    System.out.println(dq.pollFirst());
                else
                    System.out.println(dq.pollLast());
            }
        }
    }
}