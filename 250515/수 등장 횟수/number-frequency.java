import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < n; i++){
            if (map.get(arr[i]) == null)
                map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
        }

        for (int i = 0; i < m; i++){
            if (map.get(queries[i]) == null)
                System.out.print(0 + " ");
            else
                System.out.print(map.get(queries[i]) + " ");
        }
        
    }
}