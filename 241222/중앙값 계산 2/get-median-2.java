import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> lst = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            lst.add(tmp);
            if (i % 2 == 0){
                Collections.sort(lst);
                System.out.print(lst.get((i + 1) / 2) + " ");
            }
        }
    }
}