package HomeWork3;

/**
 * Created by Влад on 18.05.2017.
 */
public class StudentsArr {
    private final int DEFAULT_NUM_STUDENTS_IN_GROUP = 30;// начальное количество студентов в одной группе
    private final int DEFAULT_NUM_OF_GROUP = 5;// начальное количество групп


    private final static int NUM_OF_STUDENT_DESCRIPTION = 4;

    private final static int ID_OF_ID_IN_ARR_STUDENTS = 0;
    private final static int ID_NAME_IN_ARR_STUDENTS = 1;
    private final static int ID_SECONDE_NAME_IN_ARR_STUDENTS =  2;
    private final static int ID_GROUP_IN_ARR_STUDENTS = 3;
//    private final static int ID_MARKS_IN_ARR_STUDENTS = 4;
//    private final static int ID_VISITS_IN_ARR_STUDENTS = 5;

    private static int UNICAL_STUDENT_ID = 1; // уникальный индетификеатор студента

    private final int DEFAULT_ERROR_INT_CODE = -1;
    private final Object DEFAULT_ERROR_OBJECT_CODE = null;

//    Группы
//    Группы представляют собой массив масивов int
//    [
//     [studentID1, studentID2, studentID3..., capacity], // capacity = len-1-(кол. пустых эллементов)
//     при добавления нового студента в группу capacity++ ,  при удалении capacity--
//     []
//    ]
    private int [][] groups = new int[DEFAULT_NUM_OF_GROUP][DEFAULT_NUM_STUDENTS_IN_GROUP];
    private String[] groupName = new String[DEFAULT_NUM_OF_GROUP]; // названия групп, синхронизирвоано с группами

//  Студенты все
//    Студенты представляют собой массив масивов int
//    [
//     [studentID, idName, idSecondName, ..., ], // capacity = len-1-(кол. пустых эллементов)
//
//     []
//    ....
//     [capacity,...]....  capacity = len-1-(кол. пустых эллементов)
//     при добавления нового студента  capacity++ ,  при удалении capacity--
//    ]
    private int [][] students =  new int [DEFAULT_NUM_STUDENTS_IN_GROUP][];

    private String[] studentNames = new String[DEFAULT_NUM_STUDENTS_IN_GROUP];
    private String[] studentSurnames = new String[DEFAULT_NUM_STUDENTS_IN_GROUP];
    private String[] sex  ={"Male", "Female"};
    private String[] dateOfBirth  = new String[DEFAULT_NUM_STUDENTS_IN_GROUP];
    private String[] studentSpecialty = new String[DEFAULT_NUM_STUDENTS_IN_GROUP];
    private String[] studentCourse = new String[DEFAULT_NUM_STUDENTS_IN_GROUP];

    public StudentsArr(){
        this.students[this.students.length-1] = new int[1];
        setCapacityOfStudent(0);
        //initArr(groups);
    }

//  Добавить нового студентав группу
    public boolean addNewStudent(String studentGroup, String studentName, String studentSurname){
        int capacity = getCapacityOfStudent();
//        ..проверка можем ли мы добавить студента, в capacity должно быть количество студентов
//        его макс значение = len - 2
        if(capacity >= this.students.length - 2){
            expandStudents();
        }
        addGroupName(studentGroup);
        addStudentNames(studentName);
        addStudentSurnames(studentSurname);
        for(int i = 0; i < this.students.length-1; i++){
            if(this.students[i] == DEFAULT_ERROR_OBJECT_CODE ){
                this.students[i] = new int[NUM_OF_STUDENT_DESCRIPTION];
               // initArr(this.students[i]);
                this.students[i][ID_OF_ID_IN_ARR_STUDENTS] = UNICAL_STUDENT_ID;
                this.students[i][ID_NAME_IN_ARR_STUDENTS] = getIdStudentNames(studentName);
                this.students[i][ID_SECONDE_NAME_IN_ARR_STUDENTS] = getIdStudentSurnames(studentSurname);
                this.students[i][ID_GROUP_IN_ARR_STUDENTS]= getIdGroupName(studentGroup);
                break;
            }
        }
        addStudentToGroup(UNICAL_STUDENT_ID, getIdGroupName(studentGroup));
        capacity++;
        setCapacityOfStudent(capacity);
        UNICAL_STUDENT_ID++;
        return true;
}

