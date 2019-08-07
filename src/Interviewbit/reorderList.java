package Interviewbit;

import static LinkedListStructure.LinkedListStructure.*;

// Runner technique
// Find the middle node -> reverse the second half thank link both
public class reorderList {


    public Node reorderLists(Node A) {
        reorderList(A);
        return A;
    }

    public void reorderList(Node head) {
        if (head == null) {
            return;
        }
        // Find the middle node
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("the middle element is " + slow.data);

        // Reverse the second half
        Node secondHalfReverse = reverse(slow.next);
        slow.next = null;

        // Link the two halves together
        while (head != null && secondHalfReverse != null) {
            Node tmp1 = head.next;
            Node tmp2 = secondHalfReverse.next;
            secondHalfReverse.next = head.next;
            head.next = secondHalfReverse;
            head = tmp1;
            secondHalfReverse = tmp2;
        }
    }

    private Node reverse(Node secondHalf) {
        Node prev = null;
        Node current = secondHalf;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Node head = prev;
        return head;
    }

    public static void main(String[] args) {
        reorderList listCycle = new reorderList();

        push(60);
        push(50);
        push(40);
        push(30);
        push(20);
        push(10);
        printList(); // 10 20 30 40 50 60


        System.out.println(); // swap first than last

        Node node = listCycle.reorderLists(head);


        printList(node);


    }
}
