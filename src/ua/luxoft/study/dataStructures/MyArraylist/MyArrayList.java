package ua.luxoft.study.dataStructures.myLinkedList.MyArraylist;

import ua.luxoft.study.dataStructures.myLinkedList.MyList;

public class MyArrayList implements MyList {
    private int size;
    private Object[] array;

    MyArrayList(int size) {
        array = new Object[size];
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (object == array[i]) {
                return i;
            }
        }
        return -1;
    }


    public void add(Object object, int index) {
        validateIndex(index);
        if (size == array.length) {
            Object[] extendedArray = new Object[size * 3 / 2 + 1];
            System.arraycopy(array, 0, extendedArray, 0, array.length);
            array = extendedArray;
        } else {
            Object[] tempArray = new Object[size + 1];
            System.arraycopy(array, index, tempArray, 0, size - index);
            System.arraycopy(tempArray, 0, array, index + 1, tempArray.length - size);
        }
        array[index] = object;
        size++;
    }

    public void remove(int index) {
        validateIndex(index);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        size--;
    }

    public void add(Object object) {
        add(object, size);
    }

    public void set(Object object, int index) {
        validateIndex(index);
        array[index] = object;
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            String message = "Index = " + index + ". Index must be between 0 and " + size;
            throw new IndexOutOfBoundsException(message);
        }
    }

    @Override
    public String toString() {
        String listToString = "MyArrayList{";
        for (int i = 0; i < size; i++) {
            listToString = listToString + " " + array[i] + " ";

        }
        return listToString + "}";
    }
}
