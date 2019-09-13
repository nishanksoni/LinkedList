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


    // 2nd way - Usual way - Basic
    // Use Normal linked list reversal -- Do count till k
    // If the next != null than make recursive call
    public Node reveseGrps(Node head, int k, int length) {
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
            length--;
        }
        if (next != null && length >= k) {
            head.next = reveseGrps(next, k, length);
        }
        Node temp = prev;
        return temp;
    }

    Node reverse(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }

    int countLength(Node head) {
        Node temporary = head;
        int length = 0;
        while (temporary != null) {
            temporary = temporary.next;
            length++;
        }
        System.out.println("The length is " + length);
        return length;
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


        int length = new reverseNodesInkGroups().countLength(head);

        Node reverseGroups = reverseNodesInGroups.reveseGrps(temp, 3, length);
        printList(reverseGroups);


    }


}
