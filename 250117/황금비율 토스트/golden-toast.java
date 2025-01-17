import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        List<Character> lst = new ArrayList<>();
        String tmp = sc.nextLine().trim();
        for (int i = 0; i < n; i++)
            lst.add(tmp.charAt(i));
        
        ListIterator<Character> it = lst.listIterator(n);

        for (int i = 0; i < m; i++){
            String cmm = sc.nextLine().trim();
            if (cmm.charAt(0) == 'L' && it.hasPrevious())
                it.previous();
            else if (cmm.charAt(0) == 'R'&& it.hasNext())
                it.next();
            else if (cmm.charAt(0) == 'D'&& it.hasNext()){
                it.next();
                it.remove();
            }
            else if (cmm.charAt(0) == 'P')
                it.add(cmm.charAt(2));
        }

        it = lst.listIterator();
        while (it.hasNext())
            System.out.print(it.next());


    }
}