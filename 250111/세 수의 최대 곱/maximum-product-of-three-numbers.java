import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++){
            int num = sc.nextInt();
            if (num >= 0)
                pos.add(num);
            else
                neg.add(num);
        }

        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg);

        long pos3 = pos.get(0) * pos.get(1) * pos.get(2);
        long neg2 = pos.get(0) * neg.get(0) * neg.get(1);

        long max = Math.max(pos3, neg2);

        System.out.print(max);
    }
}