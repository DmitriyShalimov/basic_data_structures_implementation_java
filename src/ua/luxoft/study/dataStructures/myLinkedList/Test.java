package ua.luxoft.study.dataStructures.myLinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myList=new MyLinkedList();
        myList.add(0);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        System.out.println(myList.size());
        System.out.println(myList.toString());
        myList.add("aa", 0);
        myList.add("bb", 3);
        myList.add("zz", 4);
        myList.add("cc", 7);
        System.out.println(myList.size());
        System.out.println(myList.toString());
               for (int i = 0; i <myList.size() ; i++) {
            System.out.println(myList.get(i));

        }



    }
}
