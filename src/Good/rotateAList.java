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
public class rotateAList {
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


    public static void main(String[] args) {
        rotateAList rotateAList = new rotateAList();

        push(40);
        push(30);
        push(20);
        push(10);

        printList(); // 10 20 30 40

        int k = 2; // After rotation it will become 30 40 10 20

        Node node = rotateAList.rotateRight(head, k);

        printList(node);


    }


}
