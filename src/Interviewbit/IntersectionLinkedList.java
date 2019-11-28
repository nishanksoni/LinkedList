package Interviewbit;

import static LinkedListStructure.LinkedListStructure.*;

// Time complexity : O(m+n).
//Space complexity : O(1).
// Example : Metro map
// Merge point of two linked list
// https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
// It works because pointer A walks through List A and List B (since once it hits null, it goes to List B's head).
// Pointer B also walks through List B and List A.
// Regardless of the length of the two lists, the sum of the lengths are the same (i.e. a+b = b+a),
// which means that the pointers sync up at the point of intersection.

// https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
public class IntersectionLinkedList {
    Node head1, head2;

    Node getIntersectionNode(Node headA, Node headB) {
        // Base condition
        if (headA == null || headB == null) {
            return null;
        }
        Node a = headA;
        Node b = headB;
        //If a & b have different lengths, then we will stop the loop after second iteration
        while (a != b) // While loop will get break when a is equal to equal to b .
        {
            if (a == null) // When a becomes null than we start pointing it to head B
            {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null)  // When b becomes null than we start pointing it to head A
            {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a; // Return a or b anything the answer will be the same
    }


    public static void main(String[] args) {
        IntersectionLinkedList list = new IntersectionLinkedList();

        // creating first linked list
        list.head1 = new Node(4);
        list.head1.next = new Node(1);
        list.head1.next.next = new Node(8);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(5);

        // creating second linked list
        list.head2 = new Node(5);
        list.head2.next = new Node(0);
        list.head2.next.next = new Node(1);

        // Mapping list 1 and list 2
        list.head2.next.next.next = list.head1.next.next;


        printList(list.head1);

        printList(list.head2);


        Node intersectionNode = list.getIntersectionNode(list.head1, list.head2);

        System.out.println();

        printList(intersectionNode);

    }

}
