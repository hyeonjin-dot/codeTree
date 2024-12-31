import java.util.*;

public class Main {
    public static int[][] board = new int[19][19];
    // public static boolean[][] visited = new int[19][19];
    public static int black_max = 0;
    public static int white_max = 0;
    public static int[] black = new int[2];
    public static int[] white = new int[2];
    public static int win = 0;

    public static int right(int x, int y) { // y++
        int cnt = 1;
        while (y + 1 < 19 && board[x][y] == board[x][y + 1]) {
            cnt++;
            y++;
        }

        if (cnt == 5 && board[x][y] == 1){
            white[0] = x;
            white[1] = y - 1;
        }else if (cnt == 5){
            black[0] = x;
            black[1] = y - 1;
        }

        return cnt;
    }

    public static int down(int x, int y) { // x++
        int cnt = 1;
        while (x + 1 < 19 && board[x][y] == board[x + 1][y]) {
            cnt++;
            x++;
        }
                
        if (cnt == 5 && board[x][y] == 1){
            white[0] = x - 1;
            white[1] = y;
        }else if (cnt == 5){
            black[0] = x - 1;
            black[1] = y;
        }

        return cnt;
    }

    public static int diagonalRight(int x, int y) { // x++, y++
        int cnt = 1;
        while (x + 1 < 19 && y + 1 < 19 && board[x][y] == board[x + 1][y + 1]) {
            cnt++;
            x++;
            y++;
        }
        
        if (cnt == 5 && board[x][y] == 1){
            white[0] = x - 1;
            white[1] = y - 1;
        }else if (cnt == 5){
            black[0] = x - 1;
            black[1] = y - 1;
        }

        return cnt;
    }

    public static int diagonalLeft(int x, int y) { // x++, y--
        int cnt = 1;
        while (x + 1 < 19 && y - 1 > -1 && board[x][y] == board[x + 1][y - 1]) {
            cnt++;
            x++;
            y--;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 19; i++){
            for (int j = 0; j < 19; j++){
                int tmp = sc.nextInt();
                board[i][j] = tmp;
            }
        }

        for (int i = 0; i < 19; i++){
            for (int j = 0; j < 19; j++){
                if (board[i][j] == 0)
                    continue;
                else{
                    int rightCnt = right(i, j);
                    int downCnt = down(i, j);
                    int diagonalRightCnt = diagonalRight(i, j);
                    int diagonalLeftCnt = diagonalLeft(i, j);
                    rightCnt = rightCnt > downCnt ? rightCnt : downCnt;
                    diagonalRightCnt = diagonalRightCnt > diagonalLeftCnt ? diagonalRightCnt : diagonalLeftCnt;
                    rightCnt = rightCnt > diagonalRightCnt ? rightCnt : diagonalRightCnt;
                    if (board[i][j] == 1)
                        black_max = black_max > rightCnt ? black_max : rightCnt;
                    else if (board[i][j] == 2)
                        white_max = white_max > rightCnt ? white_max : rightCnt;
                }
            }
        }

        if (black_max == 5){
            System.out.println(1);
            System.out.print(white[0] + " " + (white[1]));
        }
        else if (white_max == 5){
            System.out.println(2);
            System.out.print(black[0] + " " + (black[1]));
        }else
            System.out.print(0);
        
    }
}