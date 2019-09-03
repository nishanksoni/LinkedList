package Basics;
// https://leetcode.com/problems/reverse-nodes-in-k-group/

import static LinkedListStructure.LinkedListStructure.*;

public class reverseNodesInkGroups {


    // 1st Way
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


    // 2nd way - Usual way
    public Node reveseGrps(Node head, int k) {
        int count = 0;
        Node next = null;
        Node current = head;
        Node prev = null;
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.next = reveseGrps(next, k);
        }
        Node temp = prev;
        return temp;
    }


    public static void main(String[] args) {
        reverseNodesInkGroups reverseNodesInGroups = new reverseNodesInkGroups();

        push(80);
        push(70);
        push(60);
        push(50);
        push(40);
        push(30);
        push(20);
        push(10);

        printList(); // 10 20 30 40 50 60 70

        Node temp = head;
        Node temp1 = head;
        Node node1 = reverseNodesInGroups.reveseGrps(temp, 3);

        printList(node1);


        Node node11 = reverseNodesInGroups.reverseInGroups(temp1, 3);
        printList(node11);




      /*  Node node = reverseNodesInGroups.reverseInGroups(head, 3);

        printList(node);*/


    }


}
