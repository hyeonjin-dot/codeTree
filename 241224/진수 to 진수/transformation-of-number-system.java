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
        
        while (ten >= b){
            tmp += (ten % b);
            tmp *= 10;
            ten /= b;
            // System.out.println(ten);
        }
        tmp += (ten % b);
        System.out.print(tmp);
    }
}