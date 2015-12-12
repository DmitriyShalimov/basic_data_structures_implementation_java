package ua.luxoft.study.data_structures.List;


public interface List {
    public int size();

    public Object get(int index);

    public boolean contains(Object object);

    public int indexOf(Object object);

    public int lastIndexOf(Object object);

    public void add(Object object);

    public void add(Object object, int index);

    public void remove(int index);

    public void clear();

    public void addCollection(List list);

    public void set(Object object, int index);

    public boolean equals(Object object);
}
