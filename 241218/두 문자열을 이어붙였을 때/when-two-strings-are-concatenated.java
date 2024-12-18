import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine().trim();
        String b = sc.nextLine().trim();

        StringBuilder ab = new StringBuilder();
        StringBuilder ba = new StringBuilder();

        ab.append(a);
        ab.append(b);
        ba.append(b);
        ba.append(a);

        System.out.print(ba.toString().equals(ab.toString()));
    }
}