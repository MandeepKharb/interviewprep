package linkedlist;

public class ReverseLinkedList {
    static Node head;
    static  class Node {
        int data;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) { data = d; }
    }

    public static Node reverseLinkedList(Node head){
        Node current =head;
        Node previous = null;
        Node next = null;
        if (head== null)
        {
            return null;
        }
        while(current.next!=null){
            next = current.next;
            current.next=previous;
            current=next;
            previous=current;


        }
        return previous;
    }
}
