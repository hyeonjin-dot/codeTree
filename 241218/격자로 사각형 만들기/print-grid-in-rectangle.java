import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();

       int[][] lst = new int[n][n];
       
       for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            if (i == 0)
                lst[i][j] = 1;
            else if (j == 0)
                lst[i][j] = 1;
            else if (j > 0 && i > 0)
                lst[i][j] = lst[i - 1][j] + lst[i][j - 1] + lst[i - 1][j - 1];
        }
       }

       for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++)
            System.out.print(lst[i][j] + " ");
        System.out.println();
       }
    }
}