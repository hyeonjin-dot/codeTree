import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        sc.nextLine();
        String commend = sc.nextLine().trim();

        int[][] place = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int tmp = sc.nextInt();
                place[i][j] = tmp;
            }
        }

        int sum = place[n / 2][n / 2];
        int[] x_way = {-1, 0, 1, 0};  // 왼쪽으로
        int[] y_way = {0, -1, 0, 1};
        // System.out.print(sum);
        int way = 0;
        int now_x = n / 2;
        int now_y = n / 2;
        for (int i = 0; i <commend.length(); i++){
            if (commend.charAt(i) == 'F'){
                if (now_x + x_way[way] < 0 || now_x + x_way[way] >= n)
                    continue;
                if (now_y + y_way[way] < 0 || now_y + y_way[way] >= n)
                    continue;
                sum += place[now_x + x_way[way]][now_y + y_way[way]];
                now_x += x_way[way];
                now_y += y_way[way];
            }else if (commend.charAt(i) == 'L')
                way = (way + 1) % 4;
            else{
                if (way == 0)
                    way = 3;
                else
                    way--;
            }
        }
        System.out.print(sum);
    }
}