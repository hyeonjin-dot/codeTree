import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i <= n; i++)
            s.add(i);
        int[] removals = new int[m];
        for (int i = 0; i < m; i++) {
            removals[i] = sc.nextInt();
            s.remove(removals[i]);
            if (i == 0){
                System.out.println(Math.max(removals[i], n - removals[i]));
                continue;
            }
            
            int cnt = 1;
            int max = 0;
            for (int c : s){
                if (s.higher(c) != null && s.higher(c) - c == 1)
                    cnt++;
                else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            System.out.println(max);
        }
    
    }
}