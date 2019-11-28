package Interviewbit;

import static LinkedListStructure.LinkedListStructure.*;
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class RemoveDuplicatesFromSortedList {

    private Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null) {
                break;
            }
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }


    public static void main(String args[]) {
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedLists = new RemoveDuplicatesFromSortedList();
        push(20);
        push(13);
        push(11);
        push(11);

        System.out.println("List before removal of duplicates");

        printList();

        Node nodes = removeDuplicatesFromSortedLists.removeDuplicates(head);


        System.out.println("List after removal of elements");

        printList(nodes);


    }


}
