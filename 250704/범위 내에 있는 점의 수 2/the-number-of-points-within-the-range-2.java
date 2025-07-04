import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] points = new int[1000001];
        int[] prexSum = new int[1000001];
        for (int i = 0; i < n; i++) {
           int idx = sc.nextInt();
            points[idx] = 1;
        }

        prexSum[0] = points[0];
        for (int i = 1; i < 1000001; i++)
            prexSum[i] = prexSum[i - 1] + points[i];
        

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a > 0)
                System.out.println(prexSum[b] - prexSum[a - 1]);
            else
                System.out.println(prexSum[b]);
        }
    }
}