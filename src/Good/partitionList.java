package Good;

/*The problem wants us to reform the linked list structure, such that the elements lesser that a certain value x,
  come before the elements greater or equal to x. This essentially means in this reformed list,
  there would be a point in the linked list before which all the elements would be smaller than x
  and after which all the elements would be greater or equal to x.*/

import static LinkedListStructure.LinkedListStructure.*;

public class partitionList {

    public Node partition(Node head, int x) {

        // before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
        Node before_head = new Node(0);
        Node before = before_head;
        Node after_head = new Node(0);
        Node after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.data < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // move ahead in the original list
            head = head.next;
        }

        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }

    public static void main(String[] args) {
        partitionList partitionList = new partitionList();

        push(5);
        push(4);
        push(3);
        push(7);
        push(2);
        push(1);

        printList();

        Node partition = partitionList.partition(head, 3);


        printList(partition);


    }
}
