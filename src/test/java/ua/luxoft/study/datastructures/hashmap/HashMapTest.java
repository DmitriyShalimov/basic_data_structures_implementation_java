package ua.luxoft.study.datastructures.hashmap;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HashMapTest {
    private HashMap<String, String> hashMap;

    @Before
    public void setUpHashMap() {
        hashMap = new HashMap<>();
    }

    @Test
    public void testMethodSizeShouldReturnSize3() {
        assertThat(hashMap.size(), is(0));
        hashMap.put("aaa", "AAA");
        hashMap.put("bbb", "BBB");
        hashMap.put("ccc", "CCC");
        assertThat(hashMap.size(), is(3));
    }

    @Test
    public void testMethodPutShouldReturnSize3ShouldReturn3ElementsInOrderAAA_BBB_CCC() {
        hashMap.put("aaa", "AAA");
        hashMap.put("bbb", "BBB");
        hashMap.put("ccc", "CCC");
        assertThat(hashMap.size(), is(3));
        assertThat(hashMap.get("aaa"), is("AAA"));
        assertThat(hashMap.get("bbb"), is("BBB"));
        assertThat(hashMap.get("ccc"), is("CCC"));

    }

    @Test
    public void testMethodPutIfAbsentShouldReturnTrueThenFalseThenReturnSize2ThenShouldReturn2ElementsInOrderAAA_BBB() {
        hashMap.put("aaa", "AAA");
        assertThat(hashMap.putIfAbsent("aaa", "AAA"), is(false));
        assertThat(hashMap.putIfAbsent("bbb", "BBB"), is(true));
        assertThat(hashMap.size(), is(2));
        assertThat(hashMap.get("aaa"), is("AAA"));
        assertThat(hashMap.get("bbb"), is("BBB"));
    }

    @Test
    public void testMethodGetShouldReturnSize3ShouldReturn3ElementsInOrderAAA_BBB_CCC() {
        hashMap.put("aaa", "AAA");
        hashMap.put("bbb", "BBB");
        hashMap.put("ccc", "CCC");
        assertThat(hashMap.size(), is(3));
        assertThat(hashMap.get("aaa"), is("AAA"));
        assertThat(hashMap.get("bbb"), is("BBB"));
        assertThat(hashMap.get("ccc"), is("CCC"));
    }

    @Test
    public void testMethodRemoveShouldReturnSize2ShouldReturn2ElementsInOrderAAA_BBBThenShouldReturnSize1ShouldReturnElementInOrderAAA() {
        hashMap.put("aaa", "AAA");
        hashMap.put("bbb", "BBB");
        assertThat(hashMap.size(), is(2));
        assertThat(hashMap.get("aaa"), is("AAA"));
        assertThat(hashMap.remove("bbb"), is("BBB"));
        assertThat(hashMap.size(), is(1));
        assertThat(hashMap.get("aaa"), is("AAA"));
    }

    @Test
    public void testMethodContainsKeyShouldReturnTrueThenFalse() {
        hashMap.put("aaa", "AAA");
        hashMap.put("bbb", "BBB");
        assertThat(hashMap.containsKey("aaa"), is(true));
        assertThat(hashMap.containsKey("ccc"), is(false));
    }

    @Test
    public void testMethodContainsValueShouldReturnTrueThenFalse() {
        hashMap.put("aaa", "AAA");
        hashMap.put("bbb", "BBB");
        assertThat(hashMap.containsValue("AAA"), is(true));
        assertThat(hashMap.containsValue("CCC"), is(false));
    }

    @Test
    public void testMethodKeySetShouldReturnDoubleTrueAndThenFalse() {
        hashMap.put("aaa", "AAA");
        hashMap.put("bbb", "BBB");
        assertThat(hashMap.keySet().contains("aaa"), is(true));
        assertThat(hashMap.keySet().contains("bbb"), is(true));
        assertThat(hashMap.keySet().contains("ccc"), is(false));

    }

    @Test
    public void testMethodValueSetShouldReturnDoubleTrueAndThenFalse() {
        hashMap.put("aaa", "AAA");
        hashMap.put("bbb", "BBB");
        assertThat(hashMap.valueList().contains("AAA"), is(true));
        assertThat(hashMap.valueList().contains("BBB"), is(true));
        assertThat(hashMap.valueList().contains("CCC"), is(false));

    }

    @Test
    public void testMethodIsEmptyShouldReturnTrueThenFalseThenTrue() {
        assertThat(hashMap.isEmpty(), is(true));
        hashMap.put("aaa", "AAA");
        assertThat(hashMap.isEmpty(), is(false));
        hashMap.clear();
        assertThat(hashMap.isEmpty(), is(true));
    }

    @Test
    public void testMethodClearShouldReturnFalseThenTrue() {
        hashMap.put("aaa", "AAA");
        hashMap.put("bbb", "BBB");
        assertThat(hashMap.isEmpty(), is(false));
        hashMap.clear();
        assertThat(hashMap.isEmpty(), is(true));


    }

    @Test
    public void testMethodAddAllShouldReturnTrueThenReturnSize2ThenShouldReturn2ElementsInOrderAAA_BBB() {
        HashMap<String, String> newHashMap = new HashMap<>();
        newHashMap.put("aaa", "AAA");
        newHashMap.put("bbb", "BBB");
        assertThat(hashMap.isEmpty(), is(true));
        hashMap.addAll(newHashMap);
        assertThat(hashMap.size(), is(2));
        assertThat(hashMap.get("aaa"), is("AAA"));
        assertThat(hashMap.get("bbb"), is("BBB"));
    }
}
