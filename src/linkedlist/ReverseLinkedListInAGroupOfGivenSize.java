/*
* "Rotate a linked list or
Given a singly linked list of size N.
 The task is to rotate the linked list counter-clockwise by k nodes,
where k is a given positive integer smaller than or equal to length of the linked list."

* */

package linkedlist;

public class ReverseLinkedListInAGroupOfGivenSize {

    private  int a=0;

    static Node head;

    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) {
            data = d;
        }
    }

    public static int length(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;

        }
        return length;
    }


    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static Node reverse(Node head, int index) {
        Node current=head;
        Node previous=null;
        Node next=null;
        int i=0;

        while(i<index&&current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
            i++;

        }

        if(next!=null){
            head.next=reverse(next,i);
        }
        return previous;
    }


    public static void main(String[] args) {
        ReverseLinkedListInAGroupOfGivenSize list = new ReverseLinkedListInAGroupOfGivenSize();

        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head, 2);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);

    }
}