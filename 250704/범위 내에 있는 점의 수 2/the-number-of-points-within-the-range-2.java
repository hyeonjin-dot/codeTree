import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] points = new int[1000001];
        for (int i = 0; i < n; i++) {
           int idx = sc.nextInt();
            points[idx] = 1;
        }
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            int cnt = 0;
            for (int j = a; j <= b; j++){
                if (points[j] == 1)
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}