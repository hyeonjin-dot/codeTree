import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int s = sc.nextInt();

        int [][] taken = new int[n][m]; // n번 사람이 m번 치즈를 몇초에 먹었는지
        int [] ill = new int[n]; // n번째 사람이 언제 아프기 시작했는지 
        boolean [] medicine = new boolean[n]; // 약먹어야하면 추가
        boolean [] spoil = new boolean[m]; // 치즈가 상했나요

        for (int i = 0; i < d; i++){
            int person = sc.nextInt() - 1;
            int cheese = sc.nextInt() - 1;
            int when = sc.nextInt();
            taken[person][cheese] = when;
        }

        for (int i = 0; i < s; i++){
            int person = sc.nextInt() - 1;
            int start = sc.nextInt();
            ill[person] = start;
        }

        for (int i = 0; i < n; i++){ // 사람 넘버
            if (ill[i] == 0)
                continue;

            for (int j = 0; j < m; j++){
                if (taken[i][j] > 0 && taken[i][j] < ill[i])
                    spoil[j] = true;
            }

        }

        for (int i = 0; i < m; i++){
            if (!spoil[i])
                continue;

            for (int j = 0; j < n; j++){
                if (taken[j][i] > 0)
                    medicine[j] = true;
            }
        }

        int res = 0;
        for (boolean medi : medicine){
            if (medi)
                res++;
        }

        System.out.print(res);
    }
}