import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        // sc.nextLine();

        String tmp = sc.next();
        LinkedList<Character> lst = new LinkedList<>();
        for (int i = 0; i < tmp.length(); i++) {
            lst.add(tmp.charAt(i));
        }

        ListIterator<Character> it = lst.listIterator(lst.size());

        for (int i = 0; i < m; i++) {
            String command = sc.next();
            char action = command.charAt(0);
            switch (action) {
                case 'L':
                    if (it.hasPrevious()) it.previous();
                    break;
                case 'R':
                    if (it.hasNext()) it.next();
                    break;
                case 'D':
                    if (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                    break;
                case 'P':
                    String s = command.split(" ")[1];
                    it.add(s.charAt(0));
                    break;
            }
        }

        it = lst.listIterator();
        while (it.hasNext())
            System.out.print(it.next());
    }
}
