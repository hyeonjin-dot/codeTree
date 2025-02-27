import java.util.Scanner;
public class Main {
    public static int[][] paper = new int[201][201];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt() + 100;
            y[i] = sc.nextInt() + 100;
            for (int a = x[i]; a < x[i] + 8; a++){
                for (int b = y[i]; b < y[i] + 8; b++)
                    paper[a][b]++;
            }
        }

        int res = 0;
        for (int i = 0; i < 201; i++){
            for (int j = 0; j < 201; j++){
                if (paper[i][j] > 0)
                    res++;
            }
        }

        System.out.print(res);
        // Please write your code here.
    }
}