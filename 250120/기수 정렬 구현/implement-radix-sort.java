import java.util.*;

public class Main {
    public static int[] radix(int[] lst, int k){
        int n = lst.length;

        for (int i = k - 1; i >= 0; i--){
            int[][] num = new int[10][n];
            for (int j = 0; j < n; j++){
                int digit = lst[j] % (int)Math.pow(10, k - i);
                num[digit][j] = lst[j];
            }
            int cnt = 0;
            int[] tmp = new int[n];
            int digit = 0;
            int j = 0;
            while (cnt < n){
                if (num[digit][j] > 0)
                    tmp[cnt++] = num[digit][j];
                j++;
                if (j == n){
                    j = 0;
                    digit++;
                }
            }

            lst = tmp;
        }

        return lst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] lst = new int[n];

        for (int i = 0; i < n; i++)
            lst[i] = sc.nextInt();

        int max = Arrays.stream(lst).max().getAsInt();
        String tmp = Integer.toString(max);
        int k = tmp.length();

        int[] res = radix(lst, k);
        for (int i = 0; i < n; i++)
            System.out.print(res[i] + " ");
    }
}