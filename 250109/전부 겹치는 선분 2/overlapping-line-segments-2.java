import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] lst = new int[101];

        for (int i = 0; i < n; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            for (int j = start; j <= end; j++)
                lst[j]++;
        }

        boolean res = false;
        for (int i = 0; i < 101; i++){
            if (lst[i] >= n - 1)
                res = true;
        }

        if (res)
            System.out.print("Yes");
        else
            System.out.print("No");

    }
}