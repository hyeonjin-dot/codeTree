import java.util.*;

class Pair implements Comparable<Pair>{
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p){
        if ((p.x + p.y) == (this.x + this.y)){
            if (p.x == this.x)
                return this.y - p.y;
            return this.x - p.x;
        }
        return (this.x + this.y) - (p.x + p.y);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Pair tmp = new Pair(x, y);
            q.add(tmp);
        }

        for (int i = 0; i < m; i++){
            Pair min = q.poll();
            min.x += 2;
            min.y += 2;
            q.add(min);
        }
        
        Pair min = q.poll();
        System.out.print(min.x + " " + min.y);
    }
}