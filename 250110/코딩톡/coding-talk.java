import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        sc.nextLine();

        String[] lst = new String[m];

        for (int i = 0; i < m; i++)
            lst[i] = sc.nextLine().trim();
        
        int[] read = new int[26];

        int p_person = Integer.parseInt(lst[p - 1].substring(2));

        for (int i = 0; i < p - 1; i++){
            if (Integer.parseInt(lst[i].substring(2)) == p_person)
                read[(int)(lst[i].charAt(0) - 'A')]++;
        }
        for (int i = p - 1; i < m; i++)
            read[(int)(lst[i].charAt(0) - 'A')]++;


        for (int i = 0; i < n; i++){
            if (p_person == 0){
                System.out.print("");
                break;
            }
            if (read[i] == 0)
                System.out.print((char)('A' + i) + " ");
        }
    }
}