    //  Удалить студента из групп по фамилии
    public boolean delStudentFromGroupBySecondeName(String secondeName){
        int IDSecondeName;
        int studentId;
        int studentUnicId;
        int studentGroup;

        // Получить ID фамилии
        IDSecondeName = getIdStudentSurnames(secondeName);
        if(isError(IDSecondeName)){
            System.out.println("В базе нет студента с фамилией - " + secondeName);
            return false;
        }
        studentId = getIdByElement(this.students,IDSecondeName, ID_SECONDE_NAME_IN_ARR_STUDENTS);
        if(isError(studentId)){
            System.out.println("В базе студентов не нашли студента с фамилией - " + secondeName );
            System.out.println("при этом, в базе фамилий мы добавляли студента с фамилией " + secondeName );
            System.out.println("В базе он под номером " + IDSecondeName);
            return false;
        }
        studentUnicId = this.students[studentId][ID_OF_ID_IN_ARR_STUDENTS];
        studentGroup = this.students[studentId][ID_GROUP_IN_ARR_STUDENTS];
        this.students[studentId][ID_GROUP_IN_ARR_STUDENTS] = DEFAULT_ERROR_INT_CODE;
        return deleteElement(this.groups[studentGroup], studentUnicId );

    }

//  contains - есть ли студент с определенной фамилией в группе (любой)
    public boolean containsStudentInGroupBySecondeName(String secondName){
        int idSecondName;
        idSecondName = getIdStudentSurnames(secondName);
        if(isError(idSecondName)){
            System.out.println("В базе нет студента с фамилией - " + secondName);
            return false;
        }
        // проверка в группах
        for(int[] students : this.students){
            if(students[ID_SECONDE_NAME_IN_ARR_STUDENTS] == idSecondName || students[ID_GROUP_IN_ARR_STUDENTS] != DEFAULT_ERROR_INT_CODE){
                return true;
            }
        }
        return false;
    }

    //  contains - есть ли студент с определенной фамилией в группе (определенной)
    public boolean containsStudentInGroupBySecondeName(String secondName, String groupName){
        int idSecondName;
        int idSGroupName;
        idSecondName = getIdStudentSurnames(secondName);
        if(isError(idSecondName)){
            System.out.println("В базе нет студента с фамилией - " + secondName);
            return false;
        }
        idSGroupName = getIdGroupName(groupName);
        if(isError(idSGroupName)){
            System.out.println("В базе нет группы с именем  - " + idSGroupName);
            return false;
        }
        // проверка в группах
        for(int[] students : this.students){
            if(students[ID_SECONDE_NAME_IN_ARR_STUDENTS] == idSecondName || students[ID_GROUP_IN_ARR_STUDENTS] == idSGroupName){
                return true;
            }
        }
        return false;
    }

//clear - очистка массива
    public void clearArray(String[] arr){
        for(String elem:arr){
            elem = (String) DEFAULT_ERROR_OBJECT_CODE;
        }
    }
    public void clearArray(int[] arr){
        for(int elem:arr){
            elem = DEFAULT_ERROR_INT_CODE;
        }
    }
    public void clearArray(int[][] arr){
        for(int[] elem:arr){
             elem = (int[])DEFAULT_ERROR_OBJECT_CODE;
        }
    }
    public void clearArray(int[][] arr, boolean all){
        if(!all){
            clearArray(arr);
            return;
        }
        for(int[] elem : arr){
            clearArray(elem);
        }
    }












    private void expandStudents(){
        int capacity = getCapacityOfStudent();
        delCapacityOfStudent();
        expandArray(this.students);
        setCapacityOfStudent(capacity);
    }
    private void expandGrops(){
        expandArray(this.groups);

    }

