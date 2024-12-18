import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        List<String> str = new ArrayList<>();
        int[] len = new int[n];

        for (int i = 0; i < n; i++){
            String tmp = sc.nextLine().trim();
            str.add(tmp);
            len[i] = tmp.length();
        }

        char c = sc.next().charAt(0);

        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++){
            if (str.get(i).charAt(0) == c){
                cnt++;
                sum += len[i];
            }
        }
        double ret = (double)(sum / (double)cnt);
        
        System.out.print(cnt + " ");
        System.out.printf("%.2f", ret);
    }
}