package Interviewbit;
//  Floyd's cycle detection algorithm
//  https://leetcode.com/problems/linked-list-cycle-ii/
// https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.
import static LinkedListStructure.LinkedListStructure.*;

public class DetectLoopListCycleII
{
    public Node detectCycle(Node head)
    {
        // Base case
        if (head == null || head.next == null) {
            return null;
        }
        Node slow_runner = head;
        Node fast_runner = head;
        // detect intersection
        while (fast_runner != null && fast_runner.next != null)
        {
            fast_runner = fast_runner.next.next; // Always two steps ahead
            slow_runner = slow_runner.next; // Running only by 1x speed -- slow pointer will reach at the mid
            if (slow_runner == fast_runner)
            {
                slow_runner = head;
                while (slow_runner != fast_runner)
                {
                    slow_runner = slow_runner.next;
                    fast_runner = fast_runner.next;
                }
                return slow_runner;
            }
        }
        return null;
    }

    public static void main(String args[]) {
        DetectLoopListCycle detectLoop = new DetectLoopListCycle();

        push(20);
        push(4);
        push(15);
        push(10);


        printList();
        head.next.next.next.next = head.next.next.next;


        new DetectLoopListCycleII().detectCycle(head);

        printList();
    }
}
