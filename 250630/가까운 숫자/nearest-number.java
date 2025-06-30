import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> s = new TreeSet<>();
        s.add(0);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int diff = Integer.MAX_VALUE;
            if (s.higher(num) == null && s.lower(num) != null)
                diff = num - s.lower(num);
            else if (s.higher(num) != null && s.lower(num) == null)
                diff = s.higher(num) - num;
            else if (s.higher(num) != null && s.lower(num) != null)
                diff = Math.min((s.higher(num) - num), (num - s.lower(num)));
            min = Math.min(min, diff);
            System.out.println(min);
            s.add(num);
        }
        
    }
}