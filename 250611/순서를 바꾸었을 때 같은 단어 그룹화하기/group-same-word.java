import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = sc.next().trim();
        }
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++){
            char[] chars = word[i].toCharArray();

            // 2. 문자 배열을 정렬
            Arrays.sort(chars);

            // 3. 정렬된 문자 배열을 문자열로 변환
            String sorted = new String(chars);
            map.put(sorted, map.getOrDefault(sorted, 0) + 1);
            max = Math.max(map.get(sorted), max);
        }

        System.out.print(max);
        
    }
}