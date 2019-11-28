package Good;

import static LinkedListStructure.LinkedListStructure.*;

public class getNthNodeFromEndLinkedList {

    void printNthNodeFromEndLinkedListUsingCount(int k) {
        Node temp = head;
        int count = 0;
        // First get the length of linked list
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // check weather k is not more than the size of length
        if (count < k) {
            return;
        }
        int position = count - k; // to get from beginning , again initialize temp
        temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        System.out.println(" The element from last position is " + temp.data);
    }


    int getNthNodeUsingTwoPointers(int k) {
        Node slow_ptr = head;
        Node fast_ptr = head;

        int count = 0;
        while (fast_ptr != null && count < k) {
            fast_ptr = fast_ptr.next;
            count++;
        }
        if (fast_ptr == null) {

            return slow_ptr.data;
        }

        while (fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
        }
        System.out.println(slow_ptr.data);
        return slow_ptr.data;
    }


    public static void main(String[] args) {
        getNthNodeFromEndLinkedList getNthNodeFromEndLinkedList = new getNthNodeFromEndLinkedList();
        push(20);
        push(4);
        push(15);
        push(35);

        printList();

        int k = 2;

        getNthNodeFromEndLinkedList.getNthNodeUsingTwoPointers(k);

        // getNthNodeFromEndLinkedList.printNthNodeFromEndLinkedListUsingCount(k);

    }
}
