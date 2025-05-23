import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine().trim();
        StringBuilder str = new StringBuilder();

        int changed = 0;

        if (n.length() == 1 && n.charAt(0) == '1'){
            System.out.print(0);
            return ;
        }

        for (int i = 0; i < n.length(); i++){
            if (n.charAt(i) == '0' && changed == 0){
                str.append('1');
                changed++;
            }
            else
                str.append(n.charAt(i));
        }

        int res = 0;
        int j = 0;
        for (int i = str.toString().length() - 1; i >= 0; i--){
            res += (str.charAt(i) - '0') * Math.pow(2, j);
            j++;
        }

        if (changed == 0)
            res--;

        System.out.print(res);
    }
}