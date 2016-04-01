package ua.luxoft.study.datastructures.list;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import ua.luxoft.study.datastructures.Iterator;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public abstract class AbstractListTest {
    private List list;
    private static final Object OBJECT_STUB = new Object();

    protected abstract List determineList();

    @Before
    public void setUpList() {
        list = determineList();
    }

    @Test
    public void testMethodSizeShouldReturnSize3() {
        list.add(OBJECT_STUB);
        list.add(OBJECT_STUB);
        list.add(OBJECT_STUB);

        assertThat(list.size(), is(3));
    }

    @Test
    public void testMethodAddWithoutIndexShouldReturnSize3ShouldReturn3ElementsWhichWeAdd() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertThat(list.size(), is(3));
        assertThat(list.get(0), CoreMatchers.<Object>is(10));
        assertThat(list.get(1), CoreMatchers.<Object>is(20));
        assertThat(list.get(2), CoreMatchers.<Object>is(30));

    }

    @Test
    public void testMethodAddWithIndexShouldReturnSize4ShouldReturn4ElementsInOrder10_aa_20_30() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertThat(list.size(), is(3));
        assertThat(list.get(0), CoreMatchers.<Object>is(10));
        assertThat(list.get(1), CoreMatchers.<Object>is(20));
        assertThat(list.get(2), CoreMatchers.<Object>is(30));

        list.add("aa", 1);

        assertThat(list.size(), is(4));
        assertThat(list.get(0), CoreMatchers.<Object>is(10));
        assertThat(list.get(1), CoreMatchers.<Object>is("aa"));
        assertThat(list.get(2), CoreMatchers.<Object>is(20));
        assertThat(list.get(3), CoreMatchers.<Object>is(30));
    }

    @Test
    public void testMethodAddAllShouldReturnSize7ShouldReturn7ElementsInOrder10_20_30_40_50_60_70() {
        List list1 = new ArrayList();
        list1.add(40);
        list1.add(50);

        List list2 = new LinkedList();
        list2.add(60);
        list2.add(70);

        list.add(10);
        list.add(20);
        list.add(30);
        assertThat(list.size(), is(3));

        list.addAll(list1);
        list.addAll(list2);

        assertThat(list.get(0), CoreMatchers.<Object>is(10));
        assertThat(list.get(1), CoreMatchers.<Object>is(20));
        assertThat(list.get(2), CoreMatchers.<Object>is(30));
        assertThat(list.get(3), CoreMatchers.<Object>is(40));
        assertThat(list.get(4), CoreMatchers.<Object>is(50));
        assertThat(list.get(5), CoreMatchers.<Object>is(60));
        assertThat(list.get(6), CoreMatchers.<Object>is(70));
        assertThat(list.size(), CoreMatchers.<Object>is(7));
    }

    @Test
    public void testMethodSetShouldReturnNegativeValueAndPositiveValue() {
        int positiveValue = 1;
        int negativeValue = -1;

        list.add(positiveValue);
        list.set(negativeValue, 0);
        assertThat(list.get(0), CoreMatchers.<Object>is(negativeValue));

        list.set(positiveValue, 0);
        assertThat(list.get(0), CoreMatchers.<Object>is(positiveValue));
    }

    @Test
    public void testMethodGetShouldReturn3ElementsInOrder10_20_30AfterRemoveShouldReturn3ElementsInOrder10_20() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertThat(list.get(0), CoreMatchers.<Object>is(10));
        assertThat(list.get(1), CoreMatchers.<Object>is(20));
        assertThat(list.get(2), CoreMatchers.<Object>is(30));

        list.remove(0);

        assertThat(list.get(0), CoreMatchers.<Object>is(20));
        assertThat(list.get(1), CoreMatchers.<Object>is(30));
    }

    @Test
    public void testMethodRemoveShouldReturnSize2ShouldReturn2ElementsInOrder10_30() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertThat(list.size(), is(3));
        assertThat(list.get(0), CoreMatchers.<Object>is(10));
        assertThat(list.get(1), CoreMatchers.<Object>is(20));
        assertThat(list.get(2), CoreMatchers.<Object>is(30));

        list.remove(1);

        assertThat(list.size(), is(2));
        assertThat(list.get(0), CoreMatchers.<Object>is(10));
        assertThat(list.get(1), CoreMatchers.<Object>is(30));
    }

    @Test
    public void testMethodIndexOfShouldReturnIndex0And1() {
        list.add(10);
        list.add(30);
        list.add(30);

        assertThat(list.indexOf(10), is(0));
        assertThat(list.indexOf(30), is(1));
    }

    @Test
    public void testLastIndexOfShouldReturnIndex0And2() {
        list.add(10);
        list.add(30);
        list.add(30);

        assertThat(list.lastIndexOf(10), is(0));
        assertThat(list.lastIndexOf(30), is(2));
    }

    @Test
    public void testMethodContainsShouldReturnBooleanInOrderTrue_False_False_True() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertThat(list.contains(20), is(true));
        assertThat(list.contains(69), is(false));
        assertThat(list.contains(null), is(false));

        list.add(null);
        assertThat(list.contains(null), is(true));
    }

    @Test
    public void testMethodClearShouldReturnSize0() {
        list.add(OBJECT_STUB);
        list.add(OBJECT_STUB);
        list.add(OBJECT_STUB);

        assertThat(list.size(), is(3));

        list.clear();
        assertThat(list.size(), is(0));

        list.add(OBJECT_STUB);
        assertThat(list.size(), is(1));
    }

    @Test
    public void testMethodEqualsShouldReturnTrueWhenCompareWithSelfFirstAndThirdListReturnFalseOtherwise() {
        List list1 = new ArrayList();
        list1.add(10);
        list1.add(null);
        list1.add(30);

        List list2 = new ArrayList();
        list2.add(10);
        list2.add(null);
        list2.add(20);

        List list3 = new LinkedList();
        list3.add(10);
        list3.add(null);
        list3.add(30);

        List list4 = new LinkedList();
        list4.add(10);
        list4.add(null);
        list4.add(30);
        list4.add(30);

        list.add(10);
        list.add(null);
        list.add(30);

        assertThat(list, is(list));
        assertThat(list, is(list1));
        assertThat(list, is(list3));
        assertThat(list.equals(list2), is(false));
        assertThat(list.equals(list4), is(false));
    }

    @Test
    public void testMethodToStringShouldReturnTrueWhenCompareExpectedAndActualString() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        String expected = "List: {10, 20, 30, 40}";
        String actual = list.toString();
        assertThat(actual, is(expected));
    }

    @Test
    public void testMethodIteratorHasNextShouldReturnDoubleTrueAndThenFalse() {
        list.add(OBJECT_STUB);
        list.add(OBJECT_STUB);
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void testMethodIteratorNextShouldReturnElementFromFirstToThird() {
        list.add(10);
        list.add(20);
        list.add(30);
        Iterator iterator = list.iterator();
        assertThat(iterator.next(), CoreMatchers.<Object>is(10));
        assertThat(iterator.next(), CoreMatchers.<Object>is(20));
        assertThat(iterator.next(), CoreMatchers.<Object>is(30));
    }

    @Test
    public void testMethodIteratorRemoveShouldDecreaseSizeByTwoLeaveOnlyLastElement() {
        list.add(10);
        list.add(20);
        list.add(30);
        Iterator iterator = list.iterator();
        iterator.next();
        iterator.remove();

        assertThat(list.size(), is(2));
        assertThat(list.get(0), CoreMatchers.<Object>is(20));

        iterator.next();
        iterator.remove();

        assertThat(list.size(), is(1));
        assertThat(list.get(0), CoreMatchers.<Object>is(30));
    }

    @Test(expected = IllegalStateException.class)
    public void testMethodIteratorRemoveShouldThrowIllegalStateException() {
        list.add(OBJECT_STUB);
        list.add(OBJECT_STUB);
        list.add(OBJECT_STUB);
        Iterator iterator = list.iterator();
        iterator.next();

        iterator.remove();
        iterator.remove();

    }

    @Test(expected = IllegalStateException.class)
    public void testMethodIteratorNextShouldThrowIllegalStateException() {
        list.iterator().next();
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testMethodRemoveShouldThrowIndexOutOfBoundsException() {
        list.add(OBJECT_STUB);
        list.add(OBJECT_STUB);
        list.add(OBJECT_STUB);

        list.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMethodAddWithIndexShouldThrowIndexOutOfBoundsException() {
        list.add(OBJECT_STUB);
        list.add(OBJECT_STUB);

        list.add(OBJECT_STUB, 8);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMethodGetShouldThrowIndexOutOfBoundsException() {
        list.add(OBJECT_STUB);
        list.add(OBJECT_STUB);
        list.add(OBJECT_STUB);

        list.get(5);
    }
}
