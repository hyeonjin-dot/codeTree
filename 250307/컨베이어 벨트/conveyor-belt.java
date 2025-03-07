import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] lst = new int[n * 2];

        for (int i = 0; i < 2 * n ; i++)
            lst[i] = sc.nextInt();

        int[] changed = new int[n * 2];

        for (int i = 0; i < 2 * n; i++)
            changed[(i + t) % (2 * n)] = lst[i];

        for (int i = 0; i < 2 * n; i++){
            System.out.print(changed[i] + " ");
            if (i == n - 1)
                System.out.println();
        }
    }
}