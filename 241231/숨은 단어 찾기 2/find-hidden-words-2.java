import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++){
            String tmp = sc.nextLine().trim();
            for (int j = 0; j < m; j++){
                board[i][j] = tmp.charAt(j);
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == 'L'){
                    if (j - 2 >= 0 && board[i][j - 1] == 'E'){ // 왼
                        if (board[i][j - 2] == 'E')
                            cnt++;
                    }
                    if (j + 2 < m && board[i][j + 1] == 'E'){ // 오
                        if (board[i][j + 2] == 'E')
                            cnt++;
                    }
                    if (i >= 2 && board[i - 1][j] == 'E'){ // 상
                        if (board[i - 2][j] == 'E')
                            cnt++;
                    }
                    if (i + 2 < n && board[i + 1][j] == 'E'){ // 하
                        if (board[i + 2][j] == 'E')
                            cnt++;
                    }
                    if (j - 2 >= 0 && i - 2 >= 0 && board[i - 1][j - 1] == 'E'){ // 대 왼 위
                        if (board[i - 2][j - 2] == 'E')
                            cnt++;
                    }
                    if (j + 2 < m && i + 2 < n && board[i + 1][j + 1] == 'E'){ // 대 왼 아래
                        if (board[i + 2][j + 2] == 'E')
                            cnt++;
                    }
                    if (i - 2 >= 0 && j + 2 < m && board[i - 1][j + 1] == 'E'){ // 대 오 위
                        if (board[i - 2][j + 2] == 'E')
                            cnt++;
                    }
                    if (i + 2 < n && j - 2 >= 0 && board[i + 1][j - 1] == 'E'){ // 대 오 아래
                        if (board[i + 2][j - 2] == 'E')
                            cnt++;
                    }
                }
            }
        }

        System.out.print(cnt);
    }
}