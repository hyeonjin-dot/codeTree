import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        TreeSet<Integer> s = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            s.add(arr[i]);
        }

        for (int i = 0; i < k; i++){
            System.out.print(s.first() + " ");
            s.remove(s.first());
        }
        // Please write your code here.
    }
}