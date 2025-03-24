import java.util.*;
public class Main {
    public static int n;
    public static int[][] num;
    public static int[][] moveDir;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // moveDir 순서대로
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int r; // 출발 x
    public static int c; // 출발 y
    public static List<Integer> lst = new ArrayList<>(); // 지나간 칸의 값 넣기
    public static int max;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void find(int x, int y){
        int idx = moveDir[x][y] - 1;

        int nx = x + dx[idx];
        int ny = y + dy[idx];

        int check = 0;

        while (inRange(nx, ny)){
            if (num[nx][ny] > num[x][y]){
                check = num[nx][ny];
                lst.add(num[nx][ny]);
                find(nx, ny);
                lst.remove(lst.size() - 1);
            }
            nx += dx[idx];
            ny += dy[idx];
        }

        if (check == 0){
            max = Math.max(max, lst.size());
            return ;
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                num[i][j] = sc.nextInt();
        }
        moveDir = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                moveDir[i][j] = sc.nextInt();
        }
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        max = 0;
        find(r, c);
        System.out.print(max);
    }
}