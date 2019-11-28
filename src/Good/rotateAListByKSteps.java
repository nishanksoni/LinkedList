package Good;
// Rotate  a list up to K nodes

import LinkedListStructure.LinkedListStructure.*;

import static LinkedListStructure.LinkedListStructure.*;

//https://leetcode.com/problems/rotate-list/discuss/22715/Share-my-java-solution-with-explanation
// https://www.geeksforgeeks.org/rotate-a-linked-list/
// The code has three parts.
// 1.Get the length
// 2.Move to the (l-K%l)th node
// 3.Do the rotation
public class rotateAListByKSteps {
    public Node rotateRight(Node head, int k) {
        if (head == null) {
            return null;
        }
        int size = 1; // since we are already at head node
        Node fast = head;
        Node slow = head;

        while (fast.next != null) {
            size++;
            fast = fast.next;
        }
        System.out.println(size);
        int cycle = size - k % size;
        for (int i = cycle; i > 1; i--) {
            // i>1 because we need to put slow.next at the start.
            slow = slow.next;
        }

        //Rotation
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    public Node rotateBasicWay(Node head, int k) {

        if (k == 0) {
            return null;
        }

        // Let us understand the below code for example k = 4
        // and list = 10->20->30->40->50->60.
        Node current = head;

        // current will either point to kth or NULL after this
        // loop. current will point to node 40 in the above example
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        // If current is NULL, k is greater than or equal to count
        // of nodes in linked list. Don't change the list in this case
        if (current == null)
            return null;

        // current points to kth node. Store it in a variable.
        // kthNode points to node 40 in the above example
        Node kthNode = current;

        // current will point to last node after this loop
        // current will point to node 60 in the above example
        while (current.next != null)
            current = current.next;

        // Change next of last node to previous head
        // Next of 60 is now changed to node 10

        current.next = head;

        // Change head to (k+1)th node
        // head is now changed to node 50
        head = kthNode.next;

        // change next of kth node to null
        kthNode.next = null;

        System.out.println("Printing now");

        return head;
    }


    public static void main(String[] args) {
        rotateAListByKSteps rotateAListByKSteps = new rotateAListByKSteps();

        push(40);
        push(30);
        push(20);
        push(10);

        printList(); // 10 20 30 40

        int k = 3; // After rotation it will become 30 40 10 20

        printList(rotateAListByKSteps.rotateBasicWay(head, k));



       /* Node node = rotateAListByKSteps.rotateRight(head, k);

        printList(node);*/
    }


}
