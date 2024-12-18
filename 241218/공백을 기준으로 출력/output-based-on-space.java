import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String one = sc.nextLine().trim();
        String two = sc.nextLine().trim();

        one = one.replace(" ", "");
        two = two.replace(" ", "");
        System.out.print(one);
        System.out.print(two);
    }
}