import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        long sum = 0;
        long[] l = new long[n];
        long[] r = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            sum += arr[i];
            l[i] = arr[i];
            if (i > 0)
                l[i] += l[i - 1];
        }

        long target = sum / 4;
        long res = 0;
        long target1 = 0;
        long target2 = 0;
        for (int i = 0; i < n - 1; i++){
            if (l[i] == target * 3)
                res += target2;
            if (l[i] == target * 2)
                target2 += target1;
            if (l[i] == target)
                target1++;
        }


        System.out.println(res);
    }
}