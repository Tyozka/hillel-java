package HomeWork7;

/**
 * Created by Влад on 20.06.2017.
 */
public class ContainerInt {

    private int[] array;



    private int size;

    ContainerInt(){
        array = new int[20];
        size = 0;
    }

    ContainerInt(int capacity){
        this();
        if(capacity > 0) array = new int[capacity];
    }

    public int getSize() {
        return size;
    }

    public ContainerInt add(int i){
        if(size < array.length){
            array[size] = i;
        } else {
            incrementArr();
            array[size] = i;
        }

        size++;
        return this;
    }

    public int get(int i) throws ArrayIndexOutOfBoundsException{
        if(i < 0 || i >= array.length)  throw new  ArrayIndexOutOfBoundsException("Index  does not exist");
        return array[i];
    }

    public boolean contains(int obj){
        for(int elem : array){
            if(elem == obj) return true;
        }
        return false;
    }

    public void addAll(ContainerInt container){
        for(int i = 0; i < container.getSize(); i++){
            this.add(container.get(i));
        }
    }

    public boolean equals(ContainerInt container){
        if(this.getSize() != container.getSize()) return false;

        for(int i = 0; i < this.size; i++){
            if(this.get(i) != container.get(i)) return false;
        }
        return true;
    }

    public boolean clear(){
        this.size = 0;
        return true;
    }

    public int indexOf(int elem){
        if(!this.contains(elem)) return -1;
        int i = 0;
        for(; i < size; i++){
            if(array[i] == elem) break;
        }
        return i;
    }

    public void sort(){
        this.sort(true);
    }

    public void sort(boolean incr){
        for(int i = 0; i < size; i++){
            for(int j = size-1; j > i; j--){
                if(compareInt(array[j-1],array[j], incr)){
                    int x = array[j-1];
                    array[j-1] = array[j];
                    array[j] = x;
                }
            }
        }
    }

    private boolean compareInt(int i, int y, boolean incr) {
        if(incr) return i > y;
        return i < y;
    }


    private void incrementArr(){
        int[] temp = new int[array.length*2];
        for(int i = 0 ; i < array.length; i++){
            temp[i] = array[i];
        }
        array = temp;
    }


}



