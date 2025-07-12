import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        int[] timeLimits = new int[n];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            timeLimits[i] = sc.nextInt();
            if (!m.containsKey(timeLimits[i]))
                m.put(timeLimits[i], scores[i]);
            else {
                if (m.get(timeLimits[i]) < scores[i])
                    m.put(timeLimits[i], scores[i]);
            }
        }

        int res = 0;
        List<Integer> lst = new ArrayList<>(m.keySet());
        for (int key : lst){
            res += m.get(key);
        }
        System.out.print(res);

    }
}