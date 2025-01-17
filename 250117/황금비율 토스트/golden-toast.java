import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        LinkedList<Character> lst = new LinkedList<>();
        for (char c : sc.nextLine().trim().toCharArray()) {
            lst.add(c);
        }

        ListIterator<Character> it = lst.listIterator(n);

        for (int i = 0; i < m; i++) {
            String command = sc.nextLine().trim();
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
                    it.add(command.charAt(2));
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : lst) {
            result.append(c);
        }
        System.out.print(result);
    }
}
