package ua.luxoft.study.data_structures.List;


public interface List {
     int size();

     Object get(int index);

     boolean contains(Object object);

     int indexOf(Object object);

     int lastIndexOf(Object object);

     void add(Object object);

     void add(Object object, int index);

     void remove(int index);

     void clear();

     void addCollection(List list);

     void set(Object object, int index);

     boolean equals(Object object);
}
