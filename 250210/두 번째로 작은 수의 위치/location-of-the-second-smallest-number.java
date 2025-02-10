import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] lst = new int[n];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            lst[i] = sc.nextInt();
            min = Math.min(min, lst[i]);
        }
        
        int cnt = 0;
        int ret = 0;
        int new_min = 101;

        for (int i = 0; i < n; i++){
            if (min == lst[i])
                lst[i] = 101;
            new_min = Math.min(new_min, lst[i]);
        }

        for (int i = 0; i < n; i++){
            if (new_min == lst[i]){
                ret = i;
                cnt++;
            }
        }

        if (ret != 0 && cnt == 1)
            System.out.print(ret + 1);
        else
            System.out.print(-1);
    }
}