    public boolean createGroup(String studentGroupName){

        addElement(this.groupName,studentGroupName);
        int idGroup = getIdGroupName(studentGroupName);
        if(idGroup >= this.groups.length){
            expandGrops();
            this.groups[idGroup] = new int[DEFAULT_NUM_STUDENTS_IN_GROUP];
            //initArr(this.groups[idGroup]);
            this.groups[idGroup][ this.groups[idGroup].length-1] = 0;
        }
        return true;
    }

    private void addStudentToGroup( int unicalStudentId, int idStudentGroup){
        int capacity = this.groups[idStudentGroup][this.groups[idStudentGroup].length-1]; //сохранили длину
        if(idStudentGroup >= this.groups.length){
            expandArray(this.groups);
        }
        for(int i = 0; i < this.groups[idStudentGroup].length-1; i++){
            if(this.groups[idStudentGroup][i] == 0){
                this.groups[idStudentGroup][i] = unicalStudentId;
                capacity++;
                this.groups[idStudentGroup][this.groups[idStudentGroup].length-1] = capacity;
                return;
            }
        }

        this.groups[idStudentGroup][this.groups[idStudentGroup].length-1] = 0;//сбросить длину
        expandArray(this.groups[idStudentGroup]);
        this.groups[idStudentGroup][this.groups[idStudentGroup].length-1] = capacity; // вернули длину
        addStudentToGroup(unicalStudentId,  idStudentGroup);

    }

    private int getCapacityOfStudent(){
        return students[students.length-1][0];
    }
    private void delCapacityOfStudent(){
        students[students.length-1][0] = 0;
    }
    private void setCapacityOfStudent(int capacity){
        this.students[this.students.length-1][0] = capacity;
    }

//    groupName
    private boolean addGroupName(String groupName){
        if(checkGroupName(groupName)) return true;
        return createGroup(groupName);
    }
    private String getGroupName(int id){
        return getElementById(this.groupName, id);
    }
    private int getIdGroupName(String groupName){
        return getIdByElement(this.groupName, groupName);
    }
    private boolean delGroupName(String groupName){
        return deleteElement(this.groupName, groupName);
    }
    private void expandGroupName(){
        expandArray(this.groupName);
    }
    private boolean checkGroupName(String groupName){
        return checkElementInArray(this.groupName,groupName);
    }

