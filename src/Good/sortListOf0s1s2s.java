package Good;

// https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/
// 1st is basic way like we do for array

import LinkedListStructure.LinkedListStructure.Node;

import java.util.Arrays;

import static LinkedListStructure.LinkedListStructure.*;

public class sortListOf0s1s2s {

    private void sortListUsingCount() {
        int[] count = {0, 0, 0};
        /* count total number of '0', '1' and '2'
         * count[0] will store total number of '0's
         * count[1] will store total number of '1's
         * count[2] will store total number of '2's  */
        Node temp = head;
        while (temp != null) {
            count[temp.data]++;
            temp = temp.next;
        }
        // again initialize temp for traversing from head
        temp = head;

        int position = 0;
        while (temp != null) {
            if (count[position] == 0) {
                position++;    // Here we are not doing temp = temp.next because we are increasing the position so that we can fill in linked list .

                // count[0] = 2 so we will fill first two positions in linked list till my count is 2 than we will increase the positions
            } else {
                temp.data = position;
                --count[position];
                temp = temp.next;
            }
        }

    }


    public static void main(String[] args) {
        sortListOf0s1s2s sortListOf0s1s2s = new sortListOf0s1s2s();
        push(0);
        push(1);
        push(0);
        push(2);
        push(1);
        push(1);
        push(2);
        push(1);
        push(2);


        printList();

        sortListOf0s1s2s.sortListUsingCount();


        printList();
    }


}
