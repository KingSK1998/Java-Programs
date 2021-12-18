package AdvDS;

public class DoublyLinkedList {
    private Node head;
    
    public DoublyLinkedList(int item) {
        head = new Node();
        head.value = item;
        head.next = null;
        head.prev = null;
    }
    
    public boolean insertItem(int item) {
        Node n = new Node();
        n.value = item;
        n.prev = null;
        head.prev = n;
        n.next = head;
        head = n;
        return true;
    }
    
    public void printList() {
        Node z = head;
        while (z != null) {            
            System.out.println(z.value);
            z = z.next;
        }
    }
    
    public boolean deleteItem(int item) {
        if(head.value == item) {
            head = head.next;
            return true;
        } else {
            Node x = head;
            Node y = head.next;
            while (true) {
                if(y == null || y.value == item) break;
                else {
                    x = y;
                    y = y.next;
                }
            }
            if(y != null) {
                x.next = y.next;
                return true;
            } else {
                return false;
            }
        }
    }
    
    class Node {    // NESTED CLASS
        private Node prev;
        private int value;
        private Node next;
    }
}