package Basics;

// https://leetcode.com/problems/remove-linked-list-elements/
// Remove all elements from a linked list of integers that have value val.

import static LinkedListStructure.LinkedListStructure.*;

public class removeLinkedListElement {


    public Node removeElements(Node head, int target) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == target) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        // If the target value is the head Node so after while loop we return head.next
        if (head.data == target) {
            return head.next;
        } else {
            return head;
        }

    }


    public static void main(String[] args) {
        removeLinkedListElement removeLinkedListElement = new removeLinkedListElement();

        push(6);
        push(5);
        push(4);
        push(3);
        push(6);
        push(2);
        push(1);

        System.out.print("Original List is :  ");
        printList();

        Node node = removeLinkedListElement.removeElements(head, 1);


        printList(node);

    }

}
