import java.util.Scanner;

public class Main {
    public static int[][] grid;
    public static int n;
    public static int m;

    public static int[] lineX = {0, 1, 2}; // 가로 X만
    public static int[] lineY = {0, 1, 2}; // 가로 y만

    public static int[] oneX = {-1, 0, 0};
    public static int[] oneY = {0, 0, 1};

    public static int[] twoX = {0, 0, 1};
    public static int[] twoY = {0, 1, 0};

    public static int[] threeX = {0, 0, 1};
    public static int[] threeY = {-1, 0, 0};

    public static int[] fourX = {-1, 0, 0};
    public static int[] fourY = {0, 0, -1};

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y < n && y >= 0);
    }

    public static int max(){
        int ret = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m - 2; j++)
                sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];                
            ret = Math.max(ret, sum);
        }

        for (int j = 0; j < m; j++){
            for (int i = 0; i < n - 2; i++)
                sum = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
            ret = Math.max(ret, sum);
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!inRange(i + oneX[0], j + oneY[0]) 
                || !inRange(i + oneX[1], j + oneY[1])
                || !inRange(i + oneX[2], j + oneY[2]))
                continue;

                sum = grid[i + oneX[0]][j + oneY[0]] 
                    + grid[i + oneX[1]][j + oneY[1]] + grid[i + oneX[2]][j + oneY[2]];
                ret = Math.max(ret, sum);
            }
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!inRange(i + twoX[0], j + twoY[0]) 
                || !inRange(i + twoX[1], j + twoY[1])
                || !inRange(i + twoX[2], j + twoY[2]))
                continue;

                sum = grid[i + twoX[0]][j + twoY[0]] 
                    + grid[i + twoX[1]][j + twoY[1]] + grid[i + twoX[2]][j + twoY[2]];
                ret = Math.max(ret, sum);
            }
        }
                
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!inRange(i + threeX[0], j + threeY[0]) 
                || !inRange(i + threeX[1], j + threeY[1])
                || !inRange(i + threeX[2], j + threeY[2]))
                continue;

                sum = grid[i + threeX[0]][j + threeY[0]] 
                    + grid[i + threeX[1]][j + threeY[1]] + grid[i + threeX[2]][j + threeY[2]];
                ret = Math.max(ret, sum);
            }
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!inRange(i + fourX[0], j + fourY[0]) 
                || !inRange(i + fourX[1], j + fourY[1])
                || !inRange(i + fourX[2], j + fourY[2]))
                continue;

                sum = grid[i + fourX[0]][j + fourY[0]] 
                    + grid[i + fourX[1]][j + fourY[1]] + grid[i + fourX[2]][j + fourY[2]];
                ret = Math.max(ret, sum);
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        System.out.print(max());

    }
}