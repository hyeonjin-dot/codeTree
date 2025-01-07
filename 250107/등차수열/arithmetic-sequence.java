import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] lst = new int[n];
        
        int min = 101;
        int max = 0;
        for (int i = 0; i < n; i++){
            lst[i] = sc.nextInt();
            min = Math.min(lst[i], min);
            max = Math.max(lst[i], max);
        }

        int res = 0;
        for (int i = min + 1; i < max; i++){
            int tmp = 0;
            for (int j = 0; j < n - 1; j++){
                for (int k = j + 1; k < n; k++){
                    if (i - lst[j] == lst[k] - i)
                        tmp++;
                }
            }
            res = Math.max(tmp, res);
        }

        System.out.print(res);
    }
}