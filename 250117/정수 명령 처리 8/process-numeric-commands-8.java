import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> lst = new LinkedList<>();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++){
            String[] cmm = sc.nextLine().trim().split(" ");
            if (cmm[0].equals("push_front"))
                lst.addFirst(Integer.parseInt(cmm[1]));
            else if (cmm[0].equals("push_back"))
                lst.addLast(Integer.parseInt(cmm[1]));
            else if (cmm[0].equals("pop_front"))
                System.out.println(lst.pollFirst());
            else if (cmm[0].equals("pop_back"))
                System.out.println(lst.pollLast());
            else if (cmm[0].equals("size"))
                System.out.println(lst.size());
            else if (cmm[0].equals("empty")){
                if (lst.size() == 0)
                    System.out.println("1");
                else
                    System.out.println("0");
            }else if (cmm[0].equals("front"))
                System.out.println(lst.peekFirst());
            else
                System.out.println(lst.peekLast());
        }
    }
}