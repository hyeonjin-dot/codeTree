import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] lst = new int[n];
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int i = 0; i < n; i++){
            lst[i] = sc.nextInt();
            if (lst[i] % 2 == 1)
                odd.add(lst[i]);
            else
                even.add(lst[i]);
        }
        int res = 0;

        if (odd.size() == even.size()){
            System.out.print(n);
            return ;
        }

        int cnt = 0;
        while (odd.size() + even.size() > 0){
            if (cnt % 2 == 0){
                if (even.size() > 0)
                    even.remove(0);
                else if (odd.size() >= 2) {
                    odd.remove(0);
                    odd.remove(0);
                }
                else if (odd.size() == 1) {
                    res -= 2;
                    odd.remove(0);
                }

            }else{
                if (odd.size() > 0)
                    odd.remove(0);
                else {
                    while (even.size() > 0)
                        even.remove(0);
                    res--;
                }
            }

            cnt++;
            res++;
        }

        System.out.print(res);
    }
}