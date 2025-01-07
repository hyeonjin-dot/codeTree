import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();

        int[] lst = new int[1001];
        int placeMax = 0;
        for (int i = 0; i < t; i++){
            String tmp = sc.nextLine().trim();
            if (tmp.charAt(0) == 'S')
                lst[Integer.parseInt(tmp.substring(2))] = 1;
            else
                lst[Integer.parseInt(tmp.substring(2))] = 2;
            placeMax = Math.max(placeMax, Integer.parseInt(tmp.substring(2)));
        }

        int res = 0;

        for (int i = a; i <= b; i++){
            int up = 1001;
            int down = 1001;
            for (int j = i; j >= 0; j--){
                if (lst[j] == 1){
                    down = (i - j);
                    break;
                }
            }
            for (int j = i; j <= placeMax; j++){
                if (lst[j] == 1){
                    up = (j - i);
                    break;
                }
            }
            int ds = Math.min(up, down);
            up = 1001;
            down = 1001;
            for (int j = i; j >= 0; j--){
                if (lst[j] == 2){
                    down = (i - j);
                    break;
                }
            }
            for (int j = i; j <= placeMax; j++){
                if (lst[j] == 2){
                    up = (j - i);
                    break;
                }
            }
            int dn = Math.min(up, down);
            if (ds <= dn)
                res++;
        }

        System.out.print(res);
    }
}