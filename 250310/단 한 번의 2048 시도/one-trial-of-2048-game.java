import java.util.Scanner;

public class Main {
    public static int[][] grid;
    public static char dir;
    public static int flag;

    public static void findFlag(){
        if (dir == 'L') // <-
            flag = 0;
        else if (dir == 'R')
            flag = 1;
        else if (dir == 'U')
            flag = 2;
        else 
            flag = 3;
    }

    public static void arrange(){
        int[][] tmp = new int[4][4];
        int idx = 0;

        if (flag < 2){
            for (int i = 0; i < 4; i++){
                idx = 0;
                for (int j = 0; j < 4; j++){
                    if (grid[i][j] > 0)
                        tmp[i][idx++] = grid[i][j];
                }
            }
        }else {
            for (int j = 0; j < 4; j++){
                idx = 0;
                for (int i = 0; i < 4; i++){
                    if (grid[i][j] > 0)
                        tmp[idx++][j] = grid[i][j];
                }
            }
        }
        grid = tmp;
    }

    public static void widMove(){ //가로
        int[][] tmp = new int[4][4];
        int idx;

        for (int i = 0; i < 4; i++){
            if (flag == 0){
                idx = 0;
                for (int j = 0; j < 4; j++){
                    if (j < 3 && grid[i][j] == grid[i][j + 1]){
                        tmp[i][idx++] =  2 * grid[i][j];
                        j++;
                    }else if (grid[i][j] > 0)
                        tmp[i][idx++] = grid[i][j];
                }
            }else {
                idx = 3;
                for (int j = 3; j >= 0; j--){
                    if (j > 0 && grid[i][j] == grid[i][j - 1]){
                        tmp[i][idx--] =  2 * grid[i][j];
                        j--;
                    }else if (grid[i][j] > 0)
                        tmp[i][idx--] = grid[i][j];
                }
            }
        }

        grid = tmp;
    }

    public static void lenMove(){ //세로
        int[][] tmp = new int[4][4];
        int idx;

        for (int j = 0; j < 4; j++){
            if (flag == 2){
                idx = 0;
                for (int i = 0; i < 4; i++){
                    if (i < 3 && grid[i][j] == grid[i + 1][j]){
                        tmp[idx++][j] =  2 * grid[i][j];
                        i++;
                    }else if (grid[i][j] > 0)
                        tmp[idx++][j] = grid[i][j];
                }
            }else {
                idx = 3;
                for (int i = 3; i >= 0; i--){
                    if (i > 0 && grid[i][j] == grid[i - 1][j]){
                        tmp[idx--][j] =  2 * grid[i][j];
                        i--;
                    }else if (grid[i][j] > 0)
                        tmp[idx--][j] = grid[i][j];
                }
            }
        }

        grid = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        dir = sc.next().charAt(0);

        findFlag();
        arrange();
        if (flag < 2)
            widMove();
        else    
            lenMove();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }


    }
}