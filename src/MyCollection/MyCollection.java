package MyCollection;
import java.util.Collection;
import java.util.Iterator;

public class MyCollection implements Collection {
    private Object[] array;
    private int size;
    public  MyCollection(){
        this.size = 0;
        array = new Object[size];
    }
    @Override
    public  boolean add(Object object){
        boolean added;
        Object[] newArray = new Object[size+1];
        System.arraycopy(array,0,newArray,0,size);
        newArray[size++]= object;
        array = newArray;
        added = true;
        return  added;
        }
    public void print(){
        if(size>0){
            for (int i = 0; i < size ; i++) {
                System.out.println(array[i].toString());
            }
        } else {
            System.out.println("Collection is empty!");
        }
    }
    @Override
    public int size(){
        int count = 0 ;
        for (int i = 0; i <size ; i++) {
            count++;
        }
        return count;
    }
    @Override
    public  boolean isEmpty(){
        if(this.size == 0){
            return true;
        }
        return false;
    }
    @Override
    public boolean contains(Object object){
        boolean contained = false;
        for (int i = 0; i <size ; i++) {
            if(object.equals(array[i])){
                contained = true;
            }
        }
        return  contained;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if(a.length >= array.length){
            System.arraycopy(array, 0, a, 0, size);
        }else {
            Object[] new_a = new Object[array.length];
            System.arraycopy(array, 0,new_a, 0, size);
            a = new_a;
        }
        return a;
    }

    @Override
    public boolean remove(Object object){
        boolean removed = false;
        for (int i = 0; i <size ; i++) {
           if(object.equals(array[i])){
               for (int j = i; j < size -1 ; j++) {
                   array[j] = array[j+1];
                   removed = true;
               }
               size--;
           }
        }
        return  removed;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean added = false;
        if(c instanceof  Object){
                for (Object o:c) {
                    this.add(o);
                    added = true;
                }
            }
        return  added;

    }

    @Override
    public boolean retainAll(Collection c) {
        boolean retained = false;
        if(c instanceof Object){
            int counter = 0;
            Object[] newArray = new Object[counter];
            for (Object o:c) {
                for(int i =0; i<this.size; i++ ){
                    if (o.equals(array[i])){
                        counter++;
                        newArray[counter-1] = array[i];
                        retained = true;

                    }
                }
            }
            array = newArray;
        }

        return retained;
    }

    @Override
    public boolean removeAll(Collection c) {
        Object[] newArray;
        for (int i = 0; i < size ; i++) {
                if(c.contains(array[i])){
                    for (int j = i; j < size -1 ; j++) {
                        array[j] = array[j+1];
                    }
                    array[--size] = null;
                }
        }
        newArray = new Object[size];
        System.arraycopy(array,0,newArray,0,size);
        array = newArray;
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (c.contains(array[i])) {

                count++;
            }
        }

        if (count >= c.size()) {
            return true;
        }
        return false;
    }


    public Object getValueByIndex(int index){
        Object result = null;
        if(index>=0 && index<size){
            for (int i = 0; i < size ; i++) {
                if(index == i){
                    result = array[i];
                }
            }
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds ");
        }
        return result ;
    }
    @Override
    public void clear(){
        for (int i = 0; i < array.length ; i++) {
                array[i]= null;
        }
        this.size = 0;
    }


}
