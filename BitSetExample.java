import java.util.BitSet;

// public class App {
    
//     Node head;
//     static class Node {
//         int data;
//         Node next;
//         Node(int d) {   data = d;   next = null;    }
//     }

//     void printList(Node node)
//     {
//         while (node != null) {
//             System.out.print(node.data + " ");
//             node = node.next;
//         }
//     }

//     public Node reverseNodes(Node node, int k) {
//         Node prev = null;
//         Node current = node;
//         Node next = null;
//         while (current != null) {
//             next = current.next;
//             current.next = prev;
//             prev = current;
//             current = next;
//         }
//         node = prev;
//         return node;
//     }

//     public static void main(String[] args) throws Exception {
//         App l1 = new App();
//         l1.head = new Node(1);
//         l1.head.next = new Node(2);
//         l1.head.next.next = new Node(3);
//         l1.head.next.next.next = new Node(4);
//         l1.head.next.next.next.next = new Node(5);
//         l1.head.next.next.next.next.next = new Node(6);
//         l1.reverseNodes(head, 3);
//         l1.printList(head);
//         System.out.println("\n");
//         // App l2 = new App();
//         // l2.head = new Node(1);
//         // l2.head.next = new Node(2);
//         // l2.head.next.next = new Node(3);
//         // l2.head.next.next.next = new Node(4);
//         // l2.head.next.next.next.next = new Node(5);
//         // l2.reverseNodes(head, 1);
//         // l2.printList(head);
//         // System.out.println("\n");
//         // App l3 = new App();
//         // l3.head = new Node(1);
//         // l3.head.next = new Node(2);
//         // l3.head.next.next = new Node(3);
//         // l3.head.next.next.next = new Node(4);
//         // l3.reverseNodes(head, 2);
//         // l3.printList(head);
//         // System.out.println("\n");
//     }
// }
public class BitSetExample{
    public static void main(String[] args) {
        BitSet bs = new BitSet(3);
        for (int i = 0; i < 3; ++i) {
            bs.set(i);
            bs.set(++i);
        }
        bs.clear(1);
        System.out.println(bs);
    }
}