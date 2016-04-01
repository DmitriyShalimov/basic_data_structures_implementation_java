package ua.luxoft.study.datastructures.list;

import ua.luxoft.study.datastructures.Iterator;

public class ArrayList implements List {
    private int size;
    private Object[] array;

    public ArrayList() {
        array = new Object[10];
    }

    public ArrayList(int size) {
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
        if (isNotNull(object)) {
            for (int i = 0; i < size; i++) {
                if (object.equals(array[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        if (isNotNull(object)) {
            for (int i = size - 1; i >= 0; i--) {
                if (object.equals(array[i])) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void remove(int index) {
        validateIndex(index);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public void addAll(List list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    public void add(Object object) {
        add(object, size);
    }

    public void add(Object object, int index) {
        validateIndex(index);
        if (size == array.length) {
            Object[] tempArray = new Object[size * 3 / 2 + 1];
            System.arraycopy(array, 0, tempArray, 0, array.length);
            array = tempArray;
        }
        if (index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = object;
        size++;
    }

    public void set(Object object, int index) {
        validateIndex(index);
        array[index] = object;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof List)) {
            return false;
        }

        List list = (List) object;
        if (size != (list.size())) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (isNotNull(array[i])) {
                if (!array[i].equals(list.get(i))) {
                    return false;
                }
            } else {
                if (list.get(i) != null) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("List: {").append(array[0]);

        for (int i = 1; i < size; i++) {
            builder.append(",")
                    .append(" ")
                    .append(array[i]);
        }

        return builder.toString() + "}";
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int current;
            private int lastReturn = -1;

            @Override
            public Object next() {
                Object object;
                if (hasNext()) {
                    object = array[current];
                    lastReturn = current;
                    current++;

                    return object;
                }
                throw new IllegalStateException();
            }

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public void remove() {
                if (lastReturn == -1) {
                    throw new IllegalStateException();
                }
                ArrayList.this.remove(lastReturn);
                current--;
                lastReturn = -1;
            }
        };
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            String message = "Index = " + index + ". Index must be between 0 and " + size;
            throw new IndexOutOfBoundsException(message);
        }
    }

    private boolean isNotNull(Object object) {
        return object != null;
    }
}
