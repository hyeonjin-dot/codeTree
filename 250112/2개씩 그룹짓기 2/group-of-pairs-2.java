import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Long> lst = new ArrayList<>();

        for (int i = 0; i < n; i++)
            lst.add(sc.nextLong());

        Collections.sort(lst);

        long min = Long.MAX_VALUE;

        for (int i = 0; i < n / 2; i++){
            long diff = lst.get(n / 2 - i) - lst.get(i);
            min = Math.min(min, diff);
        }

        System.out.print(min);
    }
}