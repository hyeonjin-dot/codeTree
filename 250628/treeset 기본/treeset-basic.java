import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> s = new TreeSet<>();

        for (int i = 0; i < n; i++){
            String str = sc.next();
            
            if (str.equals("add")){
                int x = sc.nextInt();
                s.add(x);
            } else if (str.equals("remove")){
                int x = sc.nextInt();
                s.remove(x);
            } else if (str.equals("find")){
                int x = sc.nextInt();
                if (s.contains(x))
                    System.out.println("true");
                else
                    System.out.println("false");
            } else if (str.equals("lower_bound")){
                int x = sc.nextInt();
                if (s.ceiling(x) == null)
                    System.out.println("None");
                else 
                    System.out.println(s.ceiling(x));
            } else if (str.equals("upper_bound")){
                int x = sc.nextInt();
                if (s.higher(x) == null)
                    System.out.println("None");
                else
                    System.out.println(s.higher(x));
            } else if (str.equals("largest")){
                if (s.isEmpty())
                    System.out.println("None");
                else
                    System.out.println(s.last());
            } else {
                if (s.isEmpty())
                    System.out.println("None");
                else
                    System.out.println(s.first());
            }
        }
    }
}