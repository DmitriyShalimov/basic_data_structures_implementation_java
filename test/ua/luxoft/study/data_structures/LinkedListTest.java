package ua.luxoft.study.data_structures;

import static org.junit.Assert.*;
import org.junit.Test;
import ua.luxoft.study.data_structures.List.ArrayList;
import ua.luxoft.study.data_structures.List.LinkedList;



public class LinkedListTest {
    LinkedList linkedList = new LinkedList();

    @Test
    public void testSize() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        int expected = 3;
        int actual = linkedList.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        String expected = "LinkedList{ 10  20  30  40 }";
        String actual = linkedList.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddToEnd() {
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
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        assertEquals(10, linkedList.get(0));
        assertEquals(20, linkedList.get(1));
        assertEquals(30, linkedList.get(2));
    }

    @Test
    public void testSet() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.set(1, 0);
        linkedList.set(2, 1);
        linkedList.set(3, 2);
        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(3, linkedList.get(2));
    }

    @Test
    public void testGetFirst() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        assertEquals(10, linkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        assertEquals(30, linkedList.getLast());
    }

    @Test
    public void testRemoveLast(){
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.removeLast();
        assertTrue(linkedList.size() == 2);
        assertEquals(20, linkedList.getLast());
    }

    @Test
    public void testRemoveFirst(){
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.removeFirst();
        assertTrue(linkedList.size() == 2);
        assertEquals(20, linkedList.getFirst());
    }

    @Test
    public void testIndexOf(){
        linkedList.add(10);
        linkedList.add(30);
        linkedList.add(30);
        assertEquals(0, linkedList.indexOf(10));
        assertEquals(1, linkedList.indexOf(30));
    }

    @Test
    public void testContains() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        assertEquals(true, linkedList.contains(20));
    }

    @Test
    public void testLastIndexOf(){
        linkedList.add(10);
        linkedList.add(30);
        linkedList.add(30);
        assertEquals(0, linkedList.lastIndexOf(10));
        assertEquals(2, linkedList.lastIndexOf(30));
    }
    @Test
    public void testAdd(){
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(21,1);
        linkedList.add(22,2);
        linkedList.add(23,5);
        assertTrue(linkedList.size() == 6);
        assertEquals(10, linkedList.get(0));
        assertEquals(21, linkedList.get(1));
        assertEquals(22, linkedList.get(2));
        assertEquals(20, linkedList.get(3));
        assertEquals(30, linkedList.get(4));
        assertEquals(23, linkedList.get(5));
    }
  @Test
  public void testClear() {
      linkedList.add(10);
      linkedList.add(20);
      linkedList.add(30);
      linkedList.clear();
      assertTrue(linkedList.size() == 0);
  }
    @Test
    public void testAddCollection() {
        linkedList.add(10);
        linkedList.add(20);
        ArrayList arrayList=new ArrayList();
        arrayList.add("aa");
        arrayList.add("bb");
        linkedList.addCollection(arrayList);
        assertEquals(10, linkedList.get(0));
        assertEquals(20, linkedList.get(1));
        assertEquals("aa", linkedList.get(2));
        assertEquals("bb", linkedList.get(3));
        assertTrue(linkedList.size() == 4);
    }

}
