import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().trim();
        String p = sc.next().trim();
        
        int pLen = p.length();
        int sLen = s.length();
        
        boolean result = true;

        for (int i = 0; i < pLen; i++){
            if (s.charAt(i) == p.charAt(i)) 
                continue;
            else if (p.charAt(i) == '.')
                continue;
            else if (i > 0 && p.charAt(i) == '*' && (p.charAt(i - 1) == s.charAt(i - 1) || p.charAt(i - 1) == '.'))
                continue;
            else {
                result = false;
                break;
            }
        }

        if (p.length() < s.length() && p.charAt(pLen - 1) != '*')
            result = false;

        if (result)
            System.out.print("true");
        else
            System.out.print("false");
    }
}