package HomeWork3;

/**
 * Created by Влад on 18.05.2017.
 */
public class StudentsArr {
    int numStudent = 30;
    //         Студенты
    int lastStudentNamber = 0;
    String[][] students =  new String[numStudent][];

    int idInArrStudentId = 0;
    int idInArrStudentName = 1;
    int idInArrStudentSurname =  2;
    int idInArrSex = 3;
    int idInArrDateOfBirth = 4;
    int idInArrStudentSpecialty = 5;
    int idInArrStudentCourse = 6;
    int idInArrStudentGroup = 7;
    int idInArrStudentsMarks = 8;

//    Группы
    String[] groups = new String[]{"First", "Second", "Third"};
/*
    int[] lastStudentMarksByID = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[][] studentsMarks = new int[numStudent][30];
*/

    public static void main(String[] args) {


    }

//        Добавить нового студента
    public boolean addNewStudent(String studentName,
                                 String studentSurname,
                                 String sex,
                                 String dateOfBirth,
                                 String studentSpecialty,
                                 String studentCourse,
                                 String studentGroup){
        //проверка можно ли добавить нового студента
        if(lastStudentNamber == numStudent - 1){
            //todo расширить массив студентов вынести в функцию
            return false;
        }
        students[lastStudentNamber] = new String[9];
        students[lastStudentNamber][idInArrStudentId] = "" + lastStudentNamber;
        students[lastStudentNamber][idInArrStudentName] =studentName;
        students[lastStudentNamber][idInArrStudentSurname] =studentSurname;
        students[lastStudentNamber][idInArrSex] =sex;
        students[lastStudentNamber][idInArrDateOfBirth] =dateOfBirth;
        students[lastStudentNamber][idInArrStudentSpecialty] =studentSpecialty;
        students[lastStudentNamber][idInArrStudentCourse] =studentCourse;
        students[lastStudentNamber][idInArrStudentGroup] = studentGroup;
        students[lastStudentNamber][idInArrStudentsMarks] = "";

        lastStudentNamber++;
        return true;
    }
    //        Добавить нового студента без специальности, группы и курса
    public boolean addNewStudent(String studentName,
                                 String studentSurname,
                                 String sex,
                                 String dateOfBirth){
        //проверка можно ли добавить нового студента
        if(lastStudentNamber == numStudent - 1){
            //todo расширить массив студентов вынести в функцию
            return false;
        }
        students[lastStudentNamber] = new String[9];
        students[lastStudentNamber][idInArrStudentId] = "" + lastStudentNamber;
        students[lastStudentNamber][idInArrStudentName] =studentName;
        students[lastStudentNamber][idInArrStudentSurname] =studentSurname;
        students[lastStudentNamber][idInArrSex] =sex;
        students[lastStudentNamber][idInArrDateOfBirth] =dateOfBirth;
        students[lastStudentNamber][idInArrStudentSpecialty] ="";
        students[lastStudentNamber][idInArrStudentCourse] ="";
        students[lastStudentNamber][idInArrStudentGroup] ="";
        students[lastStudentNamber][idInArrStudentsMarks] = "";

        lastStudentNamber++;
        return true;
    }
//    удаление по фамилии
    public boolean delStudentBySurname(String surname){
        boolean isStudentDelete = false;
        for(int i = 0 ; i < students.length; i++ ){
            if( students[i][idInArrStudentSurname].equals(surname)){
                students[i] = null;
                isStudentDelete = true;
            }
        }
        return isStudentDelete;
    }

//    удаление по какомо-ту атрибуту
//    удаляет сразу всех студентов с данным атрибутом
//    может удалить всех студентов
    public boolean delStudentByAttribute(String attributePattern, int attribute){
        boolean isStudentDelete = false;
        for(int i = 0 ; i < students.length; i++ ){
            if(attribute >= students[i].length || attribute < 0){
                continue;
            }
            if( students[i][attribute].equals(attributePattern)){
                students[i] = null;
                isStudentDelete = true;
            }
        }
        return isStudentDelete;
    }

//    Есть ли хотябы один студент с такой фамилией
    public boolean containsStudentWithSurname(String surname) {
        boolean isStudentContains = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i][idInArrStudentSurname].equals(surname)) {
                isStudentContains = true;
                break;
            }
        }
        return isStudentContains;
    }

//    удалить всех студентов
    public boolean clearStudents(){
        boolean isStudentsClear = false;
        for(int i = 0; i < students.length; i++){
            students[i] = null;
            if(i == students.length-1){
                isStudentsClear = true;
            }
        }
        return isStudentsClear;
    }



}
