import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> all = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++){
            int num = sc.nextInt();
            if (num >= 0)
                pos.add(num);
            else
                neg.add(num);
            all.add(num);
        }

        Collections.sort(all, Collections.reverseOrder());
        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg);

        long pos3 = 0;
        long neg2 = 0;

        if (neg.size() >= 2){ // 일반적 
            if (pos.size() >= 3){
                pos3 = pos.get(0) * pos.get(1) * pos.get(2);
                neg2 = pos.get(0) * neg.get(0) * neg.get(1);
            }else { // pos 1, 2
                if (pos.size() == 2)
                    pos3 = pos.get(0) * pos.get(1) * neg.get(0);
                else
                    pos3 = pos.get(0) * neg.get(0) * neg.get(1);
                neg2 = pos.get(0) * neg.get(0) * neg.get(1);
            }
        } else if (n == 3){ // 3개
            pos3 = all.get(0) * all.get(1) * all.get(2);
            neg2 = pos3;
        } else if (neg.size() <= 1){ // neg0
            pos3 = pos.get(0) * pos.get(1) * pos.get(2);
            neg2 = pos3;
        }

        long max = Math.max(pos3, neg2);

        System.out.print(max);
    }
}