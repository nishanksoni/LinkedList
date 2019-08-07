package Basics;

import static LinkedListStructure.LinkedListStructure.*;

public class reverseNodesInkGroups {


    private Node reverseInGroups(Node head, int k) {
        //1. test weather we have more then k node left, if less then k node left we just return head
        Node node = head;
        int count = 0;
        while (count < k) {
            if (node == null) {
                return head;
            }
            node = node.next;
            count++;
        }

        // 2.reverse k node at current level
        Node previous = reverseInGroups(node, k); //pre node point to the the answer of sub-problem // recursive call
        // Now our usual reversal method until the count > 0
        Node next;
        Node current = head;
        while (count > 0) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count = count - 1;
        }
        return previous;
    }


    public static void main(String[] args) {
        reverseNodesInkGroups reverseNodesInGroups = new reverseNodesInkGroups();

        push(70);
        push(60);
        push(50);
        push(40);
        push(30);
        push(20);
        push(10);

        printList(); // 10 20 30 40 50 60 70

        Node node = reverseNodesInGroups.reverseInGroups(head, 3);

        printList(node);

    }


}
