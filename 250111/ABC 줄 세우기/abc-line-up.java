import java.util.*;

public class Main {
    public static boolean ordered(int[] lst){
        int n = lst.length;

        for (int i = 0; i < n; i++){
            if (lst[i] != i)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String tmp = sc.nextLine().trim();

        int[] lst = new int[n];
        int idx = 0;
        for (int i = 0; i < tmp.length(); i++){
            if (tmp.charAt(i) == ' ')
                continue;
            else{
                lst[idx] = (int)(tmp.charAt(i) - 'A');
                idx++;
            }
        }

        idx = 0;
        for (int i = n - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (lst[j] > lst[j + 1]){
                    int num = lst[j];
                    lst[j] = lst[j + 1];
                    lst[j + 1] = num;
                    idx++;
                }
            }
        }
        
        System.out.print(idx);
    }
}