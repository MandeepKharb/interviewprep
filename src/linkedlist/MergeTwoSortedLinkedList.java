package linkedlist;

   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class MergeTwoSortedLinkedList {
    public ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode head;
        if (first == null)
            return second;
        else if (second == null)
            return first;
        else if (first.val < second.val) {
            head = first;
            head.next = mergeTwoLists(first.next, second);
        } else {
            head = second;
            head.next = mergeTwoLists(first, second.next);
        }
        return head;

    }
}