    //  StudentNames
    private boolean addStudentNames(String name){
        return addElement(this.studentNames, name);
    }
    private String getStudentNames(int id){
        return getElementById(this.studentNames, id);
    }
    private int getIdStudentNames(String name){
        return getIdByElement(this.studentNames, name);
    }
    private boolean delStudentNames(String name){
        return deleteElement(this.studentNames, name);
    }
    private void expandStudentNames(){
        expandArray(this.studentNames);
    }
    private boolean checkStudentName(String name){
        return checkElementInArray(this.studentNames,name);
    }

//    StudentSurnames
    private boolean addStudentSurnames(String surname){
    return addElement(this.studentSurnames, surname);
}
    private String getStudentSurnames(int id){
        return getElementById(this.studentSurnames, id);
    }
    private int getIdStudentSurnames(String surname){
        return getIdByElement(this.studentSurnames, surname);
    }
    private boolean delStudentSurnames(String surname){
        return deleteElement(this.studentSurnames, surname);
    }
    private void expandStudentSurnames(){
        expandArray(this.studentSurnames);
    }
    private boolean checkStudentSurnames(String surname){
        return checkElementInArray(this.studentSurnames,surname);
    }

//    DateOfBirth
    private boolean addStudentDateOfBirth(String dateOfBirth){
    return addElement(this.dateOfBirth, dateOfBirth);
}
    private String getStudentDateOfBirth(int id){
        return getElementById(this.dateOfBirth, id);
    }
    private int getIdStudentDateOfBirth(String dateOfBirth){
        return getIdByElement(this.dateOfBirth, dateOfBirth);
    }
    private boolean delStudentDateOfBirth(String dateOfBirth){
        return deleteElement(this.dateOfBirth, dateOfBirth);
    }
    private void expandStudentDateOfBirth(){
        expandArray(this.dateOfBirth);
    }
    private boolean checkStudentDateOfBirth(String dateOfBirth){
        return checkElementInArray(this.studentSurnames,dateOfBirth);
    }
//    studentSpecialty
    private boolean addStudentSpecialty(String studentSpecialty){
        if(checkStudentSpecialty(studentSpecialty)) return true;
        return addElement(this.studentSpecialty, studentSpecialty);
    }
    private String getStudentSpecialty(int id){
        return getElementById(this.studentSpecialty, id);
    }
    private int getIdStudentSpecialty(String studentSpecialty){
        return getIdByElement(this.studentSpecialty, studentSpecialty);
    }
    private boolean delStudentStudentSpecialty(String studentSpecialty){
        return deleteElement(this.studentSpecialty, studentSpecialty);
    }
    private void expandStudentSpecialty(){
        expandArray(this.studentSpecialty);
    }
    private boolean checkStudentSpecialty(String studentSpecialty){
        return checkElementInArray(this.studentSpecialty,studentSpecialty);
    }
//    studentCourse
    private boolean addStudentCourse(String studentCourse){
        if(checkStudentCourse(studentCourse)) return true;
        return addElement(this.studentCourse, studentCourse);
    }
    private String getStudentCourse(int id){
        return getElementById(this.studentCourse, id);
    }
    private int getIdStudentCourse(String studentCourse){
        return getIdByElement(this.studentCourse, studentCourse);
    }
    private boolean delStudentCourse(String studentCourse){
        return deleteElement(this.studentCourse, studentCourse);
    }
    private void expandStudentCourse(){
        expandArray(this.studentCourse);
    }
    private boolean checkStudentCourse(String studentCourse){
        return checkElementInArray(this.studentCourse,studentCourse);
    }

