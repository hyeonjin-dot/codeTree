import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] lst = new int[n];

        for (int i = 0; i < n; i++)
            lst[i] = sc.nextInt();

        int cnt = 0;
        int distance = 0;
        for (int i = 0; i < n; i++){
            if (lst[i] == 0 && distance == 0)
                continue;
          
            distance++;

            if (distance == 2 * m + 1){
                distance = 0;
                cnt++;
            }
            
        }
        
        if (cnt == 0)
            cnt++;

        System.out.print(cnt);

    }
}