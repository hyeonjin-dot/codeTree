import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int idx = n - 1;
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--){
            sum += arr[i];
            if (sum == k)
                cnt++;
            if (sum >= k)
                sum -= arr[idx--];
        }

        System.out.print(cnt);
    }
}