import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
            max = Math.max(max, sum);
            if (sum <= 0)
                sum = 0;
        }
        
        System.out.print(max);
    }
}