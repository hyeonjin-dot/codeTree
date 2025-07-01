import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 1; i <= m; i++)
            s.add(i);

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (s.contains(arr[i]))
                s.remove(arr[i]);
            else {
                if (s.lower(arr[i]) == null)
                    break ;
                else
                    s.remove(s.lower(arr[i]));
            }
        }

        System.out.print(s.size());
        // Please write your code here.
    }
}