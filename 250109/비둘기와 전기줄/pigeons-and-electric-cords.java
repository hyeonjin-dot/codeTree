import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] lst = new int[11];
        Arrays.fill(lst, -1);

        int res = 0;

        for (int i = 0; i < n; i++){
            int num = sc.nextInt();
            int space = sc.nextInt();
            if (lst[num] != -1 && lst[num] != space){
                res++;
                lst[num] = space;
            }else
                lst[num] = space;
        }

        System.out.print(res);
    }
}