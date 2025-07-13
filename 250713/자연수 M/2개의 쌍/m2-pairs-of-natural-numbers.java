import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int count = sc.nextInt();
            int value = sc.nextInt();
            map.put(value, map.getOrDefault(value, 0) + count);
            total += count;
        }

        int max = 0;

        while (total > 1) {
            int minKey = map.firstKey();
            int maxKey = map.lastKey();
            int pairSum = minKey + maxKey;
            max = Math.max(max, pairSum);

            // 하나씩 소모
            map.put(minKey, map.get(minKey) - 1);
            map.put(maxKey, map.get(maxKey) - 1);
            total -= 2;

            if (map.get(minKey) != null && map.get(minKey) == 0) map.remove(minKey);
            if (map.get(maxKey) != null && map.get(maxKey) == 0 && minKey != maxKey) map.remove(maxKey);
        }

        System.out.println(max);
    }
}
