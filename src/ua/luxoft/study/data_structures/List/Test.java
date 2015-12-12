package ua.luxoft.study.data_structures.List;

/**
 * Created by dimon on 12/12/2015.
 */
public class Test {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(11);
        linkedList.add(12);
        linkedList.add(13);
        linkedList.add(14);
        linkedList.add(15);
        linkedList.add(16);
        linkedList.add(17);
        linkedList.add("a",6);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.get(4));
        System.out.println(linkedList.get(5));
        System.out.println(linkedList.get(6));
        System.out.println(linkedList.get(7));
    }
}
