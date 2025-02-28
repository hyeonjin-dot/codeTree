import java.util.Scanner;
public class Main {
    public static int[] dx = {1, -1, 0, 0}; // e w s n
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            // Please write your code here.
            if (direction == 'E'){
                x += dx[0] * distance;
                y += dy[0] * distance;
            }else if (direction == 'W'){
                x += dx[1] * distance;
                y += dy[1] * distance;
            } else if (direction == 'S'){
                x += dx[2] * distance;
                y += dy[2] * distance;
            }else {
                x += dx[3] * distance;
                y += dy[3] * distance;
            }
        }

        System.out.print(x + " " + y);
    }
}