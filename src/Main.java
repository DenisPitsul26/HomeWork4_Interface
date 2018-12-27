import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Денис", "Піцул", true, 20, false,
                85, 43);
        Student student2 = new Student("Володимир", "Перон", true, 19, false,
                85, 54);
        Student student3 = new Student("Андрій", "Онищук", true, 20, false,
                80, 32);
        Student student4 = new Student("Роман", "Осадчук", true, 17, true,
                92, 65);
        Student student5 = new Student("Олександр", "Срібний", true, 19, true,
                88, 49);

        Group group = new Group(343);
        try {
            group.addStudentToGroup(student1);
            group.addStudentToGroup(student2);
            group.addStudentToGroup(student3);
            group.addStudentToGroup(student4);
            group.addStudentToGroup(student5);
        } catch (ArrayIsFullException e) {
            e.printStackTrace();
        }

        Scanner input = new Scanner(System.in);
        int numberOfChoice;
        while(true){
            showMainMenu();

            try {
                numberOfChoice = Integer.parseInt(input.next());
            } catch (NumberFormatException e){
                System.out.println("Input correct number: ");
                continue;
            }

            switch (numberOfChoice) {
                case 1:
                    try {
                        group.addStudentToGroup(createStudent());
                    } catch (ArrayIsFullException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println(group.toString());
                    System.out.print("Which student do you want to delete(number)?: ");

                    int index;
                    try {
                        index = Integer.parseInt(input.next());
                    } catch (NumberFormatException e) {
                        System.out.println("Input correct number: ");
                        continue;
                    }
                    group.deleteStudentByIndex(index);
                    break;
                case 3:
                    group.sortStudent(1);
                    break;
                case 4:
                    showSortMenu();
                    int parameter;
                    try {
                        parameter = Integer.parseInt(input.next());
                    } catch (NumberFormatException e) {
                        System.out.println("Input correct number: ");
                        continue;
                    }
                    if (parameter >= 1 && parameter <= 6)
                        group.sortStudent(parameter);
                    else if (parameter == 7)
                        continue;
                    else {
                        System.out.println("Input number from 1 to 7: ");
                        continue;
                    }
                    break;
                case 5:
                    group.showInfo();
                    break;
                case 6:
                    System.out.println(Arrays.toString(group.getAdultMaleStudents()));
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a number between 1 to 7, please");
                    continue;
            }

        }

    }

    public static void showMainMenu() {
        System.out.println("\tMake your choice:");
        System.out.println("Add Student to the group - 1;");
        System.out.println("Delete student from the group - 2;");
        System.out.println("Sort Students in the group by Surname - 3:");
        System.out.println("Sort Students in the group by parameters - 4;");
        System.out.println("View all students in the group - 5;");
        System.out.println("All the male students who were 18 years old - 6;");
        System.out.println("Close program - 7.");
    }

    public static void showSortMenu() {
        System.out.println("\tWhat parameter do you want to sort?");
        System.out.println("LastName ascending - 1;");
        System.out.println("LastName descending - 2;");
        System.out.println("Age ascending - 3;");
        System.out.println("Age descending - 4;");
        System.out.println("AverageScore ascending - 5;");
        System.out.println("AverageScore descending - 6;");
        System.out.println("Get main menu.");
    }

    public static Student createStudent(){
        Scanner in = new Scanner(System.in);
        Student student = new Student();

        try {
            System.out.print("Input first name: ");
            student.setFirstName(in.nextLine());
            System.out.print("Input last name: ");
            student.setLastName(in.nextLine());
            System.out.print("Input sex: ");
            student.setSex(in.nextBoolean());
            System.out.print("Input age: ");
            student.setAge(in.nextInt());
            System.out.print("Is get stipend: ");
            student.setStipend(in.nextBoolean());
            System.out.print("Input average score: ");
            student.setAverageScore(in.nextDouble());
            System.out.print("Input number of the record book: ");
            student.setNumberOfTheRecordBook(in.nextInt());
        }catch (InputMismatchException e) {
            System.out.println("Error adding student.");
            return null;
        }

        return student;
    }
}
