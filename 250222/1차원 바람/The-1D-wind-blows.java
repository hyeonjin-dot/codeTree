import java.util.*;

public class Main {
    public static int[][] lst;
    public static int n;
    public static int m;
    public static String[] commend;

    public static void listMove(int moveLine, boolean left){
        if (!left){ // ->
            int tmp = lst[moveLine][0];
            for (int j = 0; j < m - 1; j++)
                lst[moveLine][j] = lst[moveLine][j + 1];
            lst[moveLine][m - 1] = tmp;
        }else { // <=
            int tmp = lst[moveLine][m - 1];
            for (int j = m - 1; j > 0; j--)
                lst[moveLine][j] = lst[moveLine][j - 1];
            lst[moveLine][0] = tmp;
        }
    }

    public static void move(String str){
        String[] split = str.split(" ");
        int moveLine = (int)(Integer.parseInt(split[0])) - 1;
        boolean left = true;
        
        if (split[1].charAt(0) == 'R')
            left = false;
        
        listMove(moveLine, left);

        boolean direction = !left;
        int moveUp = moveLine - 1;

        while (true) { // 위로
            if (moveUp < 0)
                break ;
            
            int sameCnt = 0;

            for (int i = 0; i < m; i++){
                if (lst[moveUp + 1][i] == lst[moveUp][i])
                    sameCnt++;
            }

            if (sameCnt == 0)
                break;

            listMove(moveUp, direction);

            moveUp--;
            direction = !direction;
        }

        int moveDown = moveLine + 1;
        direction = !left;

        while (true) { // 아래로
            if (moveDown >= n)
                break ;
            
            int sameCnt = 0;

            for (int i = 0; i < m; i++){
                if (lst[moveDown - 1][i] == lst[moveDown][i])
                    sameCnt++;
            }

            if (sameCnt == 0)
                break;

            listMove(moveDown, direction);

            moveDown++;
            direction = !direction;
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int q = sc.nextInt();

        lst = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                lst[i][j] = sc.nextInt();
            }
        }

        if (q > 0) {
            commend = new String[q];
            sc.nextLine();

            for (int i = 0; i < q; i++)
                commend[i] = sc.nextLine().trim();

            for (int i = 0; i < q; i++)
                move(commend[i]);
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                System.out.print(lst[i][j] + " ");
            System.out.println();
        }
    }
}