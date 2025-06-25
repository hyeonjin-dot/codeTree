import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // arr1 길이
        int m = sc.nextInt(); // arr2 길이
        int k = sc.nextInt(); // k번째로 작은 합

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();
        for (int i = 0; i < m; i++) arr2[i] = sc.nextInt();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        Set<String> visited = new HashSet<>();

        pq.add(new int[] {0, 0, arr1[0] + arr2[0]});
        visited.add("0,0");

        int answer = 0;

        for (int count = 0; count < k; count++) {
            int[] now = pq.poll();
            int i = now[0];
            int j = now[1];
            answer = now[2];

            if (i + 1 < n) {
                String key = (i + 1) + "," + j;
                if (!visited.contains(key)) {
                    pq.add(new int[] {i + 1, j, arr1[i + 1] + arr2[j]});
                    visited.add(key);
                }
            }

            if (j + 1 < m) {
                String key = i + "," + (j + 1);
                if (!visited.contains(key)) {
                    pq.add(new int[] {i, j + 1, arr1[i] + arr2[j + 1]});
                    visited.add(key);
                }
            }
        }

        System.out.println(answer);
    }
}
