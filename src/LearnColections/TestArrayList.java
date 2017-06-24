package LearnColections;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Velev Vlad on 24.06.2017.
 */
public class TestArrayList {
    public static void main(String[] args) {
        LinkedList<StudentTest> list = new LinkedList<>();
        list.add(new StudentTest("Vlad"));
        list.add(new StudentTest("Igor"));
        list.add(new StudentTest("Vitalya"));
        list.add(new StudentTest("Serega"));
        list.add(new StudentTest("Ura"));
        list.add(new StudentTest("Sasha"));
        list.add(new StudentTest("Kasha"));
        list.add(new StudentTest("Vlad"));

        System.out.println(list.get(4).sayName());
        list.add(4, new StudentTest("Kolia"));
        System.out.println(list.get(4).sayName());

        System.out.println(list.size());


        System.out.println(list.size());
    }
}
