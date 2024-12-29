import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        sc.nextLine();

        char[][] lst = new char[r][c];
        for (int i = 0; i < r; i++){
            String tmp = sc.nextLine().trim();
            int idx = 0;
            for (int j = 0; j < tmp.length(); j++){
                if (tmp.charAt(j) == ' ')
                    continue;
                else
                    lst[i][idx++] = tmp.charAt(j);
            }
        }
        int cnt = 0;
        for (int i = 1; i < r - 2; i++){
            for (int j = 1; j < c - 2; j++){
                if (lst[0][0] != lst[i][j]){
                    for (int x = i + 1; x < r - 1; x++){
                        for (int y = j + 1; y < c - 1; y++){
                            if (lst[x][y] != lst[i][j])
                                cnt++;
                        }
                    }
                }
            }
        }

        System.out.print(cnt);
    }
}