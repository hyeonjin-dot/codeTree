import java.util.Scanner;
public class Main {
    public static int[] num;
    public static int[] count1;
    public static int[] count2;
    public static int n;

    public static boolean checkSame(int i, int a){
        String str = String.valueOf(num[i]);
        String tmp = String.valueOf(a);
        
        int cnt = 0;

        for (int x = 0; x < 3; x++){
            if (str.charAt(x) == tmp.charAt(x))
                cnt++;
        }

        return cnt == count1[i];
    }

    public static boolean checkHave(int i, int a){
        String str = String.valueOf(num[i]);
        String tmp = String.valueOf(a);

        int cnt = 0;

        for (int x = 0; x < 3; x++){
            for (int y = 0; y < 3; y++){
                if (x != y && str.charAt(x) == tmp.charAt(y))
                    cnt++;
            }
        }

        return cnt == count2[i];
    }
    
    public static boolean isValid(int x){
        String str = String.valueOf(x);

        if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2)
            || str.charAt(1) == str.charAt(2))
                return false;

        for (int i = 0; i < n; i++){
            if (!checkSame(i, x) || !checkHave(i, x))
                return false;
        }
        return true;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n];
        count1 = new int[n];
        count2 = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            count1[i] = sc.nextInt();
            count2[i] = sc.nextInt();
        }
    
        int res = 0;
        for (int i = 123; i <= 987; i++){
            if (isValid(i))
                res++;
        }

        System.out.print(res);
    }
}