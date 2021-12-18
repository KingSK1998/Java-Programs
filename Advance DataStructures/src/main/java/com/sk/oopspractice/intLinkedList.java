package com.sk.oopspractice;

public class intLinkedList {
    private Node head;
    
    public intLinkedList() {
        head = new Node();
        head.value = 0;
        head.link = null;
    }
    
//    public boolean insertItem(int item) {
//        Node n = new Node();
//        n.value = item;
//        n.link = head;
//        head = n;
//        return true;
//    }
    
    public boolean insertItem(int item) {
        Node n = new Node();
        n.value = item;
        n.link = null;
        Node newNode = head;
        while (newNode.link != null) {            
            newNode = newNode.link;
        }
        newNode.link = n;
        return true;
    }
    
    public void printList() {
        Node z = head.link;
        while (z != null) {            
            System.out.println(z.value);
            z = z.link;
        }
    }
    
    public boolean deleteItem(int item) {
        if(head.value == item) {
            head = head.link;
            return true;
        } else {
            Node x = head;
            Node y = head.link;
            while (true) {
                if(y == null || y.value == item) break;
                else {
                    x = y;
                    y = y.link;
                }
            }
            if(y != null) {
                x.link = y.link;
                return true;
            } else {
                return false;
            }
        }
    }
    
    public void reverse() {
        int c = 0;
        Node a = head.link;
        while (a.link != null) {
            Node b = head.link;
            while (b.link != null) {
                if (b.value < b.link.value) {
                    c = b.value;
                    b.value = b.link.value;
                    b.link.value = c;
                }
                b = b.link;
            }
            a = a.link;
        }
    }
    
    class Node {    // NESTED CLASS
        private int value;
        private Node link;
    }
}
