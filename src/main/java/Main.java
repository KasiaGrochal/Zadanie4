import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean appOn = true;
        List<Employee> employeeList = new ArrayList<>();

        addNewEmployee(employeeList, 5);

        while (appOn) {
            printMainMenu();

            switch (getAction()) {
                case 1:
                    getSalaryTotal(employeeList);
                    break;
                case 2:
                    getAllData(employeeList);
                    break;
                case 3:
                    addNewEmployee(employeeList, 1);
                    break;
                case 4:
                    appOn = false;
                    System.out.println("Closing the app...");
                    break;
            }
        }
    }

    public static void printMainMenu() {
        System.out.println("\nPlease type an integer to choose the corresponding action:\n" +
                "\t1 - Print sum of all employees salary\n" +
                "\t2 - Display all employees data\n" +
                "\t3 - Add new employee\n" +
                "\t4 - End program\n");
    }

    public static void addNewEmployee(List<Employee> list, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Employee newEmployee = new Employee();
            newEmployee.addEmployeeDetails();
            list.add(newEmployee);
        }
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

    public static int getAction() {
        Scanner scanner = new Scanner(System.in);
        int action = 0;
        for (int i = 0; i < 1; i++) {
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException a) {
                System.out.println("You've entered a string, please enter an integer value");
                i--;
                printMainMenu();
                scanner.nextLine();
            }
        }
        return action;
    }

}

