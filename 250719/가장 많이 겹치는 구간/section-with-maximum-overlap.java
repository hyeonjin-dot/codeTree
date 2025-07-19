import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] lst = new int[200001];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            lst[x1] = 1;
            lst[x2] = -1;
        }
        
        int max = 0;
        int sum = 0;
        for (int i = 0; i < 200001; i++){
            if (lst[i] != 0)
                sum += lst[i];
            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}