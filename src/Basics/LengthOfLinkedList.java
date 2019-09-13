package Basics;

import LinkedListStructure.LinkedListStructure;

import static LinkedListStructure.LinkedListStructure.*;

// Same as traversing the linked list
public class LengthOfLinkedList {


    // Iterative solution  -- same as searching an element or traversing a linked list
    int getCount(Node head) {
        // Base case
        if (head == null) {
            return 0;
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    // Recursive solution
    int getCountRec(Node head) {
        // Base case
        if (head == null) {
            return 0;
        }
        return 1 + getCountRec(head.next); // 1 is very important if you not write 1 than you will get 0 as output because of base condition
    }


    public static void main(String[] args) {
        push(5);
        push(4);
        push(3);
        push(2);
        push(1);

        int count = new LengthOfLinkedList().getCount(head);




        System.out.println("Length of a linked list by iterative way is  " + count);


        int countRec = new LengthOfLinkedList().getCountRec(LinkedListStructure.head);
        System.out.println("Length of a linked list by recursion is  " + countRec);
    }


}
