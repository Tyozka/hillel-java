package HomeWork3;

/**
 * Created by Влад on 18.05.2017.
 */
public class StudentsArr {
    int numStudent = 30;// начальное количество студентов в одной группе
    int numGroups = 5;
    static int lastNumberOfStudentAddedToDB = 1;
    static int capacityStudentDB = 0;
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
//    Группы представляют собой массив масивов int
//    [
//     [studentID1, studentID2, studentID3..., capacity], // capacity = len-1-(кол. пустых эллементов)
//     при добавления нового студента в группу capacity++ ,  при удалении capacity--
//     []
//    ]
    int [][] groups = new int[numGroups][];
//    названия групп
    String[] groupName = new String[numGroups];

//  Студенты все
    String[][] students =  new String[numStudent][];


    public static void main(String[] args) {


    }


//  Добавить нового студента
    public boolean addNewStudent(String studentName,
                                 String studentSurname,
                                 String sex,
                                 String dateOfBirth,
                                 String studentSpecialty,
                                 String studentCourse,
                                 String studentGroup){
        //проверка можно ли добавить нового студента
        //todo сначала попытаться удалить пустые места и сдвинуть все не пустые влево
        if(students[students.length-1] !=  null){
            //todo расширить массив студентов / вынести в функцию
            return false;
        }
        students[capacityStudentDB] = new String[9];
        students[capacityStudentDB][idInArrStudentId] = "" + lastNumberOfStudentAddedToDB;
        students[capacityStudentDB][idInArrStudentName] =studentName;
        students[capacityStudentDB][idInArrStudentSurname] =studentSurname;
        students[capacityStudentDB][idInArrSex] =sex;
        students[capacityStudentDB][idInArrDateOfBirth] =dateOfBirth;
        students[capacityStudentDB][idInArrStudentSpecialty] =studentSpecialty;
        students[capacityStudentDB][idInArrStudentCourse] =studentCourse;

        students[capacityStudentDB][idInArrStudentsMarks] = "";


        if(checkGroup(studentGroup)){
            if(!addStudentToGroup(studentGroup, lastNumberOfStudentAddedToDB)){
                students[capacityStudentDB] = null;
                return false;
            }
        } else {
            addNewGroupByName(studentGroup);
            if(!addStudentToGroup(studentGroup, lastNumberOfStudentAddedToDB)){
                students[capacityStudentDB] = null;
                return false;
            }
        }


        capacityStudentDB++;
        lastNumberOfStudentAddedToDB++;
        return true;
    }

//    Создать новую группу по Имени
    public void addNewGroupByName(String studentGroupName){
        int idNewGroup = -1;
        for( int i = 0; i < groupName.length; i++){
            if(groupName[i] == null){
                groupName[i] = studentGroupName;
                idNewGroup = i;
            }
        }
        if(idNewGroup != -1){
            for(int j = 0; j < groups.length; j++){
                if( groups[j] == null ){
                    groups[j] = new int[2+numStudent];
                    return;
                }
            }
            //todo увеличить масим groups[j]
            addNewGroupByName(studentGroupName);
            return ;
        }
    }

    //    Если мы добавили студента в группу тогда True иначе false
    public boolean addStudentToGroup(String groupName, int StudentId ){
        int groupId = getGroupIdByName(groupName);
        if(groupId == -1){
            addNewGroupByName(groupName);
        }
        for(int i = 0; i < groups.length; i++){
            if( groups[i][0] == groupId ){
                int groupCapacity = groups[i][groups[i].length - 1];
                for(int j = 1; j < groups[i].length - 1; j++ ){ //
                    if(groups[i][j] == 0){
                        groups[i][j] = StudentId;
                        groupCapacity++;
                        groups[i][groups[i].length - 1] = groupCapacity;
                        return true;
                    }
                }
                //todo Расширить группу, так как нам не хватило место чтоб добавить студента
            }
        }
        return addStudentToGroup(groupName, StudentId); // пытаемся еще раз
    }



    private int getGroupIdByName(String group) {
        for (int i = 0; i < groupName.length; i++ ){
            if(groupName[i].equals(group)){
                return i;
            }
        }
        return -1;
    }

    public boolean checkGroup(String studentGroup) {
        for(String group : groupName){
            if(group.equals(studentGroup)){
               return true;
            }
        }
        return false;
    }

    //удаление по фамилии
    public boolean delStudentBySurname(String surname){
        //todo найти студента с такой фамилией, если нет то вернуть false
        //todo получить группу студента
        //todo получить id студента
        //todo удалить студента из БД студентов
        //todo удалить пустые элементы из БД студентов
        //todo найти id группы по названию
        //todo в списке студентов по группам найти группу по id и удалить студента по id студента
        //todo  удалить пустые элементы из группы по id
        // Если все ок вернуть true
        return true;
    }

//todo function    contains - есть ли студент с определенной фамилией в группе
    public boolean containsStudentWithSurnameInGroup(String surname, String Group){
        //todo проверить есть ли такой студент
        //todo если есть то достать его группу
        //todo если группу студента совпадает с входным параметром то вернуть true
        //todo иначе вернуть false
        return false;
    }


//todo function    clear - очистка массива
//todo function    trim - удаление пустых элементов массива
//todo function    объединение двух групп
//todo function    сортировка по фамилии
//todo function    containsAll - есть ли группа студентов в другой группе
//todo function    equals - одинаковые ли группы
//todo function    print - красивый вывод на печать группы



/*

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


*/
}
