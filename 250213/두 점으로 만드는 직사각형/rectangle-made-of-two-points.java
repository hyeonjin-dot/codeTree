import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();

        int minx = Math.min(x1, a1);
        int maxx = Math.max(x2, a2);
        int miny = Math.min(y1, b1);
        int maxy = Math.max(y2, b2);

        int res = (maxx - minx) * (maxy - miny);
        System.out.print(res);
    }
}