package linkedlist;

public class NthNodeFromEnd {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public static int nthNodeFromEnd(int n){
        Node first=head;
        Node second=head;
        int count =1;
        if(head==null)
            return -1;
        while(count<n){
            first=first.next;
            count++;
        }
        while(first.next!=null){
            first=first.next;
            second=second.next;
        }
        return second.data;
    }

}

