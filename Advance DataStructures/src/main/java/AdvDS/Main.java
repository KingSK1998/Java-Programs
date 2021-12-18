package AdvDS;

public class Main {
    public static void main(String[] args) {
//        DoublyLinkedList list = new DoublyLinkedList(2);
//        list.insertItem(3);
//        list.insertItem(6);
//        list.deleteItem(3);
//        list.printList();

//        Person p1 = new Person("A", 24);
//        Person p2 = new Person("B", 55);
//        Person p3 = new Person("C", 23);
//        Person p4 = new Person("D", 34);
//        Person p5 = new Person("E", 18);
//        BST bst = new BST();
//        bst.insert(p1);
//        bst.insert(p2); 
//        bst.insert(p3);
//        bst.insert(p4);
//        bst.insert(p5);
//        
//        bst.showAll(bst.findNode("A"));
//        Person p = bst.getData(bst.findParent("B"));
//        System.out.println(p.toString());

        HashTable hashTable = new HashTable();
        Student std1 = new Student("Rishab", "123", 3.5);
        Student std2 = new Student("Rohan", "456", 3.1);
        Student std3 = new Student("Ritesh", "321", 3.4);
        int std1Key = hashTable.toHashCode(std1.getRoll_no());
        int std2Key = hashTable.toHashCode(std2.getRoll_no());
        int std3Key = hashTable.toHashCode(std3.getRoll_no());
        hashTable.insert(std1Key, std1);
        hashTable.insert(std2Key, std2);
        hashTable.insert(std3Key, std3);
        hashTable.deleteStd(std3.getRoll_no());
        hashTable.showData();
//        Student new_Std2 = hashTable.fetchStdInfo(std2.getRoll_no());
//        if(new_Std2.getName().equals(std2.getName()))
//            System.out.println("Equal");
    }
}
