import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] lst = new int[n];

        for (int i = 0; i < n; i++)
            lst[i] = sc.nextInt();

        for (int i = 1; i < n; i++){
            int key = lst[i];
            int j = i - 1;
            while (j >= 0 && lst[j] > key){
                lst[j + 1] = lst[j];
                j--;
            }
            lst[j + 1] = key;
        }

        for (int i = 0; i < n; i++)
            System.out.print(lst[i] + " ");
    }
}