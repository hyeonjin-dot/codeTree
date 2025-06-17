import java.util.*;
import java.util.Map.Entry;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
            if (m.containsKey(numbers[i]))
                continue;
            m.put(numbers[i], i + 1);
        }
        
        Iterator<Entry<Integer, Integer>> it = m.entrySet().iterator();
        while (it.hasNext()){
            Entry<Integer, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}