import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();

        int[] lst = new int[n];

        for (int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            lst[i] = tmp;
        }

        int min_price = Integer.MAX_VALUE;
        for (int i = 0; i < n - t; i++){
            int tmp_price = 0;
            for (int j = i; j < i + t; j++){
                tmp_price += Math.abs(lst[j] - h);
            }
            min_price = min_price < tmp_price ? min_price : tmp_price;
        }

        System.out.print(min_price);
    }
}