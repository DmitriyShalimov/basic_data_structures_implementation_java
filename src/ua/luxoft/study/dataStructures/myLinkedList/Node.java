package ua.luxoft.study.dataStructures.myLinkedList;

/**
 * Created by red1 on 11/25/2015.
 */
public class Node {
    Object element;
    Node next;
    Node prev;

    public Node() {
    }

    public Node(Object element, Node next, Node prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }
}
