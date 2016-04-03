package ua.luxoft.study.datastructures.list;

public interface List extends Iterable {

    int size();

    Object get(int index);

    boolean contains(Object object);

    int indexOf(Object object);

    int lastIndexOf(Object object);

    void add(Object object);

    void add(Object object, int index);

    void remove(int index);

    void clear();

    void addAll(List list);

    void set(Object object, int index);
}
