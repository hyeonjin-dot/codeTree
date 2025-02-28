import java.util.Scanner;
public class Main {
    public static int n;

    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int res = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int tmp = 0;
                for (int idx = 0; idx < 4; idx++){
                    if (inRange(i + dx[idx], j + dy[idx]))
                        tmp += arr[i + dx[idx]][j + dy[idx]];
                }
                if (tmp >= 3)
                    res++;
            }
        }

        System.out.print(res);
    }
}