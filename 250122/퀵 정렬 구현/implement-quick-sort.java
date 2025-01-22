import java.util.*;

public class Main {
    public static int partition(int[] lst, int low, int high){
        int pivot = lst[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++){
            if (lst[j] < pivot){
                i++;
                int tmp = lst[j];
                lst[j] = lst[i];
                lst[i] = tmp;
            }
        }

        int tmp = lst[high];
        lst[high] = lst[i + 1];
        lst[i + 1] = tmp;
        return i + 1;
    }

    public static void sort(int[] lst, int low, int high){
        if (low < high){
            int pos = partition(lst, low, high);

            sort(lst, low, pos - 1);
            sort(lst, pos + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] lst = new int[n];

        for (int i = 0; i < n; i++)
            lst[i] = sc.nextInt();

        sort(lst, 0, n - 1);

        for (int i = 0; i < n; i++)
            System.out.print(lst[i] + " ");
    }
}