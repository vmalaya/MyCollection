package MyCollection;

import java.util.Arrays;

public class MyCollection {
    private Object[] array;
    private int size;
    public  MyCollection(){
        this.size = 0;
        array = new Object[size];
    }
    public  void  add(Object object){
            Object[] newArray = new Object[size+1];
            System.arraycopy(array,0,newArray,0,size);
            newArray[size++]= object;
            array = newArray;
        }
    public void print(){
        if(size>0){
            System.out.println(Arrays.asList(array));
        } else {
            System.out.println("Collection is empty!");
        }
    }
    public int size(){
        int count = 0 ;
        for (int i = 0; i <size ; i++) {
            count++;
        }
        return count;
    }
    public  boolean isEmpty(){
        if(this.size == 0){
            return true;
        }
        return false;
    }
    public boolean contains(Object object){
        for (int i = 0; i <size ; i++) {
            if(object.equals(array[i])){
                return true;
            }
        }
        return  false;
    }
    public void remove(Object object){
        for (int i = 0; i <size ; i++) {
           if(object.equals(array[i])){
               for (int j = i; j < size -1 ; j++) {
                   array[j] = array[j+1];
               }
               size--;
           }
        }
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
    public void addAll(MyCollection newCollection){
        for (int i = 0; i < newCollection.size() ; i++) {
            this.add(newCollection.getValueByIndex(i));
        }

    }
    public void clear(){
        for (int i = 0; i < array.length ; i++) {
                array[i]= null;
        }
        this.size = 0;
    }
    public void removeAll(MyCollection collection){
        int size1 = collection.size();
        Object[] newArray;
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size1 ; j++) {
               if(array[i].equals(collection.getValueByIndex(j))){
                   for (int k = i; k < size -1 ; k++) {
                       array[k] = array[k+1];
                   }
                   array[--size] = null;
                }
            }
        }
        newArray = new Object[size];
        System.arraycopy(array,0,newArray,0,size);
        array = newArray;
    }
    public boolean containsAll(MyCollection collection) {
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (collection.contains(array[i])) {

                count++;
            }
        }

        if (count >= collection.size()) {
            return true;
        }
        return false;
    }

}
