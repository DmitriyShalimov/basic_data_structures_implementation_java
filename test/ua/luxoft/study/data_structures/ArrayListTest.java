package ua.luxoft.study.data_structures;

import org.junit.Test;
import ua.luxoft.study.data_structures.List.ArrayList;
import ua.luxoft.study.data_structures.List.LinkedList;
import static org.junit.Assert.*;


public class ArrayListTest {
    ArrayList arrayList = new ArrayList();

    @Test
    public void testSize() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        int expected = 3;
        int actual = arrayList.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testGet() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        assertEquals(10, arrayList.get(0));
        assertEquals(20, arrayList.get(1));
        assertEquals(30, arrayList.get(2));
    }

    @Test
    public void testContains() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        assertEquals(true, arrayList.contains(10));
        assertEquals(true, arrayList.contains(20));
        assertEquals(true, arrayList.contains(30));
    }

    @Test
    public void testIndexOf() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(20);
        assertEquals(0, arrayList.indexOf(10));
        assertEquals(1, arrayList.indexOf(20));
    }

    @Test
    public void testLastIndexOf() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(20);
        assertEquals(0, arrayList.lastIndexOf(10));
        assertEquals(2, arrayList.lastIndexOf(20));
    }

    @Test
    public void testAdd() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30, 1);
        assertTrue(arrayList.size() == 3);
        assertEquals(10, arrayList.get(0));
        assertEquals(30, arrayList.get(1));
        assertEquals(20, arrayList.get(2));
    }

    @Test
    public void testAddToAnd() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        assertTrue(arrayList.size() == 3);
        assertEquals(10, arrayList.get(0));
        assertEquals(20, arrayList.get(1));
        assertEquals(30, arrayList.get(2));
    }

    @Test
    public void testRemove() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.remove(1);
        assertTrue(arrayList.size() == 2);
        assertEquals(10, arrayList.get(0));
        assertEquals(30, arrayList.get(1));
    }

    @Test
    public void testSet() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.set(50, 1);
        assertTrue(arrayList.size() == 3);
        assertEquals(10, arrayList.get(0));
        assertEquals(50, arrayList.get(1));
        assertEquals(30, arrayList.get(2));
    }

    @Test
    public void testToString() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        String expected = "ArrayList{ 10  20  30  40 }";
        String actual = arrayList.toString();
        assertEquals(expected, actual);
    }

    @Test
     public void testClear() {
        arrayList.add(10);
         arrayList.add(20);
         arrayList.add(30);
         arrayList.clear();
         assertTrue(arrayList.size() == 0);
     }

    @Test
    public void testAddCollection() {
        arrayList.add(10);
        arrayList.add(20);
        LinkedList linkedList=new LinkedList();
        linkedList.add("aa");
        linkedList.add("bb");
        arrayList.addCollection(linkedList);
        assertEquals(10, arrayList.get(0));
        assertEquals(20, arrayList.get(1));
        assertEquals("aa", arrayList.get(2));
        assertEquals("bb", arrayList.get(3));
        assertTrue(arrayList.size() == 4);
    }
}
