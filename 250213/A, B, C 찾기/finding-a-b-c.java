import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] lst = new long[7];

        for (int i = 0; i < 7; i++)
            lst[i] = sc.nextLong();

        long a = 0;
        long b = 0;
        long c = 0;

        Arrays.sort(lst);
        a = lst[0];
        b = lst[1];
        c = lst[6] - a - b;


        System.out.print(a + " " + b + " " + c);
    }
}