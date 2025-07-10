import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); // 가방 크기
        double res = 0.0;
        double[][] lst = new double[n][2];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            lst[i][0] = (double)v / w;
            lst[i][1] = w;
        }

        Arrays.sort(lst, (a, b) -> Double.compare(b[0], a[0]));
        int bag = 0;
        int idx = 0;

        while (bag <= m && idx < n){
            // System.out.println(lst[idx][0] + " " + lst[idx][1] + " " + res + " " + bag);
            if (bag + lst[idx][1] <= (double)m){
                bag += lst[idx][1];
                res += (lst[idx][0] * lst[idx][1]);
            } else {
                int remain = m - bag;
                if ((double)remain >= lst[idx][1]) {
                    bag += lst[idx][1];
                    res += (lst[idx][0] * lst[idx][1]);
                } else {
                    bag += remain;
                    res += (lst[idx][0] * remain);
                }
            }
            idx++;
        }
        

        System.out.printf("%.3f", res);
    }
}