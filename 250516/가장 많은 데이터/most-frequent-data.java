import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> m = new HashMap<>();
        String[] arr = new String[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            if (m.get(arr[i]) == null)
                m.put(arr[i], 1);
            else
                m.put(arr[i], m.get(arr[i]) + 1);
            max = Math.max(m.get(arr[i]), max);
        }

        System.out.print(max);
    }
}