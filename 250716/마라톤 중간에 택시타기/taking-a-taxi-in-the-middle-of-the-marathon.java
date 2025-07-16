import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int[] l = new int[n];
        int[] r = new int[n];

        for (int i = 0; i < n; i++){
            if (i == 0){
                l[0] = 0;
                r[n - i - 1] = 0;
                continue;
            }
            l[i] = Math.abs(x[i] - x[i - 1]) + Math.abs(y[i] - y[i - 1]);
            r[n - i - 1] = Math.abs(x[n - i - 1] - x[n - i]) + Math.abs(y[n - i - 1] - y[n - i]);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++){ // 뛰어 넘을 거
            int sum = 0;
            for (int j = 0; j < i; j++)
                sum += l[j];
            for (int j = n - 1; j > i; j--)
                sum += r[j];
            sum += (Math.abs(x[i - 1] - x[i + 1]) + Math.abs(y[i - 1] - y[i + 1]));
            min = Math.min(sum, min);
        }

        System.out.print(min);
    }
}