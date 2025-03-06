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
        
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++){
            int sum = 0;
            int a = x[0];
            int b = y[0];
            for (int j = 1; j < n; j++){
                if (i != 0 && i != n - 1 && i == j)
                    continue ;
                sum += Math.abs(x[j] - a) + Math.abs(y[j] - b);
                a = x[j];
                b = y[j];
            }
            min = Math.min(min, sum);
        }

        System.out.print(min);
        
    }
}