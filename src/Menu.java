public class Menu {

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
}
