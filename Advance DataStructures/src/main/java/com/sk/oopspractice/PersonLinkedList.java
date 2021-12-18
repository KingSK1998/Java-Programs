package com.sk.oopspractice;

public class PersonLinkedList {
    private Node head;
    
    public PersonLinkedList(Person person) {
        head = new Node();
        head.person = person;
        head.link = null;
    }
    
//    public boolean insertItem(int item) {
//        Node n = new Node();
//        n.value = item;
//        n.link = head;
//        head = n;
//        return true;
//    }
    
    public boolean insertItem(Person person) {
        Node n = new Node();
        Node newNode = head;
        while (newNode.link != null) {            
            newNode = newNode.link;
        }
        n.person = person;
        n.link = null;
        newNode.link = n;
        return true;
    }
    
    public void printList() {
        Node z = head;//.link;
        while (z != null) {            
            System.out.println(z.person.getPerson());
            z = z.link;
        }
    }
    
    public boolean deleteItem(String name) {
        if(name.equals(head.person.getName())) {
            head = head.link;
            return true;
        } else {
            Node x = head;
            Node y = head.link;
            while ((y != null) && (y.person.getName().equals(name))) {
                x = y;
                y = y.link;
            }
            if(y != null) {
                x.link = y.link;
                return true;
            } else {
                return false;
            }
        }
    }
    
//    public void reverse() {
//        int c = 0;
//        Node a = head.link;
//        while (a.link != null) {
//            Node b = head.link;
//            while (b.link != null) {
//                if (b.value < b.link.value) {
//                    c = b.value;
//                    b.value = b.link.value;
//                    b.link.value = c;
//                }
//                b = b.link;
//            }
//            a = a.link;
//        }
//    }
    
    class Node {    // NESTED CLASS
        private Person person;
        private Node link;
    }
}
