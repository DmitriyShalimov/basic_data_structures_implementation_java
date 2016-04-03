package ua.luxoft.study.datastructures.list;

public class LinkedList implements List {
    private Node first;
    private Node last;
    private int size;

    public void add(Object object) {
        Node node = new Node(object, null, null);
        if (size == 0) {
            first = last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }

    public void add(Object object, int index) {
        validateIndex(index);
        if (index == size) {
            add(object);
        } else {
            if (index == 0) {
                first = new Node(object, first, null);
            } else {
                if (index <= (size / 2)) {
                    addToFirstHalfOfList(object, index);
                } else {
                    addToSecondHalfOfList(object, index);
                }
                size++;
            }
        }
    }

    public Object get(int index) {
        validateIndex(index);
        Object object;
        Node node;
        if (index == 0) {
            object = getFirst();
        } else if (index == size - 1) {
            object = getLast();
        } else {
            node = searchItem(index);
            object = node.element;
        }
        return object;
    }

    public Object getFirst() {
        return first.element;
    }

    public Object getLast() {
        return last.element;
    }

    public void set(Object object, int index) {
        validateIndex(index);
        Node node = searchItem(index);
        node.element = object;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        validateIndex(index);
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            if (index < (size / 2)) {
                removeFromTheBeginning(index);
            } else {
                removeFromTheEnd(index);
            }
            size--;
        }
    }

    public void removeLast() {
        last = last.prev;
        size--;
    }

    public void removeFirst() {
        first = first.next;
        size--;
    }

    public void clear() {
        Node node = first;
        for (int i = 0; i < size - 1; i++) {
            Node temp = node.next;
            node.element = null;
            node.prev = null;
            node.next = null;
            node = temp;
        }
        first = last = null;
        size = 0;
    }

    public void addAll(List list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    public int indexOf(Object object) {
        Node node;
        node = first;
        if (isNotNull(object)) {
            for (int i = 0; i < size; i++) {
                if (object.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        Node node;
        node = last;
        if (isNotNull(object)) {
            for (int i = size - 1; i >= 0; i--) {
                if (object.equals(node.element)) {
                    return i;
                }
                node = node.prev;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (node.element == null) {
                    return i;
                }
                node = node.prev;
            }
        }
        return -1;
    }

    public boolean contains(Object object) {
        return indexOf(object) >= 0;
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

        Node node = first;
        for (int i = 0; i < size; i++) {
            if (isNotNull(node.element)) {
                if (!node.element.equals(list.get(i))) {
                    return false;
                }
            } else {
                if (!(list.get(i) == null)) {
                    return false;
                }
            }
            node = node.next;
        }
        return true;
    }

    @Override
    public String toString() {
        Node node;
        node = first;
        StringBuilder builder = new StringBuilder();
        builder.append("List: {").append(first.element);
        node = node.next;
        for (int i = 1; i < size; i++) {
            builder.append(",")
                    .append(" ")
                    .append(node.element);
            node = node.next;
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
                    object = get(current);
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
                LinkedList.this.remove(lastReturn);
                current--;
                lastReturn = -1;
            }
        };
    }

    private boolean isNotNull(Object object) {
        return object != null;
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            String message = "Index = " + index + ". Index must be between 0 and " + size;
            throw new IndexOutOfBoundsException(message);
        }
    }

    private void removeFromTheBeginning(int index) {
        Node node;
        node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = node.prev = null;
        node.element = null;
    }

    private void removeFromTheEnd(int index) {
        Node node;
        node = last;
        for (int i = size - 1; i > index; i--) {
            node = node.prev;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = node.prev = null;
        node.element = null;
    }

    private void addToFirstHalfOfList(Object object, int index) {
        Node node = first;
        for (int i = 1; i < index; i++) {
            node = node.next;
        }
        Node temp = new Node(object, node.next, node);
        node.next = temp;
        temp.next = node.next.next;
        node.next.next.prev = temp;
    }

    private void addToSecondHalfOfList(Object object, int index) {
        Node node = last;
        for (int i = size - 1; i > index; i--) {
            node = node.prev;
        }
        Node temp = new Node(object, node, node.prev);
        node.prev = temp;
        temp.prev = node.prev.prev;
        node.prev.prev.next = temp;
    }

    private Node searchItem(int index) {
        Node node;
        if (index <= (size / 2)) {
            node = first;
            for (int i = 1; i <= index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 2; i >= index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    private class Node {
        private Object element;
        private Node next;
        private Node prev;

        public Node(Object element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}