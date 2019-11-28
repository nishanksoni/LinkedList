package Good;

import static LinkedListStructure.LinkedListStructure.*;

// Merge Sort
// get the middle of the list :  Abstracting out finding the middle node
//
public class sortList {

    private Node sort(Node head) {
        // Base condition
        if (head == null && head.next == null) {
            return head;
        }
        // get the middle of the list :  Abstracting out finding the middle node
        Node middle = getMiddle(head);


        // Sort the left. Sort the right. This is recursive splitting and handing responsibility off
        Node leftHalf = sort(head);
        Node rightHalf = sort(middle);

        Node middleNext = middle.next;

        // set the next of middleNode to null
        middle.next = null;

        Node node = mergeSort(leftHalf, rightHalf);

        return node;
    }

    Node getMiddle(Node head) {
        if (head == null) {
            return null;
        }
        Node slow_runner = head;
        Node fast_runner = head;

        while (fast_runner != null && fast_runner.next != null) {
            fast_runner = fast_runner.next.next;
            slow_runner = slow_runner.next;
        }
        return slow_runner;
    }

    Node mergeSort(Node l1, Node l2) {
        Node node = new Node(0);
        Node head1 = l1;
        Node head2 = l2;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                node.next = head1;
                head1 = head1.next;
                node = node.next;
            } else {
                node.next = head2;
                head2 = head2.next;
                node = node.next;
            }
        }
        if (head1 != null) {
            node.next = head1;
        }
        if (head2 != null) {
            node.next = head2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        sortList sortList = new sortList();

        push(5);
        push(4);
        push(3);
        push(7);
        push(2);
        push(1);

        printList();

        Node sort = sortList.sort(head);


        printList(sort);


    }


}
