import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            set.add(tmp);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            if (set.contains(tmp))
                System.out.println("1");
            else
                System.out.println("0");
        }
        // Please write your code here.
    }
}