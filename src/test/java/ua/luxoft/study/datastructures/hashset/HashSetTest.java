package ua.luxoft.study.datastructures.hashset;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HashSetTest {
    private HashSet<String> hashSet;

    @Before
    public void setUpHashSet() {
        hashSet = new HashSet<>();
    }

    @Test
    public void testMethodSizeShouldReturnSize3() {
        assertThat(hashSet.size(), is(0));
        hashSet.put("aaa");
        hashSet.put("bbb");
        hashSet.put("ccc");
        assertThat(hashSet.size(), is(3));
        hashSet.put("ccc");
        assertThat(hashSet.size(), is(3));
    }

    @Test
    public void testMethodPutShouldReturnDoubleTrueThenFalseThenReturnSize2() {
        assertThat(hashSet.put("aaa"), is(true));
        assertThat(hashSet.put("bbb"), is(true));
        assertThat(hashSet.put("bbb"), is(false));
        assertThat(hashSet.size(), is(2));
    }

    @Test
    public void testMethodRemoveShouldReturnSize2ShouldReturnDoubleTrueThenFalseThenReturnSize0() {
        hashSet.put("aaa");
        hashSet.put("bbb");
        assertThat(hashSet.size(), is(2));
        assertThat(hashSet.remove("aaa"), is(true));
        assertThat(hashSet.remove("bbb"), is(true));
        assertThat(hashSet.size(), is(0));
        assertThat(hashSet.remove("aaa"), is(false));
    }

    @Test
    public void testMethodContainsShouldReturnTrueThenFalse() {
        hashSet.put("aaa");
        hashSet.put("bbb");
        assertThat(hashSet.contains("aaa"), is(true));
        assertThat(hashSet.contains("ccc"), is(false));
    }

    @Test
    public void testMethodKeySetShouldReturnDoubleTrueAndThenFalse() {
        hashSet.put("aaa");
        hashSet.put("bbb");
        assertThat(hashSet.keySet().contains("aaa"), is(true));
        assertThat(hashSet.keySet().contains("bbb"), is(true));
        assertThat(hashSet.keySet().contains("ccc"), is(false));
    }

    @Test
    public void testMethodIsEmptyShouldReturnTrueThenFalseThenTrue() {
        assertThat(hashSet.isEmpty(), is(true));
        hashSet.put("aaa");
        assertThat(hashSet.isEmpty(), is(false));
        hashSet.clear();
        assertThat(hashSet.isEmpty(), is(true));
    }

    @Test
    public void testMethodClearShouldReturnFalseThenTrue() {
        hashSet.put("aaa");
        hashSet.put("bbb");
        assertThat(hashSet.isEmpty(), is(false));
        hashSet.clear();
        assertThat(hashSet.isEmpty(), is(true));
    }

    @Test
    public void testMethodAddAllShouldReturnSize2ThenShouldReturnDoubleTrue() {
        HashSet<String> newHashMap = new HashSet<>();
        hashSet.put("aaa");
        newHashMap.put("aaa");
        newHashMap.put("bbb");
        hashSet.addAll(newHashMap);
        assertThat(hashSet.size(), is(2));
        assertThat(hashSet.contains("aaa"), is(true));
        assertThat(hashSet.contains("bbb"), is(true));
    }
}
