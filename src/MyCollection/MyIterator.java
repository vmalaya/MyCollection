package MyCollection;


import java.util.Iterator;

public class MyIterator implements Iterator {
    private MyCollection collection;
    private int index;

    public MyIterator(MyCollection collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return index < collection.size();
    }

    @Override
    public Object next() {
        Object o = collection.getValueByIndex(index);
        index++;
        return o;
    }
}
