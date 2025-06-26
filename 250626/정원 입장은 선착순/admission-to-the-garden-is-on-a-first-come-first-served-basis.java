import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] a = new int[3];
            a[0] = sc.nextInt();
            a[1] = sc.nextInt();
            a[2] = i;
            q.add(a);
        }
        
        int[] a = q.poll();
        int sum = a[0] + a[1];
        int max = 0;


        // sum보다  tmp[0]이 크면 sum 초기화
        while (!q.isEmpty()) {
            int[] best = null;
            List<int[]> deferred = new ArrayList<>();

            while (!q.isEmpty() && q.peek()[0] <= sum) {
                int[] now = q.poll();
                if (best == null || now[2] < best[2]) {
                    if (best != null) deferred.add(best);
                    best = now;
                } else {
                    deferred.add(now);
                }
            }

            if (best == null) {
                best = q.poll();       // 강제 시작할 작업
                sum = best[0];         // sum 초기화
            }

            max = Math.max(max, sum - best[0]);
            sum += best[1];

            for (int[] d : deferred) {
                q.add(d); // deferred 리스트 다시 추가
            }
        }

        System.out.println(max);
    }
}