package HomeWork9;

/**
 * Created by Velev Vlad on 20.06.2017.
 */
public interface VCollection {
    int size();
    boolean isEmpty();
    boolean contains(Object object);
    boolean add(Object object);
    boolean remove(Object object);
    boolean addAll(MyCollection collection);
    void clear();
    boolean retainAll(MyCollection collection);
    boolean removeAll(MyCollection collection);
    boolean containsAll(MyCollection collection);

}
