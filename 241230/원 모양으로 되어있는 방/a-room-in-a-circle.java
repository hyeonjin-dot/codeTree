import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();
        
        int[] lst = new int[n];

        for (int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            lst[i] = tmp;
        }

        int min = 200301;
        
        for (int i = 0; i < n; i++){ // 여기서 시작 가정
            int cnt = 0;
            for (int j = 0; j < n; j++){
                if (i == j)
                    continue;
                else if (i < j)
                    cnt = cnt + (j - i) * lst[j];
                else
                    cnt = cnt + (j - i + n) * lst[j];
            }
            min = min < cnt ? min : cnt;
        }

        System.out.print(min);
    }
}