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
        
        Arrays.sort(lst, (a, b) -> Integer.compare(b[1], a[1]));

        int cnt = 0;
        int last = 0;
        for (int i = 0; i < n; i++){
            if (i == 0){
                last = lst[i][0];
                cnt++;
                continue ;
            } 
            
            if (lst[i][1] <= last){
                cnt++;
                last = lst[i][0];
            }
        }

        System.out.print(cnt);
    }
}