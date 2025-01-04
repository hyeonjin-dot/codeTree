import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int res = 0;
        for (int i = x; i <= y; i++){
            int[] lst = new int[10];
            int tmp = i;
          
            while (tmp > 9){
                lst[tmp % 10]++;
                tmp /= 10;
            }
            lst[tmp]++;
            int cnt = 0;
            int other = 0;
            for (int j = 0; j < 10; j++){
                if (lst[j] == 1)
                    cnt++;
                else if (lst[j] == 0)
                    other++;
            }

            if (cnt == 1 && other == 8)
                res++;
        }

        System.out.print(res);
    }
}