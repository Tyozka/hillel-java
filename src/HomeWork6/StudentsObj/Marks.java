package HomeWork6.StudentsObj;

import java.util.ArrayList;

/**
 * Created by Velev Vlad on 11.06.2017.
 */
public class Marks {


    private ArrayList <Integer> marks;


    public Marks(){
        this.marks = new ArrayList<Integer>();
    }
    public Marks(ArrayList<Integer> marks){
        this.marks = marks;
    }
    public Marks(Integer[] marks){
        this.marks = new ArrayList<Integer>();
        for(Integer elem: marks){
            this.marks.add(elem);
        }
    }
    public Marks(Integer marks){
        this.marks = new ArrayList<Integer>();
        this.marks.add(marks);
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void addMark(Integer mark){
        this.marks.add(mark);
    }


}
