import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[3];
        
        for (int i = 0; i < 3; i++)
            arr[i] = sc.nextInt();
        
        int cnt = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                for (int k = 1; k <= n; k++){
                    if (Math.abs(arr[0] - i) < 3 
                        || Math.abs(arr[1] - j) < 3 || Math.abs(arr[2] - k) < 3)
                        cnt++;
                }
            }
        }
        
        System.out.print(cnt);

    }
}