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

        int res = 0;
        int diff = (lst[n - 1] - lst[0]) - k;
        while (diff > 0){
            if (diff % 2 == 0){
                lst[0] += diff / 2;
                lst[n - 1] -= diff / 2;
                res += diff;
            }
            else{
                lst[0] += diff / 2 + 1;
                lst[n - 1] -= diff / 2;
                res += diff;
            }
            Arrays.sort(lst);
            diff = (lst[n - 1] - lst[0]) - k;
        }
        System.out.print(res);

    }
}