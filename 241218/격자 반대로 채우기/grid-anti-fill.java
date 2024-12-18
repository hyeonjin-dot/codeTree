import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // List<List<Integer>> lst = new ArrayList<>();

        int[][] lst = new int[n][n];
        
        int tmp = 1;
        
        int x = n - 1;
        int y = n - 1;

        while (tmp < n * n){
            while (x >= 0){
                lst[x][y] = tmp;
                tmp ++;
                x--;
            }
            x++;
            y--; 
            while (x < n){
                lst[x][y] = tmp;
                tmp++;
                x++;
            }
            x--;
            y--;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(lst[i][j] +" ");
            System.out.println();
        }
    }
}