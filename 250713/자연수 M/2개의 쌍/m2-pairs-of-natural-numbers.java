import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = 0; j < x; j++)
                s.add(y);
        }

        int max = Integer.MIN_VALUE;
        while (s.size() > 0){
            int fir = s.first();
            int last = s.last();
            s.remove(fir);
            s.remove(last);
            max = Math.max(fir+last, max);
        }

        System.out.print(max);

    }
}