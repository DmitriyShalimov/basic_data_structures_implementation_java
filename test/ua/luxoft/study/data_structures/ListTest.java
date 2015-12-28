package ua.luxoft.study.data_structures;

import org.junit.Test;
import ua.luxoft.study.data_structures.List.ArrayList;
import ua.luxoft.study.data_structures.List.LinkedList;
import ua.luxoft.study.data_structures.List.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class ListTest {
    List list;

    protected abstract List determineList();

    protected ListTest() {
        list = determineList();
    }

    @Test
    public void testSize() {
        list.add(10);
        list.add(20);
        list.add(30);
        int expected = 3;
        int actual = list.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        String expected = "List{ 10  20  30  40 }";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddToEnd() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertTrue(list.size() == 3);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    public void testGet() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    public void testSet() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.set(1, 0);
        list.set(2, 1);
        list.set(3, 2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testIndexOf() {
        list.add(10);
        list.add(30);
        list.add(30);
        assertEquals(0, list.indexOf(10));
        assertEquals(1, list.indexOf(30));
    }

    @Test
    public void testContains() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(true, list.contains(20));
    }

    @Test
    public void testLastIndexOf() {
        list.add(10);
        list.add(30);
        list.add(30);
        assertEquals(0, list.lastIndexOf(10));
        assertEquals(2, list.lastIndexOf(30));
    }

    @Test
    public void testAdd() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(21, 1);
        list.add(22, 2);
        list.add(23, 5);
        assertTrue(list.size() == 6);
        assertEquals(10, list.get(0));
        assertEquals(21, list.get(1));
        assertEquals(22, list.get(2));
        assertEquals(20, list.get(3));
        assertEquals(30, list.get(4));
        assertEquals(23, list.get(5));
    }

    @Test
    public void testClear() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.clear();
        assertTrue(list.size() == 0);
    }

    @Test
    public void testGetFirst() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(10, list.getFirst());
    }

    @Test
    public void testGetLast() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(30, list.getLast());
    }

    @Test
    public void testRemoveFirst() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.removeFirst();
        assertEquals(20, list.get(0));
        assertEquals(30, list.get(1));
        assertTrue(list.size() == 2);
    }

    @Test
    public void testRemoveLast() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.removeLast();
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertTrue(list.size() == 2);
    }

    @Test
    public void testRemove() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(1);
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
        assertTrue(list.size() == 2);
    }

    @Test
    public void testAddCollection() {
        List list1 = new ArrayList();
        List list2 = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list1.add(40);
        list1.add(50);
        list2.add(60);
        list2.add(70);
        list.addCollection(list1);
        list.addCollection(list2);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(40, list.get(3));
        assertEquals(50, list.get(4));
        assertEquals(60, list.get(5));
        assertEquals(70, list.get(6));
        assertTrue(list.size() == 7);
    }

    @Test
    public void testEquals() {
        List list1 = new ArrayList();
        List list2 = new LinkedList();
        List list3 = new ArrayList();
        List list4 = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list2.add(10);
        list2.add(20);
        list2.add(30);
        list3.add(10);
        list3.add(20);
        list3.add(30);
        list3.add(30);
        list4.add(10);
        list4.add(20);
        list4.add(40);
        assertEquals(true, list.equals(list1));
        assertEquals(true, list.equals(list2));
        assertEquals(false, list.equals(list3));
        assertEquals(false, list.equals(list4));
    }
}
