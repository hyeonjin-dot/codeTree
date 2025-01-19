import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] lst = new int[n];

        for (int i = 0; i < n; i++)
            lst[i] = sc.nextInt();

        int min = 0;
        for (int i = 0; i < n; i++){
            min = i;
            for (int j = i; j < n; j++){
                if (lst[min] > lst[j])
                    min = j;
            }
            int tmp = lst[i];
            lst[i] = lst[min];
            lst[min] = tmp;
        }   

        for (int i = 0; i < n; i++)
            System.out.print(lst[i] + " ");
    }
}