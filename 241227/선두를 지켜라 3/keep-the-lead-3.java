import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a_len = sc.nextInt();
        int b_len = sc.nextInt();

        int[] a_cumulative = new int[1000001];
        int[] b_cumulative = new int[1000001];

        int maxA = 0, maxB = 0;
        int idx = 0;
        for (int i = 0; i < a_len; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            for (int j = 0; j < t; j++) {
                maxA += v;
                a_cumulative[idx] = maxA;
                idx++;
            }
        }

        idx = 0;
        for (int i = 0; i < b_len; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            for (int j = 0; j < t; j++) {
                maxB += v;
                b_cumulative[idx] = maxB;
                idx++;
            }
        }

        int prt = 0;
        int lastResult = 0;
        for (int i = 0; i < idx; i++) {
            int result;
            if (a_cumulative[i] > b_cumulative[i]) {
                result = 1;
            } else if (a_cumulative[i] < b_cumulative[i]) {
                result = 2;
            } else {
                result = 3;
            }

            if (result != lastResult) {
                prt++;
                lastResult = result;
            }
        }

        System.out.println(prt);
    }
}
