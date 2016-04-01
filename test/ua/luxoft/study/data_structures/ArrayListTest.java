package ua.luxoft.study.data_structures;

import ua.luxoft.study.data_structures.List.ArrayList;
import ua.luxoft.study.data_structures.List.List;

public class ArrayListTest extends ListTest {
    @Override
    protected List determineList() {
        return new ArrayList();
    }
}
