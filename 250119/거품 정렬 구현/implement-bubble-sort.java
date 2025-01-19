import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] lst = new int[n];

        for (int i = 0; i < n; i++)
            lst[i] = sc.nextInt();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - 1; j++){
                if (lst[j] > lst[j + 1]){
                    int tmp = lst[j];
                    lst[j] = lst[j + 1];
                    lst[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < n; i++)
            System.out.print(lst[i] + " ");
    }
}