import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] lst = new int[10000];
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt() - 1;
            char c = sc.next().charAt(0);
            if (c == 'G')
                lst[pos] = 1;
            else
                lst[pos] = 2;
        }
        
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 10000 - k; i++){
            int sum = 0;
            for (int j = i; j <= i + k; j++)
                sum += lst[j];
            max = Math.max(sum, max);
        }

        System.out.print(max);
    }
}