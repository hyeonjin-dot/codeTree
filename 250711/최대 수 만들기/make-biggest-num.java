import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().trim();
        }

        Arrays.sort(arr, (a, b) -> {
            // 첫 번째 문자 비교
            if (a.charAt(0) != b.charAt(0)) {
                return Character.compare(b.charAt(0), a.charAt(0));
            }
            // 길이 비교
            else if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            // 두 번째 문자 비교
            else {
                // 만약 문자열 길이가 1이라면 비교할 수 없음
                if (a.length() < 2 || b.length() < 2) return 0;
                return Character.compare(b.charAt(1), a.charAt(1));
            }
        });
        
        for (int i = 0; i < n; i++){
            System.out.print(arr[i]);
        }
    }
}