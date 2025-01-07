import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] lst = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++){
            lst[i] = sc.nextInt();
            max = Math.max(max, lst[i]);
        }

        int res = 0;
        for (int i = max; i >= 0; i--){
            int tmp = 0;
            boolean up = false;
            for (int j = 0; j < n; j++){
                if (lst[j] - i > 0)
                    up = true;
                else if (lst[j] - i <= 0 && up){
                    tmp++;
                    up = false;
                }
            }
            if (up)
                tmp++;
            res = Math.max(res, tmp);
        }
        
        System.out.print(res);
    }
}