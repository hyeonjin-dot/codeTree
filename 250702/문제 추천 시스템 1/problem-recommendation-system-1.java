import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<int[]> s = new TreeSet<>((a,b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            return a[0] - b[0];
        });
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[2];
            tmp[0] = sc.nextInt();
            tmp[1] = sc.nextInt();
            s.add(tmp);
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            if (command.equals("rc")) {
                int x = sc.nextInt();
                if (x == 1){
                    int[] tmp = s.first();
                    System.out.println(tmp[0]);
                }else {
                    int[] tmp = s.last();
                    System.out.println(tmp[0]);
                }
            } else if (command.equals("ad") || command.equals("sv")) {
                int[] tmp = new int[2];
                tmp[0] = sc.nextInt();
                tmp[1] = sc.nextInt();
                if (command.equals("ad"))
                    s.add(tmp);
                else
                    s.remove(tmp);
            }
        }
        
    }
}