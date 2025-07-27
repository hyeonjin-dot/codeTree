import java.util.*;
public class Main {
    public static int[] x;
    public static int[] y;
    public static int n;

    public static int count(int a, int b){
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++){
            if (x[i] > a && y[i] > b)
                cnt[0]++;
            else if (x[i] < a && y[i] > b)
                cnt[1]++;
            else if (x[i] < a && y[i] < b)
                cnt[2]++;
            else 
                cnt[3]++;
        }

        Arrays.sort(cnt);
        // System.out.println(a + " " + b + " " + cnt[3]);
        return (cnt[3]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        int minX = 1001;
        int minY = 1001;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            minX = Math.min(minX, x[i]);
            minY = Math.min(minY, y[i]);
            maxX = Math.max(maxX, x[i]);
            maxY = Math.max(maxY, y[i]);
        }
        int res = 1000;
        for (int i = minX + 1; i < maxX; i = i + 2){
            for (int j = minY + 1; j < maxY; j = j + 2)
                res = Math.min(res, count(i, j));
        }        
        
        System.out.print(res);
    }
}