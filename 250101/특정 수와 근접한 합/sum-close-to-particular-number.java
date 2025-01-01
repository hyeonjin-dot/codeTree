import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] lst = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            sum += tmp;
            lst[i] = tmp;
        }

        int diff = s;
        int tmp_sum;

        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                tmp_sum = sum - lst[i] - lst[j];
                diff = diff < Math.abs(s - tmp_sum) ? diff : Math.abs(s - tmp_sum);
            }
        }

        System.out.print(diff);
    }
}