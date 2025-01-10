import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        sc.nextLine();

        int[] lst = new int[26];
        char[] how = new char[100];

        for (int i = 0; i < m; i++){
            String tmp = sc.nextLine().trim();
            lst[(int)(tmp.charAt(0) - 'A')] = Integer.parseInt(tmp.substring(2));
            how[i] = tmp.charAt(0);
        }

        if (lst[(int)(how[p - 1] - 'A')] == 0){
            System.out.print("");
            return ;
        }

        int[] read = new int[n];
        for (int i = 0 ; i < p - 1; i++){
            if (lst[(int)(how[i] - 'A')] == lst[(int)(how[p - 1] - 'A')]){
                read[(int)(how[i] - 'A')]++;
            }
        }
        for (int i = p - 1; i < m; i++)
            read[(int)(how[i] - 'A')]++;
        
        for (int i = 0; i < m; i++){
            if (read[i] == 0){
                char tmp = (char)('A' + i);
                System.out.print(tmp + " ");
            }
        }
    }
}