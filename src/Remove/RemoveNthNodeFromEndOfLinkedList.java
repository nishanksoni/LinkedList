package Remove;

import static LinkedListStructure.LinkedListStructure.*;
import static LinkedListStructure.LinkedListStructure.head;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNthNodeFromEndOfLinkedList {

    public Node removeNthFromEnd(Node head, int n) {
        Node slow = head;
        Node fast = head;
        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return slow.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return head;
    }


    public static void main(String[] args) {
        RemoveNthNodeFromEndOfLinkedList removeNthNodeFromEndOfLinkedList = new RemoveNthNodeFromEndOfLinkedList();
        push(20);
        push(4);
        push(15);
        push(35);

        printList();

        int k = 2;
        Node node = new RemoveNthNodeFromEndOfLinkedList().removeNthFromEnd(head, k);

        printList(node);

    }
}
