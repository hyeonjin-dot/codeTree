import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int count = sc.nextInt();
            int value = sc.nextInt();
            map.put(value, map.getOrDefault(value, 0) + count);
            total += count;
        }

        int[] keys = map.keySet().stream().mapToInt(i -> i).sorted().toArray();
        int left = 0, right = keys.length - 1;
        int leftCount = map.get(keys[left]);
        int rightCount = map.get(keys[right]);
        int max = 0;

        for (int i = 0; i < total / 2; i++) {
            int pairSum = keys[left] + keys[right];
            max = Math.max(max, pairSum);

            leftCount--;
            rightCount--;

            if (leftCount == 0 && left < right) {
                left++;
                leftCount = map.get(keys[left]);
            }

            if (rightCount == 0 && left < right) {
                right--;
                rightCount = map.get(keys[right]);
            }
        }

        System.out.println(max);
    }
}
