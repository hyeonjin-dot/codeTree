import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            TreeSet<Integer> s = new TreeSet<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                char command = sc.next().charAt(0);
                int num = sc.nextInt();
                if (command == 'I')
                    s.add(num);
                else if (command == 'D' && !s.isEmpty()){
                    if (num == 1)
                        s.remove(s.last());
                    else
                        s.remove(s.first());
                }
            }
            if (s.isEmpty())
                System.out.println("EMPTY");
            else
                System.out.println(s.last() + " " + s.first());
        }
    }
}