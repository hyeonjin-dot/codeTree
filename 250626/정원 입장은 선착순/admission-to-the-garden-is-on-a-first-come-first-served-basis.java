import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<int[]> jobs = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] a = new int[3];
            a[0] = sc.nextInt();
            a[1] = sc.nextInt();
            a[2] = i;
            jobs.add(a);
        }
        
        // 1. 시간 순으로 정렬된 작업들 (도착시간 기준)
        

        // 2. 지금 가능한 작업 중 번호가 가장 작은 사람 (번호 기준)
        PriorityQueue<int[]> candidates = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        int sum = 0;
        int max = 0;

        while (!jobs.isEmpty() || !candidates.isEmpty()) {

            // 현재 시간에 입장 가능한 작업들 모두 candidates에 추가
            while (!jobs.isEmpty() && jobs.peek()[0] <= sum) {
                candidates.add(jobs.poll());
            }

            int[] best;

            // 입장 가능한 사람이 있으면, 그 중 번호가 가장 작은 사람
            if (!candidates.isEmpty()) {
                best = candidates.poll();
            } else {
                // 입장 가능한 사람이 없으면 다음 사람 기다림
                best = jobs.poll();
                sum = best[0];
            }

            max = Math.max(max, sum - best[0]);  // 대기 시간
            sum += best[1];                      // 머무는 시간 반영
        }


        System.out.println(max);
    }
}