package Good;

import static LinkedListStructure.LinkedListStructure.*;

// Merge Sort
public class sortList {

    private Node sort(Node head) {

        if (head == null && head.next == null) {
            return head;
        }
        // get the middle of the list
        Node middle = getMiddle(head);
        Node middleNext = middle.next;

        // set the next of middleNode to null
        middle.next = null;

       // mergeSort(middle);

        return null;
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
