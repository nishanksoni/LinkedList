package Interviewbit;

import static LinkedListStructure.LinkedListStructure.*;

// Hard Question
//  delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28335/My-accepted-Java-code
public class RemoveDuplicatesFromSortedList2 {

    private Node removeDuplicatesCompletely(Node head) {
        if (head == null) {
            return null;
        }
        Node FakeHead = new Node(0);
        FakeHead.next = head;
        Node previous = FakeHead;
        Node current = head;
        while (current != null) {
            while (current.next != null && current.data == current.next.data) {
                current = current.next;
            }
            if (previous.next == current) {
                previous = previous.next; // // cur.val is distinct, move pre to next node
            } else {
                previous.next = current.next; // skip duplicates, but pre shouldn't move now
            }
            current = current.next;
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
