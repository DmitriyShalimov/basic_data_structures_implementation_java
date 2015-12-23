package ua.luxoft.study.data_structures.List;


public class ArrayList implements List, Iterable {
    private int size = 0;
    private Object[] array;

    public ArrayList() {
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
            if (checkNull(array[i])) {
                if (array[i].equals(object)) {
                    return i;
                }
            } else {
                if (array[i] == object) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (checkNull(array[i])) {
                if (array[i].equals(object)) {
                    return i;
                }
            } else {
                if (array[i] == object) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void add(Object object, int index) {
        validateIndex(index);
        if (size == array.length) {
            Object[] tempArray = new Object[size * 3 / 2 + 1];
            System.arraycopy(array, 0, tempArray, 0, array.length);
            array = tempArray;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = object;
        size++;
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

    public void addCollection(List list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }


    public void add(Object object) {
        add(object, size);
    }

    public void set(Object object, int index) {
        validateIndex(index);
        array[index] = object;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof List) {
            List list = (List) object;
            if (size == (list.size())) {
                for (int i = 0; i < size; i++) {
                    if (array[i].equals(list.get(i))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            String message = "Index = " + index + ". Index must be between 0 and " + size;
            throw new IndexOutOfBoundsException(message);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ArrayList{");
        for (int i = 0; i < size; i++) {
            builder.append(" ").append(array[i]).append(" ");
        }
        return builder.toString() + "}";
    }

    public boolean checkNull(Object object) {
        return object != null;
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            int current = 0;
            int lastReturn = -1;

            @Override
            public Object next() {
                Object object;
                if (hasNext()) {
                    object = array[current];
                    lastReturn = current;
                    current++;

                    return object;
                }
                return null;
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
}
