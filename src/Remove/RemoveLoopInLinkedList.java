package Remove;

import Interviewbit.DetectLoopListCycle;

import static LinkedListStructure.LinkedListStructure.*;
import static LinkedListStructure.LinkedListStructure.head;

// https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
// https://www.youtube.com/watch?v=_BG9rjkAXj8
public class RemoveLoopInLinkedList {
    void removeLoop(Node head) {
        Node slow_runner = head;
        Node fast_runner = head;

        // Base case
        if (head == null || head.next == null) {
            return;
        }
        while (fast_runner != null && fast_runner.next != null) {
            fast_runner = fast_runner.next.next; // Always two steps ahead
            slow_runner = slow_runner.next; // Running only by 1x speed -- slow pointer will reach at the mid

            if (slow_runner == fast_runner) {
                break;
            }
        }
        // If loop exist
        if (slow_runner == fast_runner) {
            slow_runner = head; // Again start slow runner from start and keep running till the slow runner next is equal to fast runner next
            while (slow_runner.next != fast_runner.next) {
                slow_runner = slow_runner.next;
                fast_runner = fast_runner.next;
            }
        }

        // Now fast runner is inside loop so we need to remove next of fast runner
        fast_runner.next = null;
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        DetectLoopListCycle detectLoop = new DetectLoopListCycle();

        push(20);
        push(4);
        push(15);
        push(10);


        printList();
        head.next.next.next.next = head.next.next.next;


        new RemoveLoopInLinkedList().removeLoop(head);

        printList();
    }


}
