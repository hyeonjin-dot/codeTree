import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int no_use = Math.abs(a - b);
        int use = 0;

        if (Math.abs(a - x) < Math.abs(a - y)){
            use += Math.abs(a - x);
            use += Math.abs(y - b);
        }else{
            use += Math.abs(a - y);
            use += Math.abs(x - b);
        }

        int ret = Math.min(no_use, use);
        System.out.print(ret);
    }
}