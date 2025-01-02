import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int money = sc.nextInt();

        int[][] lst = new int[n][2];

        for (int i = 0; i < n; i++){
            lst[i][0] = sc.nextInt();
            lst[i][1] = sc.nextInt();
        }

        boolean used = false;
        int sum = 0;
        int idx = -1;
        while (sum <= money && idx < n){
            idx++;
            sum += lst[idx][1];
        
            if (!used && sum + lst[idx][0] > money 
                    && sum + (lst[idx][0] / 2) < money){
                sum += lst[idx][0] / 2;
                used = true;
            }else
                sum += lst[idx][0];
        }

        System.out.print(idx);
    }
}