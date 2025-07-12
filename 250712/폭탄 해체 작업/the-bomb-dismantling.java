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

        int idx = 1;
        int res = 0;
        while (idx <= time){
            if (m.lower(new Pair(idx + 1, 0)) != null){
                Pair tmp = m.lower(new Pair(idx + 1, 0));
                // System.out.println(idx + " " + tmp.getTime() + " " + tmp.getValue());
                if (tmp.getTime() >= idx) {
                    res += tmp.getValue();
                    m.remove(tmp);
                }
            }
            idx++;
        }
        
        
        System.out.print(res);

    }
}