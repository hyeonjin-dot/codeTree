import java.util.*;

class Pair implements Comparable<Pair> {
    int time;
    int value;

    public Pair(int time, int value){
        this.time = time;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.time != o.time) return Integer.compare(this.time, o.time);
        return Integer.compare(this.value, o.value);
    }

    public int getValue(){
        return this.value;
    }

    public int getTime(){
        return this.time;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        int[] timeLimits = new int[n];
        TreeSet<Pair> m = new TreeSet<>();
        int time = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            timeLimits[i] = sc.nextInt();
            m.add(new Pair(timeLimits[i], scores[i]));
            time = Math.max(time, timeLimits[i]);
        }

        int idx = time;
        int res = 0;

        while (idx >= 1) {
            // idx 이하에서 가능한 Pair 모두 가져오기
            SortedSet<Pair> candidates = m.tailSet(new Pair(idx, 0));
            Pair best = null;

            for (Pair p : candidates) {
                if (best == null || p.getValue() > best.getValue()) {
                    best = p;
                }
            }

            if (best != null) {
                res += best.getValue();
                m.remove(best);
            }

            idx--;
        }

        
        
        System.out.print(res);

    }
}