import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();

        int len = str.length();
        for (int i = 0; i < len; i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        boolean res = true;
        for (int i = 0; i < len; i++){
            if (map.get(str.charAt(i)) == 1){
                System.out.print(str.charAt(i));
                res = false;
                break ;
            }
        }

        if (res)
            System.out.print("None");
    }
}