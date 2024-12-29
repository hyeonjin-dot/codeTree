import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        sc.nextLine();

        int[][] lst = new int[r][c];
        for (int i = 0; i < r; i++){
            String tmp = sc.nextLine().trim();
            int idx = 0;
            for (int j = 0; j < tmp.length(); j++){
                if (tmp.charAt(j) == ' ')
                    continue;
                else
                    lst[i][idx++] = tmp.charAt(j) == 'W' ? 0 : 1 ;
            }
        }
        int cnt = 0;
        for (int i = 1; i < r - 2; i++){
            for (int j = 1; j < c - 2; j++){
                if (lst[0][0] != lst[i][j]){
                    for (int x = i + 1; x < r - 1; x++){
                        for (int y = j + 1; y < c - 1; y++){
                            if (lst[x][y] != lst[i][j] 
                                && lst[0][0] != lst[r - 1][c - 1])
                                cnt++;
                        }
                    }
                }
            }
        }

        System.out.print(cnt);
    }
}