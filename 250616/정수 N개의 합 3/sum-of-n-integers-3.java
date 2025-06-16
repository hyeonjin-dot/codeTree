import java.util.Scanner;

public class Main {
    public static int[][] arr;
    public static int n;
    public static int k;

    public static int getSum(int x, int y){
        int sum = 0;
        for (int i = x; i < x + k; i++){
            for (int j = y; j < y + k; j++){
                sum += arr[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
       
        int max = 0;
        for (int i = 0; i <= n - k; i++){
            for (int j = 0; j <= n - k; j++)
                max = Math.max(max, getSum(i, j));
        }

        System.out.print(max);
    }
}