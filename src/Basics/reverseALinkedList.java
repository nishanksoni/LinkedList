package Basics;

import static LinkedListStructure.LinkedListStructure.*;
//Time Complexity: O(n)
// Space Complexity: O(1)
// Basic linked list reversal where you only need to change the pointers
// https://www.geeksforgeeks.org/reverse-a-linked-list/ : watch GIF
// https://leetcode.com/problems/reverse-linked-list/
public class reverseALinkedList {

    private void reverse() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }


    public static void main(String[] args) {
        reverseALinkedList reverseALinkedList = new reverseALinkedList();
        push(30);
        push(20);
        push(10);

        printList(); // 10 20 30

        reverseALinkedList.reverse();

        printList();

    }


}
