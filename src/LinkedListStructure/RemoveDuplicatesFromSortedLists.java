package LinkedListStructure;


import static LinkedListStructure.LinkedListStructure.*;

public class RemoveDuplicatesFromSortedLists {

    private Node removeDuplicates(Node head) {
        Node temp = head;

        while (temp != null) {
            if (temp.next == null) {
                break;
            }
            // 11 (1st one ) == 11 (2nd one)
            // we are changing the value of 11 (2nd one ) to 13 ( 3rd one )
            // so now 1st one point to 3rd one i.e 11 --> 13
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }


    public static void main(String args[]) {
        RemoveDuplicatesFromSortedLists removeDuplicatesFromSortedLists = new RemoveDuplicatesFromSortedLists();
        push(20);
        push(13);
        push(11);
        push(11);

        System.out.println("List before removal of duplicates");

        printList();

        Node nodes = removeDuplicatesFromSortedLists.removeDuplicates(head);


        System.out.println("List after removal of elements");

        printList(nodes);


    }


}
