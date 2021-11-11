import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee {
    Scanner input = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private double salary;
    private final String expectedInputFirstName = "First name";
    private final String expectedInputLastName = "Last name";
    private final String expectedInputSalary = "Salary";


    public void addDetails() {
        System.out.println("You are adding a new employee.");
        validateStringInput(expectedInputFirstName);
        validateStringInput(expectedInputLastName);
        validateDoubleInput(expectedInputSalary);
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

    public void validateStringInput(String expectedInput) {
        for (int i = 0; i < 1; i++) {
            System.out.println(expectedInput + ":");
            String typed = input.nextLine();
            if (typed.isEmpty() || typed.isBlank()) {
                i--;
                System.out.println(expectedInput + " cannot be empty. Please enter first name again.");
            } else if (expectedInput.equals(expectedInputFirstName)) {
                setFirstName(typed);
            } else {
                setLastName(typed);
            }
        }
    }

    public void validateDoubleInput(String expectedInput) {
        for (int i = 0; i < 1; i++) {
            System.out.println(expectedInput + ":");
            try {
                setSalary(input.nextDouble());
            } catch (InputMismatchException e) {
                System.out.println("You've entered a string, please enter an integer value");
                i--;
                input.nextLine();
            }
        }
    }
}