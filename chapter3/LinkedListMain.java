package chapter3;

import chapter3.LinkedList;
import chapter3.Node;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i = 0; i < 10; i++) {
            list.insertToHead(i);
        }

        list.deleteNode(5);
        list.deleteNode(2);

        Node head = list.getHead();

        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}