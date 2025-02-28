import java.util.Scanner;

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int N;

    public static boolean inRange(int R, int C){
        return (R >= 0 && R < N && C >= 0 && C < N);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt() - 1;
        int C = sc.nextInt() - 1;
        char D = sc.next().charAt(0);

        int idx = 0;

        if (D == 'U')
            idx = 0;
        else if (D == 'D')
            idx = 1;
        else if (D == 'R')
            idx = 2;
        else
            idx = 3;

        while (T > 0){
            if (!inRange(R + dx[idx], C + dy[idx])){
                if (idx % 2 == 0)
                    idx++;
                else
                    idx--;
            }else {
                R += dx[idx];
                C += dy[idx];
            }
            T--;
        }

        System.out.print((R + 1) + " "  + (C + 1));
    }
}