import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bCards = new int[n];
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < 2 * n; i++)
            s.add(i + 1);

        for (int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
            s.remove(bCards[i]);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++){
            int target = bCards[i];
            if (s.higher(target) == null)
                s.remove(s.first());
            else {
                s.remove(s.higher(target));
                cnt++;
            }
        }
        
        System.out.print(cnt);
    }
}