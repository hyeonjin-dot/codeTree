import java.util.*;
public class Main {
    public static int n;
    public static List<Integer> lst = new ArrayList<>();
    public static boolean[] visited;

    public static void printAnswer(){
        for (int i = 0; i < n; i++)
            System.out.print(lst.get(i) + " ");
        System.out.println();
    }

    public static void make(int idx){
        if (idx == 0){
            printAnswer();
            return ;
        }

        for (int i = n; i > 0; i--){
            if (visited[i])
                continue ;

            lst.add(i);
            visited[i] = true;
            make(idx - 1);
            lst.remove(lst.size() - 1);
            visited[i] = false;
        }
        return ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n + 1];
        make(n);
    }
}