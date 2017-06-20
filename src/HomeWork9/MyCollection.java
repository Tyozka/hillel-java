package HomeWork9;

/**
 * Created by Velev Vlad on 20.06.2017.
 */
public class MyCollection implements VCollection {
    private int size = 0;
    private Object[] objects;

    public MyCollection(){
        objects = new Object[30];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object object){
        for(Object obj : this.objects){
            if(obj.equals(object)) return true;
        }
        return false;
    }

    @Override
    public boolean add(Object object){
        if(object == null) return false;
        if(this.size >= this.objects.length) increaseSize();
        this.objects[size] = object;
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if(isEmpty()) return false;
        if(!contains(obj)) return false;
        for(int i =0 ; i < this.objects.length; i++){
            if(this.objects[i].equals(obj)) {
                if(i != this.size-1){
                    this.objects[i] = this.objects[this.size-1];
                  }
                this.objects[this.size-1] = null;
                this.size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(MyCollection collection) {

        return false;
    }

    @Override
    public void clear(){
        for(int i =0 ; i < this.objects.length; i++){
            this.objects[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean retainAll(MyCollection collection) {
        return false;
    }

    @Override
    public boolean removeAll(MyCollection collection){
        return false;
    }

    @Override
    public boolean containsAll(MyCollection collection) {
        return false;
    }

    private void increaseSize(){
        Object[] temp = new Object[objects.length*2];
        for(int i = 0; i < objects.length; i++){
            temp[i] = objects[i];
        }
        objects = temp;
    }
}
