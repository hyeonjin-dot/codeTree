import java.util.*;
class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int min = 1000000001;
        Pair[] p = new Pair[n];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            min = Math.min(min, x1);
            max = Math.max(max, x2);
            p[i] = new Pair(x1, x2);
        }

        int[] lst = new int[max - min + 1];
        for (int i = 0; i < n; i++){
            int x1 = p[i].x;
            int x2 = p[i].y;
            lst[x1 - min]++;
            lst[x2 - min]--;
        }

        int tmp = 0;
        int res = 0;
        for (int i = 0; i < max - min + 1; i++){
            tmp += lst[i];
            res = Math.max(tmp, res);
        }

        System.out.print(res);
    }
}