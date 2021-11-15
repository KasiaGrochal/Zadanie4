import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee {
    Scanner input = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private double salary;
    private ExpectedInput expectedInput;

    public void addEmployeeDetails() {
        System.out.println("You are adding a new employee.");
        getValidatedStringInput(ExpectedInput.FIRST_NAME);
        getValidatedStringInput(ExpectedInput.LAST_NAME);
        getvalidatedDoubleInput(ExpectedInput.SALARY);
        System.out.println("You have successfully added an employee\n");
    }

    public void getAllData() {
        System.out.println("Salary for " + firstName + " " + lastName + " is " + salary);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void getValidatedStringInput(ExpectedInput expectedInput) {
        for (int i = 0; i < 1; i++) {
            System.out.println(expectedInput.getDisplayName() + ":");
            String typed = input.nextLine();
            if (typed.isEmpty() || typed.isBlank()) {
                i--;
                System.out.println(expectedInput.getDisplayName() + " cannot be empty. Please enter " + expectedInput.getDisplayName() + " again.");
            } else {
                switch (expectedInput) {
                    case FIRST_NAME:
                        setFirstName(typed);
                        break;
                    case LAST_NAME:
                        setLastName(typed);
                        break;
                }
            }
        }
    }

    public void getvalidatedDoubleInput(ExpectedInput expectedInput) {
        for (int i = 0; i < 1; i++) {
            System.out.println(expectedInput.getDisplayName() + ":");
            try {
                setSalary(input.nextDouble());
            } catch (InputMismatchException e) {
                System.out.println("You've entered a string, please enter an integer or double value");
                i--;
                input.nextLine();
            }
        }
    }
}