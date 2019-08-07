package Interviewbit;

import static LinkedListStructure.LinkedListStructure.*;

//  delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
public class RemoveDuplicatesFromSortedList2
{

    private Node removeDuplicatesCompletely(Node head)
    {
        if (head == null) {
            return null;
        }
        Node FakeHead = new Node(0);
        FakeHead.next = head;
        Node pre = FakeHead;
        Node cur = head;
        while (cur != null) {
            while (cur.next != null && cur.data == cur.next.data) {
                cur = cur.next;
            }
            if (pre.next == cur)
            {
                pre = pre.next; // // cur.val is distinct, move pre to next node
            } else {
                pre.next = cur.next; // skip duplicates, but pre shouldn't move now
            }
            cur = cur.next;
        }
        return FakeHead.next;
    }


    public static void main(String args[]) {
        RemoveDuplicatesFromSortedList2 removeDuplicatesFromSortedList2 = new RemoveDuplicatesFromSortedList2();
        push(5);
        push(4);
        push(3);
        push(3);
        push(2);
        push(1);

        System.out.println("List before removal of duplicates");

        printList();

        Node node = removeDuplicatesFromSortedList2.removeDuplicatesCompletely(head); // 3 was the duplicate now it is completely removed

        System.out.println("List after removal of elements");

        printList(node);
    }


}
