import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];
        HashMap<Long, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            map.put((long)arr[i], map.getOrDefault((long)arr[i], 0) + 1);
        }

        List<Map.Entry<Long, Integer>> lst = new ArrayList<>(map.entrySet());
        lst.sort((a, b) -> {
            int cmp = b.getValue().compareTo(a.getValue());
            if (cmp != 0) return cmp;
            return b.getKey().compareTo(a.getKey()); // key가 큰 순서대로
        });

        for (int i = 0; i < k; i++)
            System.out.print(lst.get(i).getKey() + " ");



    }
}