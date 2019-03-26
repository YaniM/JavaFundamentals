package customlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MyList<T extends Comparable<T>> implements Iterable<T> {
    private ArrayList<T> list;

    public MyList() {
        this.list = new ArrayList<T>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        if (this.list.contains(element)) {
            return true;
        }

        return false;
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(this.list, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        int count = 0;

        for (T t : list) {
            if (t.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public T getMax() {
        return Collections.max(list);
    }

    public T getMin() {
        return Collections.min(list);
    }

    public void print() {
        for (T t : this.list) {
            System.out.println(t);
        }
    }

    public int size(){
        return this.list.size();
    }

    public T get(int index){
        return this.list.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}
