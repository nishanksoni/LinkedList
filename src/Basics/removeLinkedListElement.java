package Basics;

// https://leetcode.com/problems/remove-linked-list-elements/

import static LinkedListStructure.LinkedListStructure.*;

public class removeLinkedListElement {


    public Node removeElements(Node head, int val) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        if (head.data == val) {
            return head.next;
        } else {
            return head;
        }

    }


    public static void main(String[] args) {
        removeLinkedListElement removeLinkedListElement = new removeLinkedListElement();

        push(6);
        push(2);
        push(6);
        push(4);
        push(5);
        push(6);


        printList();

        Node node = removeLinkedListElement.removeElements(head, 6);


        printList(node);

    }

}
