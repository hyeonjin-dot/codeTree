import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] lst = new int[n * 3];

        for (int i = 0; i < 3 * n; i++)
            lst[i] = sc.nextInt();

        int[] tmp = new int[n * 3];

        for (int i = 0; i < 3 * n; i++)
            tmp[(i + t) % (3 * n)] = lst[i];
        
        for (int i = 0; i < 3 * n; i++){
            System.out.print(tmp[i] + " " );

            if (i == n - 1 || i == 2 * n - 1)
                System.out.println();
        }
    }
}