    private void initArr(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = DEFAULT_ERROR_INT_CODE;
        }
    }
    private void initArr(int[][] array){
        for(int i = 0; i < array.length; i++){
            if(array[i] != DEFAULT_ERROR_OBJECT_CODE){ initArr(array[i]);}
        }
    }
    private void initArr(String[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = (String)DEFAULT_ERROR_OBJECT_CODE;
        }
    }

    private boolean checkElementInArray(String[] array, String element) {
        for (int i = 0; i < array.length; i++ ){
            if(array[i] != null && array[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    private boolean checkElementInArray(int[] array, int element) {
        for (int i = 0; i < array.length; i++ ){
            if(array[i] != DEFAULT_ERROR_INT_CODE && array[i] == element){
                return true;
            }
        }
        return false;
    }

    private int[] getElementById(int[][] array, int id){
        if(id <= DEFAULT_ERROR_INT_CODE || id >= array.length){
            return null;
        }
        return array[id];
    }
    private int getElementById(int[] array, int id){
        if(id <= DEFAULT_ERROR_INT_CODE || id >= array.length){
            return DEFAULT_ERROR_INT_CODE;
        }
        return array[id];
    }
    private String getElementById(String[] array, int id){
        if(id <= DEFAULT_ERROR_INT_CODE || id >= array.length){
            return ""+ DEFAULT_ERROR_INT_CODE;
        }
        return array[id];
    }

    private boolean addElement(String[] array, String element){
        if(checkElementInArray(array , element)) return true;
        for(int i = 0 ; i < array.length; i++){
            if(array[i] == null){
                array[i] = element;
                return true;
            }
        }
        // если мы тут попали то мы не смогли найти место для добавления, поэтому надо расширить
        expandArray(array);
        return addElement(array, element);
    }
    private boolean addElement(int[] array, int element){
        if(checkElementInArray(array , element)) return true;
        for(int i = 0 ; i < array.length; i++){
            if(array[i] == DEFAULT_ERROR_INT_CODE){
                array[i] = element;
                return true;
            }
        }
        // если мы тут попали то мы не смогли найти место для добавления, поэтому надо расширить
        expandArray(array);
        return addElement(array, element);
    }
    private boolean addElement(String[] array, String element, int ignoreLastElements){
        if(checkElementInArray(array , element)) return true;
        for(int i = 0 ; i < array.length-ignoreLastElements; i++){
            if(array[i] == null){
                array[i] = element;
                return true;
            }
        }
        // если мы тут попали то мы не смогли найти место для добавления, поэтому надо расширить
        expandArray(array);
        return addElement(array, element);
    }
    private boolean addElement(int[] array, int element, int ignoreLastElements){
        if(checkElementInArray(array , element)) return true;
        for(int i = 0 ; i < array.length-ignoreLastElements; i++){
            if(array[i] == DEFAULT_ERROR_INT_CODE){
                array[i] = element;
                return true;
            }
        }
        // если мы тут попали то мы не смогли найти место для добавления, поэтому надо расширить
        expandArray(array);
        return addElement(array, element);
    }

    private boolean deleteElement(String[] array, String element){
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(element)){
                array[i] = null;
                return true;
            }
        }
        return false;
    }
    private boolean deleteElement(int[] array, int element){
        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                array[i] = DEFAULT_ERROR_INT_CODE;
                return true;
            }
        }
        return false;
    }
    private boolean deleteElement(int[][] array, int[] element){
        for(int i = 0; i < array.length; i++){
            if(array[i].length == element.length){
                for(int j = 0; j < array[i].length; j++){
                    if(array[i][j] != element[j]){
                        return false;
                    }
                }
                array[i] = null;
                return true;
            }
        }
        return false;
    }

    private int getIdByElement(String[] array, String element) {
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(element)){
                return i ;
            }
        }
        return DEFAULT_ERROR_INT_CODE;
    }
    private int getIdByElement(int[][] array, int findElement, int filtreId){
        for(int i = 0; i < array.length; i++ ){
            if(filtreId <= DEFAULT_ERROR_INT_CODE || filtreId >= array[i].length ){
                System.out.println("При вызове массива мы получили ошибку переполнения массива в " + array[i].toString() + " " +
                        "Елементов меньше, чем мы искали по фильтру под номером " + filtreId);
                break;
            }
            if(array[i][filtreId] == findElement){
                System.out.println("Мы нашли нужный элемент");
                return i;
            }
        }
        return DEFAULT_ERROR_INT_CODE;
    }
    private int getIdByElement(int[] array, int element){
        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                return i ;
            }
        }
        return DEFAULT_ERROR_INT_CODE;
    }

    private void expandArray(int[][] array) {
        int [][] tempArray = new int[array.length * 2][]; // увеличить в 2 раза масив
        for(int i = 0; i < array.length; i++){
            tempArray[i] = new int[array[i].length];
           // initArr(tempArray[i]);
            for(int j = 0; j < array[i].length; j++){
                tempArray[i][j] = array[i][j];
            }
        }
        array = tempArray;
    }
    private void expandArray(int[] array) {
        int[] tempArray = new int[array.length * 2]; // увеличить в 2 раза масив
        for(int i = 0; i < array.length; i++){
            tempArray[i] = array[i];
        }
        array = tempArray;
    }
    private void expandArray(String[] array){
        String[] tempArray = new String[array.length * 2]; // увеличить в 2 раза масив
        for(int i = 0; i < array.length; i++){
            tempArray[i] = array[i];
        }

        array = tempArray;
    }

    private boolean isError(int code){
        if(code == DEFAULT_ERROR_INT_CODE){
            return true;
        }
        return false;
    }
    private boolean isError(String code){
        if(code == null){
            return true;
        }
        return false;
    }
    private boolean isError(int[] code){
        if(code.length == 0){
            return true;
        }
        return false;
    }
    private boolean isError(String[] code){
        if(code.length == 0){
            return true;
        }
        return false;
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
