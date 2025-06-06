import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] groupA = new String[n];
        String[] groupB = new String[n];
        for (int i = 0; i < n; i++) {
            groupA[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            groupB[i] = sc.next();
        }

        int cnt = 0;

        for (int i = 0; i < m - 2; i++){
            for (int j = i + 1; j < m - 1; j++){
                for (int k = j + 1; k < m; k++){
                    HashSet<String> a = new HashSet<>();
                    HashSet<String> b = new HashSet<>();
                    for (int len = 0; len < n; len++){
                        a.add("" + groupA[len].charAt(i) + groupA[len].charAt(j) + groupA[len].charAt(k));
                        b.add("" + groupB[len].charAt(i) + groupB[len].charAt(j) + groupB[len].charAt(k));
                    }
                    HashSet<String> copy = new HashSet<>(a);
                    copy.retainAll(b);

                    if (copy.isEmpty())
                        cnt++;
                }
            }
        }

        System.out.print(cnt);
        
    }
}