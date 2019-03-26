package customlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter {

    public static <T extends Comparable<T>> void sort(MyList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).compareTo(list.get(j))>0){
                    list.swap(i,j);
                }
            }
        }
    }
}
