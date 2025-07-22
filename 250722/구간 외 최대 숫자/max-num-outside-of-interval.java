import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        l[0] = arr[0];
        r[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++){
            l[i] = Math.max(arr[i], l[i - 1]);
            r[n - i - 1] = Math.max(arr[n - i - 1], r[n - i]);
        }
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            System.out.println(Math.max(l[a - 1], r[b + 1]));
        }
        // Please write your code here.
    }
}