import java.util.*;

class Bomb {
    int score;
    int deadline;

    public Bomb(int score, int deadline) {
        this.score = score;
        this.deadline = deadline;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Bomb> bombs = new ArrayList<>();
        int maxTime = 0;

        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int deadline = sc.nextInt();
            bombs.add(new Bomb(score, deadline));
            maxTime = Math.max(maxTime, deadline);
        }

        // 마감 시간 내림차순 정렬
        bombs.sort((a, b) -> b.deadline - a.deadline);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 점수 max heap
        int res = 0;
        int idx = 0;

        for (int t = maxTime; t >= 1; t--) {
            // 마감 시간 >= t인 폭탄들 pq에 추가
            while (idx < n && bombs.get(idx).deadline >= t) {
                pq.offer(bombs.get(idx).score);
                idx++;
            }

            // 점수 가장 높은 것 하나 해체
            if (!pq.isEmpty()) {
                res += pq.poll();
            }
        }

        System.out.println(res);
    }
}
