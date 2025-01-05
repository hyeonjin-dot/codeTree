import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int money = sc.nextInt();

        int[][] lst = new int[n][3];

        for (int i = 0; i < n; i++){
            lst[i][0] = sc.nextInt();
            lst[i][1] = sc.nextInt();
            lst[i][2] = lst[i][0] + lst[i][1];
        }
        Arrays.sort(lst, (a, b) -> {
            if (a[2] != b[2]) {
                return Integer.compare(a[2], b[2]); // a[2] 기준
            } else {
                return Integer.compare(b[0], a[0]);
            }
        });

        boolean used = false;
        int sum = 0;
        int idx = 0;
        while (idx < n){
            sum += lst[idx][1];

            if (!used 
                    && sum + (lst[idx][0] / 2) <= money){
                sum += lst[idx][0] / 2;
                used = true;
            }else if (sum + lst[idx][0] <= money)
                sum += lst[idx][0];
            else
                break;
            idx++;
        }

        // System.out.println(sum);
        // if (sum <= money)
            System.out.print(idx);
        // else
            // System.out.print(idx - 1);
    }
}