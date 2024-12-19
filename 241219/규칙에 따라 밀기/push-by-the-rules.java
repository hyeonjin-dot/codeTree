import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();
        String moving = sc.nextLine().trim();
        StringBuilder move = new StringBuilder();

        for (int i = 0; i < moving.length() ; i++){
            if (moving.charAt(i) == 'L' && i < moving.length() - 1){
                if (moving.charAt(i + 1) == 'R'){
                    i++;
                    continue;
                }
            }
            else if (moving.charAt(i) == 'R'&& i < moving.length() - 1){
                if (moving.charAt(i + 1) == 'L'){
                    i++;
                    continue;
                }
            }
            move.append(moving.charAt(i));
        }
        
        // L << 방향 - R >> 방향 +

        int dic = 0;
        for (int i = 0; i < move.length(); i++){
            if (move.charAt(i) == 'L')
                dic++;
            else
                dic--;
        }

        for (int i = 0; i < str.length(); i++){
            dic += str.length();
            int idx = dic % str.length();
            System.out.print(str.charAt(idx));
            dic++;
        }
    }
}