import java.util.Scanner;

public class Main {
    public static boolean valid(int target){
        int[] lst = new int[10];

        String str = Integer.toString(target);
        int lot = 0;
        int one = 0;

        for (int i = 0; i < str.length(); i++){
            int idx = (str.charAt(i) - '0');
            lst[idx]++;
        }

        for (int i = 0; i < 10; i++){
            if (lst[i] > 1)
                lot++;
            if (lst[i] == 1)
                one++;
        }

        return (one == 1 && lot == 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int cnt = 0;

        for (int i = x; i <= y; i++){
            if (valid(i)){
                // System.out.println(i);
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}