import java.util.Scanner;

public class Main {
    public static int[] dx = {0, -1, 0, 1}; // 왼쪽으로 북 좌 남 우
    public static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        int x = 0;
        int y = 0;

        int idx = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'L')
                idx++;
            else if (s.charAt(i) == 'R')
                idx--;
            else{
                x += dx[idx];
                y += dy[idx];
            }

            if (idx < 0)
                idx+= 4;
            idx %= 4; 
        }

        System.out.print(x + " " + y);
    }
}