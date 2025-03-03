import java.util.Scanner;
public class Main {
    public static int[] dx = {0, 0, 1, -1}; // 동서남북
    public static int[] dy = {1, -1, 0, 0};
    public static int x;
    public static int y;
    public static int n;
    public static int time;

    public static int checkDir(char dir){
        if (dir == 'E')
            return 0;
        else if (dir == 'W')
            return 1;
        else if (dir == 'S')
            return 2;
        else    
            return 3;
    }
    
    public static void move(char dir, int dist){
        int idx = checkDir(dir);

        for (int i = 0; i < dist; i++){
            x += dx[idx];
            y += dy[idx];
            time++;
            
            if (x == 0 && y == 0)
                return;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = 0;
        y = 0;
        time = 0;

        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();
            move(dir, dist);
            if (x == 0 && y == 0)
                break;
        }

        if (x != 0 || y != 0)
            time = -1;

        System.out.print(time);
    
    }
}