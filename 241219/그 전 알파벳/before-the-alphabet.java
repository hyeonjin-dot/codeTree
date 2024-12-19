import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char c = sc.nextLine().trim().charAt(0);

        if (c == 'a')
            System.out.print('z');
        else
            System.out.print(--c);
    }
}