package genericbox;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Box<T> {
    private T item;
    private Class<T> clazz;

    public Box(Class<T> clazz, T item) {
        this.item = item;
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return  this.clazz.getName()+ ": " + this.item;
    }

    public static <T extends Comparable<T>> int countElements(ArrayList<T> list,T element){
        int count = 0;

        for (T t : list) {
            if(t.compareTo(element)>0){
                count++;
            }
        }

        return count;
    }
}
