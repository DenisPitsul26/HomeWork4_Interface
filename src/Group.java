import java.util.Arrays;
import java.util.Comparator;

public class Group implements Voenkom{
    private int numberOfGroup;
    private Student[] studentsList;

    public Group(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
        studentsList = new Student[10];
    }

    public Group() {
        studentsList = new Student[10];
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public void addStudentToGroup(Student student) throws ArrayIsFullException {
        if (student == null) {
            System.out.println("This student is null.");
            return;
        }
        boolean isGroupFull = true;
        boolean thisStudentIsAlreadyInTheGroup = false; //для того щоб ми не добавляни 2 раза одного студента
        for (int i = 0; i < studentsList.length; i++) {
            if (studentsList[i] != null) {
                if (studentsList[i].getFirstName().equals(student.getFirstName())
                && studentsList[i].getLastName().equals(student.getLastName())) {
                    thisStudentIsAlreadyInTheGroup = true;
                }
            }
        }
        if (!thisStudentIsAlreadyInTheGroup) {
            for (int i = 0; i < studentsList.length; i++) {
                if (studentsList[i] == null) {
                    isGroupFull = false;
                    studentsList[i] = student;
                    System.out.println(student.getFirstName()+" "+ student.getLastName()+" has added successfully.");
                    break;
                }
            }
            if (isGroupFull) throw new ArrayIsFullException();
        }
        else
            System.out.println("This student is already in the group.");

    }

    public void deleteStudentFromGroup(Student student) {
        if (student != null) {
            boolean thereAreNoThisStudentInGroup = false;
            for (int i = 0; i < studentsList.length; i++) {
                if (studentsList[i] != null) {
                    if (studentsList[i].getFirstName().equals(student.getFirstName())
                            && studentsList[i].getLastName().equals(student.getLastName())) {
                        thereAreNoThisStudentInGroup = true;
                        studentsList[i] = null;
                        System.out.println(student.getFirstName() + " " + student.getLastName() + " has deleted from group.");
                    }
                }
            }
            if (!thereAreNoThisStudentInGroup) {
                System.out.println("Such a student is not in the group.");
            }
        }
    }

    public void deleteStudentByIndex(int index) {
        if (index >= 1 && index <= 10) {
            if (studentsList[index-1] != null){
                Student student = studentsList[index-1];
                studentsList[index-1] = null;
                System.out.println(student +" is delete from the "+ index +" place in the group.");
            }
            else
                System.out.println("This place is empty.");
        }
        else
            System.out.println("No such place in the group.");
    }

    public Student getStudentByLastName(String lastName) {
        for (Student aStudentsList : studentsList) {
            try {
                if (aStudentsList.getLastName().equals(lastName)) {
                    return aStudentsList;
                }
            } catch (NullPointerException e) {
            }
        }
        System.out.println("Such a student is not in the group.");
        return null;
    }

    /*public Student[] getArrayWithoutNullElements(Student[] studentsList1){
        int lengthStudents = 0;
        for (int i = 0; i < studentsList1.length; i++) {
            if (studentsList1[i] != null) {
                lengthStudents++;
            }
        }

        Student[] students = new Student[lengthStudents];
        int index = 0;
        for (int i = 0; i < studentsList1.length; i++) {
            if (studentsList1[i] != null) {
                students[index] = studentsList1[i];
                index++;
            }
        }

        return students;
    }*/
    /*public Student[] getSortedArray() {
        Student[] students = null;
        students = getArrayWithoutNullElements(studentsList);

        for (int i = 0; i < students.length-1; i++) {
            for (int j = 0; j < students.length-1; j++) {
                if (!students[j].getLastName().equals(students[j+1].getLastName())) {
                    if (students[j].getLastName().compareTo(students[j + 1].getLastName()) > 0) {
                        Student temp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = temp;
                    }
                }
                else {
                    if (students[j].getFirstName().compareTo(students[j + 1].getFirstName()) > 0) {
                        Student temp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = temp;
                    }
                }
            }
        }


        return students;
    }*/

    //вот в цій роботі потрібно вже відсортувати сам масив студентів
    public void sortStudent(int paremetr) {
        if (paremetr >= 1 && paremetr <= 6) {
            Student.setSortParam(paremetr);
            Arrays.sort(studentsList, Comparator.nullsLast(Student::compareTo));
        }
    }
    public void showInfo() {
        System.out.println("Group{\n");
        for (int i = 0; i < studentsList.length; i++) {
            if (studentsList[i] != null) {
                System.out.println(studentsList[i]);
            }
        }
        System.out.println("}");
    }

    @Override
    public String toString() {

        return "Group{\n"+ Arrays.toString(studentsList) +"}";
    }

    @Override
    public Student[] getAdultMaleStudents() {
        int lengthAdultStudents = 0;
        for (int i = 0; i < studentsList.length; i++) {
            try {
                if (studentsList[i].getAge() >= 18 && studentsList[i].getSex())
                    lengthAdultStudents++;
            }catch (NullPointerException e){
            }
        }

        Student[] adultStudents = new Student[lengthAdultStudents];

        int index = 0;
        for (int i = 0; i < studentsList.length; i++) {
            try {
                if (studentsList[i].getAge() >= 18 && studentsList[i].getSex()) {
                    adultStudents[index] = studentsList[i];
                    index++;
                    System.out.println(index);
                }
            }catch (NullPointerException e){
            }
        }

        return adultStudents;
    }
}
