package Good;

import static LinkedListStructure.LinkedListStructure.*;

public class AddLists {
    Node head1, head2;

    Node addLists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node iterator = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            carry = sum / 10;// Carry is either 0 or 1
            int mod = sum % 10;// lets say your sum is  12 than you will write 2 only and 1 is in carry so mod is 2
            iterator.next = new Node(mod);

            iterator = iterator.next;
        }
        // After while loop finishes lets say any carry is there than we need to write
        if (carry > 0) {
            iterator.next = new Node(carry);
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        AddLists addLists = new AddLists();

        // creating first linked list
        addLists.head1 = new Node(9);
        addLists.head1.next = new Node(9);
        addLists.head1.next.next = new Node(3);

        // creating second linked list
        addLists.head2 = new Node(2);
        addLists.head2.next = new Node(2);
        addLists.head2.next.next = new Node(3);


        printList(addLists.head1);

        printList(addLists.head2);

        System.out.println("=======");

        Node node = addLists.addLists(addLists.head1, addLists.head2);

        printList(node);

    }
}
