import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int min = sc.nextInt();
        int max = 0;

        int length = 0;
        for (int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            if (tmp > min)
                length++;
            else{
                max = max > length ? max : length;
                length = 0;
            }
        }

        System.out.print(max);
    }
}