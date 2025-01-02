import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] lst = new int[n][2];

        for (int i = 0; i < n; i++){
            lst[i][0] = sc.nextInt();
            lst[i][1] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                int tmp = (int)Math.pow(lst[i][0] - lst[j][0], 2) 
                    + (int)Math.pow(lst[i][1] - lst[j][1], 2);
                min = Math.min(tmp, min);
            }
        }

        System.out.print(min);
    }
}