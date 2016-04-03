package ua.luxoft.study.datastructures.hashset;

import ua.luxoft.study.datastructures.hashmap.HashMap;

import java.util.Set;

public class HashSet<K> {

    private HashMap<K, Object> map;
    private Object value = null;

    public HashSet() {
        map = new HashMap<K, Object>();
    }

    public boolean put(K key) {
        if (map.containsKey(key)) {
            return false;
        } else {
            map.put(key, value);
            return true;
        }
    }


    public boolean remove(K key) {
        if (map.containsKey(key)) {
            map.remove(key);
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return map.size();
    }

    public boolean contains(K key) {
        return map.containsKey(key);
    }


    public Set<K> keySet() {
        return map.keySet();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void clear() {
        map.clear();
    }

    public void addAll(HashSet<K> source) {
       for (K key: source.keySet()){
           this.put(key);
       }
    }
}
