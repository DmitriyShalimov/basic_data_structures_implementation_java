package ua.luxoft.study.dataStructures.myLinkedList;

public class MyLinkedList implements MyList {
    private Node first;
    private Node last;
    private int size = 0;

    public MyLinkedList() {
    }

    public void add(Object object) {
        Node node = new Node(object, first, last);
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
        Node node;
        if (index == size) {
            add(object);
        } else {
            if (index <= (size / 2)) {
                node = first;
                for (int i = 1; i <= index; i++) {
                    node = node.next;
                }
                Node temp = new Node(node.element, node.next, node.prev);
                node.element = object;
                node.next = temp;
                node.next.next.prev = node.next;
                node.next.prev = node;

            } else {

                node = last;
                for (int i = size - 1; i > index; i--) {
                    node = node.prev;
                }
                Node temp = new Node(node.element, node.next, node.prev);

                node.next = temp;
                node.next.next.prev = node.next;
                node.next.prev = node;
                node.element = object;
            }
            size++;

        }
    }

    public Object get(int index) {
        validateIndex(index);
        Object object;
        Node node;
        if (index == 0) {
            object = getFirst();
        } else {
            if (index == size - 1) {
                object = getLast();
            } else {
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
                object = node.element;
            }
        }

        return object;
    }

    public void set(Object object, int index) {
        validateIndex(index);
        Node node;
        if (index <= (size / 2)) {
            node = first;
            for (int i = 1; i <= index; i++) {
                node = node.next;
            }
            node.element = object;
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            node.element = object;
        }
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        validateIndex(index);
        Node node;
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            if (index < (size / 2)) {
                node = first;
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = node.prev = null;
                node.element = null;
            } else {
                node = last;
                for (int i = size - 1; i > index; i--) {
                    node = node.prev;
                }
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = node.prev = null;
                node.element = null;
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

    public Object getFirst() {
        return first.element;
    }

    public Object getLast() {
        return last.element;
    }

    public int indexOf(Object object) {
        int index = 0;
        Node node;
        node = first;
        for (int i = 0; i < size; i++) {
            if (node.element.equals(object)) {
                index = i;
                break;
            } else {
                index = -1;
            }
            node = node.next;
        }
        return index;
    }

    public int lastIndexOf(Object object) {
        int index = 0;
        Node node;
        node = last;
        for (int i = size - 1; i >= 0; i--) {
            if (node.element.equals(object)) {
                index = i;
                break;
            } else {
                index = -1;
            }
            node = node.prev;
        }
        return index;
    }

    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            String message = "Index = " + index + ". Index must be between 0 and " + size;
            throw new IndexOutOfBoundsException(message);
        }
    }

    @Override
    public String toString() {
        String listToString = "MyLinkedList{";
        Node node;
        node = first;
        for (int i = 0; i < size; i++) {
            listToString = listToString + " " + node.element + " ";
            node = node.next;
        }
        return listToString + "}";
    }
}