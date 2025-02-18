import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int xx1 = sc.nextInt();
        int yy1 = sc.nextInt();
        int xx2 = sc.nextInt();
        int yy2 = sc.nextInt();

        int xmax = Math.max(xx2, x2);
        int xmin = Math.min(x1, xx1);
        int ymax = Math.max(yy2, y2);
        int ymin = Math.min(y1, yy1);

        int x = xmax - xmin;
        int y = ymax - ymin;

        if (x > y)
            System.our.print(x * x);
        else
            System.our.print(y * y);
      
    }
}