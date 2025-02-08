import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] lst = new int[3];

        for (int i = 0; i < 3; i++)
            lst[i] = sc.nextInt();

        int cnt = 0;

        while (true){
            if (lst[0] + 1 == lst[1] && lst[1] + 1 == lst[2])
                break;

            if (lst[1] - lst[0] == 2){
                lst[1] = lst[0] + 1;
                lst[2] = lst[1] + 1;
            }else if (lst[2] - lst[1] == 2){
                lst[1] = lst[2] - 1;
                lst[0] = lst[1] - 1;
            }else {
                if (lst[1] - lst[0] > lst[2] - lst[1]){
                    lst[2] = lst[1];
                    lst[1] = lst[2] - 2;
                }else{
                    lst[0] = lst[1];
                    lst[1] = lst[0] + 2;
                }
            }
            cnt++;
        }

        System.out.print(cnt);
    }
}