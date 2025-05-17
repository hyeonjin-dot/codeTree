import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] words = new String[n + 1];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            words[i] = sc.next();
            map.put(words[i], i);
        }
        
        for (int i = 1; i <= m; i++){
            String s = sc.next().trim();
            if (s.charAt(0) - '0' <= 9 && s.charAt(0) - '0' >= 0)
                System.out.println(words[Integer.parseInt(s)]);
            else
                System.out.println(map.get(s));
        }
    }
}