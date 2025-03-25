import java.util.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static List<Integer> lst = new ArrayList<>();
    public static int min;

    public static void find(int idx){
        if (idx == n - 1){
            //if (lst.size() > 1)
                min = Math.min(min, lst.size());
            return ;
        }

        lst.add(arr[idx]);
        int move = arr[idx];
        for (int i = 1; i <= move; i++){
            if (idx >= n)
                continue;
            find(idx + i);
        }
        lst.remove(lst.size() - 1);
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        min = Integer.MAX_VALUE;
        find(0);
        min = min == Integer.MAX_VALUE ? -1 : min;
        System.out.print(min);
    }
}