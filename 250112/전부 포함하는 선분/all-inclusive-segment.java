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

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            int minX1 = Integer.MAX_VALUE;
            int maxX2 = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++){
                if (i == j)
                    continue;
                minX1 = Math.min(minX1, lst[j][0]);
                maxX2 = Math.max(maxX2, lst[j][1]);
            }
            minLength = Math.min(minLength, (maxX2 - minX1));
        }

        System.out.print(minLength);
    }
}