package Good;

import static LinkedListStructure.LinkedListStructure.*;

public class Segregate0s1s2s {
    public Node sortList(Node head) {
        Node temp = head;
        int[] count = {0, 0, 0};
        while (temp != null) {
            count[temp.data]++;
            temp = temp.next;
        }
        int i = 0;
        temp = head;
        while (temp != null) {
            // check weather the index is zero or not - if it becomes zero we will jump to next index
            if (count[i] == 0) {
                i++;
            } else {
                temp.data = i;
                --count[i];
                temp = temp.next;
            }
        }


        return null;

    }


    public static void main(String args[]) {
        Segregate0s1s2s llist = new Segregate0s1s2s();
          
        /* Constructed Linked List is 1->2->3->4->5->6->7-> 
           8->8->9->null */
        push(0);
        push(1);
        push(0);
        push(2);
        push(1);
        push(1);
        push(2);
        push(1);
        push(2);

        printList(); // 10 20 30 40

        llist.sortList(head);

    }
}
