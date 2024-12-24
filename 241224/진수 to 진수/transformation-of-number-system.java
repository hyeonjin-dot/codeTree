import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int n = sc.nextInt();

        int ten = 0;
        int tmp = n;
        int idx = 0;
        while (tmp > 9){
            ten += (tmp % 10) * Math.pow(a, idx);
            idx++;
            tmp /= 10;
        }
        ten += (tmp % 10) * Math.pow(a, idx);
        
        tmp = 0;
        idx = 0;
        // System.out.println(ten);
        while (ten >= b){
            tmp += (ten % b) * Math.pow(10, idx);
            idx++;
            // System.out.println(ten % b);
            // tmp *= 10;
            ten /= b;
            // System.out.println(ten);
        }
        tmp += (ten % b) * Math.pow(10, idx);
        System.out.print(tmp);
    }
}