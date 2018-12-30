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
            Menu.showMainMenu();

            try {
                numberOfChoice = Integer.parseInt(input.next());
            } catch (NumberFormatException e){
                System.out.println("Input correct number: ");
                continue;
            }

            switch (numberOfChoice) {
                case 1:
                    try {
                        group.addStudentToGroup(Group.createStudent());
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
                    Menu.showSortMenu();
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

}
