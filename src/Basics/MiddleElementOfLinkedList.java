package Basics;

import static LinkedListStructure.LinkedListStructure.*;

// Runner technique
// slow_runner and fast_runner approach
public class MiddleElementOfLinkedList {

    void printMiddle() {
        Node slow_runner = head;
        Node fast_runner = head;

        // Base case
        if (head == null) {
            return;
        }
        while (fast_runner != null && fast_runner.next != null) {
            fast_runner = fast_runner.next.next; // Always two steps ahead
            slow_runner = slow_runner.next; // Running only by 1x speed -- slow pointer will reach at the mid
        }

        System.out.println("The middle element is " + slow_runner.data);
    }


    public static void main(String[] args) {
        MiddleElementOfLinkedList middleElementOfALinkedList = new MiddleElementOfLinkedList();

        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        push(6);


        printList();

        middleElementOfALinkedList.printMiddle();

    }

}

// Another way is
// Traverse the whole linked list and count the no. of nodes. Now traverse the list again till count/2 and return the node at count/2.