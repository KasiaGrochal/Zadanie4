import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            employeeList.add(addNewEmployee());
        }
        while (!quit) {
            printMainMenu();
            int action = 0;
            for (int i = 0; i < 1; i++) {
                try {
                    action = scanner.nextInt();
                } catch (InputMismatchException a) {
                    System.out.println("You've entered a string, please enter an integer value");
                    i--;
                    scanner.nextLine();
                }
            }

            switch (action) {
                case 1:
                    getSalaryTotal(employeeList);
                    break;
                case 2:
                    getAllData(employeeList);
                    break;
                case 3:
                    employeeList.add(addNewEmployee());
                    break;
                case 4:
                    quit = true;
                    System.out.println("Closing the app...");
                    break;
            }
        }
    }

    public static void printMainMenu() {
        System.out.println("\nPlease type an integer to choose the corresponding action:\n" +
                "1 - Print sum of all employees salary\n" +
                "2 - Display all employees data\n" +
                "3 - Add new employee\n" +
                "4 - End program\n");
    }

    public static Employee addNewEmployee() {
        Employee newEmployee = new Employee();
        newEmployee.addDetails();
        return newEmployee;
    }

    public static void getSalaryTotal(List<Employee> list) {
        double salary = 0;
        for (Employee employee : list) {
            salary += employee.getSalary();
        }
        System.out.println("Sum of the salaries is " + salary + "\n");
    }

    public static void getAllData(List<Employee> list) {
        for (Employee employee : list) {
            employee.getAllData();
        }
    }
}
