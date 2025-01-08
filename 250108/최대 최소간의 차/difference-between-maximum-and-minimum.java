import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] lst = new int[n];

        for (int i = 0; i < n; i++)
            lst[i] = sc.nextInt();

        Arrays.sort(lst);
        int min = lst[0];
        int max = lst[n - 1];

        int res = Integer.MAX_VALUE;

        for (int i = min; i <= max; i++){
            int tmp = 0;
            for (int j = 0; j < n; j++){
                tmp += Math.min(Math.abs(lst[j] - i), Math.abs(lst[j] - i - k));
            }
            res = Math.min(tmp, res);
        }
        
        System.out.print(res);

    }
}