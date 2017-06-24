package HomeWork10.List;

/**
 * Created by Velev Vlad on 24.06.2017.
 */
public class SinglyNode {


    private SinglyNode next = null;
    private Object data;

    SinglyNode(){

    }
    SinglyNode(Object o){
        this.data = o;
    }

    SinglyNode(Object o, SinglyNode next){
        this(o);
        this.next = next;
    }

    public SinglyNode getNext() {
        return next;
    }

    public void setNext(SinglyNode next) {
        this.next = next;
    }

    public Object getData(){
        return this.data;
    }

    public void setData(Object o){
        this.data = o;
    }


    public boolean isLast(){
        return this.getNext() == null;
    }
}
