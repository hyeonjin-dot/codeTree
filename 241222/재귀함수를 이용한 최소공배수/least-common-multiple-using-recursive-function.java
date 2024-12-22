import java.util.*;

public class Main {
    public static int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b){
        return (a * (b / gcd(a, b)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> lst = new ArrayList<>();

        for (int i = 0; i < n; i++){
            lst.add(sc.nextInt());
        }
        
        // Collections.sort(lst);

        int ret = lst.get(0);
        for (int i = 1; i < n; i++){
            // System.out.println(ret);
            if (ret > lst.get(i))
                ret = lcm(ret, lst.get(i));
            else
                ret = lcm(lst.get(i), ret);
            // System.out.println(lst.get(i) + " " + ret);
        }

        System.out.print(ret);
    }
}