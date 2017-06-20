package HomeWork7.StudentsObj_;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Velev Vlad on 11.06.2017.
 */
public class Student extends Persone implements Comparable{
    private String name;
    private String secondName;
//    private Marks marks;
    // visits

    public Student(){
        super();
//        marks = new Marks();
    }

    public Student(final String name, final String secondName){
        super(name, secondName);
//        marks = new Marks();
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

//    public Marks getMarks() {
//        return marks;
//    }
    @Override
    public int compareTo(@NotNull Object st){
        int i = this.getName().compareTo(((Student)st).getName());
        int y = this.getSecondName().compareTo(((Student)st).getSecondName());

        if(i > 0 & y > 0 ) return 1;
        if(i == 0 & y == 0) return  0;
        return -1;
    }

    public boolean equals (Student other){
        if(!this.name.equals(other.getName())) return false;
        if(!this.secondName.equals(other.getSecondName())) return false;

        return true;
    }

}
