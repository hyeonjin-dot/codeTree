import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++){
            String cmd = sc.next();
            if (cmd.equals("add")){
                int a = sc.nextInt();
                int b = sc.nextInt();
                map.put(a, b);
            }else if (cmd.equals("remove")){
                int a = sc.nextInt();
                map.remove(a);
            } else if (cmd.equals("find")){
                int a = sc.nextInt();
                if (map.containsKey(a))
                    System.out.println(map.get(a));
                else
                    System.out.println("None");
            } else{
                Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
                while (it.hasNext()){
                    Entry<Integer, Integer> entry = it.next();
                    System.out.print(entry.getValue() + " ");
                }
                if (map.isEmpty())
                    System.out.print("None");
                System.out.println();
            }
            
        }

    }
}