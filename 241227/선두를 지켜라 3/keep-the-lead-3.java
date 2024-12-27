import java.util.*;

public class Main {
    public static List<Integer> A = new ArrayList<>();
    public static List<Integer> B = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a_len = sc.nextInt();
        int b_len = sc.nextInt();

        for (int i = 0; i < a_len; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();

            if (A.size() == 0)
                A.add(v);
            else{
                for (int j = 1; j < t; j++)
                    A.add(Collections.max(A) + v);
            }
        }

        for (int i = 0; i < b_len; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();

            if (B.size() == 0)
                B.add(v);
            else{
                for (int j = 0; j < t; j++)
                    B.add(Collections.max(B) + v);
            }
        }

        int ret = 0;
        int tmp_ret;
        int prt = 0;
        for (int i = 0; i < A.size(); i++){
            tmp_ret = ret;
            // System.out.println(A.get(i) + " " + B.get(i));
            if (A.get(i) > B.get(i))
                ret = 1;
            else if (A.get(i) < B.get(i))
                ret = 2;
            else
                ret = 3;

            if (tmp_ret != ret)
                prt++;
        }

        System.out.print(prt);
    }
}