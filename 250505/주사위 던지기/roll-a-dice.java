import java.util.Scanner;

public class Main {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int n;
    public static int[] dice;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int moveDice(int[] dice, int dire){
        if (dire == 0){
            int temp = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[4];
            dice[4] = temp;
        }else if (dire == 1){
            int temp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[5];
            dice[5] = temp;
        }else if (dire == 2){
            int temp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[3];
            dice[3] = temp;
        }else {
            int temp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[2];
            dice[2] = temp;
        }

        return dice[1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        int[] directions = new int[m];
        int[][] place = new int[n][n];
        for (int i = 0; i < m; i++) {
            String tmp = sc.next();
            if (tmp.equals("U"))
                directions[i] = 1;
            else if (tmp.equals("D"))
                directions[i] = 0;
            else if (tmp.equals("L"))
                directions[i] = 3;
            else
                directions[i] = 2;
        }
    
        int[] dice = {1, 6, 4, 3, 2, 5};

        place[r][c] = dice[1];
        for (int i = 0; i < m; i++){
            int dire = directions[i];
            int nx = r + dx[dire];
            int ny = c + dy[dire];

            if (inRange(nx, ny)){
                place[nx][ny] = moveDice(dice, dire);
                r = nx;
                c = ny;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                sum += place[i][j];
        }

        System.out.print(sum);
    }
}