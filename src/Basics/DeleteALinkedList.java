package Basics;

import static LinkedListStructure.LinkedListStructure.*;

public class DeleteALinkedList {
    private void deleteEntireList() {
        head = null;
    }

    void deleteNodeAtPosition(int k) {

    }


    public static void main(String[] args) {
        DeleteALinkedList llist = new DeleteALinkedList();
        /* Use push() to construct below list
           1->12->1->4->1  */

        push(1);
        push(4);
        push(1);
        push(12);
        push(1);

        printList();


        llist.deleteEntireList();


        System.out.println("Linked list after deletion ");
        printList();

    }


}
