import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] lst = new int[n][2];
        boolean[] checked = new boolean[n];

        for (int i = 0; i < n; i++){
            lst[i][0] = sc.nextInt();
            lst[i][1] = sc.nextInt();
        }
        // lst[i][0] ~ lst[i][1] 가 
        // lst[j][0] ~ lst[j][0] 속에 다 들어오면 겹침

        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                if (lst[i][1] <= lst[j][1] && lst[i][0] >= lst[j][0]){
                    checked[i] = true;
                    checked[j] = true;
                }else if (lst[i][1] >= lst[j][1] && lst[i][0] <= lst[j][0]){
                    checked[i] = true;
                    checked[j] = true;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++){
            if (!checked[i])
                res++;
        }

        System.out.print(res);
    }
}