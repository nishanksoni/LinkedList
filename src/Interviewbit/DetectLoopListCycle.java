package Interviewbit;

import static LinkedListStructure.LinkedListStructure.*;

// List Cycle
// Runner technique
// Move one pointer(slow_p) by one and another pointer(fast_p) by two.
// If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list does not have a loop
// https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
public class DetectLoopListCycle {

    int foundLoop() {
        Node slow_runner = head;
        Node fast_runner = head;

        // Base case
        if (head == null) {
            return 0;
        }
        while (fast_runner != null && fast_runner.next != null) {
            fast_runner = fast_runner.next.next; // Always two steps ahead
            slow_runner = slow_runner.next; // Running only by 1x speed -- slow pointer will reach at the mid

            if (slow_runner == fast_runner) {
                System.out.println("Loop got found at " + slow_runner.data);
                return slow_runner.data;
            }
        }
        return 0;
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

        int foundLoop = detectLoop.foundLoop();

        if (foundLoop > 0) {
            System.out.println("Loop got found at " + foundLoop);
        } else {
            System.out.println("Loop is not there Wrong Mappings   ");
        }

    }


}
