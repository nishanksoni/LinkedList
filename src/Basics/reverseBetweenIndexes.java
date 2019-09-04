package Basics;

import static LinkedListStructure.LinkedListStructure.*;

// https://www.geeksforgeeks.org/reverse-sublist-linked-list/
// https://leetcode.com/problems/reverse-linked-list-ii/
// Hard
// Reverse a sublist of linked list
public class reverseBetweenIndexes {
    public Node reverseBetween(Node head, int m, int n) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        Node start = pre.next;
        Node then = start.next;
        int diff = n - m;

        for (int i = 0; i < diff; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;

    }


    public static void main(String[] args) {
        reverseBetweenIndexes reverseBetweenTwoIndexes = new reverseBetweenIndexes();

        push(70);
        push(60);
        push(50);
        push(40);
        push(30);
        push(20);
        push(10);

        printList(); // 10 20 30 40 50 60 70

        Node node = reverseBetweenTwoIndexes.reverseBetween(head, 2, 6);

        printList(node);

    }

}
