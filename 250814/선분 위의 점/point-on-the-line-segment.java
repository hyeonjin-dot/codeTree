import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        Arrays.sort(points);
        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            if (points[n - 1] < a || points[0] > b)
                System.out.println(0);
            else {
                int cnt = 0;
                for (int num : points){
                    if (num >= a && num <= b)
                        cnt++;
                }
                System.out.println(cnt);
            }
        }
        
        // Please write your code here.
    }
}