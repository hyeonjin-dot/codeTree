import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] lst = new int[n][2];

        for (int i = 0; i < n; i++){
            lst[i][0] = sc.nextInt();
            lst[i][1] = sc.nextInt();
        }

        int res = 0;

        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1; j < n - 1; j++){
                for (int k = j + 1; k < n; k++){
                    int[] length = new int[100];
                    boolean overlap = false;
                    for (int x = 0; x < n; x++){
                        if (x == i || x == j || x == k)
                            continue;
                        for (int y = lst[x][0]; y <= lst[x][1]; y++){
                            length[y]++;
                            if (length[y] == 2){
                                overlap = true;
                                break;
                            }
                        }
                    }
                    if (!overlap)
                        res++;
                }
            }
        }

        System.out.print(res);

    }
}