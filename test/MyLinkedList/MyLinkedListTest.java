package MyLinkedList;

import static org.junit.Assert.*;
import org.junit.Test;
import ua.luxoft.study.dataStructures.myLinkedList.MyLinkedList;

public class MyLinkedListTest {

    @Test
    public void testSize() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        int expected = 3;
        int actual = linkedList.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        String expected = "MyLinkedList{ 10  20  30  40 }";
        String actual = linkedList.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddToEnd() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        assertTrue(linkedList.size() == 3);
        assertEquals(10, linkedList.get(0));
        assertEquals(20, linkedList.get(1));
        assertEquals(30, linkedList.get(2));
    }

    @Test
    public void testGet() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        assertEquals(10, linkedList.get(0));
        assertEquals(20, linkedList.get(1));
        assertEquals(30, linkedList.get(2));
    }

    @Test
    public void testSet() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.set(0, 1);
        linkedList.set(1, 2);
        linkedList.set(2, 3);
        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(3, linkedList.get(2));
    }

    @Test
    public void testGetFirst() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        assertEquals(10, linkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        assertEquals(30, linkedList.getLast());
    }

    @Test
    public void testRemoveLast(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.removeLast();
        assertTrue(linkedList.size() == 2);
        assertEquals(20, linkedList.getLast());
    }

    @Test
    public void testRemoveFirst(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.removeFirst();
        assertTrue(linkedList.size() == 2);
        assertEquals(20, linkedList.getFirst());
    }

    @Test
    public void testIndexOf(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(30);
        linkedList.add(30);
        assertEquals(0, linkedList.indexOf(10));
        assertEquals(1, linkedList.indexOf(30));
    }

    @Test
    public void testContains() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        assertEquals(true, linkedList.contains(20));
    }

    @Test
    public void testLastIndexOf(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(30);
        linkedList.add(30);
        assertEquals(0, linkedList.lastIndexOf(10));
        assertEquals(2, linkedList.lastIndexOf(30));
    }
    @Test
    public void testAdd(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(21,0);
        linkedList.add(22,2);
        linkedList.add(23,5);
        System.out.println(linkedList.toString());
        assertTrue(linkedList.size() == 6);
        assertEquals(21, linkedList.get(0));
        assertEquals(10, linkedList.get(1));
        assertEquals(22, linkedList.get(2));
        assertEquals(20, linkedList.get(3));
        assertEquals(30, linkedList.get(4));
        assertEquals(23, linkedList.get(5));
    }
}
