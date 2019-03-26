package listyIterator;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    private List<String> data;
    private int internalIndex;

    public ListyIterator(ArrayList<String> data) {
        this.data = data;
        setInternalIndex();
    }

    public void setInternalIndex() {
        if (this.data.size() == 0) {
            this.internalIndex = -1;
        } else {
            this.internalIndex = 0;
        }
    }

    public boolean Move() {
        if (this.internalIndex < this.data.size() - 1) {
            this.internalIndex++;
            return true;
        }

        return false;
    }

    public String Print() {
        if (this.data.size() == 0) {
            throw new IndexOutOfBoundsException("Invalid Operation!");
        }

        return this.data.get(this.internalIndex);

    }

    public boolean HasNext() {
        return this.internalIndex < this.data.size() - 1;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return this.count < data.size();
            }

            @Override
            public String next() {
                return data.get(this.count++);
            }
        };
    }
}
