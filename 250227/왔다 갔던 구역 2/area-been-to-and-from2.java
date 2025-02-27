import java.util.Scanner;
public class Main {
    public static int[] space = new int[2001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int idx = 1000;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            if (dir == 'R'){//++
                for (int j = 0; j < x; j++)
                    space[idx + j]++;
                idx += x;
            }else {
                for (int j = 0; j < x; j++)
                    space[idx - j]++;
                idx -= x;
            }
        }

        int res = 0;
        for (int i = 0; i < 2001; i++){
            if (space[i] >= 2)
                res++;
        }

        System.out.print(res);
    }
}