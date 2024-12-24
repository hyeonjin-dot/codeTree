import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int n = sc.nextInt();

        int ten = 0;
        int tmp = n;
        int idx = 0;
        while (tmp > 9){
            ten += (tmp % 10) * (int)Math.pow(a, idx);
            idx++;
            tmp /= 10;
        }
        ten += (tmp % 10) * (int)Math.pow(a, idx);
        
        List<Integer> result = new ArrayList<>();
        while (ten > 0) {
            result.add(ten % b);
            ten /= b;
        }
        
        for (int i = result.size() - 1; i >= 0; i--)
            System.out.print(result.get(i));
    }
}