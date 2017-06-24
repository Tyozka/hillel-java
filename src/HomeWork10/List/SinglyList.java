package HomeWork10.List;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Velev Vlad on 24.06.2017.
 */
public class SinglyList implements Collection{
    private SinglyNode first;
    private int capasity;

    SinglyList(){
        this.capasity = 0;
    }
    SinglyList(Object o){
        this.first = new SinglyNode(o);
        this.capasity = 1;
    }

    public boolean add(Object o){
        if(this.capasity == 0){
            this.first =  new SinglyNode(o);
            this.capasity = 1;
            return true;
        }

        SinglyNode last = getLast();
        last.setNext(new SinglyNode(o));
        capasity++;
        return true;
    }

    @Override
    public boolean remove(Object o){
        if(size() == 0 ) return false;
        if(size() == 1 ){
            if( this.first.getData().equals(o)){
                this.first = null;
                return true;
            } else return false;
        }
        SinglyNode prew = this.first;
        SinglyNode next = prew.getNext();


        do{
            if(next.isLast()) {
                if( next.getData().equals(o)){
                    prew.setNext(null);
                    capasity--;
                    return true;
                } else return false;
            }
            else {
                if( next.getData().equals(o)){
                    prew.setNext(null);
                    capasity--;
                    return true;
                } else {
                    prew = next;
                    next = next.getNext();
                }
            }


        } while (true);
    }

    @Override
    public boolean addAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public void clear(){
        this.first.setNext(null);
        this.capasity = 0;

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

    public Object get(int i) throws IndexOutOfBoundsException{
        if(!checkIndex(i)) throw new IndexOutOfBoundsException("Нет такого индекса");
        SinglyNode tempNode = this.first;
        int index = 1;
        while ( index <= capasity){
            tempNode = getNext(tempNode);
            index++;
        }
        return tempNode.getData();


    }

    public int size(){
        return this.capasity;
    }

    @Override
    public boolean isEmpty() {
        return capasity == 0;
    }

    @Override
    public boolean contains(Object o) {
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
        return new Object[0];
    }

    @NotNull
    @Override
    public Object[] toArray(@NotNull Object[] a) {
        return new Object[0];
    }

    public void set(int index, Object o) throws IndexOutOfBoundsException{
        if(!checkIndex(index)) throw new IndexOutOfBoundsException("Нет такого индекса");
        SinglyNode tempNode = this.first;
        int i = 1;
        while ( i <= index){
            tempNode = getNext(tempNode);
            i++;
        }
        tempNode.setData(o);
    }

    private SinglyNode getNext(SinglyNode tempNode) {
        if(tempNode.isLast()) return tempNode;
        return tempNode.getNext();
    }

    private boolean checkIndex(int i) {
        return i > 0 && i <= capasity;
    }

    private SinglyNode getLast(){
        SinglyNode tempNode = this.first;
        do{
            if(!tempNode.isLast()){
                tempNode = tempNode.getNext();
            }
        }while(!tempNode.isLast());
        return tempNode;
    }

}
