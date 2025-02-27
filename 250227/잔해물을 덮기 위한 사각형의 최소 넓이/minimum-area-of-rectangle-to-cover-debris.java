import java.util.Scanner;

public class Main {
    public static int[][] paper = new int[2001][2001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt() + 1000;
        int rect1_y1 = sc.nextInt() + 1000;
        int rect1_x2 = sc.nextInt() + 1000;
        int rect1_y2 = sc.nextInt() + 1000;
        int rect2_x1 = sc.nextInt() + 1000;
        int rect2_y1 = sc.nextInt() + 1000;
        int rect2_x2 = sc.nextInt() + 1000;
        int rect2_y2 = sc.nextInt() + 1000;
        
        for (int i = rect1_x1; i <= rect1_x2; i++){
            for (int j = rect1_y1; j <= rect1_y2; j++)
                paper[i][j]++;
        }

        for (int i = rect2_x1; i <= rect2_x2; i++){
            for (int j = rect2_y1; j <= rect2_y2; j++)
                paper[i][j] = 0;
        }

        int min_x = Integer.MAX_VALUE;
        int max_x = Integer.MIN_VALUE;
        int min_y = Integer.MAX_VALUE;
        int max_y = Integer.MIN_VALUE;

        for (int i = rect1_x1; i <= rect1_x2; i++){
            for (int j = rect1_y1; j <= rect1_y2; j++){
                if (paper[i][j] == 1){
                    min_x = Math.min(min_x, i);
                    max_x = Math.max(max_x, i);
                    min_y = Math.min(min_y, j);
                    max_y = Math.max(max_y, j);
                }
            }
        }
        
        if (max_x == Integer.MIN_VALUE){
            System.out.print("0");
            return ;
        }

        System.out.print((max_y-min_y) * (max_x - min_x));
    }
}