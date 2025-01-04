import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] lst = new int[n];

        for (int i = 0; i < n; i++)
            lst[i] = sc.nextInt();
        
        int max = -1;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j <= i + k && j < n; j++){
                if (lst[i] == lst[j])
                    max = Math.max(lst[i], max);
            }
        }

        System.out.print(max);
    }
}