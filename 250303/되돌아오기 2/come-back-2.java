import java.util.Scanner;
public class Main {
    public static int[] dx = {-1, 0, 1, 0}; // 시계방향
    public static int[] dy = {0, 1, 0, -1};
    public static int x;
    public static int y;
    public static int time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();
        
        x = 0;
        y = 0;
        time = 0;
        int idx = 0;

        for (int i = 0; i < commands.length(); i++){
            if (commands.charAt(i) == 'F'){
                x += dx[idx];
                y += dy[idx];
            }else if (commands.charAt(i) == 'R')
                idx++;
            else
                idx--;
            
            if (idx < 0)
                idx += 4;
            idx %= 4;   
            time++;

            if (x == 0 && y == 0)
                break;
        }
        
        if (x != 0 && y != 0)
            time = -1;

        System.out.print(time);
    }
}