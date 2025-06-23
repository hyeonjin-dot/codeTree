import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<String, Integer> map = new TreeMap<>();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Entry<String, Integer> entry = it.next();
            // System.out.println(entry.getKey() + " " + );
            System.out.printf("%s %.4f\n", entry.getKey(), ((double)entry.getValue()/ n) * 100);
        }
        // Please write your code here.
    }
}