import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            m.put(y, m.getOrDefault(y, 0) + x);
            total += x;
        }
        
        int[] key = m.keySet().stream().mapToInt(i -> i).sorted().toArray();

        int size = key.length;
        int rightIdx = 0;
        int leftIdx = size - 1;
        int rightCnt = m.get(key[rightIdx]);
        int leftCnt = m.get(key[leftIdx]);
        int max = 0;
        
        for (int i = 0; i < total / 2; i++){
            int sum = key[rightIdx] + key[leftIdx];
            max = Math.max(max, sum);

            rightCnt--;
            leftCnt--;

            if (rightCnt <= 0){
                rightIdx++;
                rightCnt = m.get(key[rightIdx]);
            }
            if (leftCnt <= 0){
                leftIdx--;
                leftCnt = m.get(key[leftIdx]);;
            }

            if (leftIdx <= rightIdx)
                break;
        }  

        System.out.print(max);
        
    }
}