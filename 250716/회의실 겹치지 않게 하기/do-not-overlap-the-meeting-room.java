import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] lst = new int[n][2];
        for (int i = 0; i < n; i++) {
            lst[i][0] = sc.nextInt();
            lst[i][1] = sc.nextInt();
        }

        Arrays.sort(lst, (a, b) -> Integer.compare(a[1], b[1]));

        int cnt = 1;
        int end = lst[0][1];
        for (int i = 1; i < n; i++){
            if (lst[i][0] >= end){
                cnt++;
                end = lst[i][1];
            }
        }

        System.out.print(n - cnt);
    }
}