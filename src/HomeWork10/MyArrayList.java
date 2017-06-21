package HomeWork10;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by Velev Vlad on 21.06.2017.
 */
public class MyArrayList implements List{

    private int size;
    private Object[] objects;

    public MyArrayList(){
        this.size = 0;
        objects = new Object[10];
    }

    public MyArrayList(int capacity){
        this();
        if(capacity > 0) {
            objects = new Object[capacity];;
        }
    }

    public MyArrayList(int capacity, Object o) {
        this();
        if(capacity > 0) {
            objects = new Object[capacity];;
        }
        this.objects[0] = o;
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
    public boolean contains(Object o) {
        for(Object obj : this.objects){
            if(obj.equals(o)) return true;
        }
        return false;
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        Object[] temp = new Object[this.size];
        for(int i = 0; i < this.objects.length; i++ ) temp[i] = this.objects[i];
        return temp;
    }

    @Override
    public boolean add(Object o) {
        if(size == this.objects.length) increase();
        this.objects[size] = o;
        size++;
        return true;
    }
    //
    private void increase() {
        Object[] temp = new Object[this.size*2];
        for(int i = 0; i < this.objects.length; i++ ) {
            temp[i] = this.objects[i];
        }
        this.objects = temp;
    }

    @Override
    public boolean remove(Object o) {
        int index = this.indexOf(o);
        if(index == -1) return false;

        if(index != size-1){
            this.objects[index] = this.objects[size-1];
        }
        this.objects[size-1] = null;
        size--;
        return true;
    }

    @Override
    public boolean addAll(@NotNull Collection c) {
        for(Object o : c.toArray()){
            this.add(o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection c) {
        if(!checkIndex(index)) return false;
        if(c == null) return false;

        this.size = index;
        return this.addAll(c);
    }

    private boolean checkIndex(int i) {

        return (i >= 0) && (i < this.objects.length);
    }


    @Override
    public void clear() {
        for(int i = 0; i < this.size; i++){
            this.objects[i] = null;
        }
        size = 0;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException{
        if(!checkIndex(index)) throw new IndexOutOfBoundsException("index "+ index +" in MyArrayList does not exist");
        return this.objects[index];
    }

    @Override
    public Object set(int index, Object element) throws IndexOutOfBoundsException{
        add(index,element);
        return element;
    }

    @Override
    public void add(int index, Object element) throws IndexOutOfBoundsException{
        if(!checkIndex(index)) throw new IndexOutOfBoundsException("index "+ index +" in MyArrayList does not exist");
        this.objects[index] = element;
    }

    @Override
    public Object remove(int index) throws IndexOutOfBoundsException{
        if(!checkIndex(index)) throw new IndexOutOfBoundsException("index "+ index +" in MyArrayList does not exist");
        Object o = this.objects[index];
        if(index != size-1){
            this.objects[index] = this.objects[size-1];
        }
        this.objects[size-1] = null;
        size--;
        return o;
    }

    @Override
    public int indexOf(Object o) {
        if(o == null) return -1;
        for(int i = 0; i < this.objects.length; i++){
            if(this.objects.equals(o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        if(o == null) return -1;
        for(int i = 0; i < this.objects.length; i++){
            if(this.objects.equals(o)) index = i;
        }
        return index;
    }

    @NotNull
    @Override
    public ListIterator listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @NotNull
    @Override
    public List subList(int fromIndex, int toIndex) {
        if(!checkIndex(fromIndex)) throw new IndexOutOfBoundsException("index "+ fromIndex +" in MyArrayList does not exist");
        if(!checkIndex(toIndex)) throw new IndexOutOfBoundsException("index "+ toIndex +" in MyArrayList does not exist");

        if(fromIndex == toIndex) return new MyArrayList(1,this.get(fromIndex));
        if(fromIndex > toIndex){
            int temp = fromIndex;
            fromIndex = toIndex;
            toIndex = temp;
        }
        int newCapacity = toIndex - fromIndex + 1;
        MyArrayList tempList = new MyArrayList(newCapacity );
        for(int i = fromIndex ; i <= toIndex; i++){
            tempList.add(this.get(i));
        }
        return tempList;
    }

    @Override
    public boolean retainAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection c) {
        return false;
    }

    @NotNull
    @Override
    public Object[] toArray(@NotNull Object[] a) {
        return new Object[0];
    }
}
