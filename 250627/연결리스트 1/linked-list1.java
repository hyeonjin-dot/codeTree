import java.util.*;

class Node {
    String data;
    Node prev, next;

    public Node(String data){
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sInit = sc.nextLine();
        Node curr = new Node(sInit);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++){
            int idx = sc.nextInt();
            
            if (idx == 1){
                String data = sc.next();
                Node tmp = new Node(data);
                if (curr.prev != null){
                    Node pre = curr.prev;
                    curr.prev = tmp;
                    tmp.next = curr;
                    tmp.prev = pre;
                    pre.next = tmp;
                } else {
                    curr.prev = tmp;
                    tmp.next = curr;
                }
            } else if (idx == 2){
                String data = sc.next();
                Node tmp = new Node(data);
                if (curr.next != null){
                    Node nex = curr.next;
                    curr.next = tmp;
                    tmp.prev = curr;
                    tmp.next = nex;
                    nex.prev = tmp;
                } else {
                    curr.next = tmp;
                    tmp.prev = curr;
                }
            } else if (idx == 3){
                if (curr.prev != null)
                    curr = curr.prev;
            } else {
                if (curr.next != null)
                    curr = curr.next;
            }
            if (curr.prev == null)
                System.out.print("(Null) ");
            else 
                System.out.print(curr.prev.data + " ");
            System.out.print(curr.data + " ");
            if (curr.next == null)
                System.out.print("(Null)");
            else 
                System.out.print(curr.next.data);
            System.out.println();
        }
        
    }
}