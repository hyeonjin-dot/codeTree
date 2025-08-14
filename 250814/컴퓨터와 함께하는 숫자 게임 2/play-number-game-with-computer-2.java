import java.util.Scanner;

public class Main {
    public static long m;

    public static long lowerBound(long x) {
        long left = 1, right = m;
        int order = 1;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid == x) {
                return order;
            }

            if (mid < x)
                left = mid + 1;
            else
                right = mid - 1;

            order++;
        }

        return order;
    }

    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long min = m;
        long max = 0;

        for (long i = a; i <= b; i++){
            long res = lowerBound(i);
            min = Math.min(res, min);
            max = Math.max(res, max);
        }

        System.out.print(min + " " + max);
    }
}