package ua.luxoft.study.datastructures.list;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LinkedListTest extends AbstractListTest {

    private LinkedList linkedList;

    @Before
    public void setUpLinkedList() {
        linkedList = new LinkedList();
    }

    @Override
    protected List determineList() {
        return new LinkedList();
    }

    @Test
      public void testMethodGetFirstShouldReturn10() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        assertThat(linkedList.getFirst(), CoreMatchers.<Object>is(10));
    }

    @Test
    public void testMethodGetLastShouldReturn30() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        assertThat(linkedList.getLast(), CoreMatchers.<Object>is(30));
            }

    @Test
    public void testMethodRemoveFirstShouldReturnSize2FirstElement20SecondElement30() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        assertThat(linkedList.size(), is(3));

        linkedList.removeFirst();

        assertThat(linkedList.get(0), CoreMatchers.<Object>is(20));
        assertThat(linkedList.get(1), CoreMatchers.<Object>is(30));
        assertThat(linkedList.size(), is(2));
    }

    @Test
    public void testMethodRemoveLastShouldReturnSize2FirstElement10SecondElement20() {
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        assertThat(linkedList.size(), is(3));

        linkedList.removeLast();

        assertThat(linkedList.get(0), CoreMatchers.<Object>is(10));
        assertThat(linkedList.get(1), CoreMatchers.<Object>is(20));
        assertThat(linkedList.size(), is(2));
    }
}


