package ua.luxoft.study.data_structures;

import ua.luxoft.study.data_structures.List.LinkedList;
import ua.luxoft.study.data_structures.List.List;

public class LinkedListTest extends ListTest {
    @Override
    protected List determineList() {
        return new LinkedList();
    }
}


