import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        // 노드 생성 및 연결
        Node head = new Node(1);
        Map<Integer, Node> map = new HashMap<>();
        map.put(1, head);

        Node curr = head;
        for (int i = 2; i <= n; i++) {
            Node next = new Node(i);
            curr.next = next;
            next.prev = curr;
            curr = next;
            map.put(i, next);
        }

        // 쿼리 처리
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            Node aNode = map.get(a);
            Node bNode = map.get(b);
            Node cNode = map.get(c);
            Node dNode = map.get(d);

            if (bNode.next == cNode) {
                Node aPrev = aNode.prev;
                Node dNext = dNode.next;

                if (aPrev != null) aPrev.next = cNode;
                cNode.prev = aPrev;

                dNode.next = aNode;
                aNode.prev = dNode;

                bNode.next = dNext;
                if (dNext != null) dNext.prev = bNode;
            }
            // 이웃한 경우: d.next == a
            else if (dNode.next == aNode) {
                Node cPrev = cNode.prev;
                Node bNext = bNode.next;

                if (cPrev != null) cPrev.next = aNode;
                aNode.prev = cPrev;

                bNode.next = cNode;
                cNode.prev = bNode;

                dNode.next = bNext;
                if (bNext != null) bNext.prev = dNode;
            }
            // 일반적인 경우
            else {
                Node aPrev = aNode.prev;
                Node bNext = bNode.next;
                Node cPrev = cNode.prev;
                Node dNext = dNode.next;

                // 연결 끊기
                if (aPrev != null) aPrev.next = cNode;
                cNode.prev = aPrev;
                if (bNext != null) bNext.prev = dNode;
                dNode.next = bNext;

                if (cPrev != null) cPrev.next = aNode;
                aNode.prev = cPrev;
                if (dNext != null) dNext.prev = bNode;
                bNode.next = dNext;
            }

        }

        // 결과 출력
        while (head.prev != null) head = head.prev; // 실제 head로 이동
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
