import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] lst = new int[n];

        for (int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            lst[i] = tmp;
        }

        int cnt = 0;

        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1; j < n - 1; j++){
                for (int k = j + 1; k < n; k++){
                    if (lst[i] <= lst[j] && lst[j] <= lst[k])
                        cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}