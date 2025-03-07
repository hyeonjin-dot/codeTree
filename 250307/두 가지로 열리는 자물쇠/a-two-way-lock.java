import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] lst = new int[2][3];

    public static boolean isWithinRange(int value, int target) {
        return Math.abs(value - target) <= 2 || Math.abs(value - (target + n)) <= 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                lst[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    boolean valid1 = isWithinRange(i, lst[0][0]) &&
                                     isWithinRange(j, lst[0][1]) &&
                                     isWithinRange(k, lst[0][2]);

                    boolean valid2 = isWithinRange(i, lst[1][0]) &&
                                     isWithinRange(j, lst[1][1]) &&
                                     isWithinRange(k, lst[1][2]);

                    if (valid1 || valid2) cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}
