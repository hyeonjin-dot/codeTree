import java.util.Scanner;
public class Main {
    public static int[][] lst;
    public static int[][] queries;
    public static int n;
    public static int m;
    public static int q;

    public static void move(int x1, int y1, int x2, int y2) {  
        int temp = lst[x1][y1]; // 왼쪽 상단 값 저장 (시작점)

        // 1️⃣ 왼쪽 열 위로 이동
        for (int i = x1; i < x2; i++) {
            lst[i][y1] = lst[i + 1][y1];
        }

        // 2️⃣ 아래쪽 행 왼쪽으로 이동
        for (int j = y1; j < y2; j++) {
            lst[x2][j] = lst[x2][j + 1];
        }

        // 3️⃣ 오른쪽 열 아래로 이동
        for (int i = x2; i > x1; i--) {
            lst[i][y2] = lst[i - 1][y2];
        }

        // 4️⃣ 위쪽 행 오른쪽으로 이동
        for (int j = y2; j > y1 + 1; j--) {
            lst[x1][j] = lst[x1][j - 1];
        }

        lst[x1][y1 + 1] = temp; // 처음 저장했던 값 넣기

        update(x1, y1, x2, y2);
    }

    public static void update(int x1, int y1, int x2, int y2){ // 값 갱신
        int[][] tmp = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(i >= x1 && i <= x2) {
                    if (j >= y1 && j <= y2){
                        int cnt = 1;
                        int sum = lst[i][j];
                        if (i - 1 >= 0){
                            cnt++;
                            sum += lst[i - 1][j];
                        }
                        if (i + 1 < n){
                            cnt++;
                            sum += lst[i + 1][j];
                        }
                        if (j - 1 >= 0){
                            cnt++;
                            sum += lst[i][j - 1];
                        }
                        if (j + 1 < m){
                            cnt++;
                            sum += lst[i][j + 1];
                        }
                        tmp[i][j] = sum / cnt;
                    }else
                        tmp[i][j] = lst[i][j];
                }else
                    tmp[i][j] = lst[i][j];
            }
        }
        lst = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        lst = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                lst[i][j] = sc.nextInt();
        queries = new int[q][4];
        for (int i = 0; i < q; i++)
            for (int j = 0; j < 4; j++)
                queries[i][j] = sc.nextInt() - 1;
        
        for (int i = 0; i < q; i++)
            move(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                System.out.print(lst[i][j] + " ");
            System.out.println();
        }

    }
}