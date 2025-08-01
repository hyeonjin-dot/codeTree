import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        Set<Integer> s = new HashSet<>();
        int max = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (s.contains(arr[i]))
                max = Math.max(max, arr[i]);
            else
                s.add(arr[i]);
            
            if (i >= k)
                s.remove(arr[i - k]);
        }

        System.out.print(max);
    }
}