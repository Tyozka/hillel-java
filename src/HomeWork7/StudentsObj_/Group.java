package HomeWork7.StudentsObj_;

/**
 * Created by Velev Vlad on 20.06.2017.
 */
public class Group {
    private static int DEFAULT_NUM_OF_STUDENT = 30;

    private Student[] students;
    private Teacher teacher;
    private int size;

    public Group(){
        students = new Student[DEFAULT_NUM_OF_STUDENT];
        size = 0;
    }

    public Group(int numOfStudents){
        students = new Student[numOfStudents];
        size = 0;
    }

    public boolean add(Student student){
        if(student == null) return false;
        if(size >= students.length) increaseSize();
        students[size] = student;
        size++;
        return true;
    }

    public boolean deleteBySecondeNeme(String secondeName){
        int index = findBySecondeName(secondeName);
        if(index == DEFAULT_INDEX_ERROR) return false;
        if(index != size-1){
            students[index] = students[size-1];
        }
        students[size-1] = null;
        size--;
        return true;
    }

    public boolean deleteAll(){
        for(int i = 0 ; i < students.length; i++){
            students[i] = null;
        }
        size = 0;
        return true;
    }

    public int findBySecondeName(String secondeName){
        for(int i = 0 ; i < students.length; i++){
            if(students[i].getSecondName().equals(secondeName)){
                return i;
            }
        }
        return DEFAULT_INDEX_ERROR;
    }
    public int findByName(String name){
        for(int i = 0 ; i < students.length; i++){
            if(students[i].getName().equals(name)){
                return i;
            }
        }
        return DEFAULT_INDEX_ERROR;
    }
    public boolean connect(Group group){
        for(Student stud : group.getStudents()){
            this.add(stud);
        }
        return true;
    }

    public boolean equals(Group group){
        if(this.students.length != group.getStudents().length) return false;
        return containsAll(group);
    }

    public boolean containsAll(Group group){
        Student[] tempGroup = group.getStudents();
        for(int i = 0 ; i < tempGroup.length; i ++ ){
            int index = this.findBySecondeName(tempGroup[i].getSecondName());
            if( index == DEFAULT_INDEX_ERROR) return false;
            if(!this.getStudents()[index].equals(tempGroup[i])) return false;
        }
        return true;
    }


    public Student[] getStudents() {
        Student[] temp = new Student[students.length];
        for(int i = 0; i < students.length; i++){
            temp[i] = students[i];
        }
        return temp;
    }

    //сортировка по фамилии

    private void increaseSize(){
        Student[] temp = new Student[students.length*2];
        for(int i = 0; i < students.length; i++){
            temp[i] = students[i];
        }
        students = temp;
    }

    private static int DEFAULT_INDEX_ERROR = -1;
}
