import java.util.Scanner;

public class Main {
    public static int[] bombs;
    public static int n;
    public static int m;

    public static int arrange(){
        int[] tmp = new int[n];
        int idx = n - 1;
        for (int i = n - 1; i >= 0; i--){
            if (bombs[i] == 0)
                continue;
            tmp[idx--] = bombs[i];
        }
        bombs = tmp;

        return n - idx - 1;
    }

    public static boolean checkSame(){
        boolean erased = false;

        for (int i = n - 1; i >= 1; i--){
            if (bombs[i] == 0)
                continue;
            if (bombs[i] == bombs[i - 1]){
                int k = i;
                int cnt = 0;
                while (k >= 1){
                    if (bombs[k] == bombs[k - 1])
                        cnt++;
                    else
                        break ;
                    k--;
                }
                if (cnt >= m - 1){
                    for (int j = i; j >= k; j--){
                        bombs[j] = 0;
                        erased = true;
                    }
                }
            }
        }
        return erased;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        bombs = new int[n];
        for (int i = 0; i < n; i++)
            bombs[i] = sc.nextInt();

        if (m == 1){
            System.out.print(0);
            return ;
        }
        
        boolean erased = true;
        int size = 0;
        while (erased){
            erased = checkSame();
            size = arrange();
        }

        System.out.println(size);

        for (int i = 0; i < n; i++){
            if (bombs[i] > 0)
                System.out.println(bombs[i]);
        }
    }
}