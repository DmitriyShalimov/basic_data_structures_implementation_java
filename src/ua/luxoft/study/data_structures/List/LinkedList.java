package ua.luxoft.study.data_structures.List;

public class LinkedList implements List {
    private Node first;
    private Node last;
    private int size = 0;

    public LinkedList() {
    }

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
        Node node;

        if (index == size) {
            add(object);
        } else {
            if (index == 0) {
                Node temp = new Node(object, first, null);
                first = temp;
            }else {

                if (index <= (size / 2)) {
                    node = first;
                    for (int i = 1; i < index; i++) {
                        node = node.next;
                    }
                    Node temp = new Node(object, node.next, node);
                    node.next = temp;
                    temp.next = node.next.next;
                    node.next.next.prev = temp;
                } else {
                    node = last;
                    for (int i = size - 1; i > index; i--) {
                        node = node.prev;
                    }
                    Node temp = new Node(object, node, node.prev);
                    node.prev = temp;
                    temp.prev = node.prev.prev;
                    node.prev.prev.next = temp;
                }
                size++;
            }}
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

    public boolean equals(List list) {
        if (!this.getClass().equals(list.getClass())) {
            return false;
        } else {
            if (size != list.size()) {
                return false;
            } else {
                Node node = first;
                for (int i = 0; i < size; i++) {
                    if (!node.element.equals(list.get(i))) {
                        return false;
                    }
                    node = node.next;
                }
            }
        }
        return true;
    }

    public int size() {
        return size;
    }

    private void removeFromTheBegining(int index) {
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

    public void remove(int index) {
        validateIndex(index);
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            if (index < (size / 2)) {
                removeFromTheBegining(index);
            } else {
                removeFromTheEnd(index);
            }
            size--;
        }
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

    public void addCollection(List list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
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
        int index = -1;
        Node node;
        node = first;
        for (int i = 0; i < size; i++) {
            if (checkNull(node.element)) {
                if (node.element.equals(object)) {
                    index = i;
                    break;
                }
            } else {
                if (node.element == object) {
                    index = i;
                    break;
                }
            }
            node = node.next;
        }
        return index;
    }

    public int lastIndexOf(Object object) {
        int index = -1;
        Node node;
        node = last;
        for (int i = size - 1; i >= 0; i--) {
            if (checkNull(node.element)) {
                if (node.element.equals(object)) {
                    index = i;
                    break;
                }
            } else {
                if (node.element == object) {
                    index = i;
                    break;
                }
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
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedList{");
        Node node;
        node = first;
        for (int i = 0; i < size; i++) {
            builder.append(" ").append(node.element).append(" ");
            node = node.next;
        }
        return builder.toString() + "}";
    }

    public boolean checkNull(Object object) {
        return object != null;
    }

    private class Node {
        Object element;
        Node next;
        Node prev;

        public Node(Object element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}