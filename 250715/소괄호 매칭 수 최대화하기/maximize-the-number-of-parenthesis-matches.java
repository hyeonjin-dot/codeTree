import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr, (a, b) -> (a + b).compareTo(b + a));

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        String str = sb.toString();
        int cnt = 0;
        for (int i = 0; i < str.length() - 1; i++){
            if (str.charAt(i) == '('){
                for (int j = i + 1; j < str.length(); j++){
                    if (str.charAt(j) == ')')
                        cnt++;
                }
            }
        }

        System.out.print(cnt);
        // Please write your code here.
    }
}