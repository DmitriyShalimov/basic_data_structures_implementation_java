package ua.luxoft.study.datastructures.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashMap<K, V> {
    private int size;
    private ArrayList<Node>[] list;

    public HashMap() {
        list = new ArrayList[16];
        for (int i = 0; i < 16; i++) {
            list[i] = new ArrayList<>();
        }
    }

    public void put(K key, V value) {
        int index;
        if (key == null) {
            index = 0;
            for (Node newNode : list[0]) {
                if (newNode.getKey() == null) {
                    newNode.setValue(value);
                    return;
                }
            }
        } else {
            index = findIndex(key);
            for (Node newNode : list[index]) {
                if (newNode.getKey().equals(key)) {
                    newNode.setValue(value);
                    return;
                }
            }
        }
        Node node = new Node(key, value);
        list[index].add(node);
        size++;
    }

    public boolean putIfAbsent(K key, V value) {
        int index;
        if (key == null) {
            index = 0;
            for (Node nod : list[0]) {
                if (nod.getKey() == null) {
                    return false;
                }
            }
        } else {
            index = findIndex(key);
            for (Node nod : list[index]) {
                if (nod.getKey().equals(key)) {
                    return false;
                }
            }
        }
        Node node = new Node(key, value);
        list[index].add(node);
        size++;
        return true;
    }

    public V get(K key) {
        V result = null;
        if (key == null) {
            for (Node node : list[0]) {
                if (node.getKey() == null) {
                    result = node.getValue();
                }
            }
        } else {
            int index = findIndex(key);
            for (Node node : list[index]) {
                if (node.getKey().equals(key)) {
                    result = node.getValue();
                }
            }
        }
        return result;
    }

    public V remove(K key) {
        int index;
        V result = null;
        boolean checkRemove = false;
        Node node = null;
        if (key == null) {
            index = 0;
            for (Node newNode : list[0]) {
                if (newNode.getKey() == null) {
                    result = newNode.getValue();
                    node = newNode;
                    checkRemove = true;
                }
            }
        } else {
            index = findIndex(key);
            for (Node newNode : list[index]) {
                if (newNode.getKey().equals(key)) {
                    result = newNode.getValue();
                    node = newNode;
                    checkRemove = true;
                }
            }
        }
        if (checkRemove) {
            list[index].remove(node);
            size--;
        }
        return result;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            for (Node node : list[0]) {
                if (node.getKey() == null) {
                    return true;
                }
            }
        } else {
            int index = findIndex(key);
            for (Node node : list[index]) {
                if (node.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (ArrayList<Node> arrayList : list) {
            for (Node node : arrayList) {
                if (node.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        for (ArrayList<Node> arrayList : list) {
            for (Node node : arrayList) {
                result.add(node.getKey());
            }
        }
        return result;
    }

    public List<V> valueList() {
        List<V> result = new ArrayList<>();
        for (ArrayList<Node> arrayList : list) {
            for (Node node : arrayList) {
                result.add(node.getValue());
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (ArrayList<Node> arrayList : list) {
            arrayList.clear();
        }
        size = 0;
    }

    public void addAll(HashMap<K, V> source) {
        Set<K> keyList = source.keySet();
        for (K key : keyList) {
            this.put(key, source.get(key));
        }
    }

    private int findIndex(K key) {
        return key.hashCode() % 16;
    }

    public class Node {
        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

