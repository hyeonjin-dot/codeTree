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

        int x = 0;
        int y = 0;
        if (x2 > xx2)
            x = x2 - xx1;
        else
            x = xx2 - x1;
        
        if (y2 > yy2)
            y = y2 - yy1;
        else
            y = yy2 - y1;

        if (x > y)
            System.out.print(x * x);
        else
            System.out.print(y * y);
    }
}