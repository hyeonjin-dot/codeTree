import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<Integer> input = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            String tmp = sc.nextLine().trim();
            String[] div = tmp.split(" ");
            if (div[0].equals("push_back"))
                input.add(Integer.parseInt(div[1]));
            else if (div[0].equals("get"))
                System.out.println(input.get(Integer.parseInt(div[1]) - 1));
            else if (div[0].equals("pop_back"))
                input.remove(input.size() - 1);
            else
                System.out.println(input.size());
        }
    }
}