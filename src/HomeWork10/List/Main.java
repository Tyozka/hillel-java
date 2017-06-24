package HomeWork10.List;

/**
 * Created by Velev Vlad on 24.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        SinglyList list = new SinglyList();
        //list.get(5);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.get(5));
        list.set(5, "новый");
        System.out.println(list.get(5));
        System.out.println(list.size());
        list.remove("новый");
        System.out.println(list.size());

    }
}
