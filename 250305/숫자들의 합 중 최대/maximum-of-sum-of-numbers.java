import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int max = Integer.MIN_VALUE;

        for (int i = x; i <= y; i++){
            String tmp = Integer.toString(i);
            int sum = 0;
            for (int j = 0; j < tmp.length(); j++)
                sum += tmp.charAt(j) - '0';
            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}