import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().trim();
        String p = sc.next().trim();
        
        int pLen = p.length();
        boolean result = true;

        for (int i = 0; i < pLen; i++){
            if (s.charAt(i) == p.charAt(i)) 
                continue;
            else if (p.charAt(i) == '.')
                continue;
            else if (i > 0 && p.charAt(i) == '*' && (p.charAt(i - 1) == s.charAt(i - 1) || p.charAt(i - 1) == '.'))
                break;
            else {
                result = false;
                break;
            }
        }

        if (result)
            System.out.print("true");
        else
            System.out.print("false");
    }
}