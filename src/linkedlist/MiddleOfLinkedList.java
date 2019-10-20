package linkedlist;

public class MiddleOfLinkedList {



    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    static Node head;

    public static Node middle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }

}
