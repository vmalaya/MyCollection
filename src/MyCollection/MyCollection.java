package MyCollection;


public class MyCollection {
    private Object[] array;
    private static final int  SIZE_OF_COLLECTION = 10;
    private int size;
    public  MyCollection(){
        this.size = 0;
        array = new Object[SIZE_OF_COLLECTION];
    }
    public  void  add(Object object){
        if(size == array.length){
            Object[] newArray = new Object[array.length*2];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
        }
        array[size++]= object;
    }
    public void print(){
        if(size>0){
        for (int i = 0; i < size ; i++) {
            System.out.println(array[i].getName());
            }
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
            if(size > 0){
                array[i]= null;
                --size;
            } else{
                break;
            }
        }
    }
    public void removeAll(MyCollection collection){
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j <collection.size() ; j++) {
               if(array[i].equals(collection.getValueByIndex(j))){
                   for (int k = i; k < size -1 ; k++) {
                       array[k] = array[k+1];
                   }
                   size--;
                }

            }

        }
    }
    public boolean containsAll(MyCollection collection){
        int count = 0;
        int size1 = collection.size();
        for (int i = 0; i < this.size; i++){
            for (int j = 0; j <size1 ; j++) {
                if(array[i].equals(collection.getValueByIndex(j))){

                    count++;
                }
            }
        }
        if(count == collection.size()){
            return true;
        }
        return  false;
    }
}
