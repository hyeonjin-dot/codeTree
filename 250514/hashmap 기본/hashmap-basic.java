import java.util.*;
public class Main {
    public static HashMap<Integer, Integer> m = new HashMap<>();;

    public static void hash(String cmd, int k, int v){
        if (cmd.equals("add"))
            m.put(k, v);
        else if (cmd.equals("remove"))
            m.remove(k);
        else{
            if (m.get(k) != null)
                System.out.println(m.get(k));
            else
                System.out.println("None");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++){
            String str = sc.nextLine().trim();
            String[] tmp = str.split(" ");
            if (tmp.length <= 2)
                hash(tmp[0], Integer.parseInt(tmp[1]), 0);
            else
                hash(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
        }   
    }
}