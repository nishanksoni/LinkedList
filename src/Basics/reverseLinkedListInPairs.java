package Basics;

import static LinkedListStructure.LinkedListStructure.*;

// Input : 10 20 30 40
// Output: 20 10 40 30
// Technique : Swap current and current next than directly jump to 2 steps
// It will be only applied when you are having current and current next element
// https://leetcode.com/problems/swap-nodes-in-pairs/
// Pairwise swap of a Linked List
// https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
public class reverseLinkedListInPairs {

    private void reverseInPairs() {
        Node current = head;
        while (current != null && current.next != null) {
            // Swap the data
            int data = current.data;
            current.data = current.next.data;
            current.next.data = data;

            // Now increase current pointer by two steps
            current = current.next.next;
        }
    }


    public static void main(String[] args) {
        reverseLinkedListInPairs reverseLinkedListInPairs = new reverseLinkedListInPairs();
        push(40);
        push(30);
        push(20);
        push(10);

        printList();

        reverseLinkedListInPairs.reverseInPairs();

        printList();

    }


}
