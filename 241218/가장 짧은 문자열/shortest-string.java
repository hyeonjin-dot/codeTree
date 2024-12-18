import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String one = sc.nextLine().trim();
        String two = sc.nextLine().trim();
        String three = sc.nextLine().trim();

        int one_l = one.length();
        int two_l = two.length();
        int three_l = three.length();

        int max = one_l > two_l ? one_l : two_l;
        max = max > three_l ? max : three_l;
        int min = one_l < two_l ? one_l : two_l;
        min = min < three_l ? min : three_l;

        System.out.print(max - min);
    